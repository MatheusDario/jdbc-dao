package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: Seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== TEST 2: Seller findByIdDepartment ===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 3: Seller findByIdDepartment ===");
        list = sellerDao.findAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 4: Seller Seller Insert ===");
        Seller newSeller = new Seller(null, "Greg", "gred@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());

        System.out.println("\n=== TEST 5: Seller Update ===");
        seller = sellerDao.findById(1);
        seller.setName("Martha Wayne");
        sellerDao.update(seller);
        System.out.println("Update completed! " + seller.getName());

        System.out.println("\n=== TEST 6: Seller Delete ===");
        System.out.println("Enter id for delete test: ");
        Integer inDelete = sc.nextInt();
        sellerDao.deleteById(inDelete);
        System.out.println("Delete completed");

        sc.close();
    }
}
