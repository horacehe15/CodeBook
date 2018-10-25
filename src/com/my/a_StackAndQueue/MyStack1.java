package com.my.a_StackAndQueue;

import java.util.Stack;

public class MyStack1 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    private MyStack1(){
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }
    public void push(int newNum){
        if (this.stackMin.isEmpty()){
            this.stackMin.push(newNum);
        }else if (newNum < this.getMin()){
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }

    private int getMin() {
        if (this.stackMin.isEmpty()){
            throw new RuntimeException("Your stack is empty!");

        }
        return this.stackMin.peek();
    }

    public int pop(){
        if (this.stackData.isEmpty()){
            throw new RuntimeException("Your stack is empty.");

        }
        int value = this.stackData.pop();
        if (value == this.getMin()){
            this.stackMin.pop();
        }
        return value;
    }

//  仅用递归函数和栈操作逆序一个栈
    public static int getAndRemoveLastElement(Stack<Integer> stack){
        int result = stack.pop();
        if (stack.isEmpty()){
            return result;
        } else{
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }
// 仅用递归函数和栈操作逆序一个栈
    public static void reverse(Stack<Integer> stack){
        if (stack.isEmpty()){
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    public static void main(String[] args) {

    }

}

