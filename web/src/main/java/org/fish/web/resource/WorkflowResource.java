package org.fish.web.resource;

import com.fasterxml.jackson.annotation.JsonView;
import org.fish.workflow.data.type.EntityStatus;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Sumit Jha
 */
public class WorkflowResource extends RepresentationModel<WorkflowResource> {
    @JsonView(View.MINIMAL.class)
    private Long id;

    @JsonView(View.MINIMAL.class)
    private String name;

    @JsonView(View.SMALL.class)
    private LocalDateTime lastRunAt;

    @JsonView(View.SMALL.class)
    private Long activeInstanceCount;

    @JsonView(View.SMALL.class)
    private Long errorInstancesCount;

    @JsonView(View.MINIMAL.class)
    private EntityStatus status;

    @JsonView(View.FULL.class)
    private String createdBy;

    @JsonView(View.FULL.class)
    private LocalDateTime createdOn;

    @JsonView(View.FULL.class)
    private String updatedBy;

    @JsonView(View.FULL.class)
    private LocalDateTime updatedOn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EntityStatus getStatus() {
        return status;
    }

    public void setStatus(EntityStatus status) {
        this.status = status;
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

    public LocalDateTime getLastRunAt() {
        return lastRunAt;
    }

    public void setLastRunAt(LocalDateTime lastRunAt) {
        this.lastRunAt = lastRunAt;
    }

    public Long getActiveInstanceCount() {
        return activeInstanceCount;
    }

    public void setActiveInstanceCount(Long activeInstanceCount) {
        this.activeInstanceCount = activeInstanceCount;
    }

    public Long getErrorInstancesCount() {
        return errorInstancesCount;
    }

    public void setErrorInstancesCount(Long errorInstancesCount) {
        this.errorInstancesCount = errorInstancesCount;
    }
}
