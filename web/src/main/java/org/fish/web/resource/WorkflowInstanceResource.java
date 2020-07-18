package org.fish.web.resource;

import com.fasterxml.jackson.annotation.JsonView;
import org.fish.workflow.data.type.EntityStatus;
import org.fish.workflow.data.type.ExecutionStatus;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;

/**
 * @author Sumit Jha
 */
public class WorkflowInstanceResource extends RepresentationModel<WorkflowInstanceResource> {

    @JsonView(View.MINIMAL.class)
    private Long id;

    @JsonView(View.SMALL.class)
    private Long workflowId;

    @JsonView(View.SMALL.class)
    private String workflowName;

    @JsonView(View.FULL.class)
    private String payload;

    @JsonView(View.MINIMAL.class)
    private EntityStatus status;

    @JsonView(View.SMALL.class)
    private ExecutionStatus executionStatus;

    @JsonView(View.SMALL.class)
    private String schedule;

    @JsonView(View.FULL.class)
    private String createdBy;

    @JsonView(View.FULL.class)
    private LocalDateTime createdOn;

    @JsonView(View.FULL.class)
    private String updatedBy;

    @JsonView(View.FULL.class)
    private LocalDateTime updatedOn;

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public EntityStatus getStatus() {
        return status;
    }

    public void setStatus(EntityStatus status) {
        this.status = status;
    }

    public ExecutionStatus getExecutionStatus() {
        return executionStatus;
    }

    public void setExecutionStatus(ExecutionStatus executionStatus) {
        this.executionStatus = executionStatus;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(Long workflowId) {
        this.workflowId = workflowId;
    }

    public String getWorkflowName() {
        return workflowName;
    }

    public void setWorkflowName(String workflowName) {
        this.workflowName = workflowName;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }
}
