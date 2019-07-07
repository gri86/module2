package builder;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private int age;
    private String name;
    private String gender;
    private String course;
    private String university;
    private String faculty;
    private int grade;
    private boolean isAlive;
    private String department;
    private String group;
    private int level;

    public Student(int age, String name, String gender, String course, String university, String faculty, int grade, boolean isAlive, String department, String group, int level) {
        this.age = age;
        this.name = name;
        this.gender = gender;
        this.course = course;
        this.university = university;
        this.faculty = faculty;
        this.grade = grade;
        this.isAlive = isAlive;
        this.department = department;
        this.group = group;
        this.level = level;
    }

    public Student(){}

    public static class Builder{
        private Student student;

        public Builder(){
            this.student = new Student();
        }

        public Builder addAge(int age){
            this.student.age = age;
            return this;
        }

        public Builder addName(String name){
            this.student.name = name;
            return this;
        }

        public Builder withGender(String gender){
            this.student.gender = gender;
            return this;
        }

        public Student build(){
            return this.student;
        }
    }
}

class Group{

    List<Student> students;

    public Group() {
        this.students = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }
}
