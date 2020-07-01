package org.fish.web.resource;

import com.fasterxml.jackson.annotation.JsonView;
import org.fish.workflow.data.type.EntityStatus;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;

/**
 * @author Sumit Jha
 */
public class Workflow extends RepresentationModel<Workflow> {
    @JsonView(View.MINIMAL.class)
    private Long id;

    @JsonView(View.MINIMAL.class)
    private String name;

    @JsonView(View.MINIMAL.class)
    private EntityStatus status;

    @JsonView(View.SMALL.class)
    private String createdBy;

    @JsonView(View.SMALL.class)
    private LocalDateTime createdOn;

    @JsonView(View.SMALL.class)
    private String updatedBy;

    @JsonView(View.SMALL.class)
    private LocalDateTime updatedOn;
}
