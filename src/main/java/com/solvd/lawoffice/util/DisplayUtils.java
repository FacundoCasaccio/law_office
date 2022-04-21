package com.solvd.lawoffice.util;

import com.solvd.lawoffice.agent.Lawyer;
import com.solvd.lawoffice.agent.Person;
import com.solvd.lawoffice.officestandard.DaysOfTheWeek;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public abstract class DisplayUtils {

    private static final Logger LOGGER = LogManager.getLogger(DisplayUtils.class);

    public static void listNames(List<Lawyer> lawyers, DaysOfTheWeek day, BiFunction<List<Lawyer>, DaysOfTheWeek, List<Lawyer>> filterByDay) {
        List<Lawyer> availableLawyers = filterByDay.apply(lawyers, day);

        LOGGER.info("Lawyers available on " + day + "\n");
        for (Lawyer lawyer : availableLawyers) {
            LOGGER.info(lawyer.getName() + lawyer.getSurname());
        }
    }

    public static void listNamesSorted(List<Lawyer> lawyers, Function<List<Lawyer>, List<Lawyer>> sorting) {
        List<Lawyer> sortedPeople = sorting.apply(lawyers);

        for (Person person : sortedPeople) {
            LOGGER.info(person.getName() + person.getSurname());
        }
    }
}
