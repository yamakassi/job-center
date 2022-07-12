package com.company.jobcenter.screen.citizen;

import com.company.jobcenter.app.VacancyService;
import com.company.jobcenter.entity.Vacancy;
import io.jmix.core.EntityStates;
import io.jmix.core.LoadContext;
import io.jmix.ui.Notifications;
import io.jmix.ui.component.Label;
import io.jmix.ui.component.Table;
import io.jmix.ui.component.data.datagrid.ContainerDataGridItems;
import io.jmix.ui.model.CollectionContainer;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.screen.*;
import com.company.jobcenter.entity.Citizen;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@UiController("Citizen.edit")
@UiDescriptor("citizen-edit.xml")
@EditedEntityContainer("citizenDc")
public class CitizenEdit extends StandardEditor<Citizen> {



    @Autowired
    protected MessageBundle messageBundle;
   @Autowired
    private VacancyService vacancyService;

    @Autowired
    private Notifications notifications;



    @Install(to = "professionField", subject = "fieldIconProvider")
    private String professionFieldIconProvider(Citizen citizen) {
        return (citizen != null) ? "font-icon:CHECK" : "font-icon:BAN";
    }

    @Install(to = "vacanciesDl", target = Target.DATA_LOADER)
    private  List<Vacancy> vacanciesDlLoadDelegate(LoadContext<Vacancy> loadContext) {

        List<Vacancy> suitableVacancies = vacancyService.loadSuitableVacancies(getEditedEntity());

        return  suitableVacancies;
    }

    @Subscribe(id = "vacanciesDl", target = Target.DATA_LOADER)
    public void onVacanciesDlPostLoad(CollectionLoader.PostLoadEvent<Vacancy> event) {

    }





}