package ShoppingSystem.DataBase;

public class Cart {
	/**
	 * @param name		商品名字
	 * @param types		商品种类
	 * @param price		单价
	 * @param number	数量
	 */
	private String name,types;
	private double price,number;
	public Cart() {
		super();
	}
	
	public Cart(String name, String types, double price, double number) {
		super();
		this.name = name;
		this.types = types;
		this.price = price;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getNumber() {
		return number;
	}

	public void setNumber(double number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "[" + name + "\t\t" + types + "\t\t" + price + "\t\t" + number + "]";
	}

	
}
