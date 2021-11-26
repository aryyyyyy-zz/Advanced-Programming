package main;

import java.util.ArrayList;

public class UppTrimatrix extends Squarematrix{
    private static int count = 700;

    {
        this.id = count;
        label.add("Upper triangular matrix");
        if (this.isSingular()) label.add("Singular matrix");
        if (this.isSkewSymmetric()) label.add("Skew symmetric matrix");
        if (this.isSymmetric()) label.add("Symmetric matrix");
        count++;
    }

    UppTrimatrix(){
        super();
        matrix.clear();
        ArrayList<Float> row1 = new ArrayList<Float>();
        row1.add(1f);
        row1.add(2f);
        ArrayList<Float> row2 = new ArrayList<Float>();
        row2.add(0f);
        row2.add(3f);
        this.matrix.add(row1);
        this.matrix.add(row2);
    }

    UppTrimatrix(ArrayList<ArrayList<Float>> matrix) {
        super(matrix);

    }
}
