package org.fish.workflow.service;

import org.fish.workflow.data.InstanceDetail;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sumit Jha
 */
@Service
public interface WorkflowInstanceService {
    List<InstanceDetail> getInstances(Long id);

    List<InstanceDetail> getInstances(List<Long> workflowIds);
}
