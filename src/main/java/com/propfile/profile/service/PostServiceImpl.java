package com.propfile.profile.service;

import com.propfile.profile.exception.ResourceNotFoundException;
import com.propfile.profile.model.Post;
import com.propfile.profile.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    @Override
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post findPostById(Long id) {
        return postRepository.getById(id);
    }

    @Override
    public Post updatePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void deletePostById(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public void deletePost(Long id, Long userId) {
       postRepository.findByIdAndUserId(id, userId)
               .map(post ->{
                   postRepository.deleteById(id);
                   return null;
               }).orElseThrow(
               () -> new ResourceNotFoundException(
                       "Post Not found " + id + " User not found " + userId
               )
       );
    }

    @Override
    public void del2(Long id) {
        postRepository.deleteById(id);
    }


}
