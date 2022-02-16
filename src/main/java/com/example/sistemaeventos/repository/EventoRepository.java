package com.example.sistemaeventos.repository;

import com.example.sistemaeventos.model.EventoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * @author https://github.com/alisonrodolfo
 */
public interface EventoRepository extends JpaRepository<EventoModel, Long> {
    /* Created by Alison on 12/02/2022 */
}
