package com.propfile.profile.service;

import com.propfile.profile.dto.UserRegistration;
import com.propfile.profile.model.Post;

import com.propfile.profile.model.User;
import com.propfile.profile.repository.PostRepository;
import com.propfile.profile.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PostRepository postRepository;


    @Override
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    @Override
    public Post savePost(Post post) {

        return postRepository.save(post);
    }

    @Override
    public Post savePostToUSer(Long id, Post post){
        if(id != null){
            List<Post> posts = new ArrayList<>();
            User user = userRepository.getById(id);

            Post newPost = postRepository.save(post);
            posts.add(newPost);

            user.setPosts(posts);
            userRepository.save(user);

            return newPost;
        }

        return null;

    }


    @Override
    public User saveUser(User user) {


        return userRepository.save(user);
    }

    @Override
    public List<User> findAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public Optional<User> findUserById(Long id) {

        return userRepository.findById(id);
    }

    @Override
    public User findByEmail(String email) {

          return userRepository.findByEmail(email);

    }

    @Override
    public User updateUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {

        userRepository.deleteById(id);
    }

    public User apiSaveUser(User user){

        return userRepository.save(user);
    }


}
