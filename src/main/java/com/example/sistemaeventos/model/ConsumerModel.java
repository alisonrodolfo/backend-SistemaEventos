package com.example.sistemaeventos.model;

import java.util.List;
import java.util.UUID;
import javax.persistence.*;

import lombok.Data;
/**
 * @author https://github.com/alisonrodolfo
 */


@Entity
@Data
@Table(name = "TB_CONSUMERS")
public class ConsumerModel {
    /* Created by Alison on 16/02/2022 */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private long id;
    @Column(name = "consumerUUID", nullable = false)
    private UUID consumerUUID;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "nivel", nullable = false)
    private String nivel;

    @OneToMany
    private List<OrderModel> orderModel;
}

