package com.company;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Menu {
    Scanner input = new Scanner(System.in); //Creating input

    int selection; //menu selection
    int dSelection; //delete selection
    int cSelection; //complete selection

    ArrayList<String> menu = new ArrayList<>(); //Array list of menu selection strings
    ArrayList<Listing> list = new ArrayList<>(); //Array list for tasks. "To-Do List"

    public Menu() {} //Empty menu constructor

    public void setMenu() { //Full menu constructor
        menu.add("Add a task");
        menu.add("Delete a task");
        menu.add("Mark a task complete");
        menu.add("View to-do list");
    }

    public void displayMenu() {
        System.out.println("Please make a selection");
        System.out.println("1: " + menu.get(0));
        System.out.println("2: " + menu.get(1));
        System.out.println("3: " + menu.get(2));
        System.out.println("4: " + menu.get(3));
    }

    public void setSelection() { //Getting the menu option then processing each option
        selection = input.nextInt(); //User's menu selection
        input.nextLine(); //BUMP

        switch(selection) {
            case 1: { //Adding a task
                System.out.println("You selected to add a new task!\n");
                Listing listing = new Listing(); //Creating new task

                System.out.println("What is the title of the new task?");
                listing.setTitle(input.nextLine());
                System.out.println("What is the description of the new task?");
                listing.setDesc(input.nextLine());
                System.out.println("\n");

                Date date = new Date(); //Creating date created
                listing.setCreated(date);
                listing.setCompleted(false);
                listing.setdCompleted(null);

                list.add(listing); //Adding task to to-do list

                System.out.println("The task you added is...");
                System.out.println("Title: " + listing.getTitle());
                System.out.println("Description: " + listing.getDesc());
                System.out.println("Date Created: " + listing.getCreated()+"\n");
                break;
            }
            case 2: { //Deleting a task
                System.out.println("You selected to delete a task!\n");
                System.out.println("Which task would you like to delete? Enter the corresponding number.");
                for (int i = 0; i < list.size(); i ++){ //Displaying which task to delete
                    System.out.println((i+1) +": " + list.get(i).getTitle());
                }
                dSelection = input.nextInt();

                System.out.println("\n");
                list.remove(dSelection-1); //Removing task from the Listing array
                System.out.println(list.get(dSelection-1).getTitle() + " has been deleted.");
                break;
            }
            case 3: { //Marking task complete
                System.out.println("You selected to complete a task!\n");
                System.out.println("Which task would you like to mark complete? Enter the corresponding number.");
                for (int i = 0; i < list.size(); i ++){ //Loop to display which task to complete
                    System.out.println((i+1) +": " + list.get(i).getTitle());
                }
                cSelection = input.nextInt();

                System.out.println("\n");
                list.get(cSelection-1).setCompleted(true); //Task is now completed

                Date date = new Date(); //Creating completed date
                list.get(cSelection-1).setdCompleted(date);
                System.out.println(list.get(cSelection-1).getTitle() + " has been marked complete.");
                break;
            }
            case 4: { //Viewing the To-Do list
                System.out.println("To-Do List");
                for (int i = 0; i < list.size(); i ++){ //Loop displaying items in Listing array
                    System.out.println((i+1) +": " + list.get(i));
                }
                break;
            }
            default: {
                System.out.println("Invalid selection.");
            }
        }
    }

    public static void runMenu() {
        Scanner input = new Scanner(System.in); //Creates input
        String choice; //Choice to continue making menu selections
        int contin = 3; //Int for String choice

        Menu menu = new Menu(); //Creating the menu object
        menu.setMenu(); //Setting up the menu options

        do { //Loop for menu selection
            menu.displayMenu();
            menu.setSelection(); //Asks the user which menu selection they want

            System.out.println("\nWould you like to make another choice? Please type yes or no.");

            choice = input.nextLine();
            choice = choice.toLowerCase();

            if (choice.equals("yes")){
                contin = 1;
            }
            else if (choice.equals("no")){
                contin = 0;
            }

        } while (contin == 1);

        System.out.println("Thank you! Good-bye.");
    }
}