package com.company.jobcenter.screen.vacancy;

import io.jmix.ui.screen.*;
import com.company.jobcenter.entity.Vacancy;

@UiController("Vacancy.browse")
@UiDescriptor("vacancy-browse.xml")
@LookupComponent("vacanciesTable")
public class VacancyBrowse extends StandardLookup<Vacancy> {
}