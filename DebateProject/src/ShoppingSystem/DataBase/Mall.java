package ShoppingSystem.DataBase;

public class Mall {
	/**
	 * @param name		商品名字
	 * @param types		商品类型
	 * @param price		商品单价
	 * @param number	商品数量
	 */
	private String name,types;
	private double price,number;
	
	public Mall() {
		super();
	}

	public Mall(String name, String types, double price, double number) {
		super();
		this.name = name;
		this.types = types;
		this.price = price;
		this.number = number;
	}

	public void addMalls(String name, String types, double price, double number) {
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
		return "["+name + "\t\t" + types + "\t\t" + price + "\t\t" + number + "]\t";
	}
	
	
	
}
