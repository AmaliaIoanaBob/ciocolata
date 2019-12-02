package com.grupa2.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClientRepository extends JpaRepository<ClientModel,Long> {
    List<ClientModel> findAllById(long id);
    ClientModel findByNameAndEmail(String name,String email);
}
