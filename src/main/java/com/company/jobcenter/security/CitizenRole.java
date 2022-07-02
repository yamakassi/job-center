package com.company.jobcenter.security;

import com.company.jobcenter.entity.JobCenter;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;

@ResourceRole(name = "Citizen", code = "citizen")
public interface CitizenRole {
    @EntityAttributePolicy(entityClass = JobCenter.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = JobCenter.class, actions = EntityPolicyAction.READ)
    void jobCenter();
}