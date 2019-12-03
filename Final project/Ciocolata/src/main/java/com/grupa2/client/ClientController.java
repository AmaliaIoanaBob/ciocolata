package com.grupa2.client;

import com.grupa2.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientController extends AbstractController<Long,ClientModel,ClientRepository,ClientService> {
    @Autowired
    public ClientController(ClientService clientService) {super(clientService);
    }
}
