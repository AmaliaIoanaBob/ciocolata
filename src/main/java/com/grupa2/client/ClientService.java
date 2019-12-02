package com.grupa2.client;


import ch.qos.logback.core.net.server.Client;
import com.grupa2.AbstractService;
import org.springframework.stereotype.Service;



    @Service
    public class ClientService extends AbstractService<Long, ClientModel, ClientRepository> {

        public ClientService(ClientRepository repository) {
            super(repository);
        }
    }












