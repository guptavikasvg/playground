public class InstanceOfTest{

    int i;

    public static void main(String[] s){

    Derived3 d3 = new Derived3();
    if (d3 instanceof Derived3)System.out.println("d3 instanceof Derived3");
    if (d3 instanceof Derived2)System.out.println("d3 instanceof Derived2");
    if (d3 instanceof Derived1)System.out.println("d3 instanceof Derived1");
    if (d3 instanceof Derived4)System.out.println("d3 instanceof Derived4");
    }
}

class Derived1 {}
class Derived2 extends Derived1{}
class Derived3 extends Derived2{}
class Derived4 extends Derived3{}


