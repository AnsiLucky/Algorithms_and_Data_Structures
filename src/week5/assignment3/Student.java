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

    public int hashcode() {
        char[] s = name.toCharArray();
        int hashName = 0;
        for (int i = 0; i < name.length(); i++)
            hashName = (31 * hashName) + s[i];

        return (int) ((hashName * gpa) + id);
    }

    @Override
    public String toString() {
        return "Student {" +
                "name='" + name + "\'" +
                ", id = " + id +
                ", gpa = " + gpa +
                '}';
    }
}

