package org.example;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    int key;
    Object value;
    BinarySearchTrees binarySearchTrees;

    public void startMenu(){
        System.out.println("Lb05-Arboles Binarios de Búsqueda");
        System.out.println("Elija la opción: \n" +
                "1- Inserción \n" +
                "2- Borrado \n" +
                "3- Búsqueda \n" +
                "4- Salir");

        int optionStartMenu = Integer.parseInt(scanner.nextLine());
        do {
            switch(optionStartMenu){
                case 1:
                    addMenu();
                    startMenu();

                    break;
                case 2:
                    //deleteMenu
                    break;
                case 3:
                    //searchMenu
                    break;
                case 4:
                    System.exit(0);
                    break;
            }

        }while(optionStartMenu!= 4);
    }

    public void addMenu(){
        System.out.println("Ingrese la llave: ");
        key = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese el valor del nodo:");
        value = scanner.nextLine();
        BinarySearchTrees binarySearchTrees = new BinarySearchTrees();
        binarySearchTrees.insertar(key, value);
    }


}
