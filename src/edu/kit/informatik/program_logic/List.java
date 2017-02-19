package edu.kit.informatik.program_logic;


import edu.kit.informatik.exceptions.SemanticsException;

/**
 * Represents a single linked list. Every list cell contains an object.
 * Created by Christian on 13.02.2017.
 */
public class List<T extends Comparable<? super T>> {
    private ListCell head;

    /**
     * Constructs an empty list.
     */
    List() {
        head = null;
    }

    /**
     * Adds an element to the list, sorted by compareTo().
     * @param element The element to be added.
     * @throws SemanticsException Throws if the element already exists in the list.
     */
    void addSorted(T element) throws SemanticsException {
        Iterator i = new Iterator(head);
        if (!i.isCurrentValid()) {
            head = new ListCell(element, null);
        } else {
            while (i.isNextValid() && i.cursor.next.content.compareTo(element) > 0) {
                i.moveNext();
            }
            if (i.cursor.next.content.compareTo(element) == 0) {
                throw new SemanticsException("this element already exists.");
            }
        }
    }

    /**
     * Returns the element that is equal to the given element with compareTo from the list.
     * If it doesn't exist, throw an exception to indicate this.
     * @param element The element to compare with the list elements.
     * @return The element in the list which is equal to the given element.
     * @throws SemanticsException Throws if there is no equal element in the list.
     */
    T getCellContent(T element) throws SemanticsException {
        Iterator i = new Iterator(head);
        while (i.isCurrentValid()) {
            if (i.cursor.content.compareTo(element) == 0) {
                return i.cursor.content;
            }
            i.moveNext();
        }
        throw new SemanticsException("this element does not exist in this list.");
    }

    /**
     * Represents a single cell in the list.
     */
    final class ListCell {
        /**
         * The content of the current ListCell.
         */
        T content;
        /**
         * The next ListCell in the list.
         */
        ListCell next;

        /**
         * Constructs a list cell with the content and the next cell.
         * @param content The content of the list cell.
         * @param next The next cell in the list.
         */
        private ListCell(T content, ListCell next) {
            this.content = content;
            this.next = next;
        }
    }

    /**
     * Iterator for this list.
     */
    final class Iterator {
        /**
         * The cursor of the Iterator which points at the current ListCell.
         */
        ListCell cursor;

        /**
         * Constructs a new Iterator with the given ListCell as starting point.
         * @param start The ListCell to start at.
         */
        Iterator(ListCell start) {
            this.cursor = start;
        }

        /**
         * Moves the Iterator to the next cell in the list.
         */
        void moveNext() {
            this.cursor = cursor.next;
        }

        /**
         * Checks if the current ListCell is valid (not null).
         * @return True if the current ListCell is not null.
         */
        Boolean isCurrentValid() {
            return this.cursor != null;
        }

        /**
         * Checks if the next ListCell is valid (not null).
         * @return True if the next ListCell is not null.
         */
        Boolean isNextValid() {
            return this.cursor.next != null;
        }


    }
}
