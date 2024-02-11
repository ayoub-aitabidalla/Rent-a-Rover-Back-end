package com.application.controllers;

import com.application.entities.ImageModel;
import com.application.entities.Product;
import com.application.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping(path = "/product/add",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public void createProduct(@RequestPart("product") Product product, @RequestPart("imageFile") MultipartFile[] file)
    {
        try {
            Set<ImageModel> images = uploadImage(file);
            product.setProductImages(images);
            productService.createProduct(product);
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }


    }
//    @PostMapping(path = "/product/add")
//    public void createProduct(@RequestBody Product product)
//    {
//            productService.createProduct(product);
//    }

    public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles) throws IOException
    {
        Set<ImageModel> imageModels = new HashSet<>();
        for(MultipartFile file: multipartFiles)
        {
            ImageModel imageModel = new ImageModel(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            imageModels.add(imageModel);
        }
        return imageModels;
    }
    @DeleteMapping(path = "/product/{id}")
    public void deleteProduct(@PathVariable Integer id)
    {
        productService.deleteProduct(id);
    }

    @GetMapping
    public List<Product> getListOfProducts()
    {
        return productService.getAllProduct();
    }
    @GetMapping(path = "/product/{id}")
    public Product getProduct(@PathVariable Integer id)
    {
        return productService.getProduct(id);
    }
    @PutMapping(path = "/product/{id}")
    public Product updateProduct(@PathVariable Integer id, @RequestBody Product product)
    {
        return productService.updateProduct(id, product);
    }

}
