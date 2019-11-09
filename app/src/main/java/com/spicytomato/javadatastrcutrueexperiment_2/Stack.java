package com.spicytomato.javadatastrcutrueexperiment_2;

public class Stack<T> {
    public Node<T> head;

    public Stack(){
        head = new Node<T>();
    }

    public boolean isEmpty(){
        return head.next == null;
    }


    public void StackClear(){
        if(!isEmpty()){
            head.next = null;
        }
    }

    public void StackPush(T data){
        head.next = new Node<>(data,head.next);
    }

    public T StackPop() {
        T data;
        if (!isEmpty()) {
            data = head.next.data;
            head.next = head.next.next;
        }else {
            data = null;
        }

        return data;
    }

    public T StackPeek(){
        T data;
        if(!isEmpty()){
            data = head.next.data;
        }else{
            data = null;
        }

        return data;
    }

    @Override
    public String toString() {
        Node<T> p = head.next;
        String s = "";
        while (p != null){
            s += p.data + " ";
            p = p.next;
        }

        return s;
    }
}
