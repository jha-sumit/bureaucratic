package org.fish.web.resource;

import com.fasterxml.jackson.annotation.JsonView;
import org.fish.workflow.ResponseStatus;
import org.fish.workflow.data.StepDetail;
import org.fish.workflow.data.WorkflowDetail;
import org.fish.workflow.data.type.EntityStatus;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

/**
 * @author Sumit Jha
 */
public class WorkflowChart extends RepresentationModel<WorkflowChart> {
    @JsonView(View.MINIMAL.class)
    private Long stepId;


    private byte[] payload;

    private ResponseStatus responseStatus;

    @Enumerated(EnumType.STRING)
    @Column(length = 12)
    private EntityStatus status;

    private WorkflowDetail workflow;
    private StepDetail step;

    @JsonView(View.SMALL.class)
    private String createdBy;

    @JsonView(View.SMALL.class)
    private LocalDateTime createdOn;

    @JsonView(View.SMALL.class)
    private String updatedBy;

    @JsonView(View.SMALL.class)
    private LocalDateTime updatedOn;

    @JsonView(View.SMALL.class)
    private Long activeInstanceCount;
    @JsonView(View.SMALL.class)
    private Long errorInstancesCount;
    @JsonView(View.SMALL.class)
    private LocalDateTime lastRunAt;
}
