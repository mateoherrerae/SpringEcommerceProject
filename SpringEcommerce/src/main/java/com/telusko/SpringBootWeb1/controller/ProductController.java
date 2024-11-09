package com.telusko.SpringBootWeb1.controller;


import com.telusko.SpringBootWeb1.model.Product;
import com.telusko.SpringBootWeb1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/products")
    // using responseEntity to return the status of the request to Postman
    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.ACCEPTED);
    }

//    @GetMapping("/product/{id}")
//    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
//        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.ACCEPTED);
//    }
    //this one handles the case where the product is not found and returns a status to the postman
    @GetMapping("/product/{id}")
    // return a response entity with the product and the status
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        Product product = productService.getProductById(id);
        if(product.getId() > 0)
            return new ResponseEntity<>(product, HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    // getting the image by id
    @GetMapping("/product/{productId}/image")
    public ResponseEntity<byte[]>getImageByProductID(@PathVariable Integer productId) {
        Product product = productService.getProductById(productId);
        if(product.getId() > 0)
            return new ResponseEntity<>(product.getImageData(), HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    // adding a product
    @PostMapping("/product")
    public ResponseEntity<?> addProduct (@RequestPart Product product, @RequestPart MultipartFile imageFile) {
        Product savedProduct = null;
        try {
            savedProduct = productService.addOrUpdateProduct(product, imageFile);
            return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);        }
    }

    // update product
    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile) {

        Product updateProduct = null;
        try{
        updateProduct = productService.addOrUpdateProduct(product, imageFile);
        return new ResponseEntity<>("Product updated successfully", HttpStatus.ACCEPTED);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);        }
    }

    // delete product
    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
        Product product = productService.getProductById(id);
        if(product != null){
            productService.deleteProduct(id);
        return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);}

        else{
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
    }
    // search by name, description , brand or category by a custom query that is in repository.
    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchById(@RequestParam String keyword) {
        List<Product> products = productService.searchProducts(keyword);
        System.out.println(keyword);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
