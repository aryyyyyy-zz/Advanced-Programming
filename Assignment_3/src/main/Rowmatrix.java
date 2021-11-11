package main;

import java.util.ArrayList;

public class Rowmatrix extends Matrix{
    private static int count = 500;

    Rowmatrix() {
        super();
        label.add("Row matrix");
        this.id= count;
        ArrayList<Float> row = new ArrayList<Float>();
        row.add(0f);
        row.add(1f);
        row.add(2f);
        this.matrix.add(row);
        count++;
    }

    Rowmatrix(ArrayList<ArrayList<Float>> input) {
        super();
        label.add("Row matrix");
        this.id= count;
        for (int i=0; i<input.size(); i++) {
            ArrayList<Float> row = new ArrayList<Float>();
            for (int j=0; j<input.get(0).size(); j++) row.add((input.get(i).get(j)));
            this.matrix.add(row);
        }
        count++;
    }

}
