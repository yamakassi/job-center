package com.company.jobcenter.screen.vacancy;

import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.model.CollectionPropertyContainer;
import io.jmix.ui.screen.*;
import com.company.jobcenter.entity.Vacancy;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Vacancy.browse")
@UiDescriptor("vacancy-browse.xml")
@LookupComponent("vacanciesTable")
public class VacancyBrowse extends StandardLookup<Vacancy> {

}