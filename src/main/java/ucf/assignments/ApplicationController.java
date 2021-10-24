package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Sabrina Lopez
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.util.HashMap;
import ucf.assignments.Application.*;

public class ApplicationController extends javafx.application.Application {

    HashMap<String, HashMap<String, Application.ItemDetails>> outerMap = new HashMap<>();
    HashMap<String, Application.ItemDetails> innerMap = new HashMap<>();

    public static HashMap<String, HashMap<String, ItemDetails>> addToDoList(HashMap<String, HashMap<String, ItemDetails>> outerMap, HashMap<String, ItemDetails> innerMap) {
        String toDoListTitle = ""; //will be initialized with the user's to-do list title input from the Screen Builder

        outerMap.put(toDoListTitle, innerMap);
        return outerMap;
    }

    public static HashMap<String, ItemDetails> addItem(HashMap<String, ItemDetails> innerMap) {
        String itemTitle = ""; //will be initialized with the user's item title input from the Screen Builder

        ItemDetails itemDetails = new ItemDetails();

        String dueDate = ""; //will be initialized with the user's item due date input from the Screen Builder
        itemDetails.setItemDueDate(dueDate);

        String itemDescription = ""; //will be initialized with the user's item description from the Screen Builder
        itemDetails.setItemDescription(itemDescription);

        int completionFlag = 0; //will be initialized as unchecked or 0
        itemDetails.setItemCompletionFlag(completionFlag);

        innerMap.put(itemTitle, itemDetails);
        return innerMap;
    }

    public static HashMap<String, HashMap<String, ItemDetails>> removeToDoList(HashMap<String, HashMap<String, ItemDetails>> outerMap, HashMap<String, ItemDetails> innerMap) {
        String toDoListTitle = ""; //get the title of the to-do list that the user wants to remove

        outerMap.remove(toDoListTitle, innerMap); //remove the specific to-do list from the to-do list / outer hashmap
        return outerMap;
    }

    public static HashMap<String, ItemDetails> removeItem(HashMap<String, ItemDetails> innerMap) {
        String itemTitle = ""; //get the title of the item that the user wants to remove

        ItemDetails itemDetails = new ItemDetails();

        innerMap.remove(itemTitle, itemDetails); //remove the specific item from the items list / inner hashmap
        return innerMap;
    }

    public static HashMap<String, HashMap<String, ItemDetails>> editToDoListTitle(HashMap<String, HashMap<String, ItemDetails>> outerMap, HashMap<String, ItemDetails> innerMap) {
        String toDoListTitle = ""; //get the title of the to-do list to navigate the hashmap

        //transfer contents of current to-do list into a new to do list
        //remove the old to-do list

        return outerMap;
    }

    public static HashMap<String, ItemDetails> editItemDueDate(HashMap<String, ItemDetails> innerMap) {
        String itemTitle = ""; //get the title of the item to navigate the hashmap

        ItemDetails itemDetails = new ItemDetails();

        String dueDate = ""; //update the due date with the user's new item due date input
        itemDetails.setItemDueDate(dueDate);

        innerMap.put(itemTitle, itemDetails);
        return innerMap;
    }

    public static HashMap<String, ItemDetails> editItemDescription(HashMap<String, ItemDetails> innerMap) {
        String itemTitle = ""; //get the title of the item to navigate the hashmap

        ItemDetails itemDetails = new ItemDetails();

        String itemDescription = ""; //update the item description with the user's new item description input
        itemDetails.setItemDescription(itemDescription);

        int completionFlag = 0;
        itemDetails.setItemCompletionFlag(completionFlag);

        innerMap.put(itemTitle, itemDetails);
        return innerMap;
    }

    public static HashMap<String, ItemDetails> editItemCompletionStatus(HashMap<String, ItemDetails> innerMap) {
        String itemTitle = ""; //get the title of the item to navigate the hashmap

        ItemDetails itemDetails = new ItemDetails();

        int completionFlag = 1; //update the completion flag with the current status of the item's checkbox
        itemDetails.setItemCompletionFlag(completionFlag);

        innerMap.put(itemTitle, itemDetails);
        return innerMap;
    }

    @FXML
    private Label welcomeText;



    @FXML
    protected void onDeleteListClick() {

        welcomeText.setText("Remove List");
    }

    @FXML
    protected void onSaveListsClick() {

        welcomeText.setText("Save List");
    }

    @FXML
    protected void onLoadListsClick() {

        welcomeText.setText("Load List");
    }

    @FXML
    protected void onBackToHomeClick() {

        welcomeText.setText("Back to Home");
    }

    @FXML
    protected void onBackToListClick() {

        welcomeText.setText("Back to List");
    }

    @FXML
    protected void onMakeListClick() {

        welcomeText.setText("Back to List");
    }

    @FXML
    protected void onMakeItemClick() {

        welcomeText.setText("Back to List");
    }

    @FXML
    protected void onSubmitListClick() {

        welcomeText.setText("Submitted List");
    }

    @FXML
    protected void onSubmitItemClick() {

        welcomeText.setText("Submitted Item");
    }

    @Override
    public void start(Stage primaryStage) {

    }
}