package com.company.jobcenter.app;

import com.company.jobcenter.entity.Citizen;
import com.company.jobcenter.entity.Vacancy;
import io.jmix.core.DataManager;
import io.jmix.core.Sort;
import io.jmix.core.querycondition.Condition;
import io.jmix.ui.component.data.TableItems;
import io.jmix.ui.component.data.table.ContainerTableItems;
import io.jmix.ui.model.CollectionContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VacancyService {


    @Autowired
    private DataManager dataManager;

    public List<Vacancy> loadSuitableVacancies( Citizen editedEntity) {
        List<Vacancy>  allVacancy =   dataManager.load(Vacancy.class).all().list();
        System.out.println(allVacancy);
        return allVacancy.stream()
                .filter(vacancy ->
                        vacancy.getProfessions().contains(editedEntity.getProfession()))
                .collect(Collectors.toList());

    }



}