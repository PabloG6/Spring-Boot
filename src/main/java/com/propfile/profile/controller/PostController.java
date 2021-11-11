package com.propfile.profile.controller;

import com.propfile.profile.model.Post;
import com.propfile.profile.service.PostService;
import com.propfile.profile.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RestController
@CrossOrigin("\"http://localhost:8081/\"")
@Slf4j
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final UserService userService;


    @GetMapping("/api/users/posts")
    public ResponseEntity<Post> getAllPosts(){
        return new ResponseEntity(postService.getPosts(), HttpStatus.OK);
    }

    @PostMapping("/api/users/{id}/posts")
    public ResponseEntity<Post> savePostToUser(@PathVariable(value = "id") Long id, @RequestBody Post post){
        return new ResponseEntity(userService.findUserById(id).map(user -> {
            post.setUser(user);
            return postService.savePost(post);
        }), HttpStatus.CREATED);
    }

    @DeleteMapping("/api/users/{userid}/posts/{postid}")
    public Optional<ResponseEntity<Object>> deleteCourse(@PathVariable(value = "userid") Long userid,
                                                         @PathVariable(value = "postid") Long postid) {
        return postService.findByIdAndUserId(postid, userid).map(course -> {
                postService.deletePostById(postid);
        return ResponseEntity.ok().build();
        });
    }

    @DeleteMapping("/api/post/{id}")
    public void delete(@PathVariable(value = "id") Long id){
        postService.deletePostById(id);
    }
}
