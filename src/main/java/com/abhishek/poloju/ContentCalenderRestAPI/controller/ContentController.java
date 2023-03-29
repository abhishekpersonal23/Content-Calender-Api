package com.abhishek.poloju.ContentCalenderRestAPI.controller;

import com.abhishek.poloju.ContentCalenderRestAPI.model.Content;
import com.abhishek.poloju.ContentCalenderRestAPI.repository.ContentCollectionRepository;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/content")
@CrossOrigin
public class ContentController {
    private final ContentCollectionRepository repository;

    @Autowired()
    public ContentController(ContentCollectionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<Content> findAll(){

        return  repository.findAll();
    }
    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"content not found"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create (@Valid @RequestBody Content content){
        if(!repository.existsById(content.id())){
            throw new ResponseStatusException(HttpStatus.ALREADY_REPORTED, "Already requested no duplicate request is allowed");
        }
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Content content, @PathVariable Integer id ){ 
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"content not found");
        }

        repository.save(content);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }

}
