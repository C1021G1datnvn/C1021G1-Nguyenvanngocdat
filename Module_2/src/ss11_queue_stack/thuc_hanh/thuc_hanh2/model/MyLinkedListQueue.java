package ss11_queue_stack.thuc_hanh.thuc_hanh2.model;

import ss11_queue_stack.thuc_hanh.thuc_hanh2.model.Node;

public class MyLinkedListQueue {
    private Node head;
    private Node tail;

    public MyLinkedListQueue() {
        this.head = null;
        this.tail = null;
    }

    /**
     * xkx =  xem không xóa
     * @param key
     */
    public void enqueue(int key) {
        Node temp = new Node(key);
        if (this.tail == null) {
            this.head = this.tail = temp;  //  gán phần tử đầu tiên =  phần tử cuối  =  null
            return;
        }
        this.tail.next = temp;
        this.tail = temp;
    }

    /**
     * xxx= xem xong xóa
     * @return
     */
    public Node dequeue() {
        if (this.head == null) {
            return null;
        }
        Node temp = this.head;
        this.head = this.head.next;
        if (this.head == null) {
            this.tail = null;
        }
        return temp; // in ra phần tử đầu tiên
    }
}
