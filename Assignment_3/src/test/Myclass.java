package test;

import java.util.ArrayList;

public class Myclass {
    public static void main(String [] args) {
        ArrayList<ArrayList<Float>> matrix = new ArrayList<ArrayList<Float>>();
        //ArrayList<Float> row = new ArrayList<Float>();
        for (int i=0; i<3 ; i++) {
            ArrayList<Float> row = new ArrayList<Float>();
            row.add((float)i);
            matrix.add(row);
        }
        for (ArrayList<Float> rows : matrix) {
            for (Float ele : rows) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


}
