package com.company.jobcenter.screen.registrationcard;

import com.company.jobcenter.entity.Citizen;
import io.jmix.ui.component.LayoutClickNotifier;
import io.jmix.ui.screen.*;
import com.company.jobcenter.entity.RegistrationCard;

@UiController("RegistrationCard.browse")
@UiDescriptor("registration-card-browse.xml")
@LookupComponent("table")
public class RegistrationCardBrowse extends MasterDetailScreen<RegistrationCard> {
    @Install(to = "citizenField", subject = "fieldIconProvider")
    private String citizenFieldIconProvider(Citizen citizen) {
        return (citizen != null) ? "font-icon:CHECK" : "font-icon:BAN";
    }

    @Subscribe
    public void onInitEntity(InitEntityEvent<RegistrationCard> event) {
        event.getEntity().setIsBenifitPaid(Boolean.TRUE);
    }

   
}