package com.demo.service;

import java.util.List;

import com.demo.entity.Post;


/**
 * @author amritesh
 *
 */
public interface PostService {
 public List<Post> retrievePosts();
 
 public Post getPost(String postId);
 
 public Post savePost(Post post);
 
 public boolean deletePost(String postId);
 
 public Post updatePost(Post post);
}