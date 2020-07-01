package org.fish.workflow.service.impl;

import org.fish.workflow.data.InstanceDetail;
import org.fish.workflow.data.WorkflowDetail;
import org.fish.workflow.data.repository.WorkflowInstanceRepository;
import org.fish.workflow.data.repository.WorkflowRepository;
import org.fish.workflow.data.type.EntityStatus;
import org.fish.workflow.data.type.ExecutionStatus;
import org.fish.workflow.service.WorkflowService;
import org.fish.workflow.service.vo.Workflow;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * @author Sumit Jha
 */
@Service
public class WorkflowServiceImpl implements WorkflowService {
    private final WorkflowRepository workflowRepository;
    private final WorkflowInstanceRepository workflowInstanceRepository;

    public WorkflowServiceImpl(
            WorkflowRepository workflowRepository,
            WorkflowInstanceRepository workflowInstanceRepository) {
        this.workflowRepository = workflowRepository;
        this.workflowInstanceRepository = workflowInstanceRepository;
    }

    @Override
    @Transactional
    public List<Workflow> getWorkflows() {
        List<Workflow> workflows = workflowRepository.findAllByStatus(EntityStatus.ACTIVE)
                .map(dtl -> new Workflow(dtl))
                .collect(Collectors.toList());
        return aggregateWorkflowInstancesFor(workflows);
    }

    protected List<Workflow> aggregateWorkflowInstancesFor(List<Workflow> workflows) {
        List<Long> activeWorkflowIds = workflows.stream().map(wfl -> wfl.getId()).collect(Collectors.toList());
        Map<Long, Map<ExecutionStatus, Long>> aggInstancesStat = workflowInstanceRepository
                .findAllByStatusAndWorkflowDetail_IdIn(EntityStatus.ACTIVE, activeWorkflowIds)
                .collect(Collectors.groupingBy(dtl -> Optional.ofNullable(dtl.getWorkflowDetail())
                                .map(WorkflowDetail::getId).orElse(null),
                        Collectors.groupingBy(InstanceDetail::getExecutionStatus,
                                Collectors.counting())));
        workflows.stream()
                .filter(wfl -> aggInstancesStat.containsKey(wfl.getId()))
                .forEach(wfl -> updateWorkflowStats(wfl, aggInstancesStat.get(wfl.getId())));

        return workflows;
    }

    private Workflow updateWorkflowStats(Workflow workflow, Map<ExecutionStatus, Long> stat) {
        AtomicLong instantInError = new AtomicLong(0);
        AtomicLong totalActiveInstant = new AtomicLong(0);
        stat.entrySet().stream()
                .forEach(e -> {
                    if (ExecutionStatus.ERROR.equals(e.getKey())) instantInError.getAndAdd(e.getValue());
                    totalActiveInstant.getAndAdd(e.getValue());
                });

        workflow.setActiveInstanceCount(totalActiveInstant.get());
        workflow.setErrorInstancesCount(instantInError.get());
        return workflow;
    }
}
