package org.example;

public class BinarySearchTrees {

    //Se crea un nuevo Nodo con sus parámetros
    //Se crea su constructor señalando que la llave que ingrese se le otorgo a ese nodo
    Nodo root;
    public BinarySearchTrees() {
        root = null;
    }
    private class Nodo {
        public Nodo father; //padre
        public Nodo right;
        public Nodo left;
        public int llave;
        public Object firstValue;
        public Object secondValue;
        public Object thirdValue;

        public Nodo(int key) {
            llave = key;
            right = null;
            left = null;
            father = null;
            firstValue = null;
            secondValue = null;
            thirdValue = null;
        }
    }


    //Método de Inserción (Árbol Binario Búsqueda)
    //Agrega un nuevo elemento. Si no hay elementos se agrega como raíz
    //Si hay elementos, evalúa la llave de ingreso, si es mayor lo ingresa a la derecha, si es menor a la izquierda
    
    
public void insert(int key, Object firstValue, Object secondValue, Object thirdValue) {
    Nodo newNodo = new Nodo(key);  // Se crea un nuevo nodo con su llave
    newNodo.firstValue = firstValue;
    newNodo.secondValue = secondValue;
    newNodo.thirdValue = thirdValue;

    if (root == null) {
        root = newNodo;
    } else {
        Nodo temporalNodo = root;
        while (temporalNodo != null) {
            newNodo.father = temporalNodo;

            if (newNodo.llave >= temporalNodo.llave) {
                temporalNodo = temporalNodo.right;
            } else {
                temporalNodo = temporalNodo.left;
            }
        }

        if (newNodo.llave < newNodo.father.llave) { // Si la llave del nuevo nodo es menor a la llave del padre
            newNodo.father.left = newNodo; // Coloca el nuevo elemento a la izquierda
        } else {
            newNodo.father.right = newNodo; // Si la llave del nuevo nodo es mayor a la llave del padre
        }
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


}
