package main;

import java.util.ArrayList;

public class LowTrimatrix extends Squarematrix{
    private static int count = 900;

    {
        this.id = count;
        label.add("Lower triangular matrix");
        count++;
    }

    LowTrimatrix() {
        super();
        matrix.clear();
        ArrayList<Float> row1 = new ArrayList<Float>();
        row1.add(1f);
        row1.add(0f);
        ArrayList<Float> row2 = new ArrayList<Float>();
        row2.add(2f);
        row2.add(3f);
        this.matrix.add(row1);
        this.matrix.add(row2);
    }

    LowTrimatrix(ArrayList<ArrayList<Float>>input) {
        super(input);
    }
}