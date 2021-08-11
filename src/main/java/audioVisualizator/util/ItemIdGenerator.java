package audioVisualizator.util;

public final class ItemIdGenerator {
    private static int CURRENT = 1;

    public static int getNextId() {
        return CURRENT++;
    }

    private ItemIdGenerator() {
    }
}
