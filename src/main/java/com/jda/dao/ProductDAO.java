package com.jda.dao;

import com.jda.bo.JavaProduct;

import java.util.List;

public interface ProductDAO {

    List<JavaProduct> getAllProducts();
    JavaProduct findProductById(int id);
    void insertProduct(JavaProduct p);
    void deleteProduct(int id);
}
