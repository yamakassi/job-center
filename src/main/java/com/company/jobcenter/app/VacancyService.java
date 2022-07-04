package com.company.jobcenter.app;

import com.company.jobcenter.entity.Citizen;
import com.company.jobcenter.entity.RegistrationCard;
import com.company.jobcenter.entity.Vacancy;
import io.jmix.core.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VacancyService {

    public static final long MIN_SALARY = 1000;

    @Autowired
    private DataManager dataManager;

    public List<Vacancy> loadSuitableVacancies(Citizen editedEntity) {
        List<Vacancy> allVacancy = dataManager.load(Vacancy.class).all().list();

        return allVacancy.stream()
                .filter(vacancy ->
                        vacancy.getProfessions().contains(editedEntity.getProfession()))
                .collect(Collectors.toList());

    }


    public Collection<Citizen> setRegisterCardAfterEmploymenCitizen(Collection<Citizen> collection, Vacancy vacancy) {
        List<RegistrationCard> registrationCards = dataManager.load(RegistrationCard.class).all().list();
        List<Citizen> citizenSelect = collection.stream().collect(Collectors.toList());
        for (Citizen citizen : citizenSelect) {
            citizen.setIsEmployment(Boolean.TRUE);


            if (vacancy.getRate() < 1 && vacancy.getSalary() < MIN_SALARY) {
                RegistrationCard cardRegist = registrationCards.stream().filter(card -> card.getCitizen().equals(citizen)).findFirst().orElse(null);
                if ( cardRegist==null) {
                      throw new IllegalStateException("citizen is not registered in the job center");
                }
                cardRegist.setIsBenifitPaid(Boolean.FALSE);
                cardRegist.setAmountBenefit(0L);
                dataManager.save(cardRegist);
            }
        }
        return citizenSelect;
    }

    public boolean validateRegistrationCardCitizen(Collection<Citizen> selectedValidateCitizen) {
        List<RegistrationCard> registrationCards = dataManager.load(RegistrationCard.class).all().list();
        List<Citizen> citizenValidateSelect = selectedValidateCitizen.stream().collect(Collectors.toList());
        for (Citizen citizen : citizenValidateSelect) {




                Long countC = registrationCards.stream().filter(card -> card.getCitizen().equals(citizen)).count();

                if(countC==0) return false;


            }
        return  true;
        }

}