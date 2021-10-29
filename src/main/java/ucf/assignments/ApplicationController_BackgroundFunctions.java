package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Sabrina Lopez
 */

import javafx.stage.Stage;
import ucf.assignments.Application_ItemStorage.ItemComponents;
import java.util.ArrayList;
import java.util.HashMap;

public class ApplicationController_BackgroundFunctions extends javafx.application.Application {

    HashMap<String, HashMap<String, Application_ItemStorage.ItemComponents>> outerMap = new HashMap<>();
    HashMap<String, Application_ItemStorage.ItemComponents> innerMap = new HashMap<>();

    public static HashMap<String, HashMap<String, ItemComponents>> addToDoList(String toDoListTitle, HashMap<String, HashMap<String, ItemComponents>> outerMap, HashMap<String, ItemComponents> innerMap) {

        outerMap.put(toDoListTitle, innerMap);
        return outerMap;
    }

    public static HashMap<String, ItemComponents> addItem(HashMap<String, ItemComponents> innerMap, String itemTitle, String itemDueDate, String itemDescription, String completionFlag) {

        ItemComponents itemComponents = new ItemComponents();

        //will be initialized with the user's item due date input from the Screen Builder
        itemComponents.setItemDueDate(itemDueDate);

        //will be initialized with the user's item description from the Screen Builder
        itemComponents.setItemDescription(itemDescription);

        //will be initialized with the user's item completion status from the Screen Builder
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

    public static HashMap<String, ItemComponents> editItemCompletionStatus(HashMap<String, ItemComponents> innerMap, String itemTitle, String itemCompletionStatus) {

        ItemComponents itemComponents = new ItemComponents();
        itemComponents.setItemCompletionFlag(itemCompletionStatus); //update the item description with the user's new item description input
        innerMap.put(itemTitle, itemComponents);
        return innerMap;
    }

    @Override
    public void start(Stage primaryStage) {

    }
}