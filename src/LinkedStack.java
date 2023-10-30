/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class LinkedStack<E> {

    private Node<E> top;
    private int size;

    public LinkedStack() {
        top = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(E data) {
// Make a new node whose next reference is the existing list
        Node<E> newNode = new Node(data, top);
        top = newNode; // top points to new node
        size++;
    }

    public E pop() {
        if(top == null)
        return null;
        
        E t = top.element; // Save the value at the top of the stack
        top = top.next; // Make top reference points to the next node in the stack
        size--;
        
        return t; // return the removed value
    }

    public E top() {
        if(top == null)
        return null;
        
        return top.element;
    }
public void print(){
    LinkedStack<E> s=new LinkedStack<>();
    while(!isEmpty()){
        E data=pop();
        System.out.println(data);
        s.push(data);
    }
    while(!s.isEmpty())
        push(s.pop());
}
}
