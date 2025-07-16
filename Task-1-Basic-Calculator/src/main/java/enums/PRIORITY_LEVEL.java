package enums;

public enum PRIORITY_LEVEL {
    LOW(1),
    MEDIUM(2),
    HIGH(3);

    private final int value;

    PRIORITY_LEVEL(int value) {
        this.value = value;
    }

    public int getPriority() {
        return value;
    }
}
