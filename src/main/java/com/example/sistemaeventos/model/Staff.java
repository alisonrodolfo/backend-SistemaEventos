package com.example.sistemaeventos.model;

/**
 * @author https://github.com/alisonrodolfo
 */

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "TB_STAFFS")
public class Staff {
    /* Created by Alison on 15/02/2022 */

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id", updatable = false, unique = true, nullable = false)
        private long id;
        @Column(name = "staffUUID", nullable = false)
        private UUID staffUUID;
        @Column(name = "name", nullable = false)
        private String name;
        @Column(name = "nivel", nullable = false)
        private String nivel;
}
