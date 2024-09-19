package org.example.Services.saleServices;

import org.example.DTO.salesRegister.ClientDTO;
import org.example.Entities.sales_register.Client;
import org.example.Persistences.repository.sales.ClientRepository;
import org.example.utils.GenericMapper;

import java.util.List;

public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void saveClient(ClientDTO clientDTO) {
        clientRepository.save(GenericMapper.map(clientDTO, Client.class));
    }

    public void updateClient(ClientDTO clientDTO) {
        clientRepository.update(GenericMapper.map(clientDTO, Client.class));
    }

    public void deleteClient(Long id) {
        clientRepository.delete(id);
    }

    public Client findByIdClient(Long id) {
        return clientRepository.findById(id);
    }

    public Client findByDNI(String dni) {
        return clientRepository.findByDNI(dni);
    }

    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }
}
