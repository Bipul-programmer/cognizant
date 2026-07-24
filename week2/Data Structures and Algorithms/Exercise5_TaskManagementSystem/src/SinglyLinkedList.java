package tasklist;

class Node {
    Task task;
    Node next;

    Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

public class SinglyLinkedList {
    private Node head;

    public SinglyLinkedList() {
        this.head = null;
    }

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Task searchTask(String taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId().equals(taskId)) {
                return current.task;
            }
            current = current.next;
        }
        return null; // Not found
    }

    public void traverseTasks() {
        Node current = head;
        if (current == null) {
            System.out.println("Task list is empty.");
            return;
        }
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    public boolean deleteTask(String taskId) {
        if (head == null) return false;

        if (head.task.getTaskId().equals(taskId)) {
            head = head.next;
            return true;
        }

        Node current = head;
        while (current.next != null && !current.next.task.getTaskId().equals(taskId)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            return true;
        }
        return false; // Task not found
    }

    public static void main(String[] args) {
        SinglyLinkedList taskList = new SinglyLinkedList();
        
        taskList.addTask(new Task("T001", "Design Database", "Pending"));
        taskList.addTask(new Task("T002", "Implement API", "In Progress"));
        taskList.addTask(new Task("T003", "Write Tests", "Not Started"));
        
        System.out.println("All Tasks:");
        taskList.traverseTasks();
        
        System.out.println("\nSearching for T002: " + taskList.searchTask("T002"));
        
        System.out.println("\nDeleting T002...");
        taskList.deleteTask("T002");
        
        System.out.println("\nAll Tasks after deletion:");
        taskList.traverseTasks();
    }
}
