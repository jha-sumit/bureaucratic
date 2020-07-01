package org.fish.web.impl;

import org.fish.web.Workflows;
import org.fish.web.resource.Workflow;
import org.fish.workflow.service.WorkflowService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
 * @author Sumit Jha
 */
@RestController
@RequestMapping("/workflows")
@CrossOrigin
public class WorkflowController implements Workflows {
    private final WorkflowService workflowService;

    public WorkflowController(WorkflowService workflowService) {
        this.workflowService = workflowService;
    }

    @Override
    public ResponseEntity createWorkflow(Workflow workflow) {
        return null;
    }

    @Override
    @GetMapping (produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity getWorkflows() {
        return ResponseEntity.ok().body(workflowService.getWorkflows());
    }
}
