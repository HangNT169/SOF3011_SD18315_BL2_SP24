package com.sof3011.hangnt169.B10_Hibernate.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductResponse {

    // Chua cac truong ma table muon hien thi
    // Product ID, Product Name, Product Code, Category Name, Category Code, Price
    private Long productID;

    private String productName;

    private String productCode;

    private String categoryName;

    private String categoryCode;

    private float price;

}
