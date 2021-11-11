package main;

import java.util.ArrayList;

public class Symmmatrix extends Squarematrix{
    private static int count = 1300;

    {
        label.add("Symmetric matrix");
        if (this.isSingular()) label.add("Singular matrix");
        this.id = count;
        count++;
    }

    Symmmatrix() {
        super();
        this.matrix.clear();

        ArrayList<Float> row1 = new ArrayList<Float>();
        row1.add(1f);
        row1.add(4f);
        ArrayList<Float> row2 = new ArrayList<Float>();
        row2.add(4f);
        row2.add(2f);
        this.matrix.add(row1);
        this.matrix.add(row2);

    }

    Symmmatrix(ArrayList<ArrayList<Float>> matrix) {
        super(matrix);
    }

}

