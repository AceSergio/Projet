package fr.epita.assistants.drawing;

public class Rectangle extends Sharp {
    private int width;

    public Rectangle(int width, int length) {
        super(length);
        this.width = width;
    }

    @Override
    public void draw() {
        for (int j = 0; j < length; j++) {
            for (int i = 0; i < width; i++) {
                if (j == 0 || j == length - 1 || i == 0 || i == width - 1) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
                if (i < width - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
