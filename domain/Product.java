package domain;

public class Product {

	public static int code;
	private String name;
	private double price;
	private Manufacturer manufacturer;

	public Product(String name, double price, Manufacturer manufacturer) {
		Product.code++;
		this.name = name;
		this.price = price;
		this.manufacturer = manufacturer;
	}

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

}
