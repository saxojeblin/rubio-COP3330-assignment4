/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Nicholas Rubio
 */

package ucf.assignments;

import org.junit.BeforeClass;
import org.junit.Test;

/* We only need to test the methods called in App, since these methods call all the other
existing methods within the ToDoList class and the Item class.
 */
public class AppTest {

    @BeforeClass
    public static void beforeClass() {
        //Create an 'App' that we can use to call App's methods
    }

    /* ---Tests of methods to build/edit ToDoList objects--- */
    @Test
    public void testAddToDoList() {
        //Create two ToDoList arrays: one expected and one actual
        //Create the expected ToDoList using hard coded values
        //Add that ToDoList to the expected array
        //Create a ToDoList with the same values using AddToDoList()
        //Add that ToDoList to the actual array
        //Assert equal both the ToDoList lists attributes
    }

    @Test
    public void testRemoveToDoList() {
        //Create two ToDoList arrays: one expected and one actual
        //Create two expected ToDoLists using hard coded values
        //Add those ToDoLists to the expected and the actual array
        //Use .remove for the expected ToDoList on the second ToDoList
        //Use removeToDoList() to remove the second ToDoList in actual
        //Assert equal both the ToDoList lists

    }

    @Test
    public void testEditTitleToDoList() {
        //Create a ToDoList with an expected title via hardcode
        //Create a ToDoList with a different title than the other ToDoList
        //Use editTitleToDoList() and pass in the expected title
        //Assert equal the two ToDoList's titles

    }

    /* ---Tests of methods to build/edit items within a ToDoList--- */
    @Test
    public void testAddItemToDoList() {
        //Create two ToDoLists, 1 and 2
        //add an item to '1' with some hard coded attributes-> this is the expected
        //add an item to '2' using addItemToDoList() passing in the same attributes
        //assert equal 1's and 2's item object lists values
    }

    @Test
    public void testRemoveItemToDoList() {
        //Create ToDoList '1' and add one item called 'a'
        //Create ToDoList '2' and add two items called 'a' and 'b'
        //Use removeItemToDoList() one '2' and remove 'b'
        //Assert equal 1 and 2 to see if they have the same items
    }

    @Test
    public void testEditToDoListItemDescription() {
        //Create ToDoList '1' and add one item called 'a'
        //Create ToDoList '2' and add one item called 'b', which is the same as 'a' but with a different description
        //Use editToDoListItemDescription() on '2' and pass in 'a''s item description
        //assert equal 'a''s description and 'b''s description in '1' and '2'
    }

    @Test
    public void testEditToDoListItemDueDate() {
        //Create ToDoList '1' and add one item called 'a'
        //Create ToDoList '2' and add one item called 'b', which is the same as 'a' but with a different due date
        //Use editToDoListItemDueDate() on '2' and pass in 'a''s item due date
        //assert equal 'a''s due date and 'b''s due date in '1' and '2'
    }

    @Test
    public void testMarkToDoListItemComplete() {
        //Create an expected item, whose 'complete' is set to true
        //Create an actual ToDoList, and add the expected item, except with its 'complete' set to false
        //use markToDoListItemComplete() on the actual and index 0
        //assert equal 'complete' of the expected item and the item in index 0 in the ToDoList
    }

    /*---BONUS METHOD TEST---*/
    @Test
    public void testSortToDoListByDate() {
        //Create a ToDoList '1' with items 'a', 'b', 'c', 'd', and 'e'
        //Add the items in order with respect to due date
        //Create ToDoList '2' with the same items as '1' but in a random, incorrect order
        //Use sortToDoListByDate() on '2'
        //assert equal each item by index of '1' and '2'
    }

    /*Tests of methods that should display item information to the user */
    @Test
    public void testDisplayAllToDoListItems() {
        //Create a list of item objects '1'
        //Create a ToDoList with the same item objects as '1' called '2'
        //Use displayAllToDoItems() with '2'
        //Use displayAllToDoItems() with '1'
        //assert equal that they return/print the same
    }

    @Test
    public void testDisplayAllToDoListIncompleteItems() {
        //Create a list of item objects '1' that has the set of incomplete items
        //Create a ToDoList with item objects that has all of '1', but also a few random complete items, called '2'
        //Use displayAllToDoListIncompleteItems() on '2'
        //Use displayAllItems() on '1'
        //assert equal they return/print the same
    }

    @Test
    public void testDisplayAllToDoListCompleteItems() {
        //Create a list of item objects '1' that has the set of complete items
        //Create a ToDoList with item objects that has all of '1', but also a few random incomplete items, called '2'
        //Use displayAllToDoListCompleteItems() on '2'
        //Use displayAllItems() on '1'
        //assert equal they return/print the same
    }

    /*---Tests of methods that load/save multiple or one ToDoList---*/
    @Test
    public void testSaveToDoList() {
        //Create a ToDoList '1'
        //Create an expected file that has the expected ToDoList in it via hardcode
        //Use saveToDoList() with '1' with a different, actual file
        //assert equal the two file's contents
    }

    @Test
    public void testSaveAllToDoLists() {
        //Create a ToDoList list '1' with some random ToDoLists and Items
        //Create an expected file that has ToDoList list in it
        //Use saveAllToDoLists() with '1' and save into a different, actual file
        //assert equaal the two file's contents
    }

    @Test
    public void testLoadToDoList() {
        //Create ToDoLists '1' and '2'
        //Edit '1' to be the expected ToDoList with the correct expected attributes
        //Create an actual, example file with ToDoList contents
        //Use loadToDoList() with the file and store into '2'
        //assert equal '1' and '2' and their attributes
    }

    @Test
    public void testLoadAllToDoLists() {
        //Create ToDoList lists '1' and '2'
        //Add a set of ToDoLists to '1' using hard coded values
        //Create a file that contains the set of ToDoLists contained in '1'
        //Use loadAllToDoLists() with file and store the ToDoLists in '2'
        //assert equal the ToDoList lists at each index
    }
}