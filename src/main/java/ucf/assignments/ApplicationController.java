package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Sabrina Lopez
 */

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import ucf.assignments.Application.ItemComponents;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import javafx.event.ActionEvent;

public class ApplicationController extends javafx.application.Application {

    HashMap<String, HashMap<String, Application.ItemComponents>> outerMap = new HashMap<>();
    HashMap<String, Application.ItemComponents> innerMap = new HashMap<>();

    public static HashMap<String, HashMap<String, ItemComponents>> addToDoList(String toDoListTitle, HashMap<String, HashMap<String, ItemComponents>> outerMap, HashMap<String, ItemComponents> innerMap) {

        outerMap.put(toDoListTitle, innerMap);
        return outerMap;
    }

    public static HashMap<String, ItemComponents> addItem(HashMap<String, ItemComponents> innerMap, String itemTitle, String itemDueDate, String itemDescription) {

        ItemComponents itemComponents = new ItemComponents();

        //will be initialized with the user's item due date input from the Screen Builder
        itemComponents.setItemDueDate(itemDueDate);

        //will be initialized with the user's item description from the Screen Builder
        itemComponents.setItemDescription(itemDescription);

        int completionFlag = 0; //will be initialized as unchecked or 0
        itemComponents.setItemCompletionFlag(completionFlag);

        innerMap.put(itemTitle, itemComponents);
        return innerMap;
    }

    public static HashMap<String, HashMap<String, ItemComponents>> removeToDoList(HashMap<String, HashMap<String, ItemComponents>> outerMap, HashMap<String, ItemComponents> innerMap, String toDoListTitle) {

        outerMap.remove(toDoListTitle, innerMap); //remove the specific to-do list from the to-do list / outer hashmap
        return outerMap;
    }

    public static HashMap<String, ItemComponents> removeItem(HashMap<String, ItemComponents> innerMap, String itemTitle) {

        ItemComponents itemComponents = new ItemComponents();
        innerMap.remove(itemTitle, itemComponents); //remove the specific item from the items list / inner hashmap
        return innerMap;
    }

    public static HashMap<String, HashMap<String, ItemComponents>> editToDoListTitle(String oldToDoListTitle, String newToDoListTitle, HashMap<String, HashMap<String, ItemComponents>> outerMap, HashMap<String, ItemComponents> innerMap) {

        HashMap<String, ItemComponents> copyOfItems = outerMap.remove(oldToDoListTitle);
        outerMap.put(newToDoListTitle, copyOfItems);
        return outerMap;
    }

    public static HashMap<String, ItemComponents> editItemDueDate(HashMap<String, ItemComponents> innerMap, String itemTitle, String itemDueDate) {

        ItemComponents itemComponents = new ItemComponents();
        itemComponents.setItemDueDate(itemDueDate); //update the due date with the user's new item due date input
        innerMap.put(itemTitle, itemComponents);
        return innerMap;
    }

    public static HashMap<String, ItemComponents> editItemDescription(HashMap<String, ItemComponents> innerMap, String itemTitle, String itemDescription) {

        ItemComponents itemComponents = new ItemComponents();
        itemComponents.setItemDescription(itemDescription); //update the item description with the user's new item description input
        innerMap.put(itemTitle, itemComponents);
        return innerMap;
    }

    public static HashMap<String, ItemComponents> editItemCompletionStatus(HashMap<String, ItemComponents> innerMap, String itemTitle) {

        ItemComponents itemComponents = new ItemComponents();
        int currentCompletionFlag = itemComponents.getItemCompletionFlag();
        int completionFlag = 0; //initialize as unmarked / uncompleted / false

        if (currentCompletionFlag == 0) {
            completionFlag = 1; //update to marked / complete / true
        }
        itemComponents.setItemCompletionFlag(completionFlag);

        innerMap.put(itemTitle, itemComponents);
        return innerMap;
    }

    ArrayList<ItemComponents> unCompletedItemsList = new ArrayList<>();
    ArrayList<ItemComponents> completedItemsList = new ArrayList<>();

    public ArrayList<ItemComponents> createCompletedItemsList(HashMap<String, ItemComponents> innerMap) {
        ItemComponents itemComponents = new ItemComponents();
        int i = 0;

        for(HashMap.Entry<String, ItemComponents> entry : innerMap.entrySet()) {
            i++;
            Integer completionFlag = entry.getValue().getItemCompletionFlag();
            if(completionFlag == 1) {
                completedItemsList.set(i, innerMap.getOrDefault(entry.getKey(), itemComponents));
            }
        }

        return completedItemsList;
    }

    public ArrayList<ItemComponents> createUncompletedItemsList(HashMap<String, ItemComponents> innerMap) {
        ItemComponents itemComponents = new ItemComponents();
        int i = 0;

        for(HashMap.Entry<String, ItemComponents> entry : innerMap.entrySet()) {
            i++;
            Integer completionFlag = entry.getValue().getItemCompletionFlag();
            if(completionFlag == 0) {
                unCompletedItemsList.set(i, innerMap.getOrDefault(entry.getKey(), itemComponents));
            }
        }

        return completedItemsList;
    }



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

    String currentToDoTitle;
    String currentItemTitle;
    String currentItemDescription;
    String currentItemDueDate;

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
        currentToDoTitle = userToDoListTitleInput.getText();
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
        editToDoListTitle(currentToDoTitle, newToDoListTitle, outerMap, innerMap);

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
        String itemTitle = userToDoListTitleInput.getText();
        String itemDueDate = userToDoListTitleInput.getText();
        String itemDescription = userToDoListTitleInput.getText();
        addItem(innerMap, itemTitle, itemDueDate, itemDescription);

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
        //declare and initialize itemTitle, a String to hold the user's selected item once gotten from the program

        String itemDueDate = userToDoListTitleInput.getText();
        //editItemDueDate(innerMap, itemTitle, itemDueDate);

        String itemDescription = userToDoListTitleInput.getText();
        //editItemDescription(innerMap, itemTitle, itemDescription);

        String itemCompletionStatus = userToDoListTitleInput.getText();
        //editItemCompletionStatus(innerMap, itemTitle);

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

    @FXML //tell the user the completed items are being shown via printing to scene
    protected void onViewCompletedItemsClick() {
        buttonResponses.setText("View Completed Items");

        //create an arraylist of all the completed items via the createCompletedItemsList function call
        //display the list of completed items in the scene for the user in the BorderPane
    }

    @FXML //tell the user the uncompleted items are being shown via printing to scene
    protected void onViewUncompletedItemsClick() {
        buttonResponses.setText("View Uncompleted Items");

        //create an arraylist of all the completed items via the createUncompletedItemsList function call
        //display the list of uncompleted items in the scene for the user in the BorderPane
    }

    @FXML //show the user all the current to-do lists onto the Welcome Screen
    protected void displayAllLists() {
        //loop through entire outer hashmap and get the keys / list titles
        //display the list titles onto the Welcome Screen in the BorderPane
    }

    @FXML //show the user all the current items of their selected to-do list title onto the To-Do List Screen
    protected void displayAllItems(String selectedListTitle) {
        //loop through entire struct list of the selected list title within the inner hashmap
        //get the item titles and display them onto the To-Do List Screen in the BorderPane
    }

    @Override
    public void start(Stage primaryStage) {

    }
}