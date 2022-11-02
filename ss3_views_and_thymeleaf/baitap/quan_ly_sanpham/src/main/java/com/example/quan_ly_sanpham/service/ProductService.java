package com.example.quan_ly_sanpham.service;

import com.example.quan_ly_sanpham.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService{
    private static final Map<Integer, Product> products;

    static {
        products=new HashMap<>();
        products.put(1, new Product(1, "May Giat", 3, "good"));
        products.put(2, new Product(2, "Tu Lanh", 2, "good"));
        products.put(3, new Product(3, "Dieu Hoa", 12, "good"));
        products.put(4, new Product(4, "Ti Vi", 7, "good"));
        products.put(5, new Product(5, "Ban Hoc", 22, "good"));
        products.put(6, new Product(6, "Iphone 14", 5, "good"));
    }


    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
