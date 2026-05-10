package com.wms.warehouse_management_system.Controller;

import com.wms.warehouse_management_system.Entity.Product;
import com.wms.warehouse_management_system.Service.ProductService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    // Service layer dependency
    private final ProductService productService;

    public ProductController(ProductService productService) //constructor injection
    {
        this.productService = productService;
    }

    @PostMapping //create products
    public Product createProduct(@Valid @RequestBody Product product)
    {
        return productService.createProduct(product); //adds new product
    }

    @GetMapping
    public List<Product> getAllProducts()
    {
        return productService.getAllProducts(); //fetches all products
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id)
    {
        return productService.getProductById(id); //fetches product by id
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id,
                                 @Valid @RequestBody Product updatedProduct)
    {
        return productService.updateProduct(id, updatedProduct);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id)
    {
        productService.deleteProduct(id); //deletes product by id
    }
}