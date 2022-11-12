package com.gestiondemembre.apirest.controller;

import com.gestiondemembre.apirest.model.Members;
import com.gestiondemembre.apirest.service.MembersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
    public List<Members> getAllDishes(@RequestParam Optional<Integer> page, @RequestParam Optional<Integer> pageSize){
        return service.getAllDishes(page, pageSize);
    }

}
