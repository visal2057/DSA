/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsa;

/**
 *
 * @author Visal
 */
public class UnboundedArrayStack {
    private int[] stack;
    private int top;
    private int capacity;

    public UnboundedArrayStack() {
        capacity = 2;
        stack = new int[capacity];
        top = -1;
    }

    // Push operation
    public void push(int data) {
        if (top == capacity - 1) {
            resize(capacity * 2);
        }
        stack[++top] = data;
    }

    // Pop operation
    public int pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }

        int value = stack[top--];

        if (top > 0 && top == capacity / 4) {
            resize(capacity / 2);
        }

        return value;
    }

    // Resize array
    private void resize(int newCapacity) {
        int[] newStack = new int[newCapacity];
        for (int i = 0; i <= top; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
        capacity = newCapacity;
    }

    public static void main(String[] args) {
        UnboundedArrayStack s = new UnboundedArrayStack();

        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);

        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
