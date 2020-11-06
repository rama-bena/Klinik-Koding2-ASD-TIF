package stack;

class Node {
    int data;
    Node prev, next;

    public Node(int data) {
        this.data = data;
    }   
}

class Stack {
    Node top;
    
    void push(int dt) {
        Node newNode = new Node(dt);
        
        if(top == null) { // stack kosong
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }
    
    int pop() {
        if(top == null) {
            System.out.println("Stack nya kosong");
            return -1;
        } else {
            int data = top.data;
            top = top.next;
            return data;
        }
    }
    
    int peek() {
        if(top == null) {
            return -1;
        }
        else {
            return top.data;
        }
    }
}

class StackArray {
    int top = -1;
    int size = 0;
    int max_size;
    int [] stack;
    
    StackArray(int max_size) {
        this.max_size = max_size;
        stack = new int[max_size];
    }
    
    void push(int dt) {
        if(isEmpty()) {
            size = 1;
            top = 0;
            stack[top] = dt;
        } else {
            if(isFull()) {
                resize();
            }
            
            top++;
            stack[top] = dt;
            size++;
        }
    }
    
    int pop() {
        if(isEmpty()) {
            System.out.println("stack kosong");
            return -1;
        }
        else {
            int keluar = stack[top];
            top--;
            size--;
            return keluar;
        }
    }
    
    int peek() {
        if(size == 0) {
            System.out.println("stack kosong");
            return -1;
        }
        else {
            return stack[top];
        }
    }
    
    private void resize() {
        int[] tmp = new int[max_size * 2];
        System.arraycopy(stack, 0, tmp, 0, max_size);
        stack = tmp;
        max_size *= 2;
    }
    
    boolean isEmpty() {
        return size == 0;
    }
    
    boolean isFull() {
        return size == max_size;
    }
    
    void printAll() { // digunakan untuk membantu melihat bentuk dari stack
        for(int i=0; i<max_size; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
        System.out.println("Top : " + top);
        System.out.println("Size : " + size);
        System.out.println("Max_size: " + max_size);
        System.out.println();
    }
}


public class MainClassStack {
    public static void main(String[] args) {
        
        StackArray stackArr = new StackArray(5);
        
        stackArr.push(1);
        stackArr.push(2);
        stackArr.printAll();
        
        stackArr.pop();
        stackArr.pop();
        stackArr.printAll(); /* perhatikan didalam stack sebenarnya masih ada 
        nilainya tetapi seolah-olah dihapus, buktinya nilai dari top = -1; size=0;*/
       
        
        stackArr.push(1);
        stackArr.push(2);
        stackArr.push(3);
        stackArr.push(4);
        stackArr.push(5);
        stackArr.printAll();
        
        stackArr.push(6);
        stackArr.printAll();
        
        
    }
}
