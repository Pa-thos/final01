package edu.kit.informatik.program_logic;

import edu.kit.informatik.program_objects.Author;
import edu.kit.informatik.program_objects.Journal;
import edu.kit.informatik.program_objects.ConferenceSeries;
import edu.kit.informatik.program_objects.Conference;

/**
 * Represents the literature and citation manager. Stores the received information in lists and
 * provides methods to access and modify the information.
 * Created by Christian on 11.02.2017.
 */
class LiteratureManager {
    private List<Author> authorList;
    private List<Journal> journalList;
    private List<ConferenceSeries> seriesList;
    private List<Conference> conferenceList;

    /**
     * Constructs a literature manager.
     */
    LiteratureManager() {
        this.authorList = new List<>();
        this.journalList = new List<>();
        this.seriesList = new List<>();
        this.conferenceList = new List<>();
    }

    /**
     * Returns the author list.
     * @return The author list.
     */
    List<Author> getAuthorList() {
        return authorList;
    }

    /**
     * Returns the journal list.
     * @return The journal list.
     */
    List<Journal> getJournalList() {
        return journalList;
    }

    /**
     * Returns the conference series list.
     * @return The conference series list.
     */
    List<ConferenceSeries> getSeriesList() {
        return seriesList;
    }

    /**
     * Returns the conference list.
     * @return The conference list.
     */
    List<Conference> getConferenceList() {
        return conferenceList;
    }
}
