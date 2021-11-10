package com.propfile.profile.service;

import com.propfile.profile.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostService {
    List<Post> getPosts();

}
