package org.fish.web.resource;

import com.fasterxml.jackson.annotation.JsonView;
import org.fish.workflow.data.type.EntityStatus;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;

/**
 * @author Sumit Jha
 */
public class Step extends RepresentationModel<Step> {
    @JsonView(View.MINIMAL.class)
    private Long id;

    @JsonView(View.SMALL.class)
    private String name;

    @JsonView({View.SMALL.class})
    private String bean;

    @JsonView(View.MINIMAL.class)
    private EntityStatus status;

    @JsonView(View.FULL.class)
    private byte[] payload;

    @JsonView(View.SMALL.class)
    private String createdBy;

    @JsonView(View.SMALL.class)
    private LocalDateTime createdOn;

    @JsonView(View.SMALL.class)
    private String updatedBy;

    @JsonView(View.SMALL.class)
    private LocalDateTime updatedOn;
}
