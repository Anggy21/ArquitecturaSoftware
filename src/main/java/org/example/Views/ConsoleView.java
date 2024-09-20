package org.example.Views;


import DTO.ClientDTO;
import DTO.ProductDTO;
import DTO.SaleDTO;
import DTO.SellerDTO;
import org.example.Controllers.*;
import org.example.DTO.CourseDTO;
import org.example.DTO.ProgramDTO;
import org.example.DTO.RegisterCourseDTO;
import org.example.DTO.StudentDTO;
import org.example.Entities.Student;
import org.example.Services.facade.DocumentsManagementFacade;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleView {
    private final Scanner scanner;

    private final StudentController studentController;
    private final RegisterCourseController registerCourseController;
    private final StudentProgramController studentProgramController;
    private final CourseController courseController;
    private final RegisterSaleController registerSaleController;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
        this.studentController = new StudentController();
        this.registerCourseController = new RegisterCourseController();
        this.studentProgramController = new StudentProgramController();
        this.courseController = new CourseController();
        this.registerSaleController = new RegisterSaleController();
    }

    public void showMenu() {
        System.out.println("Menú: ");
        System.out.println("1. Ingresar al sistema de cursos");
        System.out.println("2. Convertir archivo");
        System.out.println("3. Ingresar venta");
        System.out.println("5. Exit");

        int option;

        do {
            System.out.println("Ingrese una opción: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    registerStudent();
                    break;
                case 2:
                    convertFile();
                    break;
                case 3:
                    System.out.println("Ingresar venta");
                    break;
                case 5:
                    System.out.println("Exiting...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (option != 5);
    }

    private void registerStudent() {

        List<Long> idStudents = studentController.viewAllStudents().stream().map(StudentDTO::getIdStudent).toList();
        StudentDTO studentToRegister = null;
        List<StudentDTO> students = studentController.viewAllStudents();

        System.out.println("\nSeleccione el número del estudiante que desea registrar: ");
        students.forEach(student -> {
            System.out.println(student.getIdStudent() + "." + student.getNameStudent() + " " + student.getLnStudent());
        });

        long idStudent;

        do {
            idStudent = scanner.nextLong();
            scanner.nextLine();

            if (!idStudents.contains(idStudent)) {
                System.out.println("El número ingresado no corresponde a un estudiante registrado");
            } else studentToRegister = studentController.viewStudentById(idStudent);

        } while (!idStudents.contains(idStudent));

        System.out.println("Ingrese el id del curso que desea registrar: ");

        List<ProgramDTO> programsDTO = studentProgramController.findProgramsByStudentId(studentToRegister.getIdStudent());

        List<CourseDTO> courses = new ArrayList<>();
        programsDTO.forEach(program -> {
            courses.addAll(courseController.viewCoursesByProgram(program));
        });

        List<Long> idCourses = courses.stream().map(CourseDTO::getIdCourse).toList();

        CourseDTO courseToRegister = null;
        long idCourse;

        do {
            idCourse = scanner.nextLong();
            scanner.nextLine();

            if (!idCourses.contains(idCourse)) {
                System.out.println("El número ingresado no corresponde a un curso registrado");
            } else courseToRegister = courseController.viewCourseById(idCourse);
        } while (!idCourses.contains(idCourse));

        RegisterCourseDTO registerCourseDTO = new RegisterCourseDTO();

        registerCourseDTO.setIdStudent(studentToRegister.getIdStudent());
        registerCourseDTO.setIdCourse(courseToRegister.getIdCourse());

        registerCourseController.registerCourse(registerCourseDTO);

        System.out.println("Estudiante registrado exitosamente");
    }

    private void convertFile() {
        System.out.println("Ingrese la ruta del archivo a convertir: ");
        String path = scanner.nextLine();

        System.out.println("Ingrese el formato al que desea convertir el archivo: ");
        String format = scanner.nextLine();

        System.out.println("Convirtiendo archivo...");

        DocumentsManagementFacade documentsManagementFacade = new DocumentsManagementFacade();

        documentsManagementFacade.convertDocument(path, format);

        System.out.println("Archivo convertido exitosamente");
    }

    private void registerSale() {

        System.out.println("Ingrese el nombre del cliente: ");
        String client = scanner.nextLine();

        System.out.println("Ingrese el DNI del cliente: ");

        String dni = scanner.nextLine();

        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setNameClient(client);
        clientDTO.setDniClient(dni);

        List<ProductDTO> products = registerSaleController.getAllProducts();

        List<Long> idProducts = products.stream().map(ProductDTO::getIdProduct).toList();

        ProductDTO productToRegister = null;

        System.out.println("Seleccione el número del producto que desea registrar: ");

        products.forEach(product -> {
            System.out.println(product.getIdProduct() + ". " + product.getProduct());
        });

        long idProduct;

        do {
            idProduct = scanner.nextLong();
            scanner.nextLine();

            if (!idProducts.contains(idProduct)) {
                System.out.println("El número ingresado no corresponde a un producto registrado");
            } else productToRegister = registerSaleController.getProductById(idProduct);
        } while (!idProducts.contains(idProduct));

        List<SellerDTO> sellerDTOS = registerSaleController.getAllSellers();

        List<Long> idSellers = sellerDTOS.stream().map(SellerDTO::getIdSeller).toList();

        SellerDTO sellerToRegister = null;

        System.out.println("Seleccione el número del vendedor que desea registrar: ");

        sellerDTOS.forEach(seller -> {
            System.out.println(seller.getIdSeller() + ". " + seller.getNameSeller());
        });

        long idSeller;

        do {
            idSeller = scanner.nextLong();
            scanner.nextLine();

            if (!idSellers.contains(idSeller)) {
                System.out.println("El número ingresado no corresponde a un vendedor registrado");
            } else sellerToRegister = registerSaleController.getSellerById(idSeller);
        } while (!idSellers.contains(idSeller));


        SaleDTO saleDTO = new SaleDTO();
        saleDTO.setDate((Date) Date.from(Instant.now()));
        saleDTO.setIdSeller(sellerToRegister.getIdSeller());

        registerSaleController.registerSale(saleDTO,List.of(productToRegister));
    }

}

