/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Nicholas Rubio
 */

package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class FXMLController{

    @FXML
    private Label label;

    @FXML
    private BorderPane mainPane;

    @FXML
    private void TDLButtonAction(ActionEvent event) throws IOException {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("ToDoListScene");
        mainPane.setCenter(view);
    }

    @FXML
    private void itemButtonAction(ActionEvent event) throws IOException {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("ItemScene");
        mainPane.setCenter(view);
    }

    @FXML
    private void displayButtonAction(ActionEvent event) throws IOException {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("DisplayScene");
        mainPane.setCenter(view);
    }

    @FXML
    private void saveLoadButtonAction(ActionEvent event) throws IOException {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("SaveLoadScene");
        mainPane.setCenter(view);
    }

    @FXML
    private void helpButtonAction(ActionEvent event) throws IOException {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("HelpScene");
        mainPane.setCenter(view);
    }

}
