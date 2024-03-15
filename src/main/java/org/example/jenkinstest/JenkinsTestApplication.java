package org.example.jenkinstest;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JenkinsTestApplication {





	public static void main(String[] args) {
		System.out.println("This is jenkins testing");

		System.out.println("This is is  ");

		List<Product> productsList;
        productsList = new ArrayList<Product>();
        //Adding Products
		productsList.add(new Product(1,"HP Laptop",25000f));
		productsList.add(new Product(2,"Dell Laptop",30000f));
		productsList.add(new Product(3,"Lenevo Laptop",28000f));
		productsList.add(new Product(4,"Sony Laptop",28000f));
		productsList.add(new Product(5,"Apple Laptop",90000f));

		Float v = productsList.stream().filter(p -> p.price > 25000)
				.map(p -> p.price)
				.reduce(1000.0f,(price, sum) -> sum + price);
		System.out.println(v);

		Optional<Float> reduce = productsList.stream()
				.map(p -> p.price)
				.reduce(Float::sum);
		System.out.println(reduce.get());


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