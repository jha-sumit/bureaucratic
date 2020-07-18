package org.fish.workflow.service.impl;

import org.fish.workflow.data.InstanceDetail;
import org.fish.workflow.data.repository.WorkflowInstanceRepository;
import org.fish.workflow.data.type.EntityStatus;
import org.fish.workflow.service.WorkflowInstanceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Sumit Jha
 */
@Service
public class WorkflowInstanceServiceImpl implements WorkflowInstanceService {
    private final WorkflowInstanceRepository instanceRepository;

    public WorkflowInstanceServiceImpl(WorkflowInstanceRepository instanceRepository) {
        this.instanceRepository = instanceRepository;
    }

    @Override
    @Transactional
    public List<InstanceDetail> getInstances(Long id) {
        return instanceRepository.findAllByWorkflowDetail_Id(id);
    }

    @Override
    @Transactional
    public List<InstanceDetail> getInstances(List<Long> workflowIds) {
        return doGetInstances(workflowIds, EntityStatus.ACTIVE);
    }

    private List<InstanceDetail> doGetInstances(List<Long> workflowIds, EntityStatus status) {
        return instanceRepository.findAllByStatusAndWorkflowDetail_IdIn(status, workflowIds);
    }
}
