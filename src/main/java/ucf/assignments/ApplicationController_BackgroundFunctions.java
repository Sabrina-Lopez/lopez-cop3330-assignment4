package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Sabrina Lopez
 */

//include any necessary imports
import javafx.stage.Stage;
//import ucf.assignments.Application_ItemStorage.ItemComponents;
import java.util.HashMap;


//create ApplicationController_BackgroundFunctions class to take care of the storage of and changes to the user-inputted data
public class ApplicationController_BackgroundFunctions extends Application {
    /*
    //declare and initialize the outerMap, a hashmap with the to-do list title as the key and its respective inner hashmap of items as the value
    HashMap<String, HashMap<String, Application_ItemStorage.ItemComponents>> outerMap = new HashMap<>();

    //declare and initialize the innerMap, a hashmap inside the outerMap with the item title as the key and its respective struct of item details as the value
    HashMap<String, Application_ItemStorage.ItemComponents> innerMap = new HashMap<>();

    //create addToDoList, a function to add the to-do lists to the outer hashmap, taking in the user's to-do list title, the outer hashmap, and the inner hashmap in its parameters
    public static HashMap<String, HashMap<String, ItemComponents>> addToDoList(String toDoListTitle, HashMap<String, HashMap<String, ItemComponents>> outerMap, HashMap<String, ItemComponents> innerMap) {

        outerMap.put(toDoListTitle, innerMap); //use the .put() method to add the user's to-do list to the outer hashmap
        return outerMap; //return the newly renovated outer hashmap
    }

    //create addItem, a function to add the items to the inner hashmap, taking in the inner hashmap and the user's item title, deadline, description, and completion status
    public static HashMap<String, ItemComponents> addItem(HashMap<String, ItemComponents> innerMap, String itemTitle, String itemDueDate, String itemDescription, String completionFlag) {

        //declare and initialize itemComponents to provide access to the ItemComponents class to add the item's details into a struct and the item into the inner hashmap
        ItemComponents itemComponents = new ItemComponents();

        //will be initialized with the user's item title input from the Screen Builder using the .setItemTitle() method
        itemComponents.setItemTitle(itemTitle);

        //will be initialized with the user's item due date input from the Screen Builder using the .setItemDueDate() method
        itemComponents.setItemDueDate(itemDueDate);

        //will be initialized with the user's item description from the Screen Builder using the .setItemDescription() method
        itemComponents.setItemDescription(itemDescription);

        //will be initialized with the user's item completion status from the Screen Builder using the .setItemCompletionFlag() method
        itemComponents.setItemCompletionFlag(completionFlag);

        innerMap.put(itemTitle, itemComponents); //use the .put() method to add the user's item to the inner hashmap
        return innerMap; //return the newly renovated inner hashmap
    }

    //create removeToDoList, a function to remove a to-do list from the outer hashmap when the user wants to delete a specific to-do list
    public static HashMap<String, HashMap<String, ItemComponents>> removeToDoList(HashMap<String, HashMap<String, ItemComponents>> outerMap, HashMap<String, ItemComponents> innerMap, String toDoListTitle) {

        outerMap.remove(toDoListTitle, innerMap); //remove the specific to-do list from the to-do list / outer hashmap using the .remove() method
        return outerMap; //return the newly renovated outer hashmap
    }

    //create removeItem, a function to remove an item from the inner hashmap when the user wants to delete a specific item
    public static HashMap<String, ItemComponents> removeItem(HashMap<String, ItemComponents> innerMap, String itemTitle) {

        //declare and initialize itemComponents to provide access to the ItemComponents class to add the item's details into a struct and the item into the inner hashmap
        ItemComponents itemComponents = new ItemComponents();

        innerMap.remove(itemTitle, itemComponents); //remove the specific item from the items list / inner hashmap using the .remove() method
        return innerMap; //return the newly renovated inner hashmap
    }

    //create editToDoListTitle, a function to edit the title of a specific to-do list
    public static HashMap<String, HashMap<String, ItemComponents>> editToDoListTitle(String oldToDoListTitle, String newToDoListTitle, HashMap<String, HashMap<String, ItemComponents>> outerMap) {

        //with the .remove() method, copy the contents of the old to-do list into the new to-do list and then remove the old to-do list
        // so the new to-do list has the contents of the old to-do list but changed title
        HashMap<String, ItemComponents> copyOfItems = outerMap.remove(oldToDoListTitle);

        outerMap.put(newToDoListTitle, copyOfItems); //use the .put() method to add the user's edited to-do list to the outer hashmap
        return outerMap; //return the newly renovated outer hashmap
    }

    //create editItemTitle, a function to edit the title of a specific item
    public static HashMap<String, ItemComponents> editItemTitle(String oldItemTitle, String newItemTitle, HashMap<String, ItemComponents> innerMap) {

        //with the .remove() method, copy the contents of the old item into the new item and then remove the old item
        // so the new item has the contents of the old item but changed title
        ItemComponents copyOfItems = innerMap.remove(oldItemTitle);

        innerMap.put(newItemTitle, copyOfItems); //use the .put() method to add the user's edited item to the inner hashmap
        return innerMap; //return the newly renovated inner hashmap
    }

    //create editItemDueDate, a function that edits the due date of a specific item when the user edits the components of said specific item
    public static HashMap<String, ItemComponents> editItemDueDate(HashMap<String, ItemComponents> innerMap, String itemTitle, String itemDueDate) {

        //declare and initialize itemComponents to provide access to the ItemComponents class to add the item's details into a struct and the item into the inner hashmap
        ItemComponents itemComponents = new ItemComponents();

        itemComponents.setItemDueDate(itemDueDate); //update the due date with the user's new item due date input
        innerMap.put(itemTitle, itemComponents); //use the .put() method to add the edited item into the inner hashmap
        return innerMap; //return the newly renovated inner hashmap
    }

    //create editItemDescription, a function that edits the description of a specific item when the user edits the components of said specific item
    public static HashMap<String, ItemComponents> editItemDescription(HashMap<String, ItemComponents> innerMap, String itemTitle, String itemDescription) {

        //declare and initialize itemComponents to provide access to the ItemComponents class to add the item's details into a struct and the item into the inner hashmap
        ItemComponents itemComponents = new ItemComponents();

        itemComponents.setItemDescription(itemDescription); //update the item description with the user's new item description input
        innerMap.put(itemTitle, itemComponents); //use the .put() method to add the edited item into the inner hashmap
        return innerMap; //return the newly renovated inner hashmap
    }

    //create editItemCompletionStatus, a function that edits the completion status of a specific item when the user edits the components of said specific item
    public static HashMap<String, ItemComponents> editItemCompletionStatus(HashMap<String, ItemComponents> innerMap, String itemTitle, String itemCompletionStatus) {

        //declare and initialize itemComponents to provide access to the ItemComponents class to add the item's details into a struct and the item into the inner hashmap
        ItemComponents itemComponents = new ItemComponents();

        itemComponents.setItemCompletionFlag(itemCompletionStatus); //update the item completion status with the user's new item completion status input
        innerMap.put(itemTitle, itemComponents); //use the .put() method to add the edited item into the inner hashmap
        return innerMap; //return the newly renovated inner hashmap
    }
     */

    @Override
    public void start(Stage primaryStage) { }
}