package org.example.Views;

import org.example.Controllers.registerCourse.StudentController;

import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner;
    StudentController studentController;
    public ConsoleView() {
        this.scanner = new Scanner(System.in);
        this.studentController = new StudentController();
    }

    public void showMenu() {
        System.out.println("Menú: ");
        System.out.println("1. Inscribir Curso");
        System.out.println("2. Eliminar Curso");
        System.out.println("3. Ver cursos");
        System.out.println("4. Ver cursos  inscritos");
        System.out.println("5. Exit");

        int option = scanner.nextInt();

    }


}
