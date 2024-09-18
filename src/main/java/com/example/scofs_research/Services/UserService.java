package com.example.scofs_research.Services;

import com.example.scofs_research.Models.Users;
import com.example.scofs_research.Repositories.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    public User userRepository;
    public Optional<Users> getById(long id){
        return userRepository.findById(id);
    }
    public Optional<Users> getByUserName(String userName){
        return userRepository.findByUserName(userName);
    }

    public List<Users> getAllUser(){
        List<Users> user = new ArrayList<>();
        user = userRepository.findAll();
        return user;
    }

    public void addUser(Users users){
        userRepository.save(users);
    }
    public void addAllUser(List<Users> users){
        userRepository.saveAll(users);
    }

    public void deleteUser(Users users){
        userRepository.delete(users);
    }
    public void deleteUserById(Long id){
        if (getById(id).isPresent()){
        userRepository.delete(getById(id).get());}
        else{
            throw new RuntimeException("User with the id doesn't exist"+id);
        }
    }
    public void deleteUserByName(String userName){
        if (getByUserName(userName).isPresent()){
        userRepository.delete(getByUserName(userName).get());}
        else {
            throw new RuntimeException("User with the userName doesn't exist"+userName);
        }
    }
    public void updateUser(long id, Users updatedUser){
        Optional<Users> existingUser = getById(id);
        if (existingUser.isPresent()){
            Users userToUpdate = existingUser.get();
            userToUpdate.setUserName(updatedUser.getUserName());
            userToUpdate.setEmail(updatedUser.getEmail());

            userRepository.save(userToUpdate);
        }
        else {
            throw new RuntimeException(""+id);
        }

    }

}
