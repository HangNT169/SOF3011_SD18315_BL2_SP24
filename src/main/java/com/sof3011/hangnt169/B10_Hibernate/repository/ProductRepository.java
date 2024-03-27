package com.sof3011.hangnt169.B10_Hibernate.repository;

import com.sof3011.hangnt169.B10_Hibernate.config.HibernateConfig;
import com.sof3011.hangnt169.B10_Hibernate.entity.Product;
import org.hibernate.Session;

import java.util.List;

public class ProductRepository {

    // Product ID, Product Name, Product Code, Category Name, Category Code, Price
//    public List<ProductResponse>getAll(){
//        Session s = HibernateConfig.getFACTORY().openSession();
//        String hql = """
//                    SELECT new com.sof3011.hangnt169.B10_Hibernate.response.ProductResponse(
//                       p.id,p.productName,p.productCode1,c.categoryName1,c.categoryCode,p.price)
//                    FROM Product p JOIN Category c
//                    ON p.category.id1 = c.id1
//                    """;
//        List<ProductResponse>lists = s.createQuery(hql).getResultList();
//        return lists;
//    }
    public List<Product> getAll() {
        Session s = HibernateConfig.getFACTORY().openSession();
        return s.createQuery("FROM Product").getResultList();
    }
}
