package fr.epita.assistants.drawing;

public class Triangle extends Sharp {
    public Triangle(int length) {
        super(length);
    }

    @Override
    public void draw() {
        for (int j = 0; j < length; j++) {
            for (int i = 0; i <= j; i++) {
                if (i == 0 || i == j || j == length - 1) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

