package org.example.scalerone.services;

import org.example.scalerone.models.Product;

import java.util.List;


public interface ProductService {
    public Product getProductById(Long id);

    public List<String> getAllProducts();

    public String addProduct(String product);

    public String updateProductById(Long id);

    public String deleteProductById(Long id);
}
