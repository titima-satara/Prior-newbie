package com.prior.newbie.service;

import com.prior.newbie.entities.Color;
import com.prior.newbie.entities.Train;
import com.prior.newbie.entities.Train2;
import com.prior.newbie.repository.ColorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@Slf4j
public class RestTemplateService {
    private final static String url = "https://61970d0aaf46280017e7e3c5.mockapi.io/api/v1/train/users";
    private RestTemplate restTemplate = new RestTemplate();
    private HttpHeaders headers = new HttpHeaders();
    private HttpEntity<String> entity = new HttpEntity<>(headers);
    private Color color = new Color();

    @Autowired
    private ColorRepository colorRepository;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //get all
    public ResponseEntity<String> findAll(){
        System.out.println("######## get find all rest template ########");
        return restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    }

    //get all with color
    public List<Train2> findAllWithColor(){
        System.out.println("######## get Color find all rest template ########");
        ResponseEntity<List<Train>> trainsEntity = restTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<>() {});
        List<Train> trains = trainsEntity.getBody();

        List<Train2> train2List = new ArrayList<>();

        List<Color> colorList = colorRepository.findAll();
        Map<String, Color> colorMap = new HashMap<>();
        for (Color color : colorList) {
            colorMap.put(color.getColor_code(), color);
        }

        for(Train train : trains){
            Train2 train2 = new Train2();
            String colorUpperCase = train.getColorCode().toUpperCase();
            if(colorMap.containsKey(colorUpperCase)){
                Color color = colorMap.get(colorUpperCase);
                train2.setCreatedAt(train.getCreatedAt());
                train2.setName(train.getName());
                train2.setAvatar(train.getAvatar());
                train2.setRank(train.getRank());
                train2.setColorCode(train.getColorCode());
                train2.setColorName(color.getColor_name());
                train2.setColorDecimal(color.getDecimal_code());
                train2.setId(train.getId());
            }
            else {
                train2.setCreatedAt(train.getCreatedAt());
                train2.setName(train.getName());
                train2.setAvatar(train.getAvatar());
                train2.setRank(train.getRank());
                train2.setColorCode(train.getColorCode());
                train2.setId(train.getId());
            }
            train2List.add(train2);
        }
        return train2List;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //get by id
    public Train findById(String id) {
        System.out.println("######## get find by id rest template ########");
        Map< String, String > params = new HashMap< String, String >();
        params.put("id", id);
        return restTemplate.getForObject(url + "/" + id, Train.class, params);
    }

    //get with color by id
    public Train2 findByIdWithColor(String id) {
        System.out.println("######## get find by id rest template ########");
        Map< String, String > params = new HashMap< String, String >();
        params.put("id", id);

        List<Color> colorList = colorRepository.findAll();
        Map<String, Color> colorMap = new HashMap<>();
        for (Color color : colorList) {
            colorMap.put(color.getColor_code(), color);
        }

        Train train = restTemplate.getForObject(url + "/" + id, Train.class, params);
        String colorUpperCase = train.getColorCode().toUpperCase();

        Train2 train2 = new Train2();
        if(colorMap.containsKey(colorUpperCase)) {
            train.setColorCode(train.colorCode.toUpperCase());
            train2.setCreatedAt(train.getCreatedAt());
            train2.setName(train.getName());
            train2.setAvatar(train.getAvatar());
            train2.setRank(train.getRank());
            train2.setColorCode(train.getColorCode());
            train2.setColorName(colorRepository.findById(train.colorCode).get().getColor_name());
            train2.setColorDecimal(colorRepository.findById(train.colorCode).get().getDecimal_code());
            train2.setId(train.getId());
        }
        else {
            train2.setCreatedAt(train.getCreatedAt());
            train2.setName(train.getName());
            train2.setAvatar(train.getAvatar());
            train2.setRank(train.getRank());
            train2.setColorCode(train.getColorCode());
            train2.setId(train.getId());
        }
        return train2;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //create
    public Train createTrain(Train train) {
        System.out.println("######## create train rest template ########");
        restTemplate.postForObject(url, train, Train.class);
        return restTemplate.postForObject(url, train, Train.class);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //update
    public String updateTrain(String id, Train train) {
        System.out.println("########  update train rest template ########");
        restTemplate.put(url + "/" + id, train, Train.class);
        return "update succeed";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //delete
    public String deleteTrain(String id) {
        System.out.println("########  delete train rest template ########");
        Map< String, String > params = new HashMap< String, String >();
        params.put("id", id);
        restTemplate.delete(url + "/" + id, params);
        return "delete succeed";
    }
}
