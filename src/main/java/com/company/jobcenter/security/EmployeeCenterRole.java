package com.company.jobcenter.security;

import com.company.jobcenter.entity.*;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityui.role.annotation.MenuPolicy;
import io.jmix.securityui.role.annotation.ScreenPolicy;

@ResourceRole(name = "EmployeeCenter", code = "employee-center")
public interface EmployeeCenterRole {
    @EntityAttributePolicy(entityClass = Citizen.class, attributes = "isEmployment", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Citizen.class, actions = EntityPolicyAction.ALL)
    @EntityAttributePolicy(entityClass = Citizen.class, attributes = {"id", "version", "firstName", "lastName", "patronymic", "profession", "createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate", "deletedBy", "deletedDate", "jobCenter", "vacancy"}, action = EntityAttributePolicyAction.MODIFY)
    void citizen();

    @EntityAttributePolicy(entityClass = RegistrationCard.class, attributes = "dateStartWork", action = EntityAttributePolicyAction.VIEW)
    @EntityAttributePolicy(entityClass = RegistrationCard.class, attributes = {"isBenifitPaid", "amountBenefit", "citizen"}, action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = RegistrationCard.class, actions = EntityPolicyAction.ALL)
    void registrationCard();

    @EntityPolicy(entityClass = Vacancy.class, actions = EntityPolicyAction.ALL)
    @EntityAttributePolicy(entityClass = Vacancy.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    void vacancy();

    @MenuPolicy(menuIds = {"Citizen.browse", "Vacancy.browse", "themeSettingsScreen", "RegistrationCard.browse", "Profession.browse"})
    @ScreenPolicy(screenIds = {"Citizen.browse", "Profession.browse", "RegistrationCard.browse", "Vacancy.browse", "MainScreen", "LoginScreen", "themeSettingsScreen", "User.browse", "Citizen.edit", "Profession.edit", "Vacancy.edit"})
    void screens();

    @EntityAttributePolicy(entityClass = User.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = User.class, actions = EntityPolicyAction.READ)
    void user();

    @EntityPolicy(entityClass = Profession.class, actions = EntityPolicyAction.ALL)
    @EntityAttributePolicy(entityClass = Profession.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    void profession();
}