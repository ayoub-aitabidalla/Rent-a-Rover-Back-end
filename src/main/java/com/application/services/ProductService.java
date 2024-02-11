package com.application.services;

import com.application.entities.Product;
import com.application.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public void createProduct(Product product)
    {
        Product checkProduct = productRepository.findByName(product.getProductName());
        if(checkProduct != null)
        {
            throw new RuntimeException("product already exist!");
        }
        productRepository.save(product);
    }
    public void deleteProduct(Integer id){
        Product product = productRepository.findProductById(id);
        if(product == null)
        {
            throw new RuntimeException("product doesn't exist");
        }
        productRepository.delete(product);

    }
    public List<Product> getAllProduct()
    {
        return productRepository.findAll();

    }
    public Product getProduct(Integer id)
    {
        Product product = productRepository.findProductById(id);
        if(product == null)
        {
            throw new RuntimeException("product doesn't exist");
        }
        return product;
    }

    public Product updateProduct(Integer id, Product product)
    {
        Product productToUpdate = productRepository.findProductById(id);
        if(product == null)
        {
            throw new RuntimeException("product doesn't exist");
        }
        productToUpdate.setProductName(product.getProductName());
        productToUpdate.setProductDesc(product.getProductDesc());
        productToUpdate.setPrice(product.getPrice());
        return productRepository.save(productToUpdate);
    }

}

