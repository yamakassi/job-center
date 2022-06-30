package com.company.jobcenter.screen.jobcenter;

import io.jmix.ui.screen.*;
import com.company.jobcenter.entity.JobCenter;

@UiController("JobCenter.vacancies")
@UiDescriptor("job-center-vacancies.xml")
@LookupComponent("jobCentersTable")
public class JobCenterVacancies extends StandardLookup<JobCenter> {
}