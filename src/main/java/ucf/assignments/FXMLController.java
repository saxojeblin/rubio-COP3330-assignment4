/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Nicholas Rubio
 */

package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.AccessibleAction;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class FXMLController implements Initializable {
    //Our ToDoList with its list of items
    public static ArrayList<Item> items = new ArrayList<>();
    public static ToDoList toDoList = new ToDoList(items);

    private Stage stage;
    private Scene scene;

    FileChooser fileChooser = new FileChooser();

    @FXML
    private Label descError;
    @FXML
    private Label dueError;
    @FXML
    private Label invalidItemNumberLabel;
    @FXML
    private Label newDescriptionError;
    @FXML
    private Label invalidItemNumberHelpLabel;
    @FXML
    private Label invalidItemNumberLabel2;
    @FXML
    private Label invalidItemNumberHelpLabel2;
    @FXML
    private Label newDueDateError;
    @FXML
    private Label markCompleteItemNumberError;
    @FXML
    private Label markCompleteItemNumberHelp;
    @FXML
    private Label deleteItemError;
    @FXML
    private Label deleteItemHelp;
    @FXML
    private Label fileNameErrorLabel;
    @FXML
    private Label loadFileErrorLabel;

    @FXML
    private BorderPane mainPane;

    @FXML
    private TextField descTextField;
    @FXML
    private TextField dueTextField;
    @FXML
    private TextField itemNumberTextField;
    @FXML
    private TextField newDescriptionTextField;
    @FXML
    private TextField itemNumberTextField2;
    @FXML
    private TextField newDueDateTextField;
    @FXML
    private TextField markCompleteItemNumber;
    @FXML
    private TextField deleteItemNumber;
    @FXML
    private TextField fileNameTextField;

    @FXML
    private TextArea allItemsTextArea;
    @FXML
    private TextArea completeItemsTextArea;
    @FXML
    private TextArea incompleteItemsTextArea;
    @FXML
    private TextArea loadFileTextArea;

    @FXML
    public void setMainScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("mainScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void addDeleteButtonAction(ActionEvent event) throws IOException {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("ItemCreateDeleteScene");
        mainPane.setCenter(view);
    }

    @FXML
    private void EditButtonAction(ActionEvent event) throws IOException {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("ItemEditScene");
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

    @FXML
    private void createItemButtonAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CreateItemScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void submitAddItem(ActionEvent event) throws IOException {

        boolean checkDesc = false, checkDue = false;

        String desc = descTextField.getText();
        String due = dueTextField.getText();

        if (desc.length() > 256 || desc.length() == 0) {
                descError.setText("Please ensure description is between 1-256 characters.");
        }
        else {
                checkDesc = true;
        }
        if (!due.matches("^([0-9]{4}[-/]?((0[13-9]|1[012])[-/]?(0[1-9]|[12][0-9]|30)|(0[13578]|1[02])[-/]?31|02[-/]?(0[1-9]|1[0-9]|2[0-8]))|([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048]|0[0-9]|1[0-6])00)[-/]?02[-/]?29)$")) {
                dueError.setText("Please ensure due date is in Gregorian Calendar format (YYYY-MM-DD) and is a valid date");
        }
        else {
            checkDue = true;
        }
        if(checkDesc == true && checkDue == true) {
            this.toDoList.addItem(desc, due, false);
            setMainScene(event);
        }
    }

    @FXML
    private void cancelAddItem(ActionEvent event) throws IOException {
        setMainScene(event);
    }

    @FXML
    private void displayAllItemsButtonAction (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DisplayAllItemsScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void fillAllItemsText(ActionEvent event) {
        String itemInfo;
        if (toDoList.getItemList().size() == 0) {
            allItemsTextArea.appendText("There are currently no items in the list.\n");
        }
        else {
            itemInfo = toDoList.displayAllItems();
            allItemsTextArea.appendText(itemInfo);
            }
        }

    @FXML
    private void doneDisplayAllButtonAction(ActionEvent event) throws IOException {
        setMainScene(event);
    }

    @FXML
    private void displayCompleteItemsButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DisplayCompleteItemsScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void fillCompleteItemsText(ActionEvent event) {
        String itemInfo;
        if (toDoList.getItemList().size() == 0) {
            completeItemsTextArea.appendText("There are currently no items in the list.\n");
        } else {
            itemInfo = toDoList.displayCompleteItems();
            if (itemInfo.equals("")) {
                completeItemsTextArea.appendText("All items in the list are incomplete.\n");
            } else {
                completeItemsTextArea.appendText(itemInfo);
            }
        }
    }

    @FXML
    private void doneDisplayCompleteButtonAction(ActionEvent event) throws IOException {
        setMainScene(event);
    }

    @FXML
    private void displayIncompleteItemsButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DisplayIncompleteItemsScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void fillIncompleteItemsText(ActionEvent event) {
        String itemInfo;
        if (toDoList.getItemList().size() == 0) {
            incompleteItemsTextArea.appendText("There are currently no items in the list.\n");
        } else {
            itemInfo = toDoList.displayIncompleteItems();
            if (itemInfo.equals("")) {
                incompleteItemsTextArea.appendText("All items in the list are complete.\n");
            } else {
                incompleteItemsTextArea.appendText(itemInfo);
            }
        }
    }

    @FXML
    private void doneDisplayIncompleteButtonAction(ActionEvent event) throws IOException {
        setMainScene(event);
    }

    @FXML
    private void editDescriptionButtonAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EditDescriptionScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void submitNewDescriptionButton(ActionEvent event) throws IOException {
        int itemNum = -1;
        String newDesc = newDescriptionTextField.getText();
        boolean checkNum = false, checkDesc = false;
        try {
             itemNum = Integer.parseInt(itemNumberTextField.getText());
             itemNum -= 1;
             if(itemNum >= toDoList.getItemList().size() || itemNum < 0) {
                 invalidItemNumberLabel.setText("Invalid Item Number: Item Number doesn't exist");
                 invalidItemNumberHelpLabel.setText("Note: If you don't know the item's number you'd like to edit, please cancel and refer to\n'Display -> Show All Items' to find the item's number.");
             }
             else  {
                checkNum = true;
             }
        }
        catch (NumberFormatException e) {
            invalidItemNumberLabel.setText("Invalid Item Number: Numbers Only");
        }

        if (newDesc.length() > 256 || newDesc.length() == 0) {
            newDescriptionError.setText("Please ensure description is between 1-256 characters.");
        }
        else {
            checkDesc = true;
        }

        if(checkDesc == true && checkNum == true) {
            toDoList.getItemList().get(itemNum).editDescription(newDesc);
            setMainScene(event);
        }
    }

    @FXML
    private void cancelEditDescription(ActionEvent event) throws IOException {
        setMainScene(event);
    }

    @FXML
    private void editDueDateButtonAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EditDueDateScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void submitNewDueDateButton(ActionEvent event) throws IOException {
        int itemNum = -1;
        String newDueDate = newDueDateTextField.getText();
        boolean checkNum = false, checkDesc = false;
        try {
            itemNum = Integer.parseInt(itemNumberTextField2.getText());
            itemNum -= 1;
            if(itemNum >= toDoList.getItemList().size() || itemNum < 0) {
                invalidItemNumberLabel2.setText("Invalid Item Number: Item Number doesn't exist");
                invalidItemNumberHelpLabel2.setText("Note: If you don't know the item's number you'd like to edit, please cancel and refer to\n'Display -> Show All Items' to find the item's number.");
            }
            else  {
                checkNum = true;
            }
        }
        catch (NumberFormatException e) {
            invalidItemNumberLabel2.setText("Invalid Item Number: Numbers Only");
        }

        if (!newDueDate.matches("^([0-9]{4}[-/]?((0[13-9]|1[012])[-/]?(0[1-9]|[12][0-9]|30)|(0[13578]|1[02])[-/]?31|02[-/]?(0[1-9]|1[0-9]|2[0-8]))|([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048]|0[0-9]|1[0-6])00)[-/]?02[-/]?29)$")) {
            newDueDateError.setText("Please ensure due date is in Gregorian Calendar format (YYYY-MM-DD) and is a valid date");
        }
        else {
            checkDesc = true;
        }

        if(checkDesc == true && checkNum == true) {
            toDoList.getItemList().get(itemNum).editDueDate(newDueDate);
            setMainScene(event);
        }
    }

    @FXML
    private void cancelEditDueDate(ActionEvent event) throws IOException {
        setMainScene(event);
    }

    @FXML
    private void markCompleteButtonAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MarkCompleteScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void submitMarkCompleteButton(ActionEvent event) throws IOException {
        int itemNum = -1;
        boolean checkNum = false;
        try {
            itemNum = Integer.parseInt(markCompleteItemNumber.getText());
            itemNum -= 1;
            if(itemNum >= toDoList.getItemList().size() || itemNum < 0) {
                markCompleteItemNumberError.setText("Invalid Item Number: Item Number doesn't exist");
                markCompleteItemNumberHelp.setText("Note: If you don't know the item's number you'd like to edit, please cancel and refer to\n'Display -> Show All Items' to find the item's number.");
            }
            else  {
                checkNum = true;
            }
        }
        catch (NumberFormatException e) {
            markCompleteItemNumberError.setText("Invalid Item Number: Numbers Only");
        }

        if (checkNum == true) {
            toDoList.getItemList().get(itemNum).markComplete();
            setMainScene(event);
        }
    }

    @FXML
    private void cancelMarkCompleteButton(ActionEvent event) throws IOException {
        setMainScene(event);
    }

    @FXML
    private void deleteItemButtonAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DeleteItemScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void submitDeleteItemButton(ActionEvent event) throws IOException {
        int itemNum = -1;
        boolean checkNum = false;
        try {
            itemNum = Integer.parseInt(deleteItemNumber.getText());
            itemNum -= 1;
            if(itemNum >= toDoList.getItemList().size() || itemNum < 0) {
                deleteItemError.setText("Invalid Item Number: Item Number doesn't exist");
                deleteItemHelp.setText("Note: If you don't know the item's number you'd like to delete, please cancel and refer to\n'Display -> Show All Items' to find the item's number.");
            }
            else  {
                checkNum = true;
            }
        }
        catch (NumberFormatException e) {
            deleteItemError.setText("Invalid Item Number: Numbers Only");
        }

        if (checkNum == true) {
            toDoList.getItemList().remove(itemNum);
            setMainScene(event);
        }
    }

    @FXML
    private void cancelDeleteItemButton(ActionEvent event) throws IOException {
        setMainScene(event);
    }

    @FXML
    private void clearAllItemsButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ClearAllItemsScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void submitClearAllButton(ActionEvent event) throws IOException {
        toDoList.getItemList().clear();
        setMainScene(event);
    }

    @FXML
    private void cancelClearAllButton(ActionEvent event) throws IOException {
        setMainScene(event);
    }

    @FXML
    private void saveToDoListButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SaveToDoListScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void submitSaveToDoList(ActionEvent event) throws IOException {
        String fileName = fileNameTextField.getText();
        boolean checkFileName = false;

        if(fileName.length() == 0) {
            fileNameErrorLabel.setText("File name entry must not be left blank.");
        }
        else {
            checkFileName = true;
        }

        if(checkFileName == true) {
            FileWriter writer = new FileWriter("src/main/java/ucf/assignments/" + fileName + ".txt");
            String items = toDoList.displayAllItems();
            writer.write(items);
            writer.close();
            setMainScene(event);
        }
    }

    @FXML
    private void cancelSaveToDoList(ActionEvent event) throws IOException {
        setMainScene(event);
    }

    @FXML
    private void loadToDoListButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LoadToDoListScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void loadFileTextArea (ActionEvent event) {
        try {
            File file = fileChooser.showOpenDialog(new Stage());
            try {
                Scanner scanner = new Scanner(file);
                while(scanner.hasNextLine()) {
                    loadFileTextArea.appendText(scanner.nextLine() + "\n");
                }
            } catch (FileNotFoundException e) {
                loadFileErrorLabel.setText("Error: Please ensure you are selecting and opening a valid file.");
            }
        }
        catch (Exception e) {
            loadFileErrorLabel.setText("Error: Please ensure you are selecting and opening a valid file.");
        }
    }

    @FXML
    private void submitLoadFileButton(ActionEvent event) throws IOException {
        setMainScene(event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fileChooser.setInitialDirectory(new File("src/main/java/ucf/assignments/"));
    }


}
