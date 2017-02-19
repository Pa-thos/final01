package edu.kit.informatik.program_objects;

/**
 * Represents a Journal
 *
 * Created by Christian Hauser on 15.02.2017.
 */
public class Journal implements Comparable<Journal> {
    private String name;
    private String publisher;

    /**
     * Constructs a journal with a name and a publisher.
     * @param name The name of the journal.
     * @param publisher The publisher of the journal.
     */
    public Journal(String name, String publisher) {
        this.name = name;
        this.publisher = publisher;
    }

    /**
     * Lexicographically compares this journal with the given journal by name
     * Returns a negative int if this journals name is lexicographically in front of the given journals name.
     * Returns 0 if they are equal.
     * Returns a positive int if it is located after the given journals name.
     * Note: Upper case letters are lexicographically in front of lower case letters.
     * @param journal The journal to be compared to.
     * @return int negative, positive or 0 if this journals name is in front, after or equal to the parameter.
     */
    public int compareTo(Journal journal) {
        return this.getName().compareTo(journal.getName());
    }

    /**
     * Returns the name of the journal.
     * @return String name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the publisher of the journal.
     * @return String publisher.
     */
    public String getPublisher() {
        return publisher;
    }
}
