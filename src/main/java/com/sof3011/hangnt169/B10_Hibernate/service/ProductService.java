/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sof3011.hangnt169.B10_Hibernate.service;

import com.sof3011.hangnt169.B10_Hibernate.entity.Product;
import com.sof3011.hangnt169.B10_Hibernate.repository.ProductRepository;
import com.sof3011.hangnt169.B10_Hibernate.response.ProductResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hangnt
 */
public class ProductService {

    public List<ProductResponse> getAll() {
        List<ProductResponse> lists = new ArrayList<>();
        List<Product> listProduct = new ProductRepository().getAll();
        for (Product product : listProduct) {
            lists.add(convertProductToResponse(product));
        }
        return lists;
    }

    private ProductResponse convertProductToResponse(Product p) {
        ProductResponse ps = new ProductResponse();
        ps.setProductID(p.getId());
        ps.setPrice(p.getPrice());
        ps.setProductCode(p.getProductCode1());
        ps.setProductName(p.getProductName());
        ps.setCategoryName(p.getCategory().getCategoryName1());
        return ps;
    }
}
