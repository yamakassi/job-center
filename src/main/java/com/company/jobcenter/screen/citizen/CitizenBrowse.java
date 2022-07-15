package com.company.jobcenter.screen.citizen;

import io.jmix.ui.component.HasValue;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.screen.*;
import com.company.jobcenter.entity.Citizen;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Citizen.browse")
@UiDescriptor("citizen-browse.xml")
@LookupComponent("citizensTable")
public class CitizenBrowse extends StandardLookup<Citizen> {
    @Autowired
    private CollectionLoader<Citizen> citizensDl;

    public void setIsEmploymentParameter(boolean b) {
        citizensDl.setParameter("isEmployment",b);
        citizensDl.load();
    }
}