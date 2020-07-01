package org.fish.workflow.data;

import org.fish.workflow.data.type.EntityStatus;

import javax.persistence.*;

import static org.fish.workflow.data.WorkflowDetail.TABLE_NAME;

/**
 * @author Sumit Jha
 */
@Entity
@Table(name = TABLE_NAME)
public class WorkflowDetail extends AbstractEntity {
    public static final String TABLE_NAME = "workflow_detail";

    private String name;

    @Enumerated(EnumType.STRING)
    @Column(length = 12)
    private EntityStatus status;

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
