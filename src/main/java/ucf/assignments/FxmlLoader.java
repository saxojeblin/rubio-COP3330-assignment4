/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Nicholas Rubio
 */

package ucf.assignments;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;

public class FxmlLoader {
    private Pane view;

    public Pane getPage(String fileName) throws IOException {
        URL fileURL = App.class.getResource(  "/ucf/assignments/" + fileName + ".fxml");
        view = new FXMLLoader().load(fileURL);

        return view;
    }
}
