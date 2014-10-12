package com.organicgarden.web;

import com.organicgarden.model.Action;
import com.organicgarden.model.Plant;
import com.organicgarden.service.PlantService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/plants")
public class PlantController {
    private static final Logger log = Logger.getLogger(UserController.class);
    private static final String OK_JSON = "{\"status\":\"ok\"}";
    @Autowired
    private PlantService plantService;

    @RequestMapping(method = RequestMethod.POST, value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> savePlant(@RequestBody Plant plant,
                                           HttpServletRequest httpServletRequest) {
        log.info("/plants save RequestMethod.POST");
        plantService.savePlant(plant, httpServletRequest);
        return new ResponseEntity<>(OK_JSON, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/available", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Plant>> getAvailablePlants() {
        log.info("/plants get available RequestMethod.GET");
        List<Plant> plants = plantService.getAvailablePlants();
        return new ResponseEntity<>(plants, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Plant> getPlantById(@PathVariable("id") Long id) {
        log.info("/plants get RequestMethod.GET by id : " + id);
        Plant plant = plantService.getPlantById(id);
        return new ResponseEntity<>(plant, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updatePlant(@RequestBody Plant plant,
                                                  HttpServletRequest httpServletRequest) {
        log.info("/plants update RequestMethod.POST");
        plantService.updatePlant(plant, httpServletRequest);
        return new ResponseEntity<>(OK_JSON, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/forUser/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Plant>> getAllPlantsForUserId(@PathVariable("id") Long id) {
        log.info("/plants get RequestMethod.GET for userid : " + id);
        List<Plant> plants = plantService.getAllPlantsForUserId(id);
        return new ResponseEntity<>(plants, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/actions", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Action>> getAllActionsForPlantId(@PathVariable("id") Long id) {
        log.info("/plants get actions RequestMethod.GET for plantid : " + id);
        List<Action> actions = plantService.getAllActionsForPlantId(id);
        return new ResponseEntity<>(actions, HttpStatus.OK);
    }


}
