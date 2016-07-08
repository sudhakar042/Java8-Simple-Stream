import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import domain.Manufacturer;
import domain.Product;


public class SimpleStreamMain {

	public static void main(String[] args) {
		List<Product> products = Arrays.asList(
				new Product("Hard drive", 240, Manufacturer.Fujitsu),
				new Product("Memory", 120, Manufacturer.Winchester),
				new Product("ZIP drive", 150, Manufacturer.Iomega),
				new Product("Monitor", 240, Manufacturer.Sony),
				new Product("Floppy disk", 5, Manufacturer.Winchester),
				new Product("DVD drive", 180, Manufacturer.CreativeLabs),
				new Product("CD drive", 90, Manufacturer.CreativeLabs),
				new Product("Printer", 270, Manufacturer.Hewlett_Packard),
				new Product("Toner cartridge", 66, Manufacturer.Hewlett_Packard),
				new Product("DVD burner", 180, Manufacturer.CreativeLabs)
				);
		
		// 1. Select the names of all the products in the store.
		products.stream()
				.forEach(e -> e.getName());
		
		// 2. Select the names and the prices of all the products in the store.
		
		// 3. Select the name of the products with a price less than or equal to $200.
		products.stream()
				.filter(e -> e.getPrice()<200)
				.map(Product::getName)
				.collect(Collectors.toList());
		
		// 4. Select all the products with a price between $60 and $120.
		products.stream()
				.filter(e -> e.getPrice()<=200)
				.filter(e -> e.getPrice()>=60)
				.map(Product::getName)
				.collect(Collectors.toList());
		
		// 5. Select the name and price in cents (i.e., the price must be multiplied by 100).
		
		// 6. Compute the average price of all the products.
		products.stream()
				.mapToDouble(Product::getPrice)
				.average();
		
		// 7. Compute the average price of all products with manufacturer code equal to 2.
		products.stream()
				.filter(p -> p.getManufacturer().equals(Manufacturer.Fujitsu))
				.mapToDouble(Product::getPrice)
				.average();
		
		// 8. Compute the number of products with a price larger than or equal to $180.
		products.stream()
				.filter(p -> p.getPrice()>=180)
				.count();
		
		// 9. Select the name and price of all products with a price larger than or equal to $180, and sort first by price (in descending order), and then by name (in ascending order).
		Comparator<Product> byPrice = Comparator.comparing(Product::getPrice);
		Comparator<Product> byName = Comparator.comparing(Product::getName);
		
		products.stream()
				.filter(p -> p.getPrice()>=180)
				.sorted(byPrice.reversed()
								.thenComparing(byName))
				.collect(Collectors.toMap(Product::getName, Product::getPrice));
				
		
		// 10. Select all the data from the products, including all the data for each product's manufacturer.
		
		// 11. Select the product name, price, and manufacturer name of all the products.
		
		// 12. Select the average price of each manufacturer's products, showing only the product's code.
		Function<? super Product,? extends Integer> mapper = new Function<Product,Integer>() {

			@Override
			public Integer apply(Product p) {
				return p.getCode();
			}
			
		};
		Function<? super Product,? extends Stream<? extends Integer>> flatMapper = new Function<Product,Stream<Integer>>() {

			@Override
			public Stream<Integer> apply(Product t) {
				return Stream.of(t.getCode());
			}
		};

		mapper = p -> p.getCode();
		mapper = Product::getCode;
		products.stream()
				.mapToDouble(Product::getPrice)
				.average();
		
		// 13. Select the average price of each manufacturer's products, showing the manufacturer's name.
		
		// 14. Select the names of manufacturer whose products have an average price larger than or equal to $150.
		
		// 15. Select the name and price of the cheapest product.
		// 16. Select the name of each manufacturer along with the name and price of its most expensive product.
		// 17. Add a new product: Loudspeakers, $70, manufacturer 2.
		// 18. Update the name of product 8 to "Laser Printer".
		// 19. Apply a 10% discount to all products.
		// 20. Apply a 10% discount to all products with a price larger than or equal to $120.
		
	}

}
