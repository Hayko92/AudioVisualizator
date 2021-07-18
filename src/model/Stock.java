package model;

public class Stock extends Item {
    public Stock(int id, String title, int price, Configuration configuration, String currency) {
        super(id, title, price, configuration, currency);
    }

    @Override
    public double calculatePrice(Configuration configuration) {
        switch (configuration.getResolution()) {
            case HD:
                return this.getPrice();
            case FHD:
                return this.getPrice() * 2;
            case FourK:
                return this.getPrice() * 4;
        }
        return 0;
    }
}
