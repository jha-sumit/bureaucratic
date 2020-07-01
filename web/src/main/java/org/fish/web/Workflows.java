package org.fish.web;

import org.fish.web.resource.Workflow;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Sumit Jha
 */
@RestController
@RequestMapping("/workflows")
public interface Workflows {
    @PostMapping
    ResponseEntity createWorkflow(@RequestBody Workflow workflow);

    @GetMapping
    ResponseEntity getWorkflows();
}
