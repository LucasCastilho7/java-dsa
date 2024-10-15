class LinkedListNoAuxSpace {
    private Node head;

    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class LinkedListSemEspacoAuxiliar {
    public static void main(String[] args) {
        LinkedListNoAuxSpace list = new LinkedListNoAuxSpace();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.print("Lista Original: ");
        list.display();

        list.reverse();

        System.out.print("Lista Invertida: ");
        list.display();
    }
}
