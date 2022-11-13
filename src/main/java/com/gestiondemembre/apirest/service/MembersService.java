package com.gestiondemembre.apirest.service;

import com.gestiondemembre.apirest.model.Members;
import com.gestiondemembre.apirest.repository.MembersRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MembersService {

    private final MembersRepository  repository;

    public List<Members> findAllMembers (Optional<Integer> page, Optional<Integer> pageSize){
        Pageable pageable = PageRequest.of(page.orElse(0), pageSize.orElse(10));
        return  repository.findAll(pageable).stream().toList();

    }



}
