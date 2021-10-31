/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Nicholas Rubio
 */

module rubio.COP3330.assignment4.main {
    requires javafx.fxml;
    requires javafx.controls;

    opens ucf.assignments to javafx.fxml;
    exports ucf.assignments;
}