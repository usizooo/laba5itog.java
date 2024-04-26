package org.example;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Scanner;

public class Turma {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.displayMenu();
    }
}

class Prison {
    private HashMap<String, Prisoner> prisoners;

    public Prison() {
        this.prisoners = new HashMap<>();
    }

    public static String timeSinceEscape(int hours, int minutes) { // функция для подсчета времени с момента побега
        return "Прошло " + hours + " часов и " + minutes + " минут с момента побега";
    }

    public static boolean isDangerousPrisoner(String prisonerID) { //функция для определеия насколько заключённый опасен
        return prisonerID.startsWith("DNG");
    }

    public static String getPrisonerGender(String prisonerID) { // функция для  определения пола заключённого
        char genderCode = prisonerID.charAt(0);
        switch (genderCode) {
            case 'M':
                return "Мужской";
            case 'F':
                return "Женский";
            default:
                return "Неизвестный";
        }
    }

    public String timeUntilRelease(String prisonerID) {  //функция для подсчёта количства дней до освобождения
        int remainingDays = 365;
        return "До освобождения заключенного " + prisonerID + " осталось " + remainingDays + " дней";
    }

    public int countTotalPrisoners(String[] prisonerIDs) { // функция для подсчёта количества заключённых в общем
        return prisonerIDs.length;
    }

    public static String getPrisonerCrime(String prisonerID) { //функция определяющая за что сидит человек
        HashMap<String, String> prisonerCrimes = new HashMap<>();
        prisonerCrimes.put("ID1", "Убийство");
        prisonerCrimes.put("ID2", "Кража");
        prisonerCrimes.put("ID3", "Наркотики");
        return prisonerCrimes.getOrDefault(prisonerID, "Неизвестное преступление");
    }

    public String lastEscapeTime() { //функция для вывода сообщения о последнем побеге
        return "Последний побег был зарегистрирован в 14:32";
    }

    public static int calculatePrisonerAge(LocalDate dateOfBirth) { //функция для выисления возраста
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(dateOfBirth, currentDate);
        return period.getYears();
    }

    public static boolean isEligibleForParole(String prisonerID) { //функция на определение есть ли досрочное освобождение
        boolean isEligible = false;
        // Логика определения права на условно-досрочное освобождение
        return isEligible;
    }
}

class Prisoner {
    private String id;
    private char gender;
    private LocalDate dateOfBirth;
    private String crime;

    public Prisoner(String id, char gender, LocalDate dateOfBirth, String crime) {
        this.id = id;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.crime = crime;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public void setCrime(String crime) {
        this.crime = crime;
    }

}

class Guard {
    public String readGuardCommand() {  //функция дл вывода команды для охраника
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите команду для охранника:");
        return scanner.nextLine();
    }
}

class InmateBoard {
    public void printMessage(String message) {  // функция для печати сообщения на табличке заключенного
        System.out.println("Сообщение для заключенных: " + message);
    }
}

class Menu {
    private Prison prison;
    private Guard guard;
    private InmateBoard inmateBoard;

    public Menu() {
        this.prison = new Prison();
        this.guard = new Guard();
        this.inmateBoard = new InmateBoard();
    }
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Меню:");
            System.out.println("1. Время с момента побега");
            System.out.println("2. Опасен ли заключенный");
            System.out.println("3. Пол заключенного");
            System.out.println("4. Количество заключенных");
            System.out.println("5. Дни до освобождения");
            System.out.println("6. Команда для охранника");
            System.out.println("7. Преступление заключенного");
            System.out.println("8. Время последнего побега");
            System.out.println("9. Возраст заключенного");
            System.out.println("10. Право на условно-досрочное освобождение");
            System.out.println("11. Введите сообщение для заключенного");
            System.out.println("0. Выход");

            System.out.print("Выберите действие: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Введите количество часов и минут с момента побега:");
                    if (scanner.hasNextInt()) {
                        int hours = scanner.nextInt();
                        if (scanner.hasNextInt()) {
                            int minutes = scanner.nextInt();
                            System.out.println(Prison.timeSinceEscape(hours, minutes));
                        } else {
                            System.out.println("Неверный формат. Введите число для минут.");
                            scanner.next(); // Очистка буфера ввода
                        }
                    } else {
                        System.out.println("Неверный формат. Введите число для часов.");
                        scanner.next(); // Очистка буфера ввода
                    }
                    break;
                case 2:
                    System.out.println("Введите идентификатор заключенного:");
                    String prisonerID = scanner.next();
                    if (prisonerID.matches("(DNG|NON)ID\\d+")) {
                        System.out.println(Prison.isDangerousPrisoner(prisonerID));
                    } else {
                        System.out.println("Неверный формат идентификатора. Идентификатор должен быть в формате DNGIDчисло или NONIDчисло.");
                    }
                    break;
                case 3:
                    System.out.println("Введите идентификатор заключенного:");
                    prisonerID = scanner.next();
                    if (prisonerID.matches("(M|F)?ID\\d+")) {
                        System.out.println(Prison.getPrisonerGender(prisonerID));
                    } else {
                        System.out.println("Неверный формат идентификатора. Идентификатор должен быть в формате MIDчисло, FIDчисло или IDчисло.");
                    }
                    break;
                case 4:
                    System.out.println("Введите идентификаторы заключенных через пробел:");
                    scanner.nextLine(); // считываем символ новой строки после предыдущего ввода числа
                    String prisonersInput = scanner.nextLine().trim(); // считываем строку с идентификаторами и убираем лишние пробелы
                    if (prisonersInput.isEmpty()) {
                        System.out.println("0");
                    } else {
                        String[] prisonerIDs = prisonersInput.split(" ");
                        boolean allIDsValid = true;
                        for (String id : prisonerIDs) {
                            if (!id.matches("ID\\d+")) {
                                allIDsValid = false;
                                break;
                            }
                        }
                        if (allIDsValid) {
                            System.out.println(prison.countTotalPrisoners(prisonerIDs));
                        } else {
                            System.out.println("Неверный формат идентификаторов. Каждый идентификатор должен быть в формате IDчисло.");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Введите идентификатор заключенного:");
                    prisonerID = scanner.next();
                    if (prisonerID.matches("ID\\d+")) {
                        System.out.println(prison.timeUntilRelease(prisonerID));
                    } else {
                        System.out.println("Неверный формат идентификатора. Идентификатор должен быть в формате IDчисло.");
                    }
                    break;
                case 6:
                    System.out.println(guard.readGuardCommand());
                    break;
                case 7:
                    System.out.println("Введите идентификатор заключенного в формате IDчисло:");
                    prisonerID = scanner.next();
                    if (prisonerID.matches("ID\\d+")) {
                        System.out.println(prison.getPrisonerCrime(prisonerID));
                    } else {
                        System.out.println("Неверный формат идентификатора. Идентификатор должен быть в формате IDчисло.");
                    }
                    break;
                case 8:
                    System.out.println(prison.lastEscapeTime());
                    break;
                case 9:
                    System.out.println("Введите дату рождения заключенного в формате ГГГГ-ММ-ДД:");
                    String birthDateStr = scanner.next();
                    if (birthDateStr.matches("\\d{4}-\\d{2}-\\d{2}")) {
                        LocalDate birthDate = LocalDate.parse(birthDateStr);
                        System.out.println(Prison.calculatePrisonerAge(birthDate));
                    } else {
                        System.out.println("Неверный формат даты. Введите дату в формате ГГГГ-ММ-ДД.");
                    }
                    break;
                case 10:
                    System.out.println("Введите идентификатор заключенного:");
                    prisonerID = scanner.next();
                    if (prisonerID.matches("(PAR)?ID\\d+")) {
                        boolean isEligible = false;
                        // Логика определения права на условно-досрочное освобождение
                        if (prisonerID.startsWith("PAR")) {
                            isEligible = true;
                        }
                        System.out.println(isEligible);
                    } else {
                        System.out.println("Неверный формат идентификатора. Идентификатор должен быть в формате PARIDчисло или IDчисло.");
                    }
                    break;
                case 11:
                    scanner.nextLine(); // Считываем символ новой строки после выбора опции из меню
                    System.out.println("Введите сообщение для таблички заключенного:");
                    String message = scanner.nextLine(); // Считываем сообщение с консоли
                    inmateBoard.printMessage(message); // Вызываем функцию для печати сообщения на табличке заключенного
                    break;
                case 0:
                    System.out.println("Программа завершена.");
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
            }
        } while (choice != 0);
        scanner.close();
    }
}