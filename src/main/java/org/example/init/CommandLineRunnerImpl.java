package org.example.init;

import org.example.DTOs.ProductDTO;
import org.example.models.Product;
import org.example.models.Warehouse;
import org.example.services.ProductService;
import org.example.services.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

//    @Autowired
//    private StudentService studentService;

    @Autowired
    private ProductService productService;

    @Autowired
    private WarehouseService warehouseService;

    @Override
    public void run(String... args) throws Exception {
        seedData();
    }

//    private void printAllStudentsByGroupName(String groupName) {
//        studentService
//                .findStudentsByGroup(groupName)
//                .forEach(System.out::println);
//    }

    private void seedData() throws IOException {
        //Добавление в БД записей
//        ProductDto p1 = new ProductDto();
//        Warehouse w1 = new Warehouse();
//        Student s1 = new Student("Petr Ivanov");
//        Student s2 = new Student("Ivan Petrov");
//        Group g1 = new Group("UVP-211");
//        Group g2 = new Group("UVP-212");

//        w1.setCount(2);
//        w1.setInvNumber("2323");
//        w1.setMinCount(1);
//
//        p1.setName("sdsd");
//        p1.setWarehouse(w1);

//        s1.setGroup(g1);
//        s2.setGroup(g2);
//
//        studentService.register(s1);
//        studentService.register(s2);
//        warehouseService.register(w1);
//        productService.register(p1);

//        printAllStudentsByGroupName("UVP-212");
//
//        studentService.transfer(s1, g2);
//
//        printAllStudentsByGroupName("UVP-212");

//        Scanner in = new Scanner(System.in);
//        String s = in.nextLine();
    }
}
