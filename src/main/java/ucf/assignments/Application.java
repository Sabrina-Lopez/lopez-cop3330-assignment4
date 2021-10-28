package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Sabrina Lopez
 */

//get any necessary imports
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.*;

public class Application extends javafx.application.Application {

    public static void main(String[] args) { //declare the main function/method
        launch(); //utilize launch method to start the program
    }

    public static class ItemComponents { //declare a public static class to utilize as a struct and hold the information for each item
        private String itemTitle; //declare a String variable, itemTitle, to hold the name or title of the item
        private String itemDueDate; //declare a String variable, itemDueDate, to hold the due date of the item
        private String itemDescription; //declare a String variable, itemDescription, to hold the description of the item
        private Integer itemCompletionFlag; //declare an Integer variable, itemCompletionFlag, to hold whether the item has been marked in its respective checkbox or not

        public String getItemTitle() {
            return itemTitle; //return the item title to the function to retrieve the item title from the constructor
        } //create getter for item's title

        public void setItemTitle(String newItemTitle) {
            this.itemTitle = newItemTitle; //use the this.(object) method to take the user input and place it into the item title variable in the constructor
        } //create setter for item's title

        public String getItemDueDate() {
            return itemDueDate; //return the item due date to the function to retrieve the item due date from the constructor
        } //create getter for item's due date

        public void setItemDueDate(String newItemDueDate) {
            this.itemDueDate = newItemDueDate; //use the this.(object) method to take the user input and place it into the item due date variable in the constructor
        } //create setter for item's due date

        public String getItemDescription() {
            return itemDescription; //return the item description to the function to retrieve the item description from the constructor
        } //create getter for item's description

        public void setItemDescription(String newItemDescription) {
            this.itemDescription = newItemDescription; //use the this.(object) method to take the user input and place it into the item description variable in the constructor
        } //create setter for item's description

        public Integer getItemCompletionFlag() {
            return itemCompletionFlag; //return the item completion status to the function to retrieve the item completion status from the constructor
        } //create getter for item's completion flag / checkbox marker

        public void setItemCompletionFlag(Integer itemCompletionFlag) { //create setter for item's completion flag / checkbox marker
            this.itemCompletionFlag = itemCompletionFlag; //use the this.(object) method to take the user input and place it into the item completion status variable in the constructor
        }
    }

    @Override //incorporate override statement
    //declare the start function/method with throws Exception in case there was an exception not considered in creating and launching the program
    public void start(Stage stage) throws Exception {

        //declare a Parent variable, root, to hold the components of the fxml file
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("welcomeScreen.fxml")));

        //declare a Scene variable, scene, to display the scene created via the fxml file
        Scene scene = new Scene(root);

        stage.setScene(scene); //create the program window / stage for the scene
        stage.setTitle("To-Do App"); //create the program window / stage title, To-Do App
        stage.show(); //show the program window / stage
    }
}