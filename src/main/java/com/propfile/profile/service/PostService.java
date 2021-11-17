package com.propfile.profile.service;

import com.propfile.profile.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<Post> getPosts();

    Post findPostById(Long id);

    Post updatePost(Post post);

    Post savePost(Post post);

    void deletePostById(Long id);

    void deletePost(Long id, Long userId);

    void del2(Long id);
}
