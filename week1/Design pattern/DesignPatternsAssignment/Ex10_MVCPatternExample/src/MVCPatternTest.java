public class MVCPatternTest {
    public static void main(String[] args) {
        Student model = new Student("Priya Sharma", "S1024", "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        System.out.println("Initial record:");
        controller.updateView();

        
        controller.setStudentGrade("A+");
        controller.setStudentName("Priya S. Sharma");

        System.out.println();
        System.out.println("After update:");
        controller.updateView();
    }
}
