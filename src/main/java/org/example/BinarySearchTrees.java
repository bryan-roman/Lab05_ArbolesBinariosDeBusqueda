package org.example;

public class BinarySearchTrees {

    Nodo root;

    public BinarySearchTrees() {
        root = null;
    }

    public void insertar(int key, Object value){
        Nodo newNodo = new Nodo(key); //Se crea un nuevo nodo y se le asigna la llave
        newNodo.value = value;

        if(root == null){ //Si no hay raíz entonces, la raíz es el nuevo nodo que se crea.
            root = newNodo;
        }
        else { //Se debe recorrer el arbol para encontrar un punto donde agregar el nodo
            Nodo temporalNodo = root;
            while(temporalNodo != null){
                newNodo.father = temporalNodo; //El padre del nuevo nodo es tmeporal

                if(newNodo.key >= temporalNodo.key){ //si la llave del nuevo nodo es mayor o igual al temporal llave
                    temporalNodo = temporalNodo.right;      //Lado derecho del árbol
                } else {
                    temporalNodo = temporalNodo.left;       //Lado izquiero del árbol
                }


            } if (newNodo.key < newNodo.father.key){ //Si la llave del nuevo nodo es menor a la llave del padre
                newNodo.father.left = newNodo; //coloque el nuevo elemento a la izquierda
            } else {
                newNodo.father.right = newNodo; //Si la llave del nuevo nodo es mayor a la llave del padre
            }
        }
    }

    private class Nodo {
        public Nodo father; //padre
        public Nodo right;
        public Nodo left;
        public int key;
        public Object value;


        public Nodo(int key) {
            key = key;
            right = null;
            left = null;
            father = null;
            value = null;
        }
    }
}