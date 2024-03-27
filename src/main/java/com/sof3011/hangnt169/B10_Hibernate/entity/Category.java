package com.sof3011.hangnt169.B10_Hibernate.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "category")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Category {

    /**
     * J3: JDBC(Java Database Connectivity) => Truy van SQL
     * J4: Hibernate
     *          => Truy van SQL
     *          => Truy van HQL(Hibernate Query Language) => Truy van thuc the (Truy van tren class)
     * J5: JPA
     *          => Truy van SQL (native query)
     *          => Truy van JPQL(JPA Query Language) => Truy van tren thuc the
     * ORM(Object Relationship Mapping):
     *  - Table
     *  - Column:
     *      + Khoa chinh
     *      + Khoa ngoai
     *      + Column binh thuong
     *  - Relationship :
     *      + 1-1: One to One
     *      + 1-n: One to Many
     *      + n-1: Many to one
     *      + n-n: Many to Many
     *      1 Product -> 1 Category
     *      1 Category -> N Product
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id1;

    @Column(name = "category_code")
    private String categoryCode;

    @Column(name = "category_name")
    private String categoryName1;

}
