package com.prior.newbie.controller;

import com.prior.newbie.entities.Train;
import com.prior.newbie.service.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/train")
public class RestTemplateController {
    @Autowired
    private RestTemplateService restTemplateService;

    //get all
    @GetMapping(value = "/all_rest")
    public ResponseEntity<String> findAllRestTemplate() {
        return restTemplateService.findAll();
    }

    //get by id
    @GetMapping(value = "/show_by_id_rest/{id}")
    public Train findByIdRestTemplate(@PathVariable String id) {
        return restTemplateService.findById(id);
    }

    //create
    @PostMapping(value = "/create_rest")
    public Train createRestTemplate(@RequestBody Train train){
        return restTemplateService.createTrain(train);
    }

    //update
    @PutMapping("/update_rest/{id}")
    public String updateRestTemplate(@PathVariable(value = "id") String id, @RequestBody Train train){
        return restTemplateService.updateTrain(id, train);
    }

    //delete
    @DeleteMapping("/delete_rest/{id}")
    public String deleteEmployee(@PathVariable(value = "id") String id){
        return restTemplateService.deleteTrain(id);
    }
}