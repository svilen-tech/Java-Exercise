package WorkingWithAbstraction.StudentSystem;

enum Discount {
    VIP(20),
    SECOND_VISIT(10),
    NONE(0);

    private int value;

    Discount(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
