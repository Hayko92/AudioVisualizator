package model;

public class Generative extends Item {
    public Generative(int id, String title, int price, Configuration configuration, String currency) {
        super(id, title, price, configuration, currency);
    }

    @Override
    public double calculatePrice(Configuration configuration) {
        switch (configuration.getResolution()) {
            case HD:
                return this.getPrice() * configuration.getComplexity();
            case FHD:
                return this.getPrice() * 2;
            case FourK:
                return this.getPrice() * 4;
        }
        return 0;
    }
}
