package com.example.demo.service;

import com.example.demo.model.entity.File;
import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;

@AllArgsConstructor
@Service
public class UserService {

    private UserRepository userRepository;

    public User create(User user) {
        return userRepository.save(user);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public User find(Long id) {
        return userRepository.findById(id).get();
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public Collection<User> find() {
        return userRepository.findAll();
    }

    public User createWithFile(String userJSON, MultipartFile file) {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = null;
        try {
            user = objectMapper.readValue(userJSON, User.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        try {
            File photo = new File();
            photo.setName(file.getOriginalFilename());
            photo.setType(file.getContentType());
            photo.setData(file.getBytes());
            user.setPhoto(photo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return create(user);

    }
}
