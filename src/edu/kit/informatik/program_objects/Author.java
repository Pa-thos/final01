package edu.kit.informatik.program_objects;

/**
 * Represents an Author of an Article.
 *
 * Created by Christian Hauser on 11.02.2017.
 */
public class Author implements Comparable<Author> {
    private String lastName;
    private String firstName;

    /**
     * Constructs an Author with first name and last name.
     * @param lastName The last name of the Author.
     * @param firstName The first name of the Author.
     */
    public Author(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    /**
     * Lexicographically compares this author with the given author by last name and if equal by first name.
     * Returns a negative int if this author is lexicographically in front of the given author.
     * Returns 0 if they are equal.
     * Returns a positive int if it is located after the given author.
     * Note: Upper case letters are lexicographically in front of lower case letters.
     * @param author The author to be compared to.
     * @return int negative, positive or 0 if this author is in front, after or equal to the parameter.
     */
    public int compareTo(Author author) {
        int returnValue = this.getLastName().compareTo(author.getLastName());
        if (returnValue == 0) {
            returnValue = this.getFirstName().compareTo(author.getFirstName());
        }
        return returnValue;
    }

    /**
     * Returns the last name of an author.
     * @return String last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns the first name of an author.
     * @return String first name.
     */
    public String getFirstName() {
        return firstName;
    }
}
