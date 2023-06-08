package org.example;

public class Main {
    public static void main(String[] args) {
        BinarySearchTrees tree = new BinarySearchTrees();
        Menu menu = new Menu(tree);
        menu.startMenu();
    }
}