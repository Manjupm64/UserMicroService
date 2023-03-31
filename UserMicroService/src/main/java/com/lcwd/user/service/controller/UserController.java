package com.lcwd.user.service.controller;

import com.lcwd.user.service.entity.User;
import com.lcwd.user.service.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userService.saveUser(user);
        return  ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @GetMapping("/{userId}")
   // @CircuitBreaker(name ="${spring.application.name}", fallbackMethod = "ratingHotelFallBack")
    //@Retry(name ="${spring.application.name}", fallbackMethod = "ratingHotelFallBack")
    @RateLimiter(name ="${spring.application.name}", fallbackMethod = "ratingHotelFallBack")
    public ResponseEntity<User> getSingleUser(@PathVariable("userId") Long userId){

        User user=userService.getUseById(userId);
        return ResponseEntity.ok(user);
    }

    public ResponseEntity<User> ratingHotelFallBack(Long id, Exception ex){
        ex.printStackTrace();
      //  LOGGER.info("FallBack is executed because service is down: ", ex.getMessage());
        User user = User.builder().email("dummy@gmail.com").name("Dummy").about("This user is created dummy because some service is down").id(141234L).build();
        return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> userList= userService.getAllUser();
        return ResponseEntity.ok(userList);
    }
}
