package com.kot.datastructure;

public class LinkedListImpl {
    private Node head;
    private int size;
    class Node{
        String data;
        Node next;

        Node(String data){
            this.data = data;
            this.next = null;
        }
    }

    public LinkedListImpl(){
        this.size = 0;
    }

    public void addFirst(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
        this.size++;
    }

    public void addLast(String data){
        Node newNode = new Node(data);
        Node currentNode = head;
        this.size++;
        if(head == null){
            head = newNode;
            return;
        }
        while(currentNode.next != null){
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
    }

    public void deleteFirst(){
        if(head == null){
            System.out.println("LinkedList is empty");
            return;
        }
        this.size--;
        if(head.next == null){
            head = null;
            return;
        }
        head = head.next;
    }

    public void deleteLast(){
        if(head == null){
            System.out.println("LinkedList is empty");
            return;
        }
        this.size--;
        if(head.next == null){
            head = null;
            return;
        }
        Node lastNode = head.next;
        Node secondLastNode = head;
        while(lastNode.next != null){
            secondLastNode = secondLastNode.next;
            lastNode = lastNode.next;
        }
        secondLastNode.next = null;


    }

    public void printList(){
        Node currentNode = head;
        if(head == null){
            System.out.println("LinkedList is empty");
            return;
        }
        while(currentNode != null){
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.print("NULL");
        System.out.println();
    }

    public void getSize(){
        System.out.println("the size is : "+ this.size);
    }

    public static void main(String[] args) {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.addFirst("a");
        linkedList.printList();
        linkedList.getSize();
        linkedList.addFirst("is");
        linkedList.printList();
        linkedList.getSize();
        linkedList.addLast("LinkedList");
        linkedList.printList();
        linkedList.getSize();
        linkedList.addFirst("this");
        linkedList.printList();
        linkedList.getSize();
        linkedList.deleteFirst();
        linkedList.printList();
        linkedList.getSize();
        linkedList.deleteLast();
        linkedList.printList();
        linkedList.getSize();

        linkedList.deleteLast();
        linkedList.printList();
        linkedList.getSize();

        linkedList.deleteLast();
        linkedList.printList();
        linkedList.getSize();
    }
}
