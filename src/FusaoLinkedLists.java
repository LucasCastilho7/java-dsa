class LinkedListToBeMerged {
    private Node head;

    public void addSorted(int data) {
        Node newNode = new Node(data);
        if (head == null || head.data >= newNode.data) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && current.next.data < newNode.data) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public static LinkedListToBeMerged merge(LinkedListToBeMerged list1, LinkedListToBeMerged list2) {
        LinkedListToBeMerged mergedList = new LinkedListToBeMerged();
        Node head1 = list1.head;
        Node head2 = list2.head;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                mergedList.addSorted(head1.data);
                head1 = head1.next;
            } else {
                mergedList.addSorted(head2.data);
                head2 = head2.next;
            }
        }

        while (head1 != null) {
            mergedList.addSorted(head1.data);
            head1 = head1.next;
        }

        while (head2 != null) {
            mergedList.addSorted(head2.data);
            head2 = head2.next;
        }

        return mergedList;
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

public class FusaoLinkedLists {
    public static void main(String[] args) {
        LinkedListToBeMerged list1 = new LinkedListToBeMerged();
        LinkedListToBeMerged list2 = new LinkedListToBeMerged();

        list1.addSorted(1);
        list1.addSorted(3);
        list1.addSorted(5);

        list2.addSorted(2);
        list2.addSorted(4);
        list2.addSorted(6);

        System.out.print("Lista 1: ");
        list1.display();

        System.out.print("Lista 2: ");
        list2.display();

        LinkedListToBeMerged mergedList = LinkedListToBeMerged.merge(list1, list2);

        System.out.print("Lista Fundida: ");
        mergedList.display();
    }
}
