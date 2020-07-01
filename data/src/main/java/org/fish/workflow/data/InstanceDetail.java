package org.fish.workflow.data;

import org.fish.workflow.data.type.EntityStatus;
import org.fish.workflow.data.type.ExecutionStatus;

import javax.persistence.*;

import static org.fish.workflow.data.InstanceDetail.TABLE_NAME;

/**
 * @author Sumit Jha
 */
@Entity
@Table(name = TABLE_NAME)
public class InstanceDetail extends AbstractEntity {
    public static final String TABLE_NAME = "workflow_instance_detail";

    @ManyToOne
    @JoinColumn(name = "workflow_id",
            referencedColumnName = "id")
    private WorkflowDetail workflowDetail;

    @Lob
    private byte[] payload;

    @Enumerated(EnumType.STRING)
    @Column(length = 12)
    private EntityStatus status;

    @Enumerated(EnumType.STRING)
    @Column(length = 12)
    private ExecutionStatus executionStatus;

    private String schedule;

    public byte[] getPayload() {
        return payload;
    }

    public void setPayload(byte[] payload) {
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

    public WorkflowDetail getWorkflowDetail() {
        return workflowDetail;
    }

    public void setWorkflowDetail(WorkflowDetail workflowDetail) {
        this.workflowDetail = workflowDetail;
    }
}
