package com.grupa2;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class AbstractController<ID_TYPE,
        MODEL extends AbstractModel<ID_TYPE>,
        REPOSITORY extends JpaRepository<MODEL,ID_TYPE>,
        SERVICE extends AbstractService<ID_TYPE,MODEL,REPOSITORY>> {

         protected SERVICE service;

    public AbstractController() {
    }

    public AbstractController(SERVICE service) {
            this.service = service;
        }

        @PostMapping(consumes = "application/json", produces = "application/json")
        public ResponseEntity<MODEL> add(@RequestBody MODEL model) {
            MODEL addedModel = service.add(model);
            return ResponseEntity.ok(addedModel);
        }

        @GetMapping(path = "/{id}", produces = "application/json")
        public ResponseEntity<MODEL> get(@PathVariable ID_TYPE id) {
            Optional<MODEL> model = service.get(id);
            if(model.isPresent()) {
                return ResponseEntity.ok(model.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @GetMapping(produces = "application/json")
        public ResponseEntity<List<MODEL>> get() {
            List<MODEL> models = service.get();
            if(!models.isEmpty()) {
                return ResponseEntity.ok(models);
            } else {
                return ResponseEntity.noContent().build();
            }
        }

        @DeleteMapping(path = "/{id}")
        public ResponseEntity delete(ID_TYPE id) {
            try {
                service.delete(id);
            } catch (EmptyResultDataAccessException e) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().build();
        }

        @PutMapping(consumes = "application/json", produces = "application/json")
        public ResponseEntity<MODEL> update(@RequestBody MODEL model) {
            try {
                MODEL updatedModel = service.update(model);
                return ResponseEntity.ok(updatedModel);
            } catch(IllegalArgumentException e) {
                return ResponseEntity.badRequest().build();
            }
        }
    }


