package main;

import java.util.ArrayList;

public class Rectangularmatrix extends Matrix{
    private static int count = 100;

    Rectangularmatrix() {
        super();
        this.id = count;
        for (int i =0 ;i<2; i++) {
            ArrayList<Float> row = new ArrayList<Float>();
            row.add(0f);
            row.add(1f);
            row.add(2f);
            this.matrix.add(row);
        }
    }

    Rectangularmatrix(ArrayList<ArrayList<Float>> input) {
        super();
        this.id = count;
        if (input!= null)
        for (int i=0; i<input.size(); i++) {
            ArrayList<Float> row = new ArrayList<Float>();
            for (int j=0; j<input.get(0).size(); j++) row.add((input.get(i).get(j)));
            this.matrix.add(row);
        }
        count++;
    }
}
