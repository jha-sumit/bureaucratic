package org.fish.workflow.data.repository;

import org.fish.workflow.data.WorkflowDetail;
import org.fish.workflow.data.type.EntityStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

/**
 * @author Sumit Jha
 */
@Repository
public interface WorkflowRepository extends JpaRepository<WorkflowDetail, Long> {
    Stream<WorkflowDetail> findAllByStatus(EntityStatus status);
}
