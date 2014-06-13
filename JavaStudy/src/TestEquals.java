class Base {
    public void printObjClass( Base obj ) {
        System.out.println("obj.getClass = " + obj.getClass() ) ;
    }
}

class TestEquals extends Base {
    public void printObjClass( Base obj ) {
        super.printObjClass( obj ) ;
        System.out.println("obj.getClass = " + obj.getClass() ) ;
    }

    public static void main( String args[] ) {
        TestEquals te = new TestEquals() ;
        te.printObjClass( te ) ;

        Base b = new Base() ;
        te.printObjClass( b ) ;
        b.printObjClass( b ) ;

        b = new TestEquals() ;
        te.printObjClass( b ) ;
    }
}
