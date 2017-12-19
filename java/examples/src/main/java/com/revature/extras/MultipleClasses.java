package com.revature.extras;

public class MultipleClasses {

}

class A extends MultipleClasses{
	
}

class B {
	C c1 = new C();
	
	class C {
		//inner class - this can be private
		B b1 = new B();
	}
}
