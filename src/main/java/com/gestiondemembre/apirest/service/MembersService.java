package com.gestiondemembre.apirest.service;

import com.gestiondemembre.apirest.model.Members;
import com.gestiondemembre.apirest.repository.MembersRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Transactional
    public List<Members> createMembers(List<Members> toCreate){
        return repository.saveAll(toCreate);
    }

    public Members updateById(Long id) {
            Members members = repository.findById(id).get();
            return repository.save(members);
    }

    public Members findById(Long id) {
        if (repository.findById(id).isEmpty()) {
            return null;
        }
        Members members = repository.findById(id).get();
        return members;
    }

    public String deleteById(Long id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return "Members successfully deleted";
        }
        return "The members does not exist";
    }
}
