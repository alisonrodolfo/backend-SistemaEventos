package com.example.sistemaeventos.repository;

import com.example.sistemaeventos.model.EventoModel;
import com.example.sistemaeventos.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author https://github.com/alisonrodolfo
 */
public interface OrdersRepository extends JpaRepository<OrderModel, Long> {
    /* Created by Alison on 12/02/2022 */
}
