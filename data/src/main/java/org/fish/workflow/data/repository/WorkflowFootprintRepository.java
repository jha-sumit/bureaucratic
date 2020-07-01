package org.fish.workflow.data.repository;

import org.fish.workflow.data.FootprintDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sumit Jha
 */
@Repository
public interface WorkflowFootprintRepository extends JpaRepository<FootprintDetail, Long> {
}
