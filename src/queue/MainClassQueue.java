
package queue;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

class QueueList {
    Node front, rear;
    int size = 0;
    
    void enqueue(int dt) {
        Node newNode = new Node(dt);
        
        if(size == 0) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    } 
    
    void dequeue() {
        if(size == 0) {
            System.out.println("queue kosong");
            return;
        } else if(size == 1) {
            front = rear = null;
        } else {
            front = front.next;
        }
        size--;
    }
    
    int peek() {
        if(size == 0) {
            System.out.println("queue kosong");
            return -1;
        }
        else {
            return front.data;
        }
    }
}


class QueueArray {
    int front = -1;
    int rear = -1;
    int size = 0;
    int max_size;
    int []queue;
    
    QueueArray(int max_size) {
        this.max_size = max_size;
        queue = new int[max_size];
    }
    
    void enqueue(int dt) {
        if(isEmpty()) {
            front = rear = 0;
            size++;
            queue[rear] = dt;
        } else {
            if(isFull()) {
                resize();
            }
            rear = (rear+1) % max_size;
            queue[rear] = dt;
            size++;
        }
    }
    
    int dequeue() {
        if(isEmpty()) {
            System.out.println("Queue Kosong");
            return -1;
        } else if(size == 1) {
            int keluar = queue[front];
            front = -1;
            rear = -1;
            size = 0;
            return keluar;
        } else {
            int keluar = queue[front];
            front = (front+1) % max_size;
            size--;
            return keluar;
        }
    }
    
    int peek() {
        if(isEmpty()) {
            System.out.println("Queue kosong");
            return -1;
        }
        else {
            return queue[front];
        }
    }
    
    private void resize() {
        int []tmp = new int[max_size * 2];
        int now = 0;
            
        while(front != rear) {
            tmp[now] = queue[front];
            front = (front+1) % max_size;
            now++;
        }
        tmp[now] = queue[front];
        
        queue = tmp;
        front = 0;
        rear = size-1;
        max_size = max_size * 2;
    }
    
    boolean isEmpty() {
        return size == 0;
    }
    
    boolean isFull() {
        return size == max_size;
    }
    
    void printAll() { // method bantuan untuk melihat bentuk queue
        for(int i=0; i<max_size; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
        System.out.println("front : " + front);
        System.out.println("rear : " + rear);
        System.out.println("size : " + size);
        System.out.println("max_size : " + max_size);
        System.out.println();
    }
}




public class MainClassQueue {
    public static void main(String[] args) {
        QueueArray queueArr = new QueueArray(5);
        
        queueArr.enqueue(1);
        queueArr.enqueue(2);
        queueArr.enqueue(3);
        queueArr.enqueue(4);
        queueArr.enqueue(5);
        queueArr.printAll();

        queueArr.dequeue();
        queueArr.printAll();
        /*Perhatikan nilai 1 masih ada padahal sudah di dequeue. 
        Ini karena tidak dihapus beneran namun seolah-olah dihapus.
        Lihat nilai front=1; size=4;*/
        
        queueArr.enqueue(6);
        queueArr.printAll();
        
        queueArr.enqueue(7);
        queueArr.printAll();
    }
}
