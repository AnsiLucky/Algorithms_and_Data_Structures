package week5.assignment3;

public class Student {
    private static int static_id = 1;

    private String name;
    private int id;
    private double gpa;

    public Student(String name, double gpa) {
        this.id = static_id++;
        this.name = name;
        this.gpa = gpa;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name +
                "\', id=" + id +
                ", gpa=" + gpa +
                '}';
    }
}

