package university;

import java.util.ArrayList;
import java.util.List;

public class University {
    public List<Student> students;
    private int capacity;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getStudentCount() {
        return students.size();
    }

    public String registerStudent(Student student) {
        if (capacity > students.size() && students.isEmpty()) {
            this.students.add(student);
            return String.format("Added student %s %s",student.getFirstName(),student.getLastName());
        } else if (getCapacity() > getStudentCount()) {
            for (Student s : students) {
                if (s.getFirstName().equals(student.getFirstName()) &&
                        s.getLastName().equals(student.getLastName())) {
                    return "Student is already in the university";
                } else {
                    this.students.add(student);
                    return "Added student " + student.getFirstName() + " " + student.getLastName();
                }
            }
        }
        return "No seats in the university";
    }

    public String dismissStudent(Student student) {
        for (Student student1 : students) {
            if (student1.getFirstName().equals(student.firstName) &&
            student1.getLastName().equals(student.getLastName())) {
                students.remove(student);
                return String.format("Removed student %s %s",student.getFirstName(),student.getLastName());
            }

        }
        return "Student not found";

    }
    public Student getStudent(String firstName,String lastName) {
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return student;
            }

        }
        return null;
    }
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Student student : students) {
            sb.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s",
                    student.getFirstName(),student.getLastName(),student.getBestSubject())).append(System.lineSeparator());

        }
        return sb.toString();
    }
}
