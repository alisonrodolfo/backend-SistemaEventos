package com.example.sistemaeventos.controll;

import com.example.sistemaeventos.model.EventoModel;
import com.example.sistemaeventos.model.OrderModel;
import com.example.sistemaeventos.repository.EventoRepository;
import com.example.sistemaeventos.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * @author https://github.com/alisonrodolfo
 */
@Controller
public class OrdersController {
    /* Created by Alison on 12/02/2022 */

    @Autowired
    private OrdersRepository ordersRepository;

    @GetMapping("/orders")
    public ResponseEntity<List<OrderModel>> getAllOrders(){
        Iterable<OrderModel> ordersList = ordersRepository.findAll();
            for(OrderModel order : ordersList) {
                long id = order.getId();
                order.add(linkTo(methodOn(OrdersController.class).getOrder(id)).withSelfRel());
            }
        return new ResponseEntity<List<OrderModel>>((List<OrderModel>) ordersList, HttpStatus.OK);
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<OrderModel> getOrder(@PathVariable(value="id") long id){
        Optional<OrderModel> order = ordersRepository.findById(id);
        if(!order.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        order.get().add(linkTo(methodOn(OrdersController.class).getAllOrders()).withRel("Order List"));
        return new ResponseEntity<OrderModel>(order.get(), HttpStatus.OK);
    }

    @PostMapping("/orders")
    public ResponseEntity<OrderModel> saveOrder(@RequestBody @Valid OrderModel order) {
        return new ResponseEntity<OrderModel>(ordersRepository.save(order), HttpStatus.CREATED);
    }
    @DeleteMapping("/orders/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable(value="id") long id) {
        Optional<OrderModel> order = ordersRepository.findById(id);
        if(!order.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ordersRepository.delete(order.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<OrderModel> updateOrder(@PathVariable(value="id") long id,
                                                      @RequestBody @Valid OrderModel orderModel) {
        Optional<OrderModel> order = ordersRepository.findById(id);
        if(!order.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        orderModel.setId(order.get().getId());
        return new ResponseEntity<OrderModel>(ordersRepository.save(orderModel), HttpStatus.OK);
    }







}
