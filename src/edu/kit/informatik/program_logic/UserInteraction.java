package edu.kit.informatik.program_logic;

import edu.kit.informatik.program_objects.Author;
import edu.kit.informatik.program_objects.Journal;
import edu.kit.informatik.program_objects.ConferenceSeries;
import edu.kit.informatik.program_objects.Conference;
import edu.kit.informatik.exceptions.SemanticsException;
import edu.kit.informatik.exceptions.SyntaxException;

/**
 * This class starts the literature manager and handles the user interaction.
 * Valid commands are defined as constants.
 * Exceptions will be thrown for invalid input.
 *
 * Created by Christian Hauser on 11.02.2017.
 */
final class UserInteraction {
    private static final String COMMAND_QUIT = "quit";
    private static final String COMMAND_ADD = "add";
        private static final String ADD_COMMAND_AUTHOR = "Author";
        private static final String ADD_COMMAND_JOURNAL = "journal";
        private static final String ADD_COMMAND_CONFERENCE = "conference";
        private static final String ADD_COMMAND_ARTICLE = "Article";
        private static final String ADD_COMMAND_KEYWORDS = "keywords";
    private static final String COMMAND_WRITTEN_BY = "written-by";
    private static final String COMMAND_CITES = "cites";
    private static final String COMMAND_ALL = "all";
        private static final String ALL_COMMAND_PUBLICATIONS = "publications";
    private static final String COMMAND_LIST = "list";
        private static final String LIST_COMMAND_INVALID_PUBLICATIONS = "invalid publications";
    private static final String COMMAND_PUBLICATIONS = "publications";
        private static final String PUBLICATIONS_COMMAND_BY = "by";
    private static final String COMMAND_IN = "in";
        private static final String IN_COMMAND_PROCEEDINGS = "proceedings";
    private static final String COMMAND_FIND = "find";
        private static final String FIND_COMMAND_KEYWORDS = "keywords";
    private static final String COMMAND_JACCARD = "jaccard";
    private static final String COMMAND_SIMILARITY = "similarity";
    private static final String COMMAND_DIRECT = "direct";
        private static final String DIRECT_COMMAND_H_INDEX = "h-index";
        private static final String DIRECT_COMMAND_PRINT_CONFERENCE = "print conference";
        private static final String DIRECT_COMMAND_PRINT_JOURNAL = "print journal";
    private static final String COMMAND_H_INDEX = "h-index";
    private static final String COMMAND_COAUTHORS = "coauthors";
        private static final String COAUTHORS_COMMAND_OF = "of";
    private static final String COMMAND_FOREIGN = "foreign";
        private static final String FOREIGN_COMMAND_CITATIONS_OF = "citations of";
    private static final String COMMAND_PRINT = "print";
        private static final String PRINT_COMMAND_BIBLIOPGRAPHY = "bibliography";

    private static final String ERR_INVALID_COMMAND = "not a valid command.";
    private static final String ERR_REQUIRES_NO_PARAMETERS = "requires no parameters.";
    private static final String ERR_NOT_LETTER = "must only contain letters from the alphabet.";
    private static final String ERR_BLANK_EXPECTED = " blank separated parameters expected.";
    private static final String ERR_COMMA_EXPECTED = " comma separated parameters expected.";
    private static final String ERR_COLON_EXPECTED = " colon separated parameters expected.";

    private boolean isRunning;
    private LiteratureManager literatureManager;

    /**
     * Constructs a new UserInteraction. The literature manager is started and the running variable set to true.
     * Then the program waits for user input.
     */
    private UserInteraction() {
        isRunning = true;
        literatureManager = new LiteratureManager();
        handleInput();
    }

    /**
     * The main method which starts the program.
     * @param args The arguments given during program launch. Here none are needed.
     */
    public static void main(String[] args) {
        new UserInteraction();
    }

    /**
     * This method handles the user input. It waits for input, checks
     * for basic validity and presents it to the handleCommand method.
     */
    private void handleInput() {
        while (isRunning) {
            String in = Terminal.readLine();
            try {
                if (in != null && !in.equals("")) {
                    String[] handledIn = in.split(" ", 2); // split input line in command and parameters
                    handleCommand(handledIn);
                } else throw new SemanticsException(ERR_INVALID_COMMAND);
            } catch (SemanticsException | SyntaxException e) {
                Terminal.printLine(e.getMessage());
            }
        }
    }

    /**
     * This method checks the first command word. If it's a command or the first word of a command,
     * the corresponding method is called.
     * If it's not part of a valid command an exception is thrown.
     * @param handledIn The command and parameters in a String array.
     * @throws SyntaxException Throws if the wrong number of parameters is given.
     * @throws SemanticsException Throws if there is a semantics problem with the input.
     */
    private void handleCommand(String[] handledIn) throws SyntaxException, SemanticsException {
        switch (handledIn[0]) {
            case COMMAND_QUIT: {
                HelperMethods.checkArrayLength(handledIn, 1, "quit " + ERR_REQUIRES_NO_PARAMETERS);
                isRunning = false;
                break;
            }
            case COMMAND_ADD: {
                handleAddCommand(handledIn);
                break;
            }
            default: {
                throw new SyntaxException(ERR_INVALID_COMMAND);
            }
        }
    }

    /**
     * This method is responsible for add commands. For a valid command,
     * the corresponding method is called.
     * For a non-valid command an exception is thrown.
     * @param handledIn The first command word and the rest in a 2 part String array.
     * @throws SyntaxException Throws if the wrong number of parameters is given.
     * @throws SemanticsException Throws if there is a semantics problem with the input.
     */
    private void handleAddCommand(String[] handledIn) throws SyntaxException, SemanticsException {
        HelperMethods.checkArrayLength(handledIn, 2, ERR_BLANK_EXPECTED);
        String[] handledInTwo = handledIn[1].split(" ", 2);
        HelperMethods.checkArrayLength(handledInTwo, 2, ERR_BLANK_EXPECTED);
        switch (handledInTwo[0]) {
            case ADD_COMMAND_AUTHOR: {
                addAuthor(handledInTwo[1]);
            }
            case ADD_COMMAND_JOURNAL: {
                addJournal(handledInTwo[1]);
            }
            case ADD_COMMAND_CONFERENCE: {
                if (handledInTwo[1].substring(0, 7).equals("series ")) {
                    addConSeries(handledInTwo[1]);
                } else addConference(handledInTwo[1]);
            }
            case ADD_COMMAND_ARTICLE: {
                if (handledInTwo[1].substring(0, 3).equals("to ")) {
                    addArticleTo(handledInTwo[1]);
                } else {
                    throw new SyntaxException(ERR_INVALID_COMMAND);
                }
            }
            default: {
                throw new SyntaxException(ERR_INVALID_COMMAND);
            }
        }

    }

    /**
     * Adds a new Author to the author list of the literature manager.
     * Throws an exception if the Author exists already.
     * @param parameters The parameters as a String.
     * @throws SyntaxException Throws if the wrong number of parameters is given.
     * @throws SemanticsException Throws if there is a semantics problem with the input.
     */
    private void addAuthor(String parameters) throws SyntaxException, SemanticsException {
        String[] splitParameters = parameters.split(",");
        HelperMethods.checkArrayLength(splitParameters, 2, 2 + ERR_COMMA_EXPECTED);
        if (!HelperMethods.isFromAlphabet(splitParameters[0]) || !HelperMethods.isFromAlphabet(splitParameters[1])) {
            throw new SemanticsException("first name and last name " + ERR_NOT_LETTER);
        }
        Author author = new Author(splitParameters[0], splitParameters[1]);
        literatureManager.getAuthorList().addSorted(author);
        HelperMethods.confirmSuccess();
    }

    /**
     * Adds a new Journal to the journal list of the literature manager.
     * Throws an exception if the Journal exists already.
     * @param parameters The command and parameters in a String array.
     * @throws SyntaxException Throws if the wrong number of parameters is given.
     * @throws SemanticsException Throws if there is a semantics problem with the input.
     */
    private void addJournal(String parameters) throws SyntaxException, SemanticsException {
        String[] splitParameters = parameters.split(",");
        HelperMethods.checkArrayLength(splitParameters, 2, 2 + ERR_COMMA_EXPECTED);
        if (!HelperMethods.isFromAlphabet(splitParameters[0]) || !HelperMethods.isFromAlphabet(splitParameters[1])) {
            throw new SemanticsException("name and publisher " + ERR_NOT_LETTER);
        }
        Journal journal = new Journal(splitParameters[0], splitParameters[1]);
        literatureManager.getJournalList().addSorted(journal);
        HelperMethods.confirmSuccess();
    }

    /**
     *
     * @param handledInTwo
     * @throws SyntaxException
     * @throws SemanticsException
     */
    private void addConSeries(String handledInTwo) throws SyntaxException, SemanticsException {
        String[] commandAndParameter = handledInTwo.split(" ", 2);
        HelperMethods.checkArrayLength(commandAndParameter, 2, ERR_BLANK_EXPECTED);
        if (!HelperMethods.isFromAlphabet(commandAndParameter[1])) {
            throw new SemanticsException("name " + ERR_NOT_LETTER);
        }
        ConferenceSeries series = new ConferenceSeries(commandAndParameter[1]);
        literatureManager.getSeriesList().addSorted(series);
        HelperMethods.confirmSuccess();
    }

    private void addConference(String parameters) throws SyntaxException, SemanticsException {
        String[] splitParameters = parameters.split(",");
        HelperMethods.checkArrayLength(splitParameters, 3, 3 + ERR_COMMA_EXPECTED);

        if (!HelperMethods.isFromAlphabet(splitParameters[0])) {
            throw new SemanticsException("name " + ERR_NOT_LETTER);
        }
        ConferenceSeries series = new ConferenceSeries(splitParameters[0]);
        series = literatureManager.getSeriesList().getCellContent(series);
        if (!HelperMethods.isDigit(splitParameters[1]) || splitParameters[1].length() != 4) {
            throw new SemanticsException("second parameter is not a valid year.");
        }
        int year = Integer.parseInt(splitParameters[1]);
        Conference conference = new Conference(series, year, splitParameters[2]);
        literatureManager.getConferenceList().addSorted(conference);
        series.getConferenceList().addSorted(conference);
        HelperMethods.confirmSuccess();
    }

    private void addArticleTo(String handledInTwo) throws SyntaxException, SemanticsException {
        String[] commandAndParameter = handledInTwo.split(" ", 2);
        HelperMethods.checkArrayLength(commandAndParameter, 2, ERR_BLANK_EXPECTED);
        String[] splitParameters = commandAndParameter[1].split(":", 2);
        HelperMethods.checkArrayLength(splitParameters, 2, ERR_COLON_EXPECTED);

    }
}
