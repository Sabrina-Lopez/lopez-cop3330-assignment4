package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Sabrina Lopez
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class ApplicationController_UserInteractionFunctions extends ApplicationController_BackgroundFunctions {

    @FXML
    private Label buttonResponses;
    @FXML
    private TextField userToDoListTitleInput;
    @FXML
    private TextField userItemTitleInput;
    @FXML
    private TextField userItemDueDateInput;
    @FXML
    private TextField userItemDescriptionInput;
    @FXML
    private TextField userItemCompletionStatusInput;

    String currentToDoListTitle;
    String currentItemTitle;
    String currentItemDescription;
    String currentItemDueDate;
    String currentItemCompletionStatus;

    @FXML //navigate to Make To-Do List Screen
    protected void onMakeListClick(ActionEvent event) throws IOException {

        //declare a Parent variable, root, to hold the components of the fxml file
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("makeToDoListScreen.fxml")));

        //declare a Scene variable, scene, to display the scene created via the fxml file
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //create a new stage for the new scene of the program
        stage.setScene(scene); //create the program window / stage for the scene
        stage.show(); //show the program window / stage
    }

    @FXML //navigate to Make Item Screen
    protected void onMakeItemClick(ActionEvent event) throws IOException {

        //declare a Parent variable, root, to hold the components of the fxml file
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("makeItemScreen.fxml")));

        //declare a Scene variable, scene, to display the scene created via the fxml file
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //create a new stage for the new scene of the program
        stage.setScene(scene); //create the program window / stage for the scene
        stage.show(); //show the program window / stage
    }

    @FXML //navigate to Edit To-Do List Screen
    protected void onEditListClick(ActionEvent event) throws IOException {

        //declare a Parent variable, root, to hold the components of the fxml file
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("editToDoListScreen.fxml")));

        //declare a Scene variable, scene, to display the scene created via the fxml file
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //create a new stage for the new scene of the program
        stage.setScene(scene); //create the program window / stage for the scene
        stage.show(); //show the program window / stage

        //in case the text field is already filled from a previous user response, take that current input before the new user input
        // to edit the to-do list title
        currentToDoListTitle = userToDoListTitleInput.getText();
    }

    @FXML //navigate to Edit Item Screen
    protected void onEditItemClick(ActionEvent event) throws IOException {

        //declare a Parent variable, root, to hold the components of the fxml file
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("editItemScreen.fxml")));

        //declare a Scene variable, scene, to display the scene created via the fxml file
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //create a new stage for the new scene of the program
        stage.setScene(scene); //create the program window / stage for the scene
        stage.show(); //show the program window / stage
    }

    @FXML //take user input and place it into the double hashmap accordingly, and navigate back to the Welcome Screen
    protected void onSubmitNewListClick(ActionEvent event) throws IOException {

        //get user input from to-do list title text field
        // and add new list via addToDoListTitle function call
        String toDoListTitle = userToDoListTitleInput.getText();
        addToDoList(toDoListTitle, outerMap, innerMap);

        //declare a Parent variable, root, to hold the components of the fxml file
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("welcomeScreen.fxml")));

        //declare a Scene variable, scene, to display the scene created via the fxml file
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //create a new stage for the new scene of the program
        stage.setScene(scene); //create the program window / stage for the scene
        stage.show(); //show the program window / stage
    }

    @FXML //take user input and edit the double hashmap accordingly, and navigate back to the Welcome Screen
    protected void onSubmitEditedListClick(ActionEvent event) throws IOException {

        //get user input from to-do list title text field
        // and change title of list via editToDoListTitle function call
        String newToDoListTitle = userToDoListTitleInput.getText();
        editToDoListTitle(currentToDoListTitle, newToDoListTitle, outerMap, innerMap);

        //declare a Parent variable, root, to hold the components of the fxml file
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("welcomeScreen.fxml")));

        //declare a Scene variable, scene, to display the scene created via the fxml file
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //create a new stage for the new scene of the program
        stage.setScene(scene); //create the program window / stage for the scene
        stage.show(); //show the program window / stage
    }

    @FXML //take user input and place it into the double hashmap accordingly, and navigate back to the To-Do List Screen
    protected void onSubmitNewItemClick(ActionEvent event) throws IOException {

        //get user input from text fields and add the item title, due date, description, and completion status into a new struct and create new index for to-do list's inner hashmap
        // via the addItem function call
        currentItemTitle = userItemTitleInput.getText();
        currentItemDueDate = userItemDueDateInput.getText();
        currentItemDescription = userItemDescriptionInput.getText();
        currentItemCompletionStatus = userItemCompletionStatusInput.getText();
        addItem(innerMap, currentItemTitle, currentItemDueDate, currentItemDescription, currentItemCompletionStatus);

        //declare a Parent variable, root, to hold the components of the fxml file
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("toDoListScreen.fxml")));

        //declare a Scene variable, scene, to display the scene created via the fxml file
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //create a new stage for the new scene of the program
        stage.setScene(scene); //create the program window / stage for the scene
        stage.show(); //show the program window / stage
    }

    @FXML //take user input and edit double hashmap accordingly, and navigate back to the To-Do List Screen
    protected void onSubmitEditedItemClick(ActionEvent event) throws IOException {

        //get user input from text fields and change the due date, description, and or completion status of the item
        // via the editItemDueDate, editItemDescription, and editItemCompletionStatus function calls respectively

        currentItemTitle = userItemTitleInput.getText();

        currentItemDueDate  = userItemDueDateInput.getText();
        editItemDueDate(innerMap, currentItemTitle, currentItemDueDate);

        currentItemDescription  = userToDoListTitleInput.getText();
        editItemDescription(innerMap, currentItemTitle, currentItemDescription);

        currentItemCompletionStatus = userItemCompletionStatusInput.getText();
        editItemCompletionStatus(innerMap, currentItemTitle, currentItemCompletionStatus);

        //declare a Parent variable, root, to hold the components of the fxml file
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("toDoListScreen.fxml")));

        //declare a Scene variable, scene, to display the scene created via the fxml file
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //create a new stage for the new scene of the program
        stage.setScene(scene); //create the program window / stage for the scene
        stage.show(); //show the program window / stage
    }

    @FXML //tell the user that the list has been removed via printing to scene
    protected void onDeleteListClick() {
        buttonResponses.setText("Remove List");

        //get the title of the specific list the user wants to remove
        //remove the list from the double hashmap via the removeToDoList function call
    }

    @FXML //tell the user that the item has been removed via printing to scene
    protected void onDeleteItemClick() {
        buttonResponses.setText("Remove Item");

        //get the title of the specific item the user wants to remove
        //remove the specific item from the to-do list in the double hashmap via the removeItem function call
    }

    @FXML //save the selected to-do lists and their items into an external file
    protected void onSaveListsClick() {

    }

    @FXML //load the selected to-do lists and their items into an external file
    protected void onLoadListsClick() {

    }

    @FXML //navigate to Home Screen
    protected void onBackToHomeClick(ActionEvent event) throws IOException {

        //declare a Parent variable, root, to hold the components of the fxml file
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("welcomeScreen.fxml")));

        //declare a Scene variable, scene, to display the scene created via the fxml file
        Scene scene = new Scene(root);
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //create a new stage for the new scene of the program
        stage.setScene(scene); //create the program window / stage for the scene
        stage.show(); //show the program window / stage
    }

    @FXML //navigate to To-Do List Screen
    protected void onBackToListClick(ActionEvent event) throws IOException {

        //declare a Parent variable, root, to hold the components of the fxml file
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("toDoListScreen.fxml")));

        //declare a Scene variable, scene, to display the scene created via the fxml file
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //create a new stage for the new scene of the program
        stage.setScene(scene); //create the program window / stage for the scene
        stage.show(); //show the program window / stage
    }

    @FXML //navigate to Item Screen
    protected void onBackToItemClick(ActionEvent event) throws IOException {

        //declare a Parent variable, root, to hold the components of the fxml file
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("itemScreen.fxml")));

        //declare a Scene variable, scene, to display the scene created via the fxml file
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //create a new stage for the new scene of the program
        stage.setScene(scene); //create the program window / stage for the scene
        stage.show(); //show the program window / stage
    }

    @FXML //show the user the completed items
    protected void onViewCompletedItemsClick() {
        AnchorPane currentCompletedItems = new AnchorPane();
        for(HashMap.Entry<String, Application_ItemStorage.ItemComponents> entry : innerMap.entrySet()) {
            if(entry.getValue().getItemCompletionFlag().equals("1")) {
                Text currentItem = new Text(entry.getKey());
                currentCompletedItems.getChildren().add(currentItem);
            }
        }
    }

    @FXML //show the user the uncompleted items
    protected void onViewUncompletedItemsClick() {
        AnchorPane currentUncompletedItems = new AnchorPane();
        for(HashMap.Entry<String, Application_ItemStorage.ItemComponents> entry : innerMap.entrySet()) {
            if(entry.getValue().getItemCompletionFlag().equals("0")) {
                Text currentItem = new Text(entry.getKey());
                currentUncompletedItems.getChildren().add(currentItem);
            }
        }
    }

    @FXML //show the user all the current to-do lists onto the Welcome Screen
    protected void displayCurrentLists() {
        AnchorPane currentLists = new AnchorPane();
        for(HashMap.Entry<String, HashMap<String, Application_ItemStorage.ItemComponents>> entry : outerMap.entrySet()) {
            Text currentList = new Text(entry.getKey());
            currentLists.getChildren().add(currentList);
        }
    }

    @FXML //show the user all the current items of their selected to-do list title onto the To-Do List Screen
    protected void displayCurrentItems() {
        AnchorPane currentItems = new AnchorPane();
        for(HashMap.Entry<String, Application_ItemStorage.ItemComponents> entry : innerMap.entrySet()) {
            Text currentItem = new Text(entry.getKey());
            currentItems.getChildren().add(currentItem);
        }
    }

    @FXML
    protected void displayCurrentItemComponents() {
        AnchorPane currentItemComponents = new AnchorPane();
        Application_ItemStorage.ItemComponents itemComponents = new Application_ItemStorage.ItemComponents();


    }



    @Override
    public void start(Stage primaryStage) { }
}