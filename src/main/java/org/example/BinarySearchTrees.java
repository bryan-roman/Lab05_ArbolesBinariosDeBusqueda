package org.example;

public class BinarySearchTrees {

    Nodo root;

    public BinarySearchTrees() {
        root = null;
    }

    private class Nodo {

        public Nodo father; //padre
        public Nodo right;
        public Nodo left;
        public int llave;
        public Object value;

        public Nodo(int key) {
            llave = key;
            right = null;
            left = null;
            father = null;
            value = null;
        }
    }

    public void inorderTreewalk(Nodo busqueda) {
        if (busqueda != null) {
            inorderTreewalk(busqueda.left);
            System.out.print(busqueda.llave+ ", "); //Regresal al medio o nodo actual
            inorderTreewalk(busqueda.right);
        }
    }

    public void preorderTreewalk(Nodo busqueda) {
        if (busqueda != null) {
            System.out.print(busqueda.llave+ ", "); //Regresal al medio o nodo actual
            preorderTreewalk(busqueda.left);
            preorderTreewalk(busqueda.right);

        }
    }

    public void postorderTreewalk(Nodo busqueda) {
        if (busqueda != null) {
            postorderTreewalk(busqueda.left);
            postorderTreewalk(busqueda.right);
            System.out.print(busqueda.llave + ", "); //Regresal al medio o nodo actual

        }
    }

    public boolean delete(int d) {
      //  boolean eliminado = false;
        Nodo auxiliar = root;
        Nodo padre = root;
        boolean esIzq = true;

        while (auxiliar.llave != d) {
            padre = auxiliar;

            if (d < auxiliar.llave) {
                esIzq = true;
                auxiliar = auxiliar.left;
            } else {
                esIzq = false;
                auxiliar = auxiliar.right;
            }
            if (auxiliar == null) {
                return false;
            }
        } //Fin while

        if (auxiliar.left == null && auxiliar.right == null) {
            if (auxiliar == root) {
                root = null;
            } else if (esIzq) {
                padre.left = null;
            } else {
                padre.right = null;
            }

        } else if (auxiliar.right == null) {
            if (auxiliar == root) {
                root = auxiliar.left;
            } else if (esIzq) {
                padre.left = auxiliar.left;
            } else {
                padre.right = auxiliar.left;
            }
        } else if (auxiliar.left == null) {
            if (auxiliar == root) {
                root = auxiliar.right;
            } else if (esIzq) {
                padre.left = auxiliar.right;
            } else {
                padre.right = auxiliar.left;
            }
        } else {
            Nodo reemplazo = obtenerReemplazo(auxiliar);
            if (auxiliar == root) {
                root = reemplazo;
            } else if (esIzq) {
                padre.left = reemplazo;

            } else {
                padre.right = reemplazo;
            }
            reemplazo.left=auxiliar.left;
        }
        return true;
    }
    
    public Nodo obtenerReemplazo(Nodo nodoReemp){
        Nodo reempPadre= nodoReemp;
        Nodo reemplazo=nodoReemp;
        Nodo auxiliar= nodoReemp.right;
        
        while(auxiliar!=null){
            reempPadre=reemplazo;
            reemplazo=auxiliar;
            auxiliar = auxiliar.left;
        }
        if (reemplazo!=nodoReemp.right) {
            reempPadre.left=reemplazo.right;
            reemplazo.right=nodoReemp.right;
        }
        return reemplazo;
    }

    public void insertar(int key, Object value) {
        Nodo newNodo = new Nodo(key); //Se crea un nuevo nodo y se le asigna la llave
        newNodo.value = value;

        if (root == null) { //Si no hay raíz entonces, la raíz es el nuevo nodo que se crea.
            root = newNodo;
        } else { //Se debe recorrer el arbol para encontrar un punto donde agregar el nodo
            Nodo temporalNodo = root;
            while (temporalNodo != null) {
                newNodo.father = temporalNodo; //El padre del nuevo nodo es tmeporal

                if (newNodo.llave >= temporalNodo.llave) { //si la llave del nuevo nodo es mayor o igual al temporal llave
                    temporalNodo = temporalNodo.right;      //Lado derecho del árbol
                } else {
                    temporalNodo = temporalNodo.left;       //Lado izquiero del árbol
                }
            }
            if (newNodo.llave < newNodo.father.llave) { //Si la llave del nuevo nodo es menor a la llave del padre
                newNodo.father.left = newNodo; //coloque el nuevo elemento a la izquierda
            } else {
                newNodo.father.right = newNodo; //Si la llave del nuevo nodo es mayor a la llave del padre
            }
        }
    }
}
