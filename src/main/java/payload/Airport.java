package payload;

import java.util.List;

/**
 * Класс содержит все полеты
 */
public class Airport {
    private List<Flight> flights;

    public List<Flight> getFlights() {
        return flights;
    }

    /**
     * Метод поиска минимальной стоимости всех перелетов
     *
     * @return минимальная стоимость всех перелетов (int)
     */
    public int getMinFlightCost() {
        return flights.stream().mapToInt(Flight::getPrice).min().orElse(0);
    }

    /**
     * Метод поиска максимальной стоимости всех перелетов
     *
     * @return максимальная стоимость всех перелетов (int)
     */
    public int getMaxFlightCost() {
        return flights.stream().mapToInt(Flight::getPrice).max().orElse(0);
    }

    /**
     * Метод поиска средней стоимости всех перелетов
     *
     * @return средняя стоимость всех перелетов (int)
     */
    public int getAvgFlightCost() {
        return (int) flights.stream().mapToInt(Flight::getPrice).average().orElse(0);
    }

    /**
     * Метод проверяет есть ли перелеты
     *
     * @return true, если есть хоть 1 перелет или false, если нет ни одного перелета
     */
    public boolean haveNoFlights() {
        return flights.size() == 0;
    }
}
