package com.example.sistemaeventos.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * @author https://github.com/alisonrodolfo
 */
@Data
@Getter
@Setter
@Entity
@Table(name = "TB_ORDERS")
public class OrderModel  extends RepresentationModel<OrderModel> implements Serializable {
    /* Created by Alison on 13/02/2022 */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;
    private String local;
    private String date;
    private String paymentMethod;
    private String shipTo;
    private String amount;

    @OneToMany
    private List<ProductModel> productModel;

    @ManyToOne
    private ConsumerModel consumerModel;


}
