package com.ws101.colitoy_delarosa_a.EcommerceApi.service;

import com.ws101.colitoy_delarosa_a.EcommerceApi.model.Product;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
        private final List<Product> products = new ArrayList<>();
        private Long nextId = 1L;

        public ProductService() {
                products.add(new Product(nextId++, "Wireless Headphones", "High-quality sound and cord-free design",
                                1299.99,
                                "Electronics", 45, "https://example.com/headphones.jpg"));
                products.add(new Product(nextId++, "Smart Watch", "Features heart rate and step tracking", 2499.50,
                                "Electronics", 30, "https://example.com/watch.jpg"));
                products.add(new Product(nextId++, "Cotton T-Shirt", "Soft fabric and regular fit", 299.75, "Clothing",
                                120,
                                "https://example.com/tshirt.jpg"));
                products.add(new Product(nextId++, "Denim Jeans", "Durable material and classic style", 799.00,
                                "Clothing", 85,
                                "https://example.com/jeans.jpg"));
                products.add(new Product(nextId++, "Ceramic Mug", "Heat-resistant and stylish design", 149.99,
                                "Home Goods",
                                200, "https://example.com/mug.jpg"));
                products.add(new Product(nextId++, "Wooden Shelf", "Sturdy construction and space-saving", 899.99,
                                "Home Goods",
                                25, "https://example.com/shelf.jpg"));
                products.add(new Product(nextId++, "Bluetooth Speaker", "Loud, clear audio and long battery life",
                                899.50,
                                "Electronics", 60, "https://example.com/speaker.jpg"));
                products.add(new Product(nextId++, "Running Shoes", "Lightweight and comfortable for exercise", 1199.00,
                                "Footwear", 75, "https://example.com/shoes.jpg"));
                products.add(new Product(nextId++, "Leather Wallet", "Premium leather and multiple card slots", 399.99,
                                "Accessories", 110, "https://example.com/wallet.jpg"));
                products.add(new Product(nextId++, "Desk Lamp", "Adjustable brightness and modern look", 349.50,
                                "Home Goods",
                                50, "https://example.com/lamp.jpg"));
        }

        public List<Product> getAllProducts() {
                return products;
        }

        public Optional<Product> getProductById(Long id) {
                return products.stream().filter(product -> product.getId().equals(id)).findFirst();
        }

        public Product createProduct(Product product) {
                product.setId(nextId++);
                products.add(product);
                return product;
        }

        public Product updateProduct(Long id, Product updatedProduct) {
                Optional<Product> existingProduct = getProductById(id);
                if (existingProduct.isPresent()) {
                        products.remove(existingProduct.get());
                        updatedProduct.setId(id);
                        products.add(updatedProduct);
                        return updatedProduct;
                }
                return null;
        }

        public boolean deleteProduct(Long id) {
                return products.removeIf(product -> product.getId().equals(id));
        }

        public List<Product> filterByCategory(String category) {
                return products.stream()
                                .filter(product -> product.getCategory().equalsIgnoreCase(category))
                                .collect(Collectors.toList());
        }

        public List<Product> filterByPriceRange(Double minPrice, Double maxPrice) {
                return products.stream()
                                .filter(product -> product.getPrice() >= minPrice && product.getPrice() <= maxPrice)
                                .collect(Collectors.toList());
        }

        public List<Product> filterByName(String keyword) {
                return products.stream()
                                .filter(product -> product.getName().toLowerCase().contains(keyword.toLowerCase()))
                                .collect(Collectors.toList());
        }
}