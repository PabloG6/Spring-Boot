package com.propfile.profile.service;

import com.propfile.profile.dto.UserRegistration;
import com.propfile.profile.model.Post;
import com.propfile.profile.model.User;


import java.util.List;
import java.util.Optional;

public interface UserService{
    //save user
    User saveUser(User user);
    //find all users
    List<User> findAllUsers();
    //find a specific user
    Optional<User> findUserById(Long id);
    //find user by email
    User findByEmail(String email);
    //update user
    User updateUser(User user);
    //delete user
    void deleteUserById(Long id);
    //save post
    Post savePost(Post post);
    //
    List<Post> getAllPost();
    //
    public Post savePostToUSer(Long id, Post post);
    //save user with post



}
