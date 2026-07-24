package employee;

public class EmployeeManagement {
    private Employee[] employees;
    private int size;
    private int capacity;

    public EmployeeManagement(int capacity) {
        this.capacity = capacity;
        this.employees = new Employee[capacity];
        this.size = 0;
    }

    public boolean addEmployee(Employee employee) {
        if (size >= capacity) {
            System.out.println("Array is full. Cannot add more employees.");
            return false;
        }
        employees[size++] = employee;
        return true;
    }

    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverseEmployees() {
        if (size == 0) {
            System.out.println("No employees to display.");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public boolean deleteEmployee(String employeeId) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        }
        // Shift elements to the left
        for (int i = index; i < size - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employees[size - 1] = null;
        size--;
        return true;
    }

    public static void main(String[] args) {
        EmployeeManagement em = new EmployeeManagement(5);
        
        em.addEmployee(new Employee("E001", "Alice", "Developer", 75000));
        em.addEmployee(new Employee("E002", "Bob", "Manager", 85000));
        em.addEmployee(new Employee("E003", "Charlie", "Analyst", 65000));
        
        System.out.println("All Employees:");
        em.traverseEmployees();
        
        System.out.println("\nSearch E002: " + em.searchEmployee("E002"));
        
        System.out.println("\nDeleting E002...");
        em.deleteEmployee("E002");
        
        System.out.println("\nAll Employees after deletion:");
        em.traverseEmployees();
    }
}
