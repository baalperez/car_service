package com.kodilla.sercive;

import com.kodilla.domain.Client;
import com.kodilla.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClient(final Long phoneNumber) {
        return clientRepository.findById(phoneNumber);
    }

    public Client saveClient(final Client client) {
        return clientRepository.save(client);
    }

    public void deleteClient(final Long phoneNumber) {
        clientRepository.deleteById(phoneNumber);
    }
}
