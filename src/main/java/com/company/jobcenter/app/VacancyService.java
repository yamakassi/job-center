package com.company.jobcenter.app;

import com.company.jobcenter.entity.Citizen;
import com.company.jobcenter.entity.RegistrationCard;
import com.company.jobcenter.entity.Vacancy;
import io.jmix.core.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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
        List<Citizen> citizenSelect = new ArrayList<>(collection);
        for (Citizen citizen : citizenSelect) {
            citizen.setIsEmployment(Boolean.TRUE);

            RegistrationCard cardRegist = registrationCards.stream()
                    .filter(card -> card.getCitizen().equals(citizen))
                    .findAny()
                    .orElseThrow(() -> new IllegalStateException("citizen is not registered in the job center"));

            if (vacancy.getRate() >= 1 && vacancy.getSalary() > MIN_SALARY) {

                cardRegist.setIsBenifitPaid(Boolean.FALSE);

                cardRegist.setAmountBenefit(0L);

            }
            cardRegist.setDateStartWork(new Date());
            dataManager.save(cardRegist);
        }
        return citizenSelect;
    }

    public boolean validateRegistrationCardCitizen(Collection<Citizen> selectedValidateCitizen) {
        List<RegistrationCard> registrationCards = dataManager.load(RegistrationCard.class).all().list();
        List<Citizen> citizenValidateSelect = new ArrayList<>(selectedValidateCitizen);
        for (Citizen citizen : citizenValidateSelect) {
            long countC = registrationCards.stream().filter(card -> card.getCitizen().equals(citizen)).count();
            if (countC == 0) return false;
        }
        return true;
    }

}