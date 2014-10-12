package com.organicgarden.web;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.organicgarden.model.Achievment;
import com.organicgarden.model.Plant;
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

import com.organicgarden.exception.UserActivationNotFoundException;
import com.organicgarden.model.User;
import com.organicgarden.service.UserService;

/**
 * @author Vyacheslav Pikhovshek
 */
@Controller
@RequestMapping("/users")
public class UserController {
	private static final Logger log = Logger.getLogger(UserController.class);
	private static final String OK_JSON = "{\"status\":\"ok\"}";
	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.POST, value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveUser(@RequestBody User user,
			HttpServletRequest httpServletRequest) {
		log.info("/users RequestMethod.POST");
        if(userService.getUserByEmail(user.getEmail()) == null){
            userService.saveUser(user, httpServletRequest);
        }
		return new ResponseEntity<>(OK_JSON, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getAllUsers(Principal principal) {
		log.info("/users RequestMethod.GET. Test1");
		List<User> users = userService.getAllUsers();
        log.info("USERS: " + users.size());
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

    @RequestMapping(method = RequestMethod.GET, value = "/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserById(@PathVariable("email") Long id) {
        log.info("/users RequestMethod.GET by id : " + id);
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateUser(@RequestBody User user,
                                           HttpServletRequest httpServletRequest) {
        log.info("/users update RequestMethod.POST");
        userService.updateUser(user, httpServletRequest);
        return new ResponseEntity<>(OK_JSON, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/achievments", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Achievment>> getAchievments(@PathVariable("id") Long id) {
        log.info("/users RequestMethod.GET achievments for user id : " + id);
        List<Achievment> achievments = userService.getAchievments(id);
        log.info("ACHIEVMENTS: " + achievments.size());
        return new ResponseEntity<>(achievments, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/plants", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Plant>> getPlants(@PathVariable("id") Long id) {
        log.info("/users RequestMethod.GET plants for user id : " + id);
        List<Plant> plants = userService.getPlants(id);
        log.info("PLANTS: " + plants.size());
        return new ResponseEntity<>(plants, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/rating", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> getRating(@PathVariable("id") Long id) {
        log.info("/users RequestMethod.GET plants for user id : " + id);
        int rating = userService.getRating(id);
        log.info("PLANTS: " + rating);
        return new ResponseEntity<>(rating, HttpStatus.OK);
    }

}
