package com.company;
import java.util.*;

/**
 * Per-Joel Sompio
 * Prestudy assignment
 * This is a program that lets the user make a shoppinglist.
 * it also has methods for sorting the list and show the
 * most expensive or the cheapest item on the list.
 */

public class Main {
    public static void main(String[] args) {
        boolean noMoreItems = false;
        int choice;
        ArrayList<Item> itemList = new ArrayList<Item>();
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("This is a program used for making a shopping list");
            System.out.println("The user will be given options to insert items as well as show prices");
            System.out.println("1: Add items to the shopping list");
            System.out.println("2: Sort the list. NOTE, the user HAS to run this option in order for the next options to work");
            System.out.println("3: Show the entire list");
            System.out.println("4: Show the cheapest item on the list");
            System.out.println("5: Show the most expensive item on the list");
            choice = input.nextInt();
            if(choice < 1 || choice > 5) {
                System.out.println("ERROR: choose between option 1-5");
            }
            switch (choice) {
                case 1:
                    while (!noMoreItems) {
                        System.out.println("Add items, first add the productname and press enter. Then add the price and press enter");
                        itemList.add(new Item(input.next(), input.nextInt()));

                        System.out.println("Add more products? press y/n");
                        if (input.next().equals("n")) {
                            noMoreItems = true;
                            System.out.println("no more products");
                        }
                    }
                    break;
                case 2:
                    Collections.sort(itemList, priceNumber);
                    break;
                case 3:
                    showList(itemList);
                    break;
                case 4:
                    showCheapestItem(itemList);
                    break;
                case 5:
                    showMostExpensiveItem(itemList);
                    break;
            }
        } while(choice >= 1 && choice <= 5);
    }

    /**
     * Method for sorting the list. goes in ascending order
     */
    static Comparator<Item> priceNumber = new Comparator<Item>() {
        public int compare(Item o1, Item o2) {
            int item1 = o1.getPrice();
            int item2 = o2.getPrice();
            return item1 - item2;
        }
    };

    /**
     * Method for printing out the entire list
     * @param itemList
     */
    static void showList(ArrayList<Item> itemList) {
        if(itemList == null || itemList.isEmpty()) {
            System.out.println("List is empty, please add items");
        } else {
            for(Item item: itemList) {
                System.out.println(item.getName() + " " + item.getPrice());
            }
        }
    }

    /**
     * Method for showing the cheapest item on the list. provided
     * that the list has already been sorted.
     * @param itemList
     */
    static void showCheapestItem(ArrayList<Item> itemList) {
        if(itemList == null || itemList.isEmpty()) {
            System.out.println("List is empty, please add items");
        } else {
            System.out.println(itemList.get(0).getName() + " " + itemList.get(0).getPrice());
        }
    }

    /**
     * Method for showing the most expensive item on the list.
     * provided that the list has already been sorted.
     * @param itemList
     */
    static void showMostExpensiveItem(ArrayList<Item> itemList) {
        if(itemList == null || itemList.isEmpty()) {
            System.out.println("List is empty, please add items");
        } else {
            int size = itemList.size() - 1;
            System.out.println(itemList.get(size).getName() + " " + itemList.get(size).getPrice());
        }
    }


}
