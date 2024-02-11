package org.example.scalerone.services;

import org.example.scalerone.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("RealProductService")
public class ProductServiceImpl implements ProductService {

    @Override
    public Product getProductById(Long id) {
        return null;
    }

    @Override
    public List<String> getAllProducts() {
        return null;
    }

    @Override
    public String addProduct(String product) {
        return null;
    }

    @Override
    public String updateProductById(Long id) {
        return null;
    }

    @Override
    public String deleteProductById(Long id) {
        return null;
    }
}
