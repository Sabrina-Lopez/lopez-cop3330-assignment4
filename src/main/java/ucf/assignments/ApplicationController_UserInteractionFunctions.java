package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Sabrina Lopez
 */

//get any necessary imports

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;


//create ApplicationController_UserInteractionFunctions to deal with the more interactive functions of the program such as when the user
// interacts with buttons and how the program changes as a result
public class ApplicationController_UserInteractionFunctions extends ApplicationController_BackgroundFunctions {
    /*
    @FXML //declare currentLists, a variable with the BorderPane class to input the current list of to-do lists into the program
    private BorderPane currentLists;

    @FXML //declare currentItemsOfList, a variable with the BorderPane class to input the current list of items of a specific to-do list into the program
    private BorderPane currentItemsOfList;

    @FXML //declare currentComponentsOfItem, a variable with the BorderPane class to input the current details of a specific item into the program
    private BorderPane currentComponentsOfItem;

    @FXML //declare userToDoListTitleInput, a variable with the TextField class to take the user's to-do list title input from the make or edit to-do list title text fields
    private TextField userToDoListTitleInput;

    @FXML //declare userItemTitleInput, a variable with the TextField class to take the user's item title input from the make or edit item title text fields
    private TextField userItemTitleInput;

    @FXML //declare userItemDueDateInput, a variable with the TextField class to take the user's item deadline from the make or edit item deadline text fields
    private TextField userItemDueDateInput;

    @FXML //declare userItemDescriptionInput, a variable with the TextField class to take the user's item description from the make or edit item description text fields
    private TextField userItemDescriptionInput;

    @FXML //declare userItemCompletionStatusInput, a variable with the TextField class to take the user's item completion status from the make or edit item completion status text fields
        // completion status means whether the item is noted/marked as complete or not
    private TextField userItemCompletionStatusInput;


    String currentToDoListTitle; //declare currentToDoListTitle, a String variable to hold the most currently selected or edited to-do list title
    String currentItemTitle; //declare currentToDoListTitle, a String variable to hold the most currently selected or edited item title
    String currentItemDescription; //declare currentToDoListTitle, a String variable to hold the most currently edited item description
    String currentItemDueDate; //declare currentToDoListTitle, a String variable to hold the most currently edited item due date
    String currentItemCompletionStatus; //declare currentToDoListTitle, a String variable to hold the most currently edited item completion status

    @FXML //create OnMakeListClick, a function to navigate to Make To-Do List Screen when the user clicks the "Make List" button
    protected void onMakeListClick(ActionEvent event) throws IOException {

        //declare a Parent variable, root, to hold the components of the fxml file using the FXMLLoader.load(Objects.requireNonNull(getClass().getResource() method
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("makeToDoListScreen.fxml")));

        //declare a Scene variable, scene, to display the scene created via the fxml file
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //create a new stage for the new scene of the program using the (Stage) ((Node) event.getSource()).getScene().getWindow() method
        stage.setScene(scene); //create the program window / stage for the scene using the .setScene() method
        stage.show(); //show the program window / stage using the .show() method
    }

    @FXML //create noMakeItemClick, a function to navigate to Make Item Screen when the user clicks the "Make Item" button
    protected void onMakeItemClick(ActionEvent event) throws IOException {

        //declare a Parent variable, root, to hold the components of the fxml file using the FXMLLoader.load(Objects.requireNonNull(getClass().getResource() method
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("makeItemScreen.fxml")));

        //declare a Scene variable, scene, to display the scene created via the fxml file
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //create a new stage for the new scene of the program using the (Stage) ((Node) event.getSource()).getScene().getWindow() method
        stage.setScene(scene); //create the program window / stage for the scene using the .setScene() method
        stage.show(); //show the program window / stage using the .show() method
    }

    @FXML //create onEditListClick, a function to navigate to Edit To-Do List Screen when the user clicks the "Edit List" button
    protected void onEditListClick(ActionEvent event) throws IOException {

        //declare a Parent variable, root, to hold the components of the fxml file using the FXMLLoader.load(Objects.requireNonNull(getClass().getResource() method
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("editToDoListScreen.fxml")));

        //declare a Scene variable, scene, to display the scene created via the fxml file
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //create a new stage for the new scene of the program using the (Stage) ((Node) event.getSource()).getScene().getWindow() method
        stage.setScene(scene); //create the program window / stage for the scene using the .setScene() method
        stage.show(); //show the program window / stage using the .show() method

        //in case the text field is already filled from a previous user response, take that current input before the new user input
        // to edit the to-do list title using the .getText() method
        currentToDoListTitle = userToDoListTitleInput.getText();
    }

    @FXML //create onEditItemClick, a function to navigate to Edit Item Screen when the user clicks "Edit Item" button
    protected void onEditItemClick(ActionEvent event) throws IOException {

        //declare a Parent variable, root, to hold the components of the fxml file using the FXMLLoader.load(Objects.requireNonNull(getClass().getResource() method
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("editItemScreen.fxml")));

        //declare a Scene variable, scene, to display the scene created via the fxml file
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //create a new stage for the new scene of the program using the (Stage) ((Node) event.getSource()).getScene().getWindow() method
        stage.setScene(scene); //create the program window / stage for the scene using the .setScene() method
        stage.show(); //show the program window / stage using the .show() method

        //in case the text field is already filled from a previous user response, take that current input before the new user input
        // to edit the item title using the .getText() method
        currentItemTitle = userItemTitleInput.getText();
    }

    @FXML //create onSubmitNewListClick, a function to take user input and place it into the double hashmap accordingly, and navigate back to the Welcome Screen
        //a function that occurs when the user clicks the submit button on the make list screen
    protected void onSubmitNewListClick(ActionEvent event) throws IOException {

        //get user input from to-do list title text field using the .getText() method
        // and add new list to the outer hashmap via addToDoListTitle function call
        currentToDoListTitle = userToDoListTitleInput.getText();
        addToDoList(toDoListTitle, outerMap, innerMap);

        //declare a Parent variable, root, to hold the components of the fxml file using the FXMLLoader.load(Objects.requireNonNull(getClass().getResource() method
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("welcomeScreen.fxml")));

        //declare a Scene variable, scene, to display the scene created via the fxml file
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //create a new stage for the new scene of the program using the (Stage) ((Node) event.getSource()).getScene().getWindow() method
        stage.setScene(scene); //create the program window / stage for the scene using the .setScene() method
        stage.show(); //show the program window / stage using the .show() method

        //display the current list of to-do lists on the welcome screen
    }

    @FXML //create onSubmitEditedListClick, a function to take user input and edit the double hashmap accordingly, and navigate back to the Welcome Screen
        //a function that occurs when the user clicks the submit button on the edit list screen
    protected void onSubmitEditedListClick(ActionEvent event) throws IOException {
        //get the to-do list that the user has most recently clicked by declaring and initializing oldToDoListTitle with the to-do list title that the user just clicked
        //String oldToDoListTitle = currentToDoListTitle;

        //get user input from to-do list title text field using the .getText() method
        // and change title of list in the outer hashmap via editToDoListTitle function call
        currentToDoListTitle = userToDoListTitleInput.getText();
        editToDoListTitle(oldToDoListTitle, currentToDoListTitle, outerMap);

        //declare a Parent variable, root, to hold the components of the fxml file using the FXMLLoader.load(Objects.requireNonNull(getClass().getResource() method
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("welcomeScreen.fxml")));

        //declare a Scene variable, scene, to display the scene created via the fxml file
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //create a new stage for the new scene of the program using the (Stage) ((Node) event.getSource()).getScene().getWindow() method
        stage.setScene(scene); //create the program window / stage for the scene using the .setScene() method
        stage.show(); //show the program window / stage using the .show() method

        //display the current list of to-do lists on the welcome screen
    }

    @FXML //create onSubmitNewItemClick, a function to take user input and place it into the double hashmap accordingly, and navigate back to the To-Do List Screen
        //a function that occurs when the user clicks the submit button on the make item screen
    protected void onSubmitNewItemClick(ActionEvent event) throws IOException {

        //get user input from text fields, using the .getText() method, and add the item title, due date, description, and completion status into a new struct and create new index for to-do list's inner hashmap
        // via the addItem function call
        currentItemTitle = userItemTitleInput.getText();
        currentItemDueDate = userItemDueDateInput.getText();
        currentItemDescription = userItemDescriptionInput.getText();
        currentItemCompletionStatus = userItemCompletionStatusInput.getText();
        addItem(innerMap, currentItemTitle, currentItemDueDate, currentItemDescription, currentItemCompletionStatus);

        //declare a Parent variable, root, to hold the components of the fxml file using the FXMLLoader.load(Objects.requireNonNull(getClass().getResource() method
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("toDoListScreen.fxml")));

        //declare a Scene variable, scene, to display the scene created via the fxml file
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //create a new stage for the new scene of the program using the (Stage) ((Node) event.getSource()).getScene().getWindow() method
        stage.setScene(scene); //create the program window / stage for the scene using the .setScene() method
        stage.show(); //show the program window / stage using the .show() method

        //display the current list of items for a specific to-do list on the to-do list screen
    }

    @FXML //create onSubmitEditedItemClick, a function to take user input and edit double hashmap accordingly, and navigate back to the To-Do List Screen
        //a function that occurs when the user clicks the submit button on the edit item screen
    protected void onSubmitEditedItemClick(ActionEvent event) throws IOException {
        //get the item that the user has most recently clicked by declaring and initializing oldItemTitle with the item title that the user just clicked
        //String oldItemTitle = currentItemTitle;

        //get user input from text fields, using the .getText() method and change the due date, description, and or completion status of the item
        // via the editItemDueDate, editItemDescription, and editItemCompletionStatus function calls respectively
        currentItemTitle = userItemTitleInput.getText();
        editItemTitle(oldItemTitle, currentItemTitle, innerMap);

        currentItemDueDate  = userItemDueDateInput.getText();
        editItemDueDate(innerMap, currentItemTitle, currentItemDueDate);

        currentItemDescription  = userToDoListTitleInput.getText();
        editItemDescription(innerMap, currentItemTitle, currentItemDescription);

        currentItemCompletionStatus = userItemCompletionStatusInput.getText();
        editItemCompletionStatus(innerMap, currentItemTitle, currentItemCompletionStatus);


        //declare a Parent variable, root, to hold the components of the fxml file using the FXMLLoader.load(Objects.requireNonNull(getClass().getResource() method
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("toDoListScreen.fxml")));

        //declare a Scene variable, scene, to display the scene created via the fxml file
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //create a new stage for the new scene of the program using the (Stage) ((Node) event.getSource()).getScene().getWindow() method
        stage.setScene(scene); //create the program window / stage for the scene using the .setScene() method
        stage.show(); //show the program window / stage using the .show() method

        //display the current list of items for a specific to-do list on the to-do list screen
    }

    @FXML //create onDeleteListClick, a function to delete s specific to-do list and then display the change to the welcome screen
        //a function that occurs when the user clicks the delete list button on the welcome screen
    protected void onDeleteListClick() {
        //get the to-do list that the user has most recently clicked
        //removeToDoList(outerMap, innerMap, currentToDoListTitle); //a function call to remove the specific to-do list from the outer hashmap
        //display the new list of to-do lists onto the welcome screen
    }

    @FXML //create onDeleteItemClick, a function to delete a specific item and then display the change to the to-do list screen
        //a function that occurs when the user clicks the delete item button on the to-do list screen
    protected void onDeleteItemClick() {
        //get the item that the user has most recently clicked
        //removeItem(innerMap, currentItemTitle); //a function call to remove the specific item from the inner hashmap
        //display the new list of items onto the to-do list screen that the items belong to
    }

    //initialize "externalListsFileCreated", a variable with the boolean datatype to create and or ensure the existence of the file for the saved list
    boolean externalListsFileCreated;

    @FXML //create onSaveListsClick, a function to save the selected to-do lists and their items into an external file
        //a function that occurs when the user clicks the save list button on the welcome screen
    protected void onSaveListsClick() throws IOException {
        //declare and initialize "externalListsFile", a variable with the File class to establish the location for the saved lists
        File externalListsFile = new File ("src\\main\\java\\ucf\\assignments\\externalLists.txt");

        //initialize "externalListsFileCreated" with whether the external lists file was created or not
        externalListsFileCreated = externalListsFile.createNewFile();

        //declare and initialize "externalListsFileOutput", a variable with the FileWriter class to write the saved lists into the external file
        FileWriter externalListsFileOutput = new FileWriter(externalListsFile);

        //save the user's selected list into the external file
        //removeToDoList(outerMap, innerMap, currentToDoListTitle); // remove the user's selected list from the hashmap via removeToDoList function call
    }

    @FXML //create onLoadListsClick, a function to load the selected to-do lists and their items from an external file
        //a function that occurs when the user clicks the load list button on the welcome screen
    protected void onLoadListsClick() {
        //ensure the file exists in the directory
        if(externalListsFileCreated) { //if the external file for the saved lists is successfully inside the directory
            //load the user's selected list from the external file by adding it back to the double hashmap
        }
    }

    @FXML //navigate to Home Screen
    protected void onBackToHomeClick(ActionEvent event) throws IOException {

        //declare a Parent variable, root, to hold the components of the fxml file using the FXMLLoader.load(Objects.requireNonNull(getClass().getResource() method
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("welcomeScreen.fxml")));

        //declare a Scene variable, scene, to display the scene created via the fxml file
        Scene scene = new Scene(root);
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //create a new stage for the new scene of the program using the (Stage) ((Node) event.getSource()).getScene().getWindow() method
        stage.setScene(scene); //create the program window / stage for the scene using the .setScene() method
        stage.show(); //show the program window / stage using the .show() method

        //display the current list of to-do lists on the welcome screen
    }

    @FXML //create onBackToListClick, a function to navigate to To-Do List Screen when the user clicks the "Back to List" button
    protected void onBackToListClick(ActionEvent event) throws IOException {

        //declare a Parent variable, root, to hold the components of the fxml file using the FXMLLoader.load(Objects.requireNonNull(getClass().getResource() method
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("toDoListScreen.fxml")));

        //declare a Scene variable, scene, to display the scene created via the fxml file
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //create a new stage for the new scene of the program using the (Stage) ((Node) event.getSource()).getScene().getWindow() method
        stage.setScene(scene); //create the program window / stage for the scene using the .setScene() method
        stage.show(); //show the program window / stage using the .show() method

        //display the current list of items for a specific to-do list on the to-do list screen
    }

    @FXML //create onBackToItemClick, a function to navigate to the Item Screen when the user clicks the "Back to Item" button
    protected void onBackToItemClick(ActionEvent event) throws IOException {

        //declare a Parent variable, root, to hold the components of the fxml file using the FXMLLoader.load(Objects.requireNonNull(getClass().getResource() method
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("itemScreen.fxml")));

        //declare a Scene variable, scene, to display the scene created via the fxml file
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //create a new stage for the new scene of the program using the (Stage) ((Node) event.getSource()).getScene().getWindow() method
        stage.setScene(scene); //create the program window / stage for the scene using the .setScene() method
        stage.show(); //show the program window / stage using the .show() method

        //display the current details of a specific item on the item screen
    }


    @FXML //show the user the completed items
    protected BorderPane onViewCompletedItemsClick() {
        BorderPane currentCompletedItems = new BorderPane(); //create currentCompletedItems, a BorderPane variable to hold and display the completed items to the user
        //for all the items within the inner hashmap of a specific to-do list
        for(HashMap.Entry<String, Application_ItemStorage.ItemComponents> entry : innerMap.entrySet()) {
            if(entry.getValue().getItemCompletionFlag().equals("1")) { //if the item in the to-do list is completed, a condition checked by using the entry.getValue().getItemCompletionFlag().equals() method
                Text currentItem = new Text(entry.getKey()); //get the title of the completed item by using the Text(entry.getKey()) method
                currentCompletedItems.getChildren().add(currentItem); //add the completed item to the BorderPane with the .getChildren().add() method
            }
        }

        currentItemsOfList = currentCompletedItems; //establish the completed items as the current new list of items to display to the user

        //display the updated BorderPane in the to-do list screen

        return currentItemsOfList; //return the newly renovated BorderPane
    }

    @FXML //show the user the uncompleted items
    protected BorderPane onViewUncompletedItemsClick() {
        BorderPane currentUncompletedItems = new BorderPane(); //create currentUnCompletedItems, a BorderPane variable to hold and display the uncompleted items to the user
        //for all the items within the inner hashmap of a specific to-do list
        for(HashMap.Entry<String, Application_ItemStorage.ItemComponents> entry : innerMap.entrySet()) {
            if(entry.getValue().getItemCompletionFlag().equals("0")) { //if the item in the to-do list is uncompleted, a condition checked using the entry.getValue().getItemCompletionFlag().equals() method
                Text currentItem = new Text(entry.getKey()); //get the title of the completed item by using the Text(entry.getKey()) method
                currentUncompletedItems.getChildren().add(currentItem); //add the completed item to the BorderPane with the .getChildren().add() method
            }
        }

        currentItemsOfList = currentUncompletedItems; //establish the uncompleted items as the current new list of items to display to the user

        //display the updated BorderPane in the to-do list screen

        return currentItemsOfList; //return the newly renovated BorderPane
    }

    @FXML //show the user all the current to-do lists onto the Welcome Screen
    protected void displayCurrentLists() {
        //for all the to-do lists within the outer hashmap
        for(HashMap.Entry<String, HashMap<String, Application_ItemStorage.ItemComponents>> entry : outerMap.entrySet()) {
            Text currentList = new Text(entry.getKey()); //get the current to-do list title or outer hashmap key
            currentLists.getChildren().add(currentList); //display it to the user by adding it to the BorderPane using the .getChildren().add() method
        }
    }

    @FXML //show the user all the current items of their selected to-do list title onto the To-Do List Screen
    protected void displayCurrentItems() {
        //for all the items within the inner hashmap of a specific to-do list
        for(HashMap.Entry<String, Application_ItemStorage.ItemComponents> entry : innerMap.entrySet()) {
            Text currentItem = new Text(entry.getKey()); //get the current item title or inner hashmap key using the Text(entry.getKey()) method
            currentItemsOfList.getChildren().add(currentItem); //display if to the user by adding it to the BorderPane using the .getChildren().add() method
        }
    }

    @FXML
    protected void displayCurrentItemComponents() {

        //declare and initialize "currentItemComponent_title" by using the Text(innerMap.get(currentItemTitle).getItemTitle()) method
        //to take the title of a specific item and put them on the BorderPane for the specific item's screen
        Text currentItemComponent_title = new Text(innerMap.get(currentItemTitle).getItemTitle());
        currentComponentsOfItem.getChildren().add(currentItemComponent_title); //add the item detail to the BorderPane to display to user

        //declare and initialize "currentItemComponent_deadline" by using the Text(innerMap.get(currentItemTitle).getItemDueDate()) method
        //to take the title of a specific item and put them on the BorderPane for the specific item's screen
        Text currentItemComponent_deadline = new Text(innerMap.get(currentItemTitle).getItemDueDate());
        currentComponentsOfItem.getChildren().add(currentItemComponent_deadline); //add the item detail to the BorderPane to display to user

        //declare and initialize "currentItemComponent_description" by using the Text(innerMap.get(currentItemTitle).getItemDescription()) method
        //to take the title of a specific item and put them on the BorderPane for the specific item's screen
        Text currentItemComponent_description = new Text(innerMap.get(currentItemTitle).getItemDescription());
        currentComponentsOfItem.getChildren().add(currentItemComponent_description); //add the item detail to the BorderPane to display to user

        //declare and initialize "currentItemComponent_completionStatus" by using the Text(innerMap.get(currentItemTitle).getItemCompletionFlag()) method
        //to take the title of a specific item and put them on the BorderPane for the specific item's screen
        Text currentItemComponent_completionStatus = new Text(innerMap.get(currentItemTitle).getItemCompletionFlag());
        currentComponentsOfItem.getChildren().add(currentItemComponent_completionStatus); //add the item detail to the BorderPane to display to user
    }

    */

    @Override
    public void start(Stage primaryStage) { }
}