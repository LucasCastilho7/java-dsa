class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    private Node head;

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

    public int[] toArray() {
        int size = getSize();
        int[] array = new int[size];
        Node temp = head;
        int index = 0;
        while (temp != null) {
            array[index++] = temp.data;
            temp = temp.next;
        }
        return array;
    }

    public int getSize() {
        int size = 0;
        Node temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
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

public class ConversaoLinkedListVetor {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        System.out.print("Lista Encadeada: ");
        list.display();

        int[] array = list.toArray();
        System.out.print("Vetor: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}