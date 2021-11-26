package quiz;

public class quiz2{
    static String i;
    static int ctr=0;
    static String[] j;

    //main function

    public static void main(String[] arr) {
        if (ctr == 1) {
            arr = j;
            arr[0] = j[0] + " again";
            arr[1] = j[1] + " again";
        }

        System.out.println(arr[0]);
        System.out.println(arr[1]);

    }

        public static void main(String arr){
            System.out.println(arr);

        }

        static {
        i = "hey";
        main(i);
        j = new String[2];
        j[0] = "hi";
        j[1] = "bye";
        main(j);
        ctr = 1;
    }
}