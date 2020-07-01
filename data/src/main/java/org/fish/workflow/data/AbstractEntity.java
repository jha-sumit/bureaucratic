package org.fish.workflow.data;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Calendar;

/**
 * @author Sumit Jha
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity {
    @Id
    @GeneratedValue
    Long id;

    @CreatedBy
    String createdBy;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    Calendar createdOn;

    @LastModifiedBy
    String updatedBy;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    Calendar updatedOn;

    public Long getId() {
        return id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Calendar getCreatedOn() {
        return createdOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public Calendar getUpdatedOn() {
        return updatedOn;
    }
}
