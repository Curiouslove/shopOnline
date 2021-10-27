package com.ecommerce.shop.payload.request;

import com.ecommerce.shop.data.model.Currency;
import com.ecommerce.shop.data.model.Feedback;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    private String name;

    @Column(length = 500)
    private String details;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    private Double price;

    @ElementCollection
    private List<String> imageUrl;

//    @OneToMany
    private List<Feedback> feedbacks;
}
