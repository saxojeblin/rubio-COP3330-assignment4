/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Nicholas Rubio
 */

package ucf.assignments;

import java.io.File;
import java.util.ArrayList;

public class ToDoList {
    /*  Attributes:
        (private) Title (string)
        (private) Item object list
    */

    public ToDoList(String title, ArrayList<Item> items) {
        /*
            Set title as this ToDoList's title
            Set items as this ToDoList's item list
        */
    }

    public String getTitle() {
        //returns the title of the ToDoList
        return ""; //TEMP LITERAL RETURN
    }

    public ArrayList<Item> getItemList() {
        //returns the title of the ToDoList
        ArrayList<Item> item = new ArrayList<>();   //TEMP VALUE TO RETURN
        return item; //TEMP LITERAL RETURN
    }

    public void editTitle(String newTitle) {
        //Set this.title equal to newTitle
    }

    public void addItem(String description, String dueDate, boolean complete) {
        //Create a new item object to build upon with attributes:
            //Set new item's description to its description
            //Set new item's dueDate to its due date
            //Set new item's complete to its completion status
        //Add the item to this ToDoList's item list
    }

    public void removeItem(int index) {
        //Remove item from item list with index 'index'
    }

    public void editItemDescription(int index, String newDescription) {
        //Call the ToDoList's item at given index
        //Use editDescription() in item class
            //Pass into method newDescription
    }

    public void editDueDate(int index, String newDueDate) {
        //Get the ToDoList's item at given index
        //Call editDueDate() in item class
            //Pass into method newDueDate
    }

    public void markItemComplete(int index) {
        //Get the ToDoList's item at given index
        //Call editDueDate in item class
    }

    public void displayAllItems() {
        //Declare an int to be size of item list
        //For loop amount of times to that int
            //Call displayItem() using item of index 'i' from the loop
    }

    public void displayIncompleteItems() {
        //Declare an int to be size of item list
        //For loop amount of times to that int
            //Find given object at index 'i' from loop
            //Determine its value of 'complete' attribute
            //If complete is FALSE--
                //call displayItem() of that item
            //else do nothing and continue
    }

    public void displayCompleteItems() {
        //Declare an int to be size of item list
        //For loop amount of times to that int
            //Find given object at index 'i' from loop
            //Determine its value of 'complete' attribute
            //If complete is TRUE--
                //call displayItem() of that item
            //else do nothing and continue
    }

    public void sortByDate() {
        //Create a temp item to store an item
        //Create an int temp to store an index of an item
        //Iterate through the item list
            //Find the next item due
                //Find next two items using item's getDueDate()
                //Compare two items, keep the one with the due date the closest
                //Compare that item with the next one in the list
                //Whenever an item is found that's due date is closer, store its index in the int temp
                //Ends with temp item storing the item with next due date and temp int storing that item's index
        //Swap the item with the closest due date with item in the first index
        //Repeat the same process for indices 'x' to 'n', 'x' being each time the loop has been completed
        //Stop the process when we have done the loop 'n' times
    }

    public void saveItems(File file) {
        //Declare an int to be size of item list
        //For loop amount of times to that int
            //Get item's description, due date, and completion using methods of item
            //Store that data into the file
    }
}
