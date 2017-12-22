package com.revature.designpatterns;

public class TestSweets {

	public static void main(String[] args) {
		//new SweetFactory().getSweets("candy").bake();
		//new SweetFactory().getSweets("hotchocolate").bake();
		//new SweetFactory().getSweets("Marshmallow").bake();
		SweetFactory s1 = new SweetFactory();
		s1.getSweets("candy").bake();
		s1.getSweets("hotchocolate").bake();
		s1.getSweets("Marshmallow").bake();

	}

}
