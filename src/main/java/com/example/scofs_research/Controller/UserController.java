package com.example.scofs_research.Controller;

import com.example.scofs_research.Models.Users;
import com.example.scofs_research.Services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;

    @GetMapping("/get")
    public ResponseEntity<?> getByUser(@RequestParam(required = false) Long id){
        List<Users> list = new ArrayList<>();
        if(id==null){
            list = userService.getAllUser();
        }
        else{
            Optional<Users> users =userService.getById(id);
            if (users.isPresent()) {
                list.add(users.get());
            }
            else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(""+id);
            }
        }
        return ResponseEntity.ok(list);

    }
    @PostMapping("/update")
    public void saveOrUpdate(@RequestParam Users user,
                             @RequestParam(required = false) Long id){
        if(id==null){
            userService.addUser(user);
        }else {
            userService.updateUser(id, user);
        }
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestParam(required = false) Long id,
                           @RequestParam Users user,
                           @RequestParam(required = false) String userName){
        if (id==null){
            userService.deleteUserByName(userName);
        }
        else if(userName == null){
            userService.deleteUserById(id);
        }
        else{
            userService.deleteUser(user);
        }
    }
}
