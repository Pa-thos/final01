package edu.kit.informatik.program_objects;

/**
 * Created by Christian on 11.02.2017.
 */
public class Article implements Comparable<Article> {
    private String id;
    private int year;
    private String title;

    Article(String id, int year, String title) {
        this.id = id;
        this.year = year;
        this.title = title;
    }

    public int compareTo(Article article) {
        int returnValue = 0;
        return returnValue;
    }
}
