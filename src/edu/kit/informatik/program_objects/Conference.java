package edu.kit.informatik.program_objects;

import edu.kit.informatik.program_logic.List;

/**
 * Represents a conference that belongs to a conference series and
 * takes place in a specific year at a specific location.
 *
 * Created by Christian on 15.02.2017.
 */
public class Conference implements Comparable<Conference> {
    private ConferenceSeries series;
    private int year;
    private String location;
    private List<Article> articleList;

    /**
     * Constructs a new Conference with a series, a year and a location.
     * @param series The conference series this conference belongs to.
     * @param year The year the conference series has been held in.
     * @param location The location where the conference series has been held.
     */
    public Conference(ConferenceSeries series, int year, String location) {
        this.series = series;
        this.year = year;
        this.location = location;
    }

    /**
     * Compares this conference with the given conference. First their conferenceSeries are lexicographically compared.
     * If those are equal, the years are compared.
     * Returns 0 if they are equal.
     * Returns a positive int if this conference is sorted in after the given conference.
     * @param conference The conference to be compared with.
     * @return int negative, positive or 0 if this Conference is in front, after or equal to the parameter.
     */
    public int compareTo(Conference conference) {
        int returnValue;
        returnValue = this.getSeries().compareTo(conference.getSeries());
        if (returnValue == 0) {
            returnValue = this.getYear() - conference.getYear();
        }
        return returnValue;
    }

    /**
     * Returns the series this conference belongs to.
     * @return the ConferenceSeries this conference belongs to.
     */
    public ConferenceSeries getSeries() {
        return series;
    }

    /**
     * Returns the year the conference was held in.
     * @return the year the conference was held in.
     */
    public int getYear() {
        return year;
    }

}
