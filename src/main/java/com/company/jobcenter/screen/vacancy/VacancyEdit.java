package com.company.jobcenter.screen.vacancy;

import io.jmix.ui.screen.*;
import com.company.jobcenter.entity.Vacancy;

@UiController("Vacancy.edit")
@UiDescriptor("vacancy-edit.xml")
@EditedEntityContainer("vacancyDc")
public class VacancyEdit extends StandardEditor<Vacancy> {
}