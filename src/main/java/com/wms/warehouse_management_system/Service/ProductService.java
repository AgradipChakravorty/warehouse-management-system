package com.wms.warehouse_management_system.Service;
import com.wms.warehouse_management_system.Entity.Product;
import com.wms.warehouse_management_system.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService
{
    private final ProductRepository productRepository; //Product repository layer field

    public ProductService(ProductRepository productRepository)  // Constructor injection
    {
        this.productRepository = productRepository;
    }


    public Product createProduct(Product product) //create product
    {
        return productRepository.save(product); // saves a new product into the database
    }

    public List<Product> getAllProducts() // gets all products
    {
        return productRepository.findAll(); //Fetches all products from database
    }

    public Product getProductById(Long id) //gets specific products by using product id
    {
        return productRepository.findById(id) //fetches a single product
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id)); // throws error if product not found
    }

    public Product updateProduct(Long id, Product updatedProduct)
    {
        Product existingProduct = productRepository.findById(id) //fetches existing products
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id)); //throws error if not found

        // updating fields
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setSku(updatedProduct.getSku());
        existingProduct.setPrice(updatedProduct.getPrice());
        return productRepository.save(existingProduct); // saves updated product
    }

    public void deleteProduct(Long id) //deletes product
    {
        productRepository.deleteById(id); //Removes product from database using ID
    }
}