package com.company;

import sun.awt.image.ImageWatched;

import java.util.List;

public class Main {

    /*
    public static boolean findLoopInLinkedList(LinkedList list) {
        return false;
    }





    public static boolean fixLoopInLinkedList(LinkedList list) {
        Node<Integer> slowPointer = list.head;
        Node<Integer> fastPointer = list.head;

        while (slow)

    }

 */


    public static int getListLength(LinkedList list) {
        if (list == null) {
            return 0;
        } else {
            int length =  0;
            Node<Integer> node = list.head;
            while (node != null) {
                length++;
                node = node.next;
            }
            return length;
        }
    }

    public static boolean findMergePoint(LinkedList list1, LinkedList list2) {
        if (list1 == null || list2 == null) {
            return false;
        } else {

            int length1 = getListLength(list1);
            int length2 = getListLength(list2);

            Node<Integer> tempHeader1 = list1.head;
            Node<Integer> tempHeader2 = list2.head;
            int diff = Math.abs(length1 - length2);

            if (length1 > length2) {
                while (diff > 0) {
                    tempHeader1 = tempHeader1.next;
                    diff--;
                }
            } else {
                while (diff > 0) {
                    tempHeader2 = tempHeader2.next;
                    diff--;
                }
            }

        }


        return false;
    }



    public static Node<Integer> reverseLinkedListRecursively(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node<Integer> second = node.next;
        node.next = null;
        System.out.println(node.data);

        Node<Integer> remaining = reverseLinkedListRecursively(second);
        //node.next.next = node;
        second.next = node;
        return remaining;
    }

    public static LinkedList reverseLinkedListIteratively(LinkedList list) {
        if (list == null) {
            System.out.println("List is null");
            return null;
        } else {
            Node<Integer> head = list.getHead();
            Node<Integer> tempPointer = head;
            Node<Integer> currentPointer = head;
            Node<Integer> previous = head;
            while (currentPointer != null) {
                //temp = currentPointer.next;
                //currentPointer = currentPointer.next;
                tempPointer = currentPointer.next;
                //currentPointer.next = head;
                if (currentPointer == head) {
                    currentPointer.next = null;
                } else {
                    currentPointer.next = previous;
                    previous = currentPointer;
                }
                currentPointer = tempPointer;
            }
            list.head = previous;
            list.print();
            return list;
        }
    }

    public static void main(String[] args) {
        //LinkedList<Integer> ll = new LinkedList<Integer>();
        //ll.pushItem(4);
        //ll.pushItem(8);
        //ll.pushItem(56);

        LinkedList<Integer> l1 = new LinkedList<>();
        l1.pushItem(90);
        l1.pushItem(43);
        l1.pushItem(2);



        l1.print();
       // ll.print();
        //LinkedList<Integer> reverseLL = reverseLinkedListIteratively(ll);

       // reverseLL.print();

        System.out.println(l1.head.data);

        l1.head = reverseLinkedListRecursively(l1.head);
        l1.print();
        System.out.println("length of the list" + getListLength(l1) );

    }

    static class LinkedList<E extends Comparable<E>> {

        Node<E> head;
        Node<E> current;

        LinkedList() {
            head = current = null;
        }

        public void pushItem(Node<E> node) {
            if (head == null) {
                head = node;
            } else {
                current = head;
                while (current.next !=null) {
                    current = current.next;
                }
                current.next = node;
            }
        }


        public void pushItem(E data) {
            Node<E> node  = new Node<E>(data);

            if (data == null) {
                return;
            }
            if (head == null) {
                head = node;
            } else {
                current = head;
                while (current.next !=null) {
                    current = current.next;
                }
                current.next = node;
            }
        }

        public void print() {
            if (head == null) {
                System.out.println("The linked list is empty");
            } else {
                current = head;
                while (current != null) {
                    System.out.println(current.data.toString());
                    current = current.next;
                }
            }
        }

        public Node<E> getHead() {
            return head;
        }

    }

    static class Node<E extends Comparable<E>> implements Comparable<Node<E>> {

        Node<E> next;
        E data;

        Node(E data) {
            this.data = data;
            next = null;
        }

        Node() {
            data = null;
            next = null;
        }

        @Override
        public int compareTo(Node<E> o) {
            return this.data.compareTo(o.data);
        }
    }
}
