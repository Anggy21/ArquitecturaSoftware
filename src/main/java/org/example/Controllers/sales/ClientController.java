package org.example.Controllers.sales;

import org.example.DTO.salesRegister.ClientDTO;
import org.example.Services.saleServices.ClientService;

import java.util.List;

public class ClientController {

    private final ClientService clientService;

    public ClientController(){
        this.clientService = new ClientService();
    }

    public void createClient(ClientDTO client){
        clientService.saveClient(client);
    }

    public void updateClient(ClientDTO client){
        clientService.updateClient(client);
    }

    public void deleteClient(Long id){
        clientService.deleteClient(id);
    }

    public ClientDTO getClient(String dni){
        return clientService.findByDNI(dni);
    }

    public List<ClientDTO> getClients(){
        return clientService.findAllClients();
    }
}
