package question7_8;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		customers maleWithCash = new customers('m', 8);
		customers femaleWithCash = new customers('f', 10);
		customers maleNoCash = new customers('m');
		customers femaleLittleCash = new customers('f', 3);
		
		customers.checkGender('f');
		customers.checkGender('x');
		customers.checkMoney(3);
		
		maleWithCash.findShoppingList();
		femaleWithCash.findShoppingList();
		maleNoCash.findShoppingList();
		femaleLittleCash.findShoppingList();
		
	}

}
