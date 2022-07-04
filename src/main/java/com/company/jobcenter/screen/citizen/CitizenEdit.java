package com.company.jobcenter.screen.citizen;

import io.jmix.ui.screen.*;
import com.company.jobcenter.entity.Citizen;

@UiController("Citizen.edit")
@UiDescriptor("citizen-edit.xml")
@EditedEntityContainer("citizenDc")
public class CitizenEdit extends StandardEditor<Citizen> {
    @Install(to = "professionField", subject = "fieldIconProvider")
    private String professionFieldIconProvider(Citizen citizen) {
        return (citizen != null) ? "font-icon:CHECK" : "font-icon:BAN";
    }
}