package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Sabrina Lopez
 */

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import ucf.assignments.Application.ItemDetails;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.event.ActionEvent;

public class ApplicationController extends javafx.application.Application {

    HashMap<String, HashMap<String, Application.ItemDetails>> outerMap = new HashMap<>();
    HashMap<String, Application.ItemDetails> innerMap = new HashMap<>();

    public static HashMap<String, HashMap<String, ItemDetails>> addToDoList(String toDoListTitle, HashMap<String, HashMap<String, ItemDetails>> outerMap, HashMap<String, ItemDetails> innerMap) {

        outerMap.put(toDoListTitle, innerMap);
        return outerMap;
    }

    public static HashMap<String, ItemDetails> addItem(HashMap<String, ItemDetails> innerMap, String itemTitle, String itemDueDate, String itemDescription) {

        ItemDetails itemDetails = new ItemDetails();

        //will be initialized with the user's item due date input from the Screen Builder
        itemDetails.setItemDueDate(itemDueDate);

        //will be initialized with the user's item description from the Screen Builder
        itemDetails.setItemDescription(itemDescription);

        int completionFlag = 0; //will be initialized as unchecked or 0
        itemDetails.setItemCompletionFlag(completionFlag);

        innerMap.put(itemTitle, itemDetails);
        return innerMap;
    }

    public static HashMap<String, HashMap<String, ItemDetails>> removeToDoList(HashMap<String, HashMap<String, ItemDetails>> outerMap, HashMap<String, ItemDetails> innerMap, String toDoListTitle) {

        outerMap.remove(toDoListTitle, innerMap); //remove the specific to-do list from the to-do list / outer hashmap

        return outerMap;
    }

    public static HashMap<String, ItemDetails> removeItem(HashMap<String, ItemDetails> innerMap, String itemTitle) {

        ItemDetails itemDetails = new ItemDetails();

        innerMap.remove(itemTitle, itemDetails); //remove the specific item from the items list / inner hashmap
        return innerMap;
    }

    public static HashMap<String, HashMap<String, ItemDetails>> editToDoListTitle(String oldToDoListTitle, String newToDoListTitle, HashMap<String, HashMap<String, ItemDetails>> outerMap, HashMap<String, ItemDetails> innerMap) {

        HashMap<String, ItemDetails> copyOfItems = outerMap.remove(oldToDoListTitle);
        outerMap.put(newToDoListTitle, copyOfItems);

        return outerMap;
    }

    public static HashMap<String, ItemDetails> editItemDueDate(HashMap<String, ItemDetails> innerMap, String itemTitle, String itemDueDate) {

        ItemDetails itemDetails = new ItemDetails();

        //update the due date with the user's new item due date input
        itemDetails.setItemDueDate(itemDueDate);

        innerMap.put(itemTitle, itemDetails);
        return innerMap;
    }

    public static HashMap<String, ItemDetails> editItemDescription(HashMap<String, ItemDetails> innerMap, String itemTitle, String itemDescription) {

        ItemDetails itemDetails = new ItemDetails();

        //update the item description with the user's new item description input
        itemDetails.setItemDescription(itemDescription);

        innerMap.put(itemTitle, itemDetails);
        return innerMap;
    }

    public static HashMap<String, ItemDetails> editItemCompletionStatus(HashMap<String, ItemDetails> innerMap, String itemTitle) {

        ItemDetails itemDetails = new ItemDetails();

        int currentCompletionFlag = itemDetails.getItemCompletionFlag();
        int completionFlag = 0; //initialize as unmarked / uncompleted / false

        if (currentCompletionFlag == 0) {
            completionFlag = 1; //update to marked / complete / true
        }

        itemDetails.setItemCompletionFlag(completionFlag);

        innerMap.put(itemTitle, itemDetails);
        return innerMap;
    }

    public ArrayList<ItemDetails> createCompletedItemsList(HashMap<String, ItemDetails> innerMap) {
        ArrayList<ItemDetails> completedItemsList = new ArrayList<>();
        ItemDetails itemDetails = new ItemDetails();
        int i = 0;

        for(HashMap.Entry<String, ItemDetails> entry : innerMap.entrySet()) {
            i++;
            Integer completionFlag = entry.getValue().getItemCompletionFlag();
            if(completionFlag == 1) {
                completedItemsList.set(i, innerMap.getOrDefault(entry.getKey(), itemDetails));
            }
        }

        return completedItemsList;
    }

    public ArrayList<ItemDetails> createUncompletedItemsList(HashMap<String, ItemDetails> innerMap) {
        ArrayList<ItemDetails> completedItemsList = new ArrayList<>();
        ItemDetails itemDetails = new ItemDetails();
        int i = 0;

        for(HashMap.Entry<String, ItemDetails> entry : innerMap.entrySet()) {
            i++;
            Integer completionFlag = entry.getValue().getItemCompletionFlag();
            if(completionFlag == 0) {
                completedItemsList.set(i, innerMap.getOrDefault(entry.getKey(), itemDetails));
            }
        }

        return completedItemsList;
    }



    @FXML
    private Label buttonResponses;

    @FXML //navigate to Make To-Do List Screen
    protected void onMakeListClick() {
        buttonResponses.setText("Make a List");
    }

    @FXML //navigate to Make Item Screen
    protected void onMakeItemClick() {
        buttonResponses.setText("Make an Item");
    }

    @FXML //navigate to Edit To-Do List Screen
    protected void onEditListClick() {
        buttonResponses.setText("Edit a List");
    }

    @FXML //navigate to Edit Item Screen
    protected void onEditItemClick() {
        buttonResponses.setText("Edit an Item");
    }

    @FXML //tell the user the new/changed list was made via printing to scene, & navigate back to the Welcome Screen
    protected void onSubmitListClick() {
        buttonResponses.setText("Submitted List");

        //get user input from to-do list title text field and change title of list via editToDoListTitle function call
    }

    @FXML //tell the user the new/changed item was made via printing to scene, & navigate back to the To-Do List Screen
    protected void onSubmitItemClick() {
        buttonResponses.setText("Submitted Item");

        //get user input from text fields and change the due date, description, and or completion status of the item
        //via the editItemDueDate, editItemDescription, and editItemCompletionStatus function calls respectively
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

    @FXML //tell the user the list has been saved via printing to scene
    protected void onSaveListsClick() {
        buttonResponses.setText("Save List");
    }

    @FXML //tell the user the list has loaded via printing to scene
    protected void onLoadListsClick() {
        buttonResponses.setText("Load List");
    }

    @FXML //navigate to Home Screen
    protected void onBackToHomeClick() {
        buttonResponses.setText("Back to Home");
    }

    @FXML //navigate to To-Do List Screen
    protected void onBackToListClick() {
        buttonResponses.setText("Back to List");
    }

    @FXML //navigate to Item Screen
    protected void onBackToItemClick() {
        buttonResponses.setText("Back to Item");
    }

    @FXML //tell the user the completed items are being shown via printing to scene
    protected void onViewCompletedItemsClick() {
        buttonResponses.setText("View Completed Items");

        //create an arraylist of all the completed items via the createCompletedItemsList function call
        //display the list of completed items in the scene for the user
    }

    @FXML //tell the user the uncompleted items are being shown via printing to scene
    protected void onViewUncompletedItemsClick() {
        buttonResponses.setText("View Uncompleted Items");

        //create an arraylist of all the completed items via the createUncompletedItemsList function call
        //display the list of uncompleted items in the scene for the user
    }

    @Override
    public void start(Stage primaryStage) {

    }
}