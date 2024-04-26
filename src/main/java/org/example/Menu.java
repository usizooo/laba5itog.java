package org.example;

import java.time.LocalDate;
import java.util.Scanner;

class Menu {
    private Prison prison;
    private Guard guard;
    private InmateBoard inmateBoard;

    public Menu() {
        this.prison = new Prison();
        this.guard = new Guard();
        this.inmateBoard = new InmateBoard();
    }

    // Метод для отображения меню и выполнения действий
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
            // Новый пункт меню для отображения информации о заключенном
            System.out.println("12. Отобразить информацию о заключенном");
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
                case 12:
                    // Запрашиваем идентификатор заключенного
                    System.out.println("Введите идентификатор заключенного:");
                    prisonerID = scanner.next();
                    // Проверяем формат идентификатора
                    if (prisonerID.matches("ID\\d+")) {
                        // Если формат верный, отображаем информацию о заключенном
                        Prisoner prisoner = prison.getPrisonerById(prisonerID); // Предположим, что такой метод есть в классе Prison
                        if (prisoner != null) {
                            prisoner.displayInformation(); // Вызываем метод displayInformation() для отображения информации о заключенном
                        } else {
                            System.out.println("Заключенный с таким идентификатором не найден.");
                        }
                    } else {
                        System.out.println("Неверный формат идентификатора. Идентификатор должен быть в формате IDчисло.");
                    }
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