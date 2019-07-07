package builder;

import java.util.List;

public class UniversityApp {

    public static void main(String[] args) {
        Student student1 = new Student
                .Builder()
                .addAge(20)
                .addName("Artem")
                .withGender("Male")
                .build();

        Group group = new Group();
        group.getStudents().add(student1);
    }

}
