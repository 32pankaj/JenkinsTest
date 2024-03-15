package org.example.jenkinstest;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JenkinsTestApplication {





	public static void main(String[] args) {
		System.out.println("This is jenkins testing");

		System.out.println("This is is  ");

		List<Product> productsList1 = new ArrayList<Product>();
        //Adding Products
		productsList1.add(new Product(1,"HP Laptop",25000f));
		productsList1.add(new Product(2,"Dell Laptop",30000f));
		productsList1.add(new Product(3,"Lenevo Laptop",28000f));
		productsList1.add(new Product(4,"Sony Laptop",28000f));
		productsList1.add(new Product(5,"Apple Laptop",90000f));

		Float v = productsList1.stream().filter(p -> p.price > 25000)
				.map(p -> p.price)
				.reduce(1000.0f,(price, sum) -> sum + price);
		System.out.println(v);

		Optional<Float> reduce = productsList1.stream()
				.map(p -> p.price)
				.reduce(Float::sum);
		System.out.println(reduce.get());


		List<Product> productsList2 = new ArrayList<Product>();
		//Adding Products
		productsList2.add(new Product(1,"HP Laptop",25000f));
		productsList2.add(new Product(2,"Dell Laptop",30000f));
		productsList2.add(new Product(3,"Lenevo Laptop",28000f));
		productsList2.add(new Product(4,"Sony Laptop",28000f));
		productsList2.add(new Product(5,"Apple Laptop",90000f));

		List<List<Product>> lists=new ArrayList<>();
		lists.add(productsList1);
		lists.add(productsList2);
		lists.stream().flatMap(plist->plist.stream())
				.filter(p->p.price>25000)
				.map(p->p.id).forEach(System.out::println);

	}
}
class Product{
	int id;
	String name;
	float price;
	public Product(int id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
}