class Constructor {

    private boolean b ;
    public static void main( String args[] ) {

        Constructor c = new Constructor() ;
        System.out.println(c.b) ;
        Constructor2 c2 = new Constructor2() ;
        System.out.println(c2.b) ;
    }
}

class Constructor2 {

    Constructor2( boolean b ) { this.b = b ; }
    Constructor2( ) { }     // Uncommenting this will cause this program to not 
                            // compile. Default Constructor isn't supplied by compiler 
                            // if you write your own non-default Constructor
    protected boolean b ;
}
