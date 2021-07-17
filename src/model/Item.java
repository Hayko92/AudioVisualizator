package model;



public class Item {
    private final int id;
    private String title;
    private int price;
    private String currency;
    private Group parent;


    public Item(int id, String title,Resolution resolution,  String currency) {
        this.id = id;
        this.title = title;
        this.price = calculatePrice(resolution);
        this.currency = currency;
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

    public  int calculatePrice(Resolution resolution) {
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
}
