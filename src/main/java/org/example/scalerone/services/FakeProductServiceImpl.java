package org.example.scalerone.services;

import org.example.scalerone.dtos.FakeStoreProductDto;
import org.example.scalerone.models.Category;
import org.example.scalerone.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("FakeProductService")
public class FakeProductServiceImpl implements  ProductService{

    final private String getProductURL = "https://fakestoreapi.com/products/1";
    RestTemplateBuilder restTemplateBuilder;
    @Autowired
    public FakeProductServiceImpl(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }
    @Override
    public Product getProductById(Long id) {
        //return "Inside FAKE Product Service Impl for ID # " + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.getForEntity(getProductURL, FakeStoreProductDto.class);
        return getProductFromFakeStoreProductDto(responseEntity.getBody());
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

    public Product getProductFromFakeStoreProductDto(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());

        Category category = new Category();
        category.setName(fakeStoreProductDto.getCategory());
        product.setCategory(category);

        return product;
    }

}
