import com.fasterxml.jackson.databind.ObjectMapper;
import payload.Airport;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Main {
    private static final String SOURCE_FILE_PATH = "flights.json";
    private static final String HELP = "Доступные команды для получения информации о перелетах:\n\n" +
            "min - минимальная стоимость перелетов\n" +
            "max - максимальная стоимость перелетов\n" +
            "avg - средняя стоимость перелетов\n" +
            "exit - выход из программы\n";
    private static final String INCORRECT_INPUT_COMMAND = "Вы ввели неверную команду. Попробуйте еще раз.\n";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Airport airport = getAirport();

        if (airport.haveNoFlights()) {
            System.out.println("Не найдено ни одного перелета! Выход из программы...");
            return;
        }

        printHelp();

        while (true) {
            System.out.println("Введите команду:\n");

            String input = scanner.nextLine().trim().toLowerCase();

            switch (input) {
                case ("min"):
                    System.out.println(airport.getMinFlightCost());
                    continue;

                case ("max"):
                    System.out.println(airport.getMaxFlightCost());
                    continue;

                case ("avg"):
                    System.out.println(airport.getAvgFlightCost());
                    continue;

                case ("exit"):
                    System.out.println("До свидания!");
                    return;

                default:
                    printErrorCommandInput();
            }
        }
    }

    /**
     * Метод парсит JSON-файл и получает объект Airport
     * @return объект Airport
     */
    private static Airport getAirport() {
        ObjectMapper mapper = new ObjectMapper();

        try(InputStream is = Main.class.getResourceAsStream(SOURCE_FILE_PATH)) {
            return mapper.readValue(is, Airport.class);

        } catch (IOException e) {
            System.out.println("Ошибка при чтении JSON-файла...");
            e.printStackTrace();
            return new Airport();
        }
    }

    /**
     * Метод печатает доступные команды для ввода в консоли
     */
    private static void printHelp() {
        System.out.println(HELP);
    }

    /**
     * Метод печатает сообщение об ошибке при вводе команды в консоли
     */
    private static void printErrorCommandInput() {
        System.out.println(INCORRECT_INPUT_COMMAND);
    }
}