package org.fish.workflow.data.repository;

import org.fish.workflow.data.WorkflowStepDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sumit Jha
 */
@Repository
public interface WorkflowStepRepository extends JpaRepository<WorkflowStepDetail, Long> {
}
