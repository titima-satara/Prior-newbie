package com.prior.newbie.service;

import com.prior.newbie.entities.Train;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class RestTemplateService {
    private final static String url = "https://61970d0aaf46280017e7e3c5.mockapi.io/api/v1/train/users";
    private RestTemplate restTemplate = new RestTemplate();
    private  HttpHeaders headers = new HttpHeaders();
    private  HttpEntity<String> entity = new HttpEntity<>(headers);

    public ResponseEntity<String> findAll(){
        System.out.println("######## get find all rest template ########");
        return restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    }

    public Train findById(String id) {
        System.out.println("######## get find by id rest template ########");
        Map< String, String > params = new HashMap< String, String >();
        params.put("id", id);
        return restTemplate.getForObject(url + "/" + id, Train.class, params);
    }

    public Train createTrain(Train train) {
        System.out.println("######## create train rest template ########");
        return restTemplate.postForObject(url, train, Train.class);
    }

    public String updateTrain(String id, Train train) {
        System.out.println("########  update train rest template ########");
        restTemplate.put(url + "/" + id, train, Train.class);
        return "update succeed";
    }

    public String deleteTrain(String id) {
        System.out.println("########  delete train rest template ########");
        Map< String, String > params = new HashMap< String, String >();
        params.put("id", id);
        restTemplate.delete(url + "/" + id, params);
        return "delete delete";
    }
}
