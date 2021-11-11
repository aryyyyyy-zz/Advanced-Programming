package main;

import java.util.ArrayList;

public class Skewmatrix extends Squarematrix{
    private static int count = 800;
    {
        label.add("Skew symmetric matrix");
        if (this.isSingular()) label.add("Singular matrix");
        this.id = count;
        count++;
    }

    Skewmatrix() {
        super();
        matrix.clear();
        ArrayList<Float> row1 = new ArrayList<Float>();
        row1.add(0f);
        row1.add(4f);
        ArrayList<Float> row2 = new ArrayList<Float>();
        row2.add(-4f);
        row2.add(0f);
        this.matrix.add(row1);
        this.matrix.add(row2);
    }
    Skewmatrix(ArrayList<ArrayList<Float>> matrix) {
        super(matrix);
    }
}
