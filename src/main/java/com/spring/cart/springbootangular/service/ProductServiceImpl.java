package com.spring.cart.springbootangular.service;

import com.spring.cart.springbootangular.entity.Category;
import com.spring.cart.springbootangular.entity.Product;
import com.spring.cart.springbootangular.repository.ProductReposory;
import com.spring.cart.springbootangular.request.CreateProductRequest;
import com.spring.cart.springbootangular.request.GetDetailsByProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductServiceImpl implements ProductService{

    @Autowired private ProductReposory productReposory;

    @Override
    public List<Product> listProduct() {
        List<Product> listProduct = new ArrayList<>();
        for(Product product : productReposory.findAll()){
            listProduct.add(product);
        }
        return listProduct;
    }

    @Override
    public Product createdProduct(CreateProductRequest requestProduct) {
        Product product = newProduct(requestProduct.getNameOfProduct(),
                requestProduct.getStockOfProduct(),
                requestProduct.getPriceOfProduct(),
                requestProduct.getCategoryOfProduct());
        return productReposory.save(product);
    }

    @Override
    public Optional<Product> getDetailProduct(GetDetailsByProductRequest requestProduct) {
        return productReposory.findById(requestProduct.getProductId());
    }


    private Product newProduct(String name, Integer stock, Integer price, Category category){
        return Product.builder()
                .name(name)
                .stock(stock)
                .price(price)
                .category(category)
                .build();
    }
}
