
public class TestInnerClasses {

	int i;
	static int j;

	static class Inner1 {
		void inner1(){
			//System.out.println(i); Cant access non-static data
			System.out.println(++j);

		}
	}

	class Inner2 {
		void inner1(){
			i = 5;
			System.out.println(i); //FINE Can access non-static outer class data

		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //new TestInnerClasses.Inner2(); //ERROR - testInnerClasses.new Inner()
        new TestInnerClasses.Inner1().inner1(); //FINE
        TestInnerClasses t = new TestInnerClasses();
        Inner2 i2 = t.new Inner2();
        i2.inner1();
	}

}
