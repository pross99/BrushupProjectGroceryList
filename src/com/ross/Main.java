package com.ross;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scaninput = new Scanner(System.in);
    private  static GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {
        // write your code here


        boolean quit = false;
        int choice = 0;
        printInstructions();

        while(!quit) {
            System.out.println("Enter Your Choice");
            choice = scaninput.nextInt();
            scaninput.nextLine();


            switch (choice) {
                case 0:
                    printInstructions();
                    break;

                case 1:
                    groceryList.printGroceryList();

                    break;

                case 2:
                    addItem();
                    break;

                case 3 :
                    modifyItem();
                    break;

                case 4:
                    removeItem();
                    break;

                case 5:
                    searchForItem();
                    break;

                case 6:
                    processArrayList();
                    break;

                case 7:
                    quit= true;
                    break;
            }
        }




    }

    public static void printInstructions() {
        System.out.println("\nPress");
        System.out.println("\t 0 - To show Instructions ");
        System.out.println("\t 1 - To Print GroceryList ");
        System.out.println("\t 2 - To Add Item ");
        System.out.println("\t 3 - To Modify item ");
        System.out.println("\t 4 - To Remove Item ");
        System.out.println("\t 5 - To Search for an Item in your basket to check if you've added it already ");
        System.out.println("\t 6 - To Process Array List. ");
        System.out.println("\t 7 - To quit");
    }

    public static void addItem() {
        System.out.print("Add : Please enter the grocery Item : ");
        groceryList.addGroceryItem(scaninput.nextLine());
    }

    public static void modifyItem() {
        System.out.print("Modify : Enter the Item: ");
        String curItem = scaninput.nextLine();

        System.out.print("Modify : Enter the Replacement Item");
        String newItem = scaninput.nextLine();

        groceryList.modifyGroceryItem(curItem, newItem);
    }

    public static void removeItem() {
        System.out.print("Remove : Enter the Item: ");
        String itemNo = scaninput.nextLine();
        groceryList.removeItem(itemNo);
        System.out.print("msg: The Item has been removed");
        groceryList.printGroceryList();
    }

    public static void searchForItem() {
        System.out.print("Item to search for: ");
        String searchItem = scaninput.nextLine();
        if(groceryList.onFile(searchItem)) {
            System.out.println("Item " + searchItem + " is on the list");
        }else{
            System.out.println(searchItem + " is not in the list");
        }
    }

    public static void processArrayList() {

        ArrayList<String> newArrayList = new ArrayList<String>();
        newArrayList.addAll(groceryList.getGroceryList());


        ArrayList<String> anotherArrayList = new ArrayList<>(groceryList.getGroceryList());

        String[] myArray = new String[groceryList.getGroceryList().size()];
        myArray = groceryList.getGroceryList().toArray(myArray);
    }




}

