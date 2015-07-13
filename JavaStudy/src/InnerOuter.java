public class InnerOuter {

    public class Inner {
        void go() {
            System.out.println(this);
            System.out.println(InnerOuter.this);
        }
    }
    public static class StaticInner {
        void go() {
            System.out.println(this);
        }
    }
    public static void main(String[] args) {

        InnerOuter outer = new InnerOuter();
        Inner inner = outer.new Inner();
        inner.go();




        Inner inner2 = outer.new Inner();
        inner2.go();

        InnerOuter outer2 = new InnerOuter();
        StaticInner staticInner = new StaticInner();
    }

}
