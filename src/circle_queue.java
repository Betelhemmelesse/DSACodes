public class circle_queue {

    private int[] items;
    private int front, rear, capacity;

    public circle_queue(int capacity) {
        this.capacity = capacity;
        items = new int[capacity];
        front = rear = -1; // Initially, queue is empty
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % capacity == front; // Circular queue check
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue overflow");
            return;
        }
        if (isEmpty()) {
            front = 0;
        }
        rear = (rear + 1) % capacity; // Circular queue handling
        items[rear] = data;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue underflow");
            return -1; // Indicate error or use a special value
        }
        int data = items[front];
        if (front == rear) {
            front = rear = -1; // If only one element, reset both front and rear
        } else {
            front = (front + 1) % capacity; // Circular queue handling
        }
        return data;
    }

    public static void main(String[] args) {
        // Create a CircularQueue with capacity 5
        circle_queue queue = new circle_queue (5);

        // Enqueue elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front element: " + queue.dequeue());  // Output: Front element: 10

        // Add another element (will overwrite the oldest element)
        queue.enqueue(40);

        System.out.println("Front element: " + queue.dequeue());  // Output: Front element: 20
        System.out.println("Front element: " + queue.dequeue());  // Output: Front element: 30
        System.out.println("Front element: " + queue.dequeue());  // Output: Front element: 40

        // Queue is empty now
        queue.enqueue(50);

        System.out.println("Front element: " + queue.dequeue());  // Output: Front element: 50
    }
}
