package com.company.jobcenter.screen.jobcenter;

import io.jmix.ui.screen.*;
import com.company.jobcenter.entity.JobCenter;

@UiController("JobCenter.citizens")
@UiDescriptor("job-center-citizens.xml")
@LookupComponent("jobCentersTable")
public class JobCenterCitizens extends StandardLookup<JobCenter> {
}