package org.example.Services.saleServices;

import org.example.DTO.salesRegister.ClientDTO;
import org.example.Entities.sales_register.Client;
import org.example.Persistences.repository.sales.ClientRepository;
import org.example.utils.GenericMapper;

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

    public ClientDTO findByIdClient(Long id) {
        return GenericMapper.map(clientRepository.findById(id), ClientDTO.class);
    }
}
