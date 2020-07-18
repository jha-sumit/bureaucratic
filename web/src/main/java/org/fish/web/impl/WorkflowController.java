package org.fish.web.impl;

import org.fish.web.Workflows;
import org.fish.web.resource.WorkflowResource;
import org.fish.web.util.Translators;
import org.fish.workflow.service.WorkflowInstanceService;
import org.fish.workflow.service.WorkflowService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Sumit Jha
 */
@RestController
@RequestMapping("/workflows")
@CrossOrigin
public class WorkflowController implements Workflows {
    private final WorkflowService workflowService;
    private final WorkflowInstanceService instanceService;

    public WorkflowController(
            WorkflowService workflowService, WorkflowInstanceService instanceService) {
        this.workflowService = workflowService;
        this.instanceService = instanceService;
    }

    @Override
    public ResponseEntity<WorkflowResource> createWorkflow(WorkflowResource workflowResource) {
        return null;
    }

    @Override
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<WorkflowResource>> getWorkflows() {
        return Optional.ofNullable(workflowService.getWorkflows())
                .map(workflows -> workflows.stream()
                        .map(Translators::from)
                        .collect(Collectors.toList()))
                .map(resources -> ResponseEntity.ok().body(resources))
                .orElse(ResponseEntity.status(HttpStatus.NO_CONTENT).body(Arrays.asList()));
    }

    @Override
    @GetMapping("/{id}/instances")
    public ResponseEntity getWorkflowInstances(@PathVariable(name = "id") Long workflowId) {
        return Optional.ofNullable(instanceService.getInstances(workflowId))
                .map(workflows -> workflows
                        .stream()
                        .map(Translators::from)
                        .collect(Collectors.toList()))
                .map(resources -> ResponseEntity.ok().body(resources))
                .orElse(ResponseEntity.status(HttpStatus.NO_CONTENT).body(Arrays.asList()));
    }
}
