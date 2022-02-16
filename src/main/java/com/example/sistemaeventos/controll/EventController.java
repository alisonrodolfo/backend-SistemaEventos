package com.example.sistemaeventos.controll;

import com.example.sistemaeventos.model.EventoModel;
import com.example.sistemaeventos.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

/**
 * @author https://github.com/alisonrodolfo
 */
@Controller
public class EventController {
    /* Created by Alison on 12/02/2022 */

    @Autowired
    private EventoRepository eventoRepository;

    @GetMapping("/eventos")
    public ResponseEntity<List<EventoModel>> getAllProdutos(){
        Iterable<EventoModel> eventoList = eventoRepository.findAll();
            for(EventoModel evento : eventoList) {
                long id = evento.getIdEvento();
                evento.add(linkTo(methodOn(EventController.class).getEvento(id)).withSelfRel());
            }
        return new ResponseEntity<List<EventoModel>>((List<EventoModel>) eventoList, HttpStatus.OK);
    }

    @GetMapping("/eventos/{id}")
    public ResponseEntity<EventoModel> getEvento(@PathVariable(value="id") long id){
        Optional<EventoModel> Evento = eventoRepository.findById(id);
        if(!Evento.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Evento.get().add(linkTo(methodOn(EventController.class).getAllProdutos()).withRel("Lista de Eventos"));
        return new ResponseEntity<EventoModel>(Evento.get(), HttpStatus.OK);
    }

    @PostMapping("/eventos")
    public ResponseEntity<EventoModel> saveProduto(@RequestBody @Valid EventoModel evento) {
        return new ResponseEntity<EventoModel>(eventoRepository.save(evento), HttpStatus.CREATED);
    }







}
