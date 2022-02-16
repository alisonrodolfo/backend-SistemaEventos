package com.example.sistemaeventos.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

/**
 * @author https://github.com/alisonrodolfo
 */
@Data
@Getter
@Setter
@Entity
@Table(name = "TB_EVENTOS")
public class EventoModel extends RepresentationModel<EventoModel> implements Serializable {
    /* Created by Alison on 12/02/2022 */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long idEvento;
    private String name;
    private String local;
    private String date;
    private String hour;

}
