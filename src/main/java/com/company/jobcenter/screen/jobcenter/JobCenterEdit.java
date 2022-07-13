package com.company.jobcenter.screen.jobcenter;

import com.company.jobcenter.entity.Vacancy;
import io.jmix.core.DataManager;
import io.jmix.core.LoadContext;
import io.jmix.ui.screen.*;
import com.company.jobcenter.entity.JobCenter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@UiController("JobCenter.edit")
@UiDescriptor("job-center-edit.xml")
@EditedEntityContainer("jobCenterDc")
public class JobCenterEdit extends StandardEditor<JobCenter> {
    @Autowired
    private DataManager dataManager;

    @Install(to = "vacanciesDl", target = Target.DATA_LOADER)
    private List<Vacancy> vacanciesDlLoadDelegate(LoadContext<Vacancy> loadContext) {

        List<Vacancy> vacanciesCenter =  dataManager.load(JobCenter.class).all().one().getVacancies();
        System.out.println(vacanciesCenter.size());
        return  vacanciesCenter;
    }
}