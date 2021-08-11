package audioVisualizator.model;



import audioVisualizator.util.ItemIdGenerator;

import java.util.Objects;

public class Item {
    private final int id;
    private final String title;
    private final String image_url;
    private final int price;
    private final String currency;
    private Group parent;
    private Configuration configuration;


    public Item(String title, int price, String image_url, Configuration configuration, String currency) {
        this.id = ItemIdGenerator.getNextId();
        this.title = title;
        this.price = price;
        this.currency = currency;
        this.image_url = image_url;
        this.configuration = configuration;
    }

    public Item(  String title, int price, String image_url) {
        this.id = ItemIdGenerator.getNextId();
        this.title = title;
        this.price = price;
        this.image_url = image_url;
        this.currency = "USD";
        this.configuration = new Configuration(Resolution.HD);
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public void setParent(Group parent) {
        this.parent = parent;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

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

    @Override
    public String toString() {
        return "model.Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                '}';
    }

    public void print() {
        System.out.printf("ITEM(%s) - id: {%d} {%s} {%d}%n",
                this.getClass().getSimpleName(), id, title, price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id && price == item.price && Objects.equals(title, item.title) && Objects.equals(image_url, item.image_url) && Objects.equals(currency, item.currency) && Objects.equals(parent, item.parent) && Objects.equals(configuration, item.configuration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, image_url, price, currency, parent, configuration);
    }
}
