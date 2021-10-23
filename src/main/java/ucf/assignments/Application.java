package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Sabrina Lopez
 */

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.*;

public class Application extends javafx.application.Application {

    public static void main(String[] args) {

        HashMap<String, HashMap<String, ItemDetails>> outerMap = new HashMap<>();
        HashMap<String, ItemDetails> innerMap = new HashMap<>();

        launch();

        //create if-else statements to track user's choices within the Screen Builder and then use the functions accordingly

        innerMap = addItem(innerMap);
        outerMap = addToDoList(outerMap, innerMap);

        innerMap = editItemDueDate(innerMap);
        innerMap = editItemDescription(innerMap);
        innerMap = editItemCompletionStatus(innerMap);
        outerMap = editToDoListTitle(outerMap, innerMap);

        innerMap = removeItem(innerMap);
        outerMap = removeToDoList(outerMap, innerMap);
    }

    public static class ItemDetails {
        private String dueDate;
        private String itemDescription;
        private Integer completionFlag;

        public String getDueDate() {
            return dueDate;
        }

        public void setDueDate(String newDueDate) {
            this.dueDate = newDueDate;
        }

        public String getItemDescription() {
            return itemDescription;
        }

        public void setItemDescription(String newItemDescription) {
            this.itemDescription = newItemDescription;
        }

        public Integer getCompletionFlag() {
            return completionFlag;
        }

        public void setCompletionFlag(Integer changedCompletionFlag) {
            this.completionFlag = changedCompletionFlag;
        }
    }

    public static HashMap<String, HashMap<String, ItemDetails>> addToDoList(HashMap<String, HashMap<String, ItemDetails>> outerMap, HashMap<String, ItemDetails> innerMap) {
        String toDoListTitle = ""; //will be initialized with the user's to-do list title input from the Screen Builder

        outerMap.put(toDoListTitle, innerMap);
        return outerMap;
    }

    public static HashMap<String, ItemDetails> addItem(HashMap<String, ItemDetails> innerMap) {
        String itemTitle = ""; //will be initialized with the user's item title input from the Screen Builder

        ItemDetails itemDetails = new ItemDetails();

        String dueDate = ""; //will be initialized with the user's item due date input from the Screen Builder
        itemDetails.setDueDate(dueDate);

        String itemDescription = ""; //will be initialized with the user's item description from the Screen Builder
        itemDetails.setItemDescription(itemDescription);

        int completionFlag = 0; //will be initialized as unchecked or 0
        itemDetails.setCompletionFlag(completionFlag);

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
        itemDetails.setDueDate(dueDate);

        innerMap.put(itemTitle, itemDetails);
        return innerMap;
    }

    public static HashMap<String, ItemDetails> editItemDescription(HashMap<String, ItemDetails> innerMap) {
        String itemTitle = ""; //get the title of the item to navigate the hashmap

        ItemDetails itemDetails = new ItemDetails();

        String itemDescription = ""; //update the item description with the user's new item description input
        itemDetails.setItemDescription(itemDescription);

        int completionFlag = 0;
        itemDetails.setCompletionFlag(completionFlag);

        innerMap.put(itemTitle, itemDetails);
        return innerMap;
    }

    public static HashMap<String, ItemDetails> editItemCompletionStatus(HashMap<String, ItemDetails> innerMap) {
        String itemTitle = ""; //get the title of the item to navigate the hashmap

        ItemDetails itemDetails = new ItemDetails();

        int completionFlag = 1; //update the completion flag with the current status of the item's checkbox
        itemDetails.setCompletionFlag(completionFlag);

        innerMap.put(itemTitle, itemDetails);
        return innerMap;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("To-Do App");
        stage.show();
    }
}