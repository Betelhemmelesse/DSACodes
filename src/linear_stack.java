import java.util.Stack;
public class linear_stack {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public linear_stack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
    public void enqueue(int data) {
        // Push all elements from stack1 to stack2 (reversing the order)
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(data);
    }
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue underflow");
            return -1; // Indicate error or use a special value
        }
        if (stack2.isEmpty()) {
            // Move all elements from stack1 to stack2 for temporary storage and reversal
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        // Create a LinearQueueUsingStacks object
        linear_stack queue = new linear_stack();

        // Enqueue elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front element: " + queue.dequeue());  // Output: Front element: 10

        // Add another element
        queue.enqueue(40);

        System.out.println("Front element: " + queue.dequeue());  // Output: Front element: 20
        System.out.println("Front element: " + queue.dequeue());  // Output: Front element: 30
        System.out.println("Front element: " + queue.dequeue());  // Output: Front element: 40
    }
}

