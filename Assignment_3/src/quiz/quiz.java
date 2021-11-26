package quiz;

public class quiz {
    public static void main(String[] args)
    {
        System.out.println("c");
        System.out.println(Scaler.i);
        System.out.println(new Scaler().j);
        System.out.println(Scaler.i);
        System.out.println(new Scaler().j);
        System.out.println(Scaler.i);
        System.out.println(Scaler.update_i(new Scaler()).i);
    }
        static
        {
            System.out.println("b");
        }
    }
    class Scaler
    { int j;
        {
            j=7+i;
            i=j+i;
        }
        static int i;
        static Scaler update_i(Scaler a)
        {
            i=i+a.j;
            return new Scaler();
        }
        static
        {
            System.out.println("a");
            i = 100;
        }
    }
