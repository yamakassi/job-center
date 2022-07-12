package com.company.jobcenter.screen.jobcenter;

import com.company.jobcenter.entity.Vacancy;
import io.jmix.core.DataManager;
import io.jmix.core.LoadContext;
import io.jmix.ui.screen.*;
import com.company.jobcenter.entity.JobCenter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@UiController("JobCenter.browse")
@UiDescriptor("job-center-browse.xml")
@LookupComponent("jobCentersTable")
public class JobCenterBrowse extends StandardLookup<JobCenter> {
    @Autowired
    private DataManager dataManager;

    @Install(to = "vacanciesDl", target = Target.DATA_LOADER)
    private List<Vacancy> vacanciesDlLoadDelegate(LoadContext<Vacancy> loadContext) {

        List<Vacancy> vacanciesCenter =  dataManager.load(JobCenter.class).all().one().getVacancies();

        return  vacanciesCenter;
    }
}