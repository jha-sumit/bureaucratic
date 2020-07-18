package org.fish.web.util;

import org.fish.commons.DateUtil;
import org.fish.commons.FluentBuilder;
import org.fish.web.resource.WorkflowInstanceResource;
import org.fish.web.resource.WorkflowResource;
import org.fish.workflow.data.InstanceDetail;
import org.fish.workflow.data.WorkflowDetail;
import org.fish.workflow.service.vo.Workflow;

import java.util.Objects;
import java.util.Optional;

import static org.fish.commons.DateUtil.localDateTimeOf;

/**
 * @author Sumit Jha
 */
public final class Translators {
    public static final WorkflowResource from(Workflow entity) {
        Objects.requireNonNull(entity);
        return FluentBuilder.of(WorkflowResource.class)
                .map(WorkflowResource::setId, () -> entity.getId())
                .map(WorkflowResource::setName, () -> entity.getName())
                .map(WorkflowResource::setActiveInstanceCount, () -> entity.getActiveInstanceCount())
                .map(WorkflowResource::setErrorInstancesCount, () -> entity.getErrorInstancesCount())
                .map(WorkflowResource::setCreatedBy, () -> entity.getCreatedBy())
                .map(WorkflowResource::setUpdatedBy, () -> entity.getUpdatedBy())
                .map(WorkflowResource::setCreatedOn, () -> Optional.ofNullable(entity.getCreatedOn())
                        .map(DateUtil::localDateTimeOf).orElse(null))
                .map(WorkflowResource::setUpdatedOn, () -> Optional.ofNullable(entity.getUpdatedOn())
                        .map(DateUtil::localDateTimeOf).orElse(null))
                .map(WorkflowResource::setLastRunAt, () -> Optional.ofNullable(entity.getLastRunAt())
                        .map(DateUtil::localDateTimeOf).orElse(null))
                .map(WorkflowResource::setStatus, () -> entity.getStatus())
                .build();
    }

    public static final WorkflowInstanceResource from(InstanceDetail entity) {
        Objects.requireNonNull(entity);
        return FluentBuilder.of(WorkflowInstanceResource.class)
                .map(WorkflowInstanceResource::setId, () -> entity.getId())
                .map(WorkflowInstanceResource::setWorkflowId, () -> Optional
                        .ofNullable(entity.getWorkflowDetail())
                        .map(WorkflowDetail::getId)
                        .orElse(null))
                .map(WorkflowInstanceResource::setWorkflowName, () -> Optional
                        .ofNullable(entity.getWorkflowDetail())
                        .map(WorkflowDetail::getName)
                        .orElse(null))
                .map(WorkflowInstanceResource::setCreatedBy, () -> entity.getCreatedBy())
                .map(WorkflowInstanceResource::setUpdatedBy, () -> entity.getUpdatedBy())
                .map(WorkflowInstanceResource::setCreatedOn, () -> Optional.ofNullable(entity.getCreatedOn())
                        .map(DateUtil::localDateTimeOf).orElse(null))
                .map(WorkflowInstanceResource::setUpdatedOn, () -> Optional.ofNullable(entity.getUpdatedOn())
                        .map(DateUtil::localDateTimeOf).orElse(null))
                .map(WorkflowInstanceResource::setStatus, () -> entity.getStatus())
                .map(WorkflowInstanceResource::setExecutionStatus, () -> entity.getExecutionStatus())
                .map(WorkflowInstanceResource::setPayload, () -> Optional.ofNullable(entity.getPayload())
                        .map(b -> new String(b)).orElse(null))
                .map(WorkflowInstanceResource::setSchedule, () -> entity.getSchedule())
                .build();
    }
}
