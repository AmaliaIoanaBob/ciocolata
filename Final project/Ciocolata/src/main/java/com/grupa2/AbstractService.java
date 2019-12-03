package com.grupa2;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class AbstractService
            <ID_TYPE,
                    MODEL extends AbstractModel<ID_TYPE>,
                    REPOSITORY extends JpaRepository<MODEL, ID_TYPE>> {

        protected REPOSITORY repository;

    public AbstractService() {
    }

    public AbstractService(REPOSITORY repository) {
            this.repository = repository;
        }

        public List<MODEL> get() {
            return repository.findAll();
        }

        public Optional<MODEL> get(ID_TYPE id) {
            return repository.findById(id);
        }

        public MODEL add(MODEL model) {
            return repository.saveAndFlush(model);
        }

        public void delete(ID_TYPE id) throws EmptyResultDataAccessException {
            repository.deleteById(id);
        }

        public MODEL update(MODEL modelToUpdate) {
            if(modelToUpdate.getId() == null) {
                throw new IllegalArgumentException();
            }
            Optional<MODEL> existingModel =
                    repository.findById(modelToUpdate.getId());
            if(existingModel.isPresent()) {
                return repository.saveAndFlush(modelToUpdate);
            } else {
                throw new IllegalArgumentException();
            }
        }
    }


