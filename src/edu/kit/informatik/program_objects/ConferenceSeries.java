package edu.kit.informatik.program_objects;

import edu.kit.informatik.program_logic.List;

/**
 * Represents a ConferenceSeries. Conferences have to belong to a conference series.
 *
 * Created by Christian on 15.02.2017.
 */
public class ConferenceSeries implements Comparable<ConferenceSeries> {
    private String name;
    private List<Conference> conferenceList;

    /**
     * Constructs a new Conference Series with a name.
     * @param name The name of the journal.
     */
    public ConferenceSeries(String name) {
        this.name = name;
    }

    /**
     * Lexicographically compares this ConferenceSeries with the given ConferenceSeries by name
     * Returns a negative int if this ConferenceSeries name is lexicographically in front of the given
     * ConferenceSeries name.
     * Returns 0 if they are equal.
     * Returns a positive int if it is located after the given ConferenceSeries name.
     * Note: Upper case letters are lexicographically in front of lower case letters.
     * @param conSeries The ConferenceSeries to be compared to.
     * @return int negative, positive or 0 if this ConferenceSeries name is in front, after or equal to the parameter.
     */
    public int compareTo(ConferenceSeries conSeries) {
        return this.getName().compareTo(conSeries.getName());
    }

    /**
     * Returns the name of the ConferenceSeries.
     * @return String name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the conference list of this series.
     * @return The conference list of this series.
     */
    public List<Conference> getConferenceList() {
        return conferenceList;
    }
}
