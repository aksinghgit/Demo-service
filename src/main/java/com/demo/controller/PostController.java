package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Post;
import com.demo.service.PostService;

/**
 * @author amritesh
 *
 */
@RestController
public class PostController {

	@Autowired
	private PostService postService;

	@GetMapping("/service/status")
	public String getStatus() {
		return "{\"status\": \"success\" }";
	}

	@PostMapping("/service/post")
	public ResponseEntity<Post> saveEmployee(@RequestBody Post post) {
		Post savedPost = postService.savePost(post);
		System.out.println("Post Saved Successfully" + savedPost);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedPost);
	}

	@GetMapping("/service/posts")
	public List<Post> getPosts() {
		List<Post> posts = postService.retrievePosts();
		return posts;
	}

	@GetMapping("/service/post/{postId}")
	public Post getEmployee(@PathVariable(name = "postId") String postId) {
		return postService.getPost(postId);
	}

	@DeleteMapping("/service/post/{postId}")
	public boolean deleteEmployee(@PathVariable(name = "postId") String postId) {
		return postService.deletePost(postId);		
	}

	@PutMapping("/service/post/{postId}")
	public Post updateEmployee(@RequestBody Post post, @PathVariable(name = "postId") String postId) {
		Post savedPost = postService.getPost(postId);
		if (savedPost != null) {
			post.setId(savedPost.getId());
			savedPost = postService.updatePost(post);
		}
		return savedPost;
	}

}