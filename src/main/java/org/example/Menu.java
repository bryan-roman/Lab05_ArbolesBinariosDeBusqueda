package org.example;

import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    int key;
    Object firstValue;
    Object secondValue;
    Object thirdValue;

    BinarySearchTrees tree;
    boolean salida = false;

    public Menu(BinarySearchTrees tree) {
        this.tree = tree;
    }

    public void startMenu() {
        while (!salida) {
            System.out.println("");
            System.out.print("Lb05-Arboles Binarios de Búsqueda \n");
            System.out.print("1- Inserción \n"
                    + "2- Borrado \n"
                    + "3- Búsqueda \n"
                    + "4- Salir \n"
                    + "Elija la opción: ");

            int optionStartMenu = Integer.parseInt(scanner.nextLine());
            switch (optionStartMenu) {
                case 1:
                    addMenu();

                    break;
                case 2:
                    deleteMenu();

                    break;
                case 3:
                    searchMenu();

                    break;
                case 4:
                    salir();
                    break;
            }

        }

    }

    public void addMenu() {
        System.out.println("Ingrese la llave(Solamente números): ");
        key = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese el primer valor del nodo:");
        firstValue = scanner.nextLine();
        System.out.println("Ingrese el segundo valor:  ");
        secondValue = scanner.nextLine();
        System.out.println("Ingrese el tercer valor");
        thirdValue = scanner.nextLine();
        tree.insert(key, firstValue, secondValue, thirdValue);
    }

    public void salir() {
        System.out.println("1 para salir, 2 para cancelar: ");
        key = Integer.parseInt(scanner.nextLine());
        if (key == 1) {
            salida = true;//
        }
    }

    public void searchMenu() {
        System.out.print("1- Preorden \n"
                + "2- Enorden \n"
                + "3- Postorden \n"
                + "Seleccione el metodo de recorrido: ");
        key = Integer.parseInt(scanner.nextLine());

        if (key == 1) {
            tree.preorderTreewalk(tree.root);
        } else {
            if (key == 2) {
                tree.inorderTreewalk(tree.root);
            } else {
                if (key == 3) {
                    tree.postorderTreewalk(tree.root);
                }
            }
        }
    }

    public void deleteMenu() {
        System.out.print("Digite la llave que desea eliminar: ");
        key = Integer.parseInt(scanner.nextLine());
        if (tree.delete(key)) {
            System.out.println("Nodo eliminado.");
        } else {
            System.out.println("El nodo no existe.");
        }
    }

}
