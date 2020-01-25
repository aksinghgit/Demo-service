package spring.boot.rest.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.entity.Post;
import com.demo.repository.PostRepository;
import com.demo.service.impl.PostServiceImpl;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {

	@InjectMocks
	PostServiceImpl postService;

	@Mock
	PostRepository postRepository;

	@Test
	public void createEmployeeTest() {
		Post post = new Post();
		post.setId("P1");
		post.setTitle("My first post");
		post.setContent("post content");
		post.setStatus("active");
		post.setTag("tag1,tag2,tag3");

		
		postService.savePost(post);
		verify(postRepository, times(1)).save(post);
	}
	

	@Test
	public void findAllEmployeeTest() {
		
		Post post = new Post();
		post.setId("P1");
		post.setTitle("My first post");
		post.setContent("post content");
		post.setStatus("active");
		post.setTag("tag1,tag2,tag3");


		when(postRepository.findAll()).thenReturn(Arrays.asList(post));
		List<Post> posts = postService.retrievePosts();
		
		assertEquals(1,posts.size());
		assertEquals(postRepository.findAll().size(), posts.size());
		
	}

	
}