package DefiningClasses.exercise.companyRoster;

public class Employee {

    // mandatory
    private String name;
    private double salary;
    private String position;
    private String department;

    // optional
    private String email;
    private int age;

    public double getSalary() {
        return salary;
    }

    public Employee(String name, double salary, String position, String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = "n/a";
        this.age = -1;
    }

    public Employee(String name,double salary,String position,String department,String email) {
        this(name,salary,position,department);
        this.email = email;
        this.age = -1;
    }

    public Employee(String name,double salary,String position,String department,int age) {
        this(name,salary,position,department);
        this.age = age;
        this.email = "n/a";
    }

    public Employee(String name,double salary,String position,String department,String email,int age) {
        this(name,salary,position,department,email);
        this.age = age;
    }
    @Override

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.name + " ");
        builder.append(String.format("%.2f ",this.salary));
        builder.append(this.email + " ");
        builder.append(this.age + " ");


        return builder.toString();
    }
}
