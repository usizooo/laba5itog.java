package org.example;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;

class Prison {
    private HashMap<String, Prisoner> prisoners;

    public Prison() {
        this.prisoners = new HashMap<>();
        // Добавим несколько примеров заключенных для тестирования
        prisoners.put("ID1", new Prisoner("ID1", 'M',
                LocalDate.of(1990, 5, 15), "Убийство"));
        prisoners.put("ID2", new Prisoner("ID2", 'F',
                LocalDate.of(1985, 8, 22), "Кража"));
        prisoners.put("ID3", new Prisoner("ID3", 'M',
                LocalDate.of(1976, 3, 10), "Наркотики"));
    }

    // Добавляем ДОП метод для получения заключенного по идентификатору
    public Prisoner getPrisonerById(String prisonerID) {
        return prisoners.get(prisonerID);
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

    public String timeUntilRelease(String prisonerID) {//функция для подсчёта количства дней до освобождения
        int remainingDays = 365;
        return "До освобождения заключенного " + prisonerID + " осталось " + remainingDays + " дней";
    }

    public int countTotalPrisoners(String[] prisonerIDs) { // функция для подсчёта количества заключённых в общем
        return prisonerIDs.length;
    }

    public static String getPrisonerCrime(String prisonerID) {//функция определяющая за что сидит человек
        HashMap<String, String> prisonerCrimes = new HashMap<>();
        prisonerCrimes.put("ID1", "Убийство");
        prisonerCrimes.put("ID2", "Кража");
        prisonerCrimes.put("ID3", "Наркотики");
        return prisonerCrimes.getOrDefault(prisonerID, null);
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