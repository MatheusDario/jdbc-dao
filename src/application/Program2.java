package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: Create Department ===");
        Department newDep = new Department(null, "Test");
        departmentDao.insert(newDep);
        System.out.println("Inserted! new Id: " + newDep.getId());

        System.out.println("\n=== TEST 2: Find By Id Department Name ===");
        Department department = departmentDao.findById(2);
        System.out.println(department);

        System.out.println("\n=== TEST 3: Update Department Name ===");
        department = departmentDao.findById(10);
        department.setName("Suits");
        departmentDao.update(department);
        System.out.println("Update completed! " + department.getName());

        System.out.println("\n=== TEST 4: Delete By Id ===");
        System.out.print("Enter id for delete: ");
        Integer id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete complete!");
    }
}
