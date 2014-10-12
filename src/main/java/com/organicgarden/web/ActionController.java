package com.organicgarden.web;

import com.organicgarden.model.Achievment;
import com.organicgarden.model.Action;
import com.organicgarden.model.Plant;
import com.organicgarden.service.AchievmentService;
import com.organicgarden.service.ActionService;
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
@RequestMapping("/actions")
public class ActionController {

    private static final Logger log = Logger.getLogger(ActionController.class);
    private static final String OK_JSON = "{\"status\":\"ok\"}";

    @Autowired
    ActionService actionService;

    @RequestMapping(method = RequestMethod.POST, value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveAction(@RequestBody Action action,
                                           HttpServletRequest httpServletRequest) {
        log.info("/actions RequestMethod.POST");
        actionService.saveAction(action);
        return new ResponseEntity<>(OK_JSON, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateAction(@RequestBody Action action,
                                                 HttpServletRequest httpServletRequest) {
        log.info("/actions RequestMethod.POST");
        actionService.updateAction(action);
        return new ResponseEntity<>(OK_JSON, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/forPlant/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Action>> getAllActionsByPlantId(@PathVariable("id") Long id) {
        log.info("/plants get RequestMethod.GET for userid : " + id);
        List<Action> actions = actionService.getActionsByPlantId(id);
        return new ResponseEntity<>(actions, HttpStatus.OK);
    }

}
