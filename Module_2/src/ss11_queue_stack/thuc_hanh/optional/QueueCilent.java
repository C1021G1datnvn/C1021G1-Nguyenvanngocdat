package ss11_queue_stack.thuc_hanh.optional;

import ss11_queue_stack.thuc_hanh.optional.MyQueue;

public class QueueCilent {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(7);
        queue.enqueue(4);
        queue.dequeue();
        queue.enqueue(56);
        queue.enqueue(2);
        queue.enqueue(67);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(24);
        queue.dequeue();
        queue.enqueue(98);
        queue.enqueue(45);
        queue.enqueue(23);
        queue.enqueue(435);
    }
}
