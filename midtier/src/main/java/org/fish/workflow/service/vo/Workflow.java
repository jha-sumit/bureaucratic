package org.fish.workflow.service.vo;

import org.fish.workflow.data.WorkflowDetail;
import org.fish.workflow.data.type.EntityStatus;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Sumit Jha
 */
public class Workflow {
    private Long id;
    private String createdBy;
    private Calendar createdOn;
    private String updatedBy;
    private Calendar updatedOn;
    private Long activeInstanceCount;
    private Long errorInstancesCount;
    private Calendar lastRunAt;
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
        this.createdOn = workflowDetail.getCreatedOn();
        this.createdOn = workflowDetail.getUpdatedOn();
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

    public Calendar getLastRunAt() {
        return lastRunAt;
    }

    public void setLastRunAt(Calendar lastRunAt) {
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

    public Calendar getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Calendar createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Calendar getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Calendar updatedOn) {
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
