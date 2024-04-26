package org.example;
import java.util.Scanner;

class Guard {
    public String readGuardCommand() {//функция дл вывода команды для охраника
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите команду для охранника:");
        return scanner.nextLine();
    }
}
