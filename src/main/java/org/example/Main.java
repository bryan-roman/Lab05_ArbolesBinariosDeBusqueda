package org.example;

public class Main {

    public static void main(String[] args) {

        BinarySearchTrees tree = new BinarySearchTrees();
        tree.insertar(4, null);
        tree.insertar(12, null);
        tree.insertar(1, null);
        tree.insertar(3, null);
        tree.insertar(8, null);
        tree.insertar(6, null);
        tree.insertar(10, null);
//        //tree.inorderTreewalk(tree.root);
//       //  tree.preorderTreewalk(tree.root);
//        tree.postorderTreewalk(tree.root);

        Menu menu = new Menu(tree);

        menu.startMenu();

    }
}
