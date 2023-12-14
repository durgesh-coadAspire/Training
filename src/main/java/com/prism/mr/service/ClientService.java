package com.prism.mr.service;

import com.prism.mr.dto.ClientsDto;
import com.prism.mr.exception.ResourceNotFoundException;
import com.prism.mr.mapper.ClientsMapper;
import com.prism.mr.model.Clients;
import com.prism.mr.model.Members;
import com.prism.mr.repository.ClientsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientsRepository clientsRepository;
    private final ClientsMapper clientsMapper;

    public ClientsDto addOrUpdateClient(ClientsDto clientsDto) {
        return clientsMapper.toDto(clientsRepository.save(clientsMapper.toEntity(clientsDto)));
    }

    public String validateClientCode(Long Id, String Code) {
        Optional<Clients> clients;
        if(Id==null )
        {
            clients=clientsRepository.findByClientCode(Code);
        }
        else {
            clients=clientsRepository.findById(Id);
            if(clients.isPresent())
            {
                if(clientsRepository.findById(Id).get().getClientCode().equalsIgnoreCase(Code))
                {
                    clients=clientsRepository.findByClientCodeAndIdIn(Code,List.of(Id));
                }
                else {
                    clients=clientsRepository.findByClientCodeAndIdNotIn(Code,List.of(Id));
                }
            }
            else {
                clients=clientsRepository.findByClientCodeAndIdNotIn(Code,List.of(Id));
            }

        }
        if(clients.isPresent())
        {
            throw new ResourceNotFoundException("Duplicate Client Code Found !!");
        }
        else {
            return "VALID CLIENT CODE";
        }

    }

}
