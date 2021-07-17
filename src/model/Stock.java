package model;

public class Stock extends Item {
    public Stock(int id, String title, Resolution resolution, String currency) {
        super(id, title, resolution, currency);
    }

    @Override
    public int calculatePrice(Resolution resolution) {
        return (5 * (resolution.ordinal() + 1));
    }
}
