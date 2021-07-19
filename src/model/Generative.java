package model;

public class Generative extends Item {
    private final double complexity;

    public Generative(int id, String title, int price, Configuration configuration, double complexity, String currency) {
        super(id, title, price, configuration, currency);
        this.complexity = complexity;
    }

    @Override
    public double calculatePrice(Configuration configuration) {
        switch (configuration.getResolution()) {
            case HD:
                return this.getPrice() * complexity;
            case FHD:
                return this.getPrice() * 2 * complexity;
            case FourK:
                return this.getPrice() * 4 * complexity;
        }
        return 0;
    }
}
