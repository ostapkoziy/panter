package com.organicgarden.web;

import com.organicgarden.model.Achievment;
import com.organicgarden.model.Plant;
import com.organicgarden.model.User;
import com.organicgarden.service.AchievmentService;
import com.organicgarden.service.UserService;
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
@RequestMapping("/achievments")
public class AchievmentsController {

    private static final Logger log = Logger.getLogger(AchievmentsController.class);
    private static final String OK_JSON = "{\"status\":\"ok\"}";

    @Autowired
    AchievmentService achievmentService;

    @RequestMapping(method = RequestMethod.POST, value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveAchievment(@RequestBody Achievment achievment,
                                           HttpServletRequest httpServletRequest) {
        log.info("/achievments RequestMethod.POST");
        achievmentService.saveAchievment(achievment);
        return new ResponseEntity<>(OK_JSON, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateAchievment(@RequestBody Achievment achievment,
                                                 HttpServletRequest httpServletRequest) {
        log.info("/achievments RequestMethod.POST");
        achievmentService.updateAchievment(achievment);
        return new ResponseEntity<>(OK_JSON, HttpStatus.OK);
    }

}
