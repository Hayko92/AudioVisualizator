package model;


public class Item {
    private final int id;
    private String title;
    private int price;
    private String currency;
    private Group parent;
    private Configuration configuration;
    private double finalPrice;


    public Item(int id, String title, int price, Configuration configuration, String currency) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.finalPrice = calculatePrice(configuration);
        this.currency = currency;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Group getParrent() {
        return parent;
    }

    public void setParrent(Group parrent) {
        this.parent = parrent;
    }

    public double calculatePrice(Configuration configuration) {
        return 0;
    }

    public int getId() {
        return id;
    }

    public Group getParent() {
        return parent;
    }

    public Configuration getConfiguration() {
        return configuration;
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
}
