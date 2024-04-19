public class linear_queue {

    private int[] items;
    private int front, rear, capacity;

    public linear_queue(int capacity) {
        this.capacity = capacity;
        items = new int[capacity];
        front = rear = -1; // Initially, queue is empty
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return rear == capacity - 1;
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue overflow");
            return;
        }
        if (front == -1) {
            front = 0; // If queue was initially empty, set front to 0
        }
        rear++;
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
            front++;
        }
        return data;
    }

    public static void main(String[] args) {
        // Create a LinearQueue with capacity 5
        linear_queue queue = new linear_queue(5);

        // Enqueue elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front element: " + queue.dequeue());  // Output: Front element: 10

        // Add another element
        queue.enqueue(40);

        System.out.println("Front element: " + queue.dequeue());  // Output: Front element: 20
    }
}

