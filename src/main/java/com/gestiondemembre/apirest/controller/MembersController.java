package com.gestiondemembre.apirest.controller;

import com.gestiondemembre.apirest.model.Members;
import com.gestiondemembre.apirest.service.MembersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/members")
@CrossOrigin
public class MembersController {

    private final MembersService service;

    @GetMapping("")
    public List<Members> getAllMembers(@RequestParam Optional<Integer> page, @RequestParam Optional<Integer> pageSize){
        return service.findAllMembers(page, pageSize);
    }

    @PostMapping("")
    public List<Members> saveMembers(@RequestBody List<Members> members){
        return service.createMembers(members);
    }

    @PutMapping("/{id}")
    public Members modifyMembers(@PathVariable Long id){
        return service.updateById(id);
    }

    @GetMapping("/{id}")
    public Members getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id){
        return service.deleteById(id);
    }

}
