package payload;

/**
 * Класс с описанием полета (пункт отправки, пункт назначения, цена)
 */
public class Flight {

    private String fromCity, toCity;
    private int price;

    public String getFromCity() {
        return fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public int getPrice() {
        return price;
    }
}
