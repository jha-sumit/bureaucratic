package org.fish.workflow.data;

import org.fish.workflow.ResponseStatus;
import org.fish.workflow.data.type.EntityStatus;

import javax.persistence.*;

import static org.fish.workflow.data.WorkflowStepDetail.TABLE_NAME;

/**
 * @author Sumit Jha
 */
@Entity
@Table(name = TABLE_NAME)
public class WorkflowStepDetail extends AbstractEntity {
    public static final String TABLE_NAME = "workflow_step_detail";

    @ManyToOne
    @JoinColumn(name = "next_id",
            referencedColumnName = "id")
    private WorkflowStepDetail next;

    @ManyToOne
    @JoinColumn(name = "previous_id",
            referencedColumnName = "id")
    private WorkflowStepDetail previous;

    @Lob
    private byte[] payload;

    @Enumerated(EnumType.STRING)
    @Column(length = 4)
    private ResponseStatus responseStatus;

    @Enumerated(EnumType.STRING)
    @Column(length = 12)
    private EntityStatus status;

    @ManyToOne
    @JoinColumn(name = "workflow_id",
            referencedColumnName = "id")
    private WorkflowDetail workflowDetail;

    @ManyToOne
    @JoinColumn(name = "step_id",
            referencedColumnName = "id")
    private StepDetail stepDetail;

    public WorkflowStepDetail getNext() {
        return next;
    }

    public void setNext(WorkflowStepDetail next) {
        this.next = next;
    }

    public byte[] getPayload() {
        return payload;
    }

    public void setPayload(byte[] payload) {
        this.payload = payload;
    }

    public WorkflowStepDetail getPrevious() {
        return previous;
    }

    public void setPrevious(WorkflowStepDetail previous) {
        this.previous = previous;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public EntityStatus getStatus() {
        return status;
    }

    public void setStatus(EntityStatus status) {
        this.status = status;
    }

    public StepDetail getStepDetail() {
        return stepDetail;
    }

    public void setStepDetail(StepDetail stepDetail) {
        this.stepDetail = stepDetail;
    }

    public WorkflowDetail getWorkflowDetail() {
        return workflowDetail;
    }

    public void setWorkflowDetail(WorkflowDetail workflowDetail) {
        this.workflowDetail = workflowDetail;
    }
}
