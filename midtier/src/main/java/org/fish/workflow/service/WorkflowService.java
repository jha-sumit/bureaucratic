package org.fish.workflow.service;

import org.fish.workflow.service.vo.Workflow;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sumit Jha
 */
@Service
public interface WorkflowService {
    List<Workflow> getWorkflows();
}
