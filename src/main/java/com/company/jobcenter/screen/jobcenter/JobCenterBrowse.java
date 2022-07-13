package com.company.jobcenter.screen.jobcenter;

import io.jmix.ui.screen.*;
import com.company.jobcenter.entity.JobCenter;

@UiController("JobCenter.browse")
@UiDescriptor("job-center-browse.xml")
@LookupComponent("jobCentersTable")
public class JobCenterBrowse extends StandardLookup<JobCenter> {
}