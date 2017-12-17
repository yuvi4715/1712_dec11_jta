public class Class_Members_Customer {
			int money;
			int value_of_desired_item;
			int quantity_of_item_owned;
			
			static int wallets = 1;
			final boolean buying_something = true;
			
			public Class_Members_Customer(int cash, int cost) {
				money = cash;
				quantity_of_item_owned = 0;
				value_of_desired_item = cost;
				System.out.println("Created Customer with " + money + " dollars. They own " 
						+ quantity_of_item_owned + " of the item they want to buy, "
								+ "and the item they want to buy costs " + value_of_desired_item + " dollars");
			}
			public Class_Members_Customer(int cash, int cost, int owned) {
				money = cash;
				quantity_of_item_owned = owned;
				value_of_desired_item = cost;
				System.out.println("Created Customer with " + money + " dollars. They own " 
						+ quantity_of_item_owned + " of the item they want to buy, "
								+ "and the item they want to buy costs " + value_of_desired_item + " dollars");
			}
			
			public void buy_item() {
				money -= value_of_desired_item;
				quantity_of_item_owned++;
				System.out.println("Item bought. Money left: " + money + " Customer owns: " + quantity_of_item_owned + " of the item now");
			}
			
			public void buy_item(int amount) {
				money -= value_of_desired_item * amount;
				System.out.println("Item bought. Money left: " + money + " Customer owns: " + quantity_of_item_owned + " of the item now");
			}
			
			public void return_item() {
				money += value_of_desired_item;
				quantity_of_item_owned--;
				System.out.println("Item returned. Money left: " + money + " Customer owns: " + quantity_of_item_owned + " of the item now");
			}
			
			public void return_item(int amount) {
				money += value_of_desired_item * amount;
				quantity_of_item_owned += amount;
				System.out.println("Item returned. Money left: " + money + " Customer owns: " + quantity_of_item_owned + " of the item now");
			}
		
		public static void main(String args[]) {
			Class_Members_Customer c1 = new Class_Members_Customer(100, 10);
			Class_Members_Customer c2 = new Class_Members_Customer(1000, 10, 5);
			
			c1.buy_item();
			c1.return_item();
			
			c2.buy_item(5);
			c2.return_item(1);
			
			return;
		}
}
