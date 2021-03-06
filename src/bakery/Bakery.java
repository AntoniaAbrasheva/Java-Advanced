package bakery;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }
    public void add(Employee employee) {
        if (capacity > employees.size()) {
            employees.add(employee);
        }
    }
    public boolean remove(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                employees.remove(employee);
                return true;
            }

        }
        return false;
    }
    public Employee getOldestEmployee() {
        return employees.get(0);
    }
    public Employee getEmployee(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }

        }
        return null;
    }
    public int getCount() {
        return employees.size();
    }
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Employees working at Bakery %s:",name)).append(System.lineSeparator());
        for (Employee employee : employees) {
            sb.append(employee).append(System.lineSeparator());

        }
        return sb.toString();
    }
}
