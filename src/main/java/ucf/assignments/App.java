/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Nicholas Rubio
 */

package ucf.assignments;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("mainScene.fxml"));
        primaryStage.setTitle("To Do List Manager");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    /* ---Methods to build/edit ToDoList objects--- */
    /* Method: add a new ToDoList to the list */
    public static void addToDoList(ArrayList<ToDoList> lists, String title) {
        //Create a new ToDoList object
        //Set new object's title to title
        //Add object to lists
    }
    /* Method: remove a ToDoList from the list */
    public static void removeToDoList(ArrayList<ToDoList> lists, int index) {
        //Remove object at 'index' of lists (lists.remove)
    }
    /* Method: edit the title of a ToDoList in the list */
    public static void editTitleToDoList(ToDoList list, String newTitle) {
        //Call ToDoList's editTitle() with list
            //Pass in newTitle
    }

    /* ---Methods to build/edit items within a ToDoList--- */
    /* Method: add an item to a ToDoList given its attributes */
    public static void addItemToDoList(ToDoList list, String description, String dueDate, boolean complete) {
        //Call ToDoList's addItem() with list
            //Pass in description, dueDate, and complete
    }
    /* Method: remove a specific item in a ToDoList */
    public static void removeItemToDoList(ToDoList list, int index) {
        //Call ToDoList's removeItem() with list
            //Pass in the index of the item to be removed

    }
    /* Method: edit a specific item's description in a ToDoList */
    public static void editToDoListItemDescription(ToDoList list, int index, String newDescription) {
        //Call ToDoList's editItemDescription() using list
            //Pass into function call index and newDescription
    }
    /* Method: edit a specific item's due date in a ToDoList */
    public static void editToDoListItemDueDate(ToDoList list, int index, String newDescription) {
        //Call ToDoList's editItemDueDate() using list
        //Pass into function call index and newDueDate
    }
    /* Method: edit a specific item's complete attribute to be 'true' */
    public static void markToDoListItemComplete(ToDoList list, int index) {
        //Call ToDoList's markItemComplete() using list
        //Pass into function call 'index', the index of the item in the item object list
    }

    /*---BONUS METHOD---*/
    /* Method: sort a ToDoList by its item's dates */
    public static void sortToDoListByDate(ToDoList list) {
        //Use ToDoList's sortByItemDate() using list
    }

    /* ---Methods to display item information to the user--- */
    /* Method: display ALL the items in a ToDoList */
    public static void displayAllToDoListItems(ToDoList list) {
        //Call ToDoList's displayAllItems() using list
    }
    /* Method: display all the INCOMPLETE items in a ToDoList */
    public static void displayAllToDoListIncompleteItems(ToDoList list) {
        //Call ToDoList's displayIncompleteItems() using list
    }
    /* Method: display all the COMPLETE items in a ToDoList */
    public static void displayAllToDoListCompleteItems(ToDoList list) {
        //Call ToDoList's displayCompleteItems() using list
    }

    /* ---Methods to load/save multiple or one ToDoLists--- */
    /* Method: save one ToDoList's items to an external file */
    public static void saveToDoList(ToDoList list, File file) {
        //Open file and get in proper form to write into
        //Save the ToDoList's title
        //Use ToDoList's saveAllItems() for list using file
        //Close file
    }
    /* Method: save the array list of ToDoList's items to some file 'file' */
    public static void saveAllToDoLists(ArrayList<ToDoList> lists, File file) {
        //Open file and get in proper form to write into
        //Get an int of size of lists
        //For loop with 'i' with that int
            //Get ToDoList object from index 'i' of lists
            //Use saveItems() from ToDoList
                //Pass in the object and file
        //Close file
    }
    /* Method: load the contents of a file into a ToDoList */
    public static void loadToDoList(ToDoList list, File file) {
        // Read the input file
        //Store each piece of ToDoList information from file into temp variables
        //Call addToDoList() and addItemToDoList() to create the to do list and the items being added
        //Close input file
    }
    /* Method: load the contents of a file into an array list of ToDoLists */
    public static void loadAllToDoLists(ArrayList<ToDoList> lists, File file) {
        // Read the input file
        // Loop through the input, going through each to do list at a time
            //Store each piece of ToDoList information from file into temp variables
            //Call addToDoList() and addItemToDoList() to create the to do list and the items being added
        //Close input file
    }
}
