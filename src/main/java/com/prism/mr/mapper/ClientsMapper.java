package com.prism.mr.mapper;

import com.prism.mr.dto.ClientsDto;
import com.prism.mr.model.Clients;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ClientsMapper {
    Clients toEntity(ClientsDto clientsDto);
    ClientsDto toDto(Clients clients);
}
