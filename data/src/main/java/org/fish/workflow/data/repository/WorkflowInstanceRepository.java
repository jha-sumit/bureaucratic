package org.fish.workflow.data.repository;

import org.fish.workflow.data.InstanceDetail;
import org.fish.workflow.data.type.EntityStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Sumit Jha
 */
@Repository
public interface WorkflowInstanceRepository extends JpaRepository<InstanceDetail, Long> {
    List<InstanceDetail> findAllByStatusAndWorkflowDetail_IdIn(EntityStatus status, List<Long> workflowIds);
    List<InstanceDetail> findAllByWorkflowDetail_Id(Long workflowId);
}
