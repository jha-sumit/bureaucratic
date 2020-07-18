package org.fish.web;

import org.fish.web.resource.WorkflowResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Sumit Jha
 */
@RestController
@RequestMapping("/workflows")
public interface Workflows {
    @PostMapping
    ResponseEntity<WorkflowResource> createWorkflow(@RequestBody WorkflowResource workflowResource);

    @GetMapping
    ResponseEntity<List<WorkflowResource>> getWorkflows();

    @GetMapping("/{id}/instances")
    ResponseEntity getWorkflowInstances(@PathVariable(name = "id") Long workflowId);
}
