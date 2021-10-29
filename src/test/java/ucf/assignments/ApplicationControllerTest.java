package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Sabrina Lopez
 */


class ApplicationControllerTest {

    //create main function to test features
        //declare and initialize "testOuterHashMap" as a HashMap
        //declare and initialize "testInnerHashMap" as a HashMap
        //declare and initialize "testListTitle" as a String
        //declare and initialize "testItemTitle" as a String
        //declare and initialize "testItemDate" as a String
        //declare and initialize "testItemDescription" as a String
        //declare and initialize "testItemCompletionMarker" as an Integer equalling 1

        //declare and initialize "userDesireBehaviorTest" as a String equal to "n"
        //declare "userDesireBehaviorTestInput" as a Scanner
        //print to the screen "Would you like to continue testing the required behaviors? (y or n)"
        //modify userDesireBehaviorTest with input from userDesireBehaviorTestInput

        //create while loop that runs until the user inputs "n" when they want to stop testing required behaviors
            //declare and initialize "requiredBehaviorInput" as a Scanner
            //print to user the following question: "Which feature would you like to test (6 - 20)?"
            //declare and initialize requiredBehavior as an integer that takes in the input of requiredBehaviorInput
            //create switch case that depends on requiredBehavior
                //case 6: addListTest
                    //break case
                //case 7: removeExistingListTest
                    //break case
                //case 8: editListTest
                    //break case
                //case 9: addNewItemTest
                    //break case
                //case 10: removeItemTest
                    //break case
                //case 11: editDescriptionTest
                    //break case
                //case 12: editDeadlineTest
                    //break case
                //case 13: markCompleteTest
                    //break case
                //case 14: displayItemsTest
                    //break case
                //case 15: displayCompletedItemsTest
                    //break case
                //case 16: displayUncompletedItemsTest
                    //break case
                //case 17: saveSingleListTest
                    //break case
                //case 18: saveAllListsTest
                    //break case
                //case 19: loadSingleListTest
                    //break case
                //case 20: loadAllListsTest
                    //break case
            //end switch function

    //create an addListTest function that takes in testOuterHashMap, testInnerHashMap, and testListTitle as its parameters
        //function call addToDoList with testListTitle, testOuterHashMap, and testInnerHashMap in its parameters, returning the testOuterHashMap
        //assertTrue if testOuterHashMap<testList, testInnerHashMap> with get(Object key) method is not null
        //end addListTest function

    //create a removeExistingListTest function that takes in testOuterHashMap, testInnerHashMap, and testListTitle as its parameters
        //function call removeToDoList with testListTitle, testOuterHashMap, and testInnerHashMap in its parameters, returning the testOuterHashMap
        //assertTrue if testOuterHashMap<testList, testInnerHashMap> with get(Object key) method is null
        //end removeExistingListTest function

    //create an editListTest function that takes in testOuterHashMap, testInnerHashMap, and testListTitle as its parameters
        //function call editToDoList with testListTitle, testOuterHashMap, and testInnerHashMap in its parameters, returning the testOuterHashMap
        //assertTrue if testOuterHashMap<testList, testInnerHashMap> with get(Object key) method 0is not null
        //end editListTest function

    //create an addNewItemTest function that takes in testOuterHashMap, testInnerHashMap, testListTitle, testItemTitle, testItemDate, and testItemDescription as its parameters
        //function call addNewItem with testInnerHashMap, testListTitle, testItemTitle, testItemDate, and testItemDescription, returning the testInnerHashMap
        //assertTrue if testInnerHashMap<testList, ItemComponents> with get(Object key) method is not null
        //end addNewItemTest function

    //create a removeItemTest function that takes in testInnerHashMap and testItemTitle as its parameters
        //function call removeItem with testItemTitle and testInnerHashMap in its parameters, returning the testInnerHashMap
        //assertTrue if testInnerHashMap<testItemTitle, ItemComponents> with get(Object key) method is null
        //end removeItemTest function

    //create an editDescriptionTest function that takes in testInnerHashMap, testItemTitle, and testItemDescription as its parameters
        //function call editDescription with testItemTitle testInnerHashMap, testItemTitle, and testItemDescription as its parameters, returning the testInnerHashMap
        //assertTrue if testInnerHashMap<testItemTitle, ItemComponents.get(itemDescription)> equals testItemDescription
        //end editDescriptionTest function

    //create an editDeadlineTest function that takes in testInnerHashMap, testItemTitle, and testDeadline as its parameters
        //function call editDueDate with testItemTitle testInnerHashMap, testItemTitle, and testDueDate as its parameters, returning the testInnerHashMap
        //assertTrue if testInnerHashMap<testItemTitle, ItemComponents.get(dueDate)> equals testDeadline
        //end editDueDateTest function

    //create a markCompleteTest that takes in testInnerHashMap and testItemTitle as its parameters
        //function call editItemCompletionStatus with testInnerHashMap and testItemTitle as its parameters, return testInnerHashMap
        //assertTrue if testInnerHashMap<testItemTitle, ItemComponents.get(completionFlag)> equals testItemCompletionMarker
        //end markCompleteTest function

    //create a displayItemsTest
        //
        //end displayItemsTest function

    //create a displayCompletedItemsTest
        //
        //end displayCompletedItemsTest function

    //create a displayUncompletedItemsTest
        //
        //end displayUncompletedItemsTest function

    //create a saveSingleListTest
        //
        //end saveSingleListTest function

    //create a saveAllListsTest
        //
        //end saveAllListsTest function

    //create a loadSingleListTest
        //
        //end loadSingleListTest function

    //create a loadAllListsTest
        //
        //end loadAllListsTest function
}