
package tree;

class Node {
    char data;
    Node left, right;
    
    Node(char data) {
        this.data = data;
        left = right = null;
    }
}

class NodeQueue {
    Object data;
    NodeQueue next;
    
    NodeQueue(Object data) {
        this.data = data;
        next = null;
    }
}

class Queue {
    NodeQueue front, rear;
    int size = 0;
    
    void enqueue(Node input) {
        NodeQueue newNode = new NodeQueue(input);
        
        if(isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    } 
    
    Node dequeue() {
        Node keluar;
        if(isEmpty()) {
            System.out.println("queue kosong");
            return null;
        } else if(size == 1) {
            keluar = (Node)front.data;
            front = rear = null;
        } else {
            keluar = (Node)(front.data);
            front = front.next;
            
        }
        size--;
        return keluar;
    }
    
    Node peek() {
        if(isEmpty()) {
            System.out.println("queue kosong");
            return null;
        }
        else {
            return (Node)front.data;
        }
    }
    
    boolean isEmpty() {
        return size == 0;
    }
}

class Tree {
    Node root;
    
    void preorder(Node now) {
        if(now == null) {
            return;
        }
        
        System.out.print(now.data + " ");
        preorder(now.left);
        preorder(now.right);
    }
    
    void inorder(Node now) {
        if(now == null) {
            return;
        }
        
        inorder(now.left);
        System.out.print(now.data + " ");
        inorder(now.right);
    }
    
    void postorder(Node now) {
        if(now == null) {
            return;
        }
        
        postorder(now.left);
        postorder(now.right);
        System.out.print(now.data + " ");
    }
    
    void levelorder(Node now) {
        Queue queue = new Queue();
        
        queue.enqueue(now);
        
        while(!queue.isEmpty()) {
            Node palingDepan = queue.peek();
            
            System.out.print(palingDepan.data + " ");
            queue.dequeue();
            
            if(palingDepan.left != null) {
                queue.enqueue(palingDepan.left);
            }
            if(palingDepan.right != null) {
                queue.enqueue(palingDepan.right);
            }
        }
    }
    
    /*Hanya method bantuan untuk melihat bentuk tree dengan jelas*/
    void levelOrderWithChild(Node now) {
        Queue queue = new Queue();
        
        queue.enqueue(now);
        
        while(!queue.isEmpty()) {
            Node palingDepan = queue.peek();
            
            System.out.print(palingDepan.data + "; ");
            queue.dequeue();
            
            System.out.print("left : ");
            if(palingDepan.left != null) {
                queue.enqueue(palingDepan.left);
                System.out.print(palingDepan.left.data);
            }
            System.out.print("; right : ");
            if(palingDepan.right != null) {
                queue.enqueue(palingDepan.right);
                System.out.print(palingDepan.right.data);
            }
            System.out.println();
        }
    }
}


public class BinaryTree {
    public static void main(String[] args) {
        
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');
        Node I = new Node('I');
        
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        D.left = H;
        D.right = I;
        
        Tree tree = new Tree();
        
        tree.root = A;
        
        System.out.println("Bentuk Awal : ");
        tree.levelOrderWithChild(tree.root);
        
        System.out.println("\n\nPREORDER : ");
        tree.preorder(tree.root);
        System.out.println("\n\nINORDER : ");
        tree.inorder(tree.root);
        System.out.println("\n\nPOSTORDER : ");
        tree.postorder(tree.root);
        System.out.println("\n\nLEVEL ORDER : ");
        tree.levelorder(tree.root);
        System.out.println("");
    }
}
