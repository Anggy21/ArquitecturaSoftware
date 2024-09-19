package org.example.Views;

import org.example.Controllers.StudentController;

import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner;
    StudentController studentController;
    public ConsoleView() {
        this.scanner = new Scanner(System.in);
        this.studentController = new StudentController();
    }

    public void showMenu() {
        System.out.println("Menú de inscripción de cursos");
        System.out.println("1. Inscribir Curso");
        System.out.println("2. Eliminar Curso");
        System.out.println("3. Ver cursos");
        System.out.println("4. Ver cursos  inscritos");
        System.out.println("5. Exit");

        int option = scanner.nextInt();

    }

    public void showMenuStudents(){
        System.out.println("Menú de estudiantes");
        System.out.println("1. Ver estudiante por ID");
        System.out.println("2. Ver todos los estudiantes");
        System.out.println("3. Exit");

        int option = scanner.nextInt();

        try{
            switch(option){
                case 1:
                    System.out.println("Ingrese el ID del estudiante");
                    long id = scanner.nextLong();

                    studentController.viewStudentById(id);
                    break;
                case 2:
                    studentController.viewAllStudents();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
