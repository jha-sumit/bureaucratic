package org.fish.workflow.data;

import org.fish.workflow.data.type.EntityStatus;

import javax.persistence.*;

import static org.fish.workflow.data.StepDetail.TABLE_NAME;

/**
 * @author Sumit Jha
 */
@Entity
@Table(name = TABLE_NAME)
public class StepDetail extends AbstractEntity {
    public static final String TABLE_NAME = "step_detail";

    private String name;
    private String bean;
    
    @Lob
    private byte[] payload;

    @Enumerated(EnumType.STRING)
    @Column(length = 12)
    private EntityStatus status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBean() {
        return bean;
    }

    public void setBean(String bean) {
        this.bean = bean;
    }

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
}
