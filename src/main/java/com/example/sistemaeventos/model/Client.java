package com.example.sistemaeventos.model;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;



/**
 * @author https://github.com/alisonrodolfo
 */
@Entity
@Data
@Table(name = "TB_CLIENTS")
public class Client {
    /* Created by Alison on 15/02/2022 */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;
    private String name;
    private String nivel;

}
