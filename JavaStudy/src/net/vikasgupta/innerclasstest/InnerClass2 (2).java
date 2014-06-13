package net.vikasgupta.innerclasstest;

class InnerClass1Test2 {
	
	public static void main(String[] args) {
		InnerClass1.Inner1 ici1; //visible as it is public
		InnerClass1.Inner2 ici2; 
		InnerClass1.Inner3 ici3; //Inner3 is not visible as it is private
		InnerClass1.Inner4 ici4;
	}
}
