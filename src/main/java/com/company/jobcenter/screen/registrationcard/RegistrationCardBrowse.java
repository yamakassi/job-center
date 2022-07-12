package com.company.jobcenter.screen.registrationcard;

import com.company.jobcenter.entity.Citizen;
import com.company.jobcenter.entity.JobCenter;
import io.jmix.core.DataManager;
import io.jmix.core.EntityStates;
import io.jmix.ui.component.Button;
import io.jmix.ui.screen.*;
import com.company.jobcenter.entity.RegistrationCard;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@UiController("RegistrationCard.browse")
@UiDescriptor("registration-card-browse.xml")
@LookupComponent("table")
public class RegistrationCardBrowse extends MasterDetailScreen<RegistrationCard> {



    @Install(to = "citizenField", subject = "fieldIconProvider")
    private String citizenFieldIconProvider(Citizen citizen) {
        return (citizen != null) ? "font-icon:CHECK" : "font-icon:BAN";
    }
}