package hw1.enums;

public enum Planet {
    Mercury(6), Venum(9), Earth(9), Mars(7),
    Yupiter(17), Saturn(15), Uran(13), Neptun(12);

    private double size;

    Planet(double size) {
        this.size = size;
    }

    public double getSize() {
        return size;
    }
}
