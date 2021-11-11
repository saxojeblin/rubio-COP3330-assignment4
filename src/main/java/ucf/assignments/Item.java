/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Nicholas Rubio
 */

package ucf.assignments;

public class Item {
    /*  Attributes:
        Description
        Due Date
        Status on if complete
    */

    public Item (String description, String dueDate, boolean complete)  {
        /*
            Set description to this item's description
            Set dueDate to this item's due date
            Set complete to this item's completion status
        */
    }

    public void editDescription(String newDescription) {
        //Set this.description equal to newDescription
    }

    public void editDueDate(String newDueDate) {
        //Set this.dueDate equal to newDueDate
    }

    public void markComplete() {
        //Set this.complete equal to 'true'
    }

    public void displayItem() {
        //Print out the item's description
        //Print out the item's due date
        //Print out the item's completion status
    }

    public String getDescription() {
        //returns the description of the item
        return "";  //TEMP LITERAL RETURN
    }

    public String getDueDate() {
        //returns the description of the item
        return "";  //TEMP LITERAL RETURN
    }

    public boolean getComplete() {
        //returns the description of the item
        return true;    //TEMP LITERAL RETURN
    }
}