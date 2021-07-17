package model;

public class Generative extends Item{
    public Generative(int id, String title, Resolution resolution, String currency) {
        super(id, title, resolution, currency);
    }

    @Override
    public int calculatePrice(Resolution resolution) {
        return (8* (resolution.ordinal()+1));
    }
}
