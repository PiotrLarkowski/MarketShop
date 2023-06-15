package com.example.MarketShop;

import com.example.MarketShop.Controllers.ProductController;
import com.example.MarketShop.DomainDto.Product.ProductDto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarketShopApplication implements CommandLineRunner {
	private final ProductController productController;

	public MarketShopApplication(ProductController productController) {
		this.productController = productController;
	}

	public static void main(String[] args) {
		SpringApplication.run(MarketShopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String[] productsNames = {"Milk", "Sugar","Bread"};
		double[] productsCosts = {2,3,1.5};
		for (int i = 0; i < 3; i++) {
			ProductDto productDto = ProductDto.builder()
					.productName(productsNames[i])
					.productPrice(productsCosts[i])
					.build();
			productController.createProduct(productDto);
		}
	}

}
