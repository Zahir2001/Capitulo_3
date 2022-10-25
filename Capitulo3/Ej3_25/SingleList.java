package Ej3_25;

import java.util.*;

public class SingleList {

    /* Link list Node */
    static class Node {
        int key;
        Node next;
    };

    // Función para invertir una Linked List utilizando la recursión
    static Node reverseList(Node head)
    {

        if (head.next == null)
            return head;

        Node rest = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return rest;
    }

    // Dadas dos linked lists no vacías 'a' y 'b'
    static Node sortedMerge(Node a, Node b)
    {
        
        // Inversa Linked List 'a'
        a = reverseList(a);

        // Inversa Linked List 'b'
        b = reverseList(b);

        // Inicializar head de la lista resultante
        Node head = null;

        Node temp;

        // Recorre ambas listas mientras ambas tienen nodos.
        while (a != null && b != null) {

            // Si el valor actual de 'a' es mayor o igual que el valor actual de 'b'.
            if (a.key >= b.key) {

                // Almacenar el siguiente nodo actual en la primera lista
                temp = a.next;
                
                // Añadir "a" al principio de la lista resultante
                a.next = head;
                
                // Hacer 'a' - head de la lista de resultados
                head = a;
                
                // Avanzar en la primera lista
                a = temp;
            }
            
            // Si el valor de 'b' es mayor. Los pasos siguientes son similares
            // a los anteriores (sólo se sustituye 'a' por 'b')
            else {
                temp = b.next;
                b.next = head;
                head = b;
                b = temp;
            }
        }

        // Si la segunda lista llegó al final, pero la primera lista tiene
        // nodos. Añade los nodos restantes de la primera lista al
        // principio de la lista resultante
        while (a != null) {

            temp = a.next;
            a.next = head;
            head = a;
            a = temp;
        }

        // Si la primera lista llegó al final, pero la segunda lista tiene
        // nodos. Añade los nodos restantes de la segunda lista al
        // principio de la lista de resultados
        while (b != null) {

            temp = b.next;
            b.next = head;
            head = b;
            b = temp;
        }

        // Devuelve el head de la lista de resultados
        return head;
    }

    /* Función para imprimir los nodos de una linked list */
    static void printList(Node Node)
    {
        while (Node != null) {
            System.out.print(Node.key+ " ");
            Node = Node.next;
        }
    }

    /* Función para crear un nuevo nodo con clave dada */
    static Node newNode(int key)
    {
        Node temp = new Node();
        temp.key = key;
        temp.next = null;
        return temp;
    }

    /* Probar las funciones anteriores*/
    public static void main(String[] args)
    {
        /* Empezar con la lista vacía */
        Node res = null;

        /* Crear linked lists ordenadas

            a: 8.16.24.40
            b: 6.12.18 */

        Node a = newNode(8);
        a.next = newNode(16);
        a.next.next = newNode(24);
        a.next.next.next = newNode(40);

        Node b = newNode(6);
        b.next = newNode(12);
        b.next.next = newNode(18);

        System.out.print("Lista A antes de la fusión: \n");
        printList(a);

        System.out.print("\nLista B antes de la fusión: \n");
        printList(b);

        /* fusionar 2 Linked Lists ordenados */
        res = sortedMerge(a, b);

        System.out.print("\nLa Linked List is: \n");
        printList(res);
    }
}
