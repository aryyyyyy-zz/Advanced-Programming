package main;

import java.util.ArrayList;

public class Columnmatrix extends Matrix{
    private static int count = 400;

    Columnmatrix() {
        super();
        label.add("Column matrix");
        this.id = count;
        for (int i=0; i<3 ; i++) {
            ArrayList<Float> row = new ArrayList<Float>();
            row.add((float)i);
            this.matrix.add(row);
        }
        count++;
    }

    Columnmatrix(ArrayList<ArrayList<Float>> input) {
        super();
        label.add("Column matrix");
        this.id = count;
        for (int i=0; i<input.size(); i++) {
            ArrayList<Float> row = new ArrayList<Float>();
            for (int j=0; j<input.get(0).size(); j++) row.add((input.get(i).get(j)));
            this.matrix.add(row);
        }
        count++;
    }

}
