package Ej3_30;

class LinkedList {

	static Node head, head1, head2;

	static class Node {

		int data;
		Node next, prev;

		Node(int d) {
			data = d;
			next = prev = null;
		}
	}

	/* Función para dividir una lista (que comienza con head) en dos listas.
	   head1_ref y head2_ref son referencias a los nodos de head de
	   las dos listas enlazadas resultantes */
	void splitList() {
		Node slow_ptr = head;
		Node fast_ptr = head;

		if (head == null) {
			return;
		}

		/* Si hay nodos impares en la circular list entonces
		   fast_ptr->next se convierte en head y para los nodos pares
		   fast_ptr->next->next se convierte en head */
		while (fast_ptr.next != head
				&& fast_ptr.next.next != head) {
			fast_ptr = fast_ptr.next.next;
			slow_ptr = slow_ptr.next;
		}

		/* Si hay elementos pares en la lista entonces mueve fast_ptr */
		if (fast_ptr.next.next == head) {
			fast_ptr = fast_ptr.next;
		}

		/* Fijar el puntero de head de la primera mitad */
		head1 = head;

		/* Fijar el puntero de head de la segunda mitad */
		if (head.next != head) {
			head2 = slow_ptr.next;
		}
		/* Hacer circular el segundo tiempo */
		fast_ptr.next = slow_ptr.next;

		/* Hacer la primera mitad circular */
		slow_ptr.next = head;
	}

	/* Función para imprimir los nodos de un singly linked list */
	void printList(Node node) {
		Node temp = node;
		if (node != null) {
			do {
				System.out.print(temp.data + " ");
				temp = temp.next;
			} while (temp != node);
		}
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		//La linked list creada sera 18->35->6->52
		list.head = new Node(18);
		list.head.next = new Node(35);
		list.head.next.next = new Node(6);
		list.head.next.next.next = new Node(52);
		list.head.next.next.next.next = list.head;

		System.out.println("Forma original de Circular Linked list ");
		list.printList(head);

		// Dividir la lista
		list.splitList();
		System.out.println("");
		System.out.println("Primera Circular List ");
		list.printList(head1);
		System.out.println("");
		System.out.println("SegundaCircular List ");
		list.printList(head2);
		
	}
}