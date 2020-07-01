package org.fish.workflow.data.repository;

import org.fish.workflow.data.InstanceDetail;
import org.fish.workflow.data.type.EntityStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author Sumit Jha
 */
@Repository
public interface WorkflowInstanceRepository extends JpaRepository<InstanceDetail, Long> {
    Stream<InstanceDetail> findAllByStatusAndWorkflowDetail_IdIn(EntityStatus status, List<Long> workflowIds);
}
