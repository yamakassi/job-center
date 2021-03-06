package com.company.jobcenter.screen.vacancy;

import com.company.jobcenter.app.VacancyService;
import com.company.jobcenter.entity.Citizen;
import com.company.jobcenter.screen.citizen.CitizenBrowse;
import io.jmix.core.Messages;
import io.jmix.core.Sort;
import io.jmix.core.common.util.ParamsMap;
import io.jmix.ui.Notifications;
import io.jmix.ui.RemoveOperation;
import io.jmix.ui.action.list.AddAction;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.screen.*;
import com.company.jobcenter.entity.Vacancy;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@UiController("Vacancy.edit")
@UiDescriptor("vacancy-edit.xml")
@EditedEntityContainer("vacancyDc")
public class VacancyEdit extends StandardEditor<Vacancy> {
    @Install(to = "employeesTable.add", subject = "screenConfigurer")
    private void employeesTableAddScreenConfigurer(Screen lookupScreen) {
        ((CitizenBrowse) lookupScreen).setIsEmploymentParameter(true);
    }
    @Autowired
    private VacancyService vacancyService;
    @Autowired
    private Notifications notifications;


    @Autowired
    private MessageBundle messageBundle;





    @Install(to = "employeesTable.add", subject = "transformation")
    private Collection<Citizen> employeesTableAddTransformation(Collection<Citizen> collection) {


        return vacancyService.setRegisterCardAfterEmploymenCitizen(collection, getEditedEntity());



    }





    @Install(to = "employeesTable.exclude", subject = "afterActionPerformedHandler")
    private void employeesTableExcludeAfterActionPerformedHandler(RemoveOperation.AfterActionPerformedEvent<Citizen> afterActionPerformedEvent) {
        afterActionPerformedEvent.getItems().get(0).setIsEmployment(false);
    }

    @Install(to = "employeesTable.add", subject = "selectValidator")
    private boolean employeesTableAddSelectValidator(LookupScreen.ValidationContext<Citizen> validationContext) {
        if(vacancyService.validateRegistrationCardCitizen(validationContext.getSelectedItems())==false){
            String messageDescript = messageBundle.getMessage( "notRegistrationCartCitizen");
            String messageCaption = messageBundle.getMessage("captionNotRegistrationCartCitizen");
            notifications.create(Notifications.NotificationType.WARNING)
                    .withCaption(messageCaption)
                    .withDescription(messageDescript)
                    .withPosition(Notifications.Position.MIDDLE_CENTER)
                    .show();
            return false;

        }
        return true;
    }


}