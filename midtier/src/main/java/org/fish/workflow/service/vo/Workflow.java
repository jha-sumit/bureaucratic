package org.fish.workflow.service.vo;

import org.fish.workflow.data.WorkflowDetail;
import org.fish.workflow.data.type.EntityStatus;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

/**
 * @author Sumit Jha
 */
public class Workflow {
    private Long id;
    private String createdBy;
    private LocalDateTime createdOn;
    private String updatedBy;
    private LocalDateTime updatedOn;
    private Long activeInstanceCount;
    private Long errorInstancesCount;
    private LocalDateTime lastRunAt;
    private String name;
    private EntityStatus status;

    public Workflow() {
    }

    public Workflow(WorkflowDetail workflowDetail) {
        super();
        this.id = workflowDetail.getId();
        this.name = workflowDetail.getName();
        this.status = workflowDetail.getStatus();
        this.createdBy = workflowDetail.getCreatedBy();
//        this.createdOn =
        this.updatedBy = workflowDetail.getUpdatedBy();
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

    public LocalDateTime getLastRunAt() {
        return lastRunAt;
    }

    public void setLastRunAt(LocalDateTime lastRunAt) {
        this.lastRunAt = lastRunAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
