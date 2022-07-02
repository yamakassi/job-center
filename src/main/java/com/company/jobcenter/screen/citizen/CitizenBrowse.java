package com.company.jobcenter.screen.citizen;

import io.jmix.ui.component.Button;
import io.jmix.ui.screen.*;
import com.company.jobcenter.entity.Citizen;

@UiController("Citizen.browse")
@UiDescriptor("citizen-browse.xml")
@LookupComponent("citizensTable")
public class CitizenBrowse extends StandardLookup<Citizen> {

}