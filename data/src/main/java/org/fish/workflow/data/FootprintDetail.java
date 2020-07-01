package org.fish.workflow.data;

import org.fish.workflow.ResponseStatus;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Calendar;

import static org.fish.workflow.data.FootprintDetail.TABLE_NAME;

/**
 * @author Sumit Jha
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = TABLE_NAME)
public class FootprintDetail {
    public static final String TABLE_NAME = "workflow_instance_footprint";

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "workflow_instance_id",
            referencedColumnName = "id")
    private InstanceDetail instanceDetail;

    @ManyToOne
    @JoinColumn(name = "workflow_step_id",
            referencedColumnName = "id")
    private WorkflowStepDetail workflowStepDetail;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    Calendar startedAt;

    @Lob
    private byte[] response;

    @Enumerated(EnumType.STRING)
    @Column(length = 4)
    private ResponseStatus responseCode;

    @Temporal(TemporalType.TIMESTAMP)
    Calendar endedAt;

    public Long getId() {
        return id;
    }

    public InstanceDetail getInstanceDetail() {
        return instanceDetail;
    }

    public WorkflowStepDetail getWorkflowStepDetail() {
        return workflowStepDetail;
    }

    public Calendar getStartedAt() {
        return startedAt;
    }

    public byte[] getResponse() {
        return response;
    }

    public ResponseStatus getResponseCode() {
        return responseCode;
    }

    public Calendar getEndedAt() {
        return endedAt;
    }

    public void setInstanceDetail(InstanceDetail instanceDetail) {
        this.instanceDetail = instanceDetail;
    }

    public void setWorkflowStepDetail(WorkflowStepDetail workflowStepDetail) {
        this.workflowStepDetail = workflowStepDetail;
    }

    public void setResponse(byte[] response) {
        this.response = response;
    }

    public void setResponseCode(ResponseStatus responseCode) {
        this.responseCode = responseCode;
    }

    public void setEndedAt(Calendar endedAt) {
        this.endedAt = endedAt;
    }
}
