package com.telusko.SpringBootWeb1.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Component
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String brand;
    private BigDecimal price;
    private String category;
    // this format allow us to change the date format and to look it better
    private Date releaseDate;
    private boolean productAvailable;
    private int stockQuantity;

    // image attributes
    private String imageName;
    private String imageType;
    @Lob
    private byte[] imageData;

    public Product(int id){
        this.id = id;
    }


}
