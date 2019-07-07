package home.composite;

import java.util.ArrayList;
import java.util.List;

public class HeadDepartment implements Department {


    private Integer id;
    private String name;

    List<Department> childDepartments = new ArrayList<>();

    @Override
    public void printDepartment() {
        childDepartments.forEach(Department::printDepartment);
    }

    public void addChild(Department department){
        childDepartments.add(department);
    }

    public void deleteChild(Department department){
        childDepartments.remove(department);
    }
}
