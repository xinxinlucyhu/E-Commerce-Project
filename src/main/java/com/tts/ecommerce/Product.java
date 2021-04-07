package com.tts.ecommerce;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Long id;

    private int quantity;

    private int price;

    private String description;

    private String name;

    private String brand;

    private String category;

    private String image;

}
