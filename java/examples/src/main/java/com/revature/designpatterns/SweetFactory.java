package com.revature.designpatterns;

public class SweetFactory {
	public SweetFactory() {
	}
	public Sweets getSweets(String SweetType) {
		if (SweetType == null) {
			return null;
		} else if (SweetType.equalsIgnoreCase("candy")){
			return new Candy();
		} else if (SweetType.equalsIgnoreCase("HotChocolate")){
			return new HotChocolate();
		} else if (SweetType.equalsIgnoreCase("Marshmallow")){
			return new Marshmallow();
		} else 
			return null;
	}
}
