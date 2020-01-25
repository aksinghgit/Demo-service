package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Post;
import com.demo.repository.PostRepository;
import com.demo.service.PostService;

/**
 * @author amritesh
 *
 */
@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;

	@Override
	public List<Post> retrievePosts() {
		List<Post> allPost = postRepository.findAll();
		return allPost;
	}

	@Override
	public Post getPost(String postId) {
		return postRepository.findById(postId).get();
	}

	@Override
	public Post savePost(Post post) {
		return postRepository.save(post);
	}

	@Override
	public boolean deletePost(String postId) {
		boolean result = true;
		try {
			postRepository.deleteById(postId);

		} catch (Exception e) {
			result = false;
		}
		return result;
	}

	@Override
	public Post updatePost(Post post) {
		return postRepository.save(post);
	}
}