/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Nicholas Rubio
 */

package ucf.assignments;

import java.io.File;
import java.util.ArrayList;

import static ucf.assignments.FXMLController.toDoList;

public class ToDoList {

    private ArrayList<Item> items = new ArrayList<>();

    public ToDoList(ArrayList<Item> items) {
        //Set items as this ToDoList's item list
        this.items = items;
    }

    public ArrayList<Item> getItemList() {
        //returns the title of the ToDoList
        return this.items;
    }

    public void editTitle(String newTitle) {
        //Set this.title equal to newTitle
    }

    public void addItem(String description, String dueDate, boolean complete) {
        //Create a new item object to build upon with attributes:
            //Set new item's description to its description
            //Set new item's dueDate to its due date
            //Set new item's complete to its completion status
        Item item = new Item(description, dueDate, complete);
        //Add the item to this ToDoList's item list
        this.items.add(item);
    }

    public void removeItem(int index) {
        //Remove item from item list with index 'index'
        this.getItemList().remove(index);
    }

    public void clearAllItems() {
        this.getItemList().clear();
    }

    public void editItemDescription(int index, String newDescription) {
        //Call the ToDoList's item at given index
        this.getItemList().get(index).editDescription(newDescription);
        //Use editDescription() in item class
    }

    public void editDueDate(int index, String newDueDate) {
        //Get the ToDoList's item at given index
        this.getItemList().get(index).editDueDate(newDueDate);
        //Call editDueDate() in item class
    }

    public void markItemComplete(int index) {
        //Get the ToDoList's item at given index
        this.getItemList().get(index).markComplete();
        //Call markComplete in item class
    }

    public String displayAllItems() {
        String completion;
        StringBuilder stb = new StringBuilder();

        int listSize = this.getItemList().size();
        for (int i = 0; i < listSize; i++) {
            int itemNum = i + 1;
            stb.append("ITEM " + itemNum + ":\n");
            stb.append("Description: " + this.getItemList().get(i).getDescription() + "\n");
            stb.append("Due Date: " + this.getItemList().get(i).getDueDate() + "\n");
            if (this.getItemList().get(i).getComplete() == true) {
                completion = "Complete.";
            }
            else  {
                completion  = "Incomplete.";
            }
            stb.append("Status: " + completion + "\n\n");
        }
        return stb.toString();

    }

    public String displayIncompleteItems() {
        StringBuilder stb = new StringBuilder();

        int listSize = this.getItemList().size();
        for (int i = 0; i < listSize; i++) {
            int itemNum = i + 1;
            if (this.getItemList().get(i).getComplete() == false) {
                stb.append("ITEM " + itemNum + ":\n");
                stb.append("Description: " + this.getItemList().get(i).getDescription() + "\n");
                stb.append("Due Date: " + this.getItemList().get(i).getDueDate() + "\n");
                stb.append("Status: Incomplete\n\n");
            }

        }
        return stb.toString();
    }

    public String displayCompleteItems() {
        StringBuilder stb = new StringBuilder();

        int listSize = this.getItemList().size();
        for (int i = 0; i < listSize; i++) {
            int itemNum = i + 1;
            if (this.getItemList().get(i).getComplete() == true) {
                stb.append("ITEM " + itemNum + ":\n");
                stb.append("Description: " + this.getItemList().get(i).getDescription() + "\n");
                stb.append("Due Date: " + this.getItemList().get(i).getDueDate() + "\n");
                stb.append("Status: Complete\n\n");
            }

        }
        return stb.toString();
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
