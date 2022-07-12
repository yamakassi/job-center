package com.company.jobcenter.screen.jobcenter;

import com.company.jobcenter.entity.Citizen;
import com.company.jobcenter.entity.Vacancy;
import io.jmix.core.DataManager;
import io.jmix.core.LoadContext;
import io.jmix.ui.screen.*;
import com.company.jobcenter.entity.JobCenter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@UiController("JobCenter.browseRegisteredCitizens")
@UiDescriptor("job-center-browse-registeredCitizens.xml")
@LookupComponent("jobCentersTable")
public class JobCenterBrowseRegisteredCitizens extends StandardLookup<JobCenter> {
    @Autowired
    private DataManager dataManager;

    @Install(to = "registeredCitizensDl", target = Target.DATA_LOADER)
    private List<Citizen> registeredCitizensDlLoadDelegate(LoadContext<Citizen> loadContext) {

        List<Citizen> registeredCitizens =  dataManager.load(JobCenter.class).all().one().getRegisteredCitizens();

        return  registeredCitizens;
    }
}