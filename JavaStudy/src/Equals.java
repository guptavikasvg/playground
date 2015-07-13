public class Equals{

    int i;

    Equals(int _i){
        i = _i;
    }

    public static void main(String[] s){

        Equals e1 = new Equals(1);
        Equals e2 = new Equals(1);

        if (e1==e2) { System.out.println("e1==e2");}
        if (e1.equals(e2)) { System.out.println("e1.equals(e2)");}

        //test2
        
        String s1 = "eee";
        String s2 = "eee";
        String s3 = new String("eee");
        String s4 = new String("eee");

        if (s1==s2) System.out.println("s1==s2");
        if (s3==s4) System.out.println("s3==s4");
        if (s1==s3) System.out.println("s1==s3");

        if (s1.equals(s2)) System.out.println("s1.equals(s2)");
        if (s3.equals(s4)) System.out.println("s3.equals(s4)");
        if (s1.equals(s3)) System.out.println("s1.equals(s3)");


    }
}
