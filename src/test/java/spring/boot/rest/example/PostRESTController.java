package spring.boot.rest.example;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.demo.controller.PostController;
import com.demo.entity.Post;
import com.demo.repository.PostRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebAppConfiguration
@ExtendWith(MockitoExtension.class)
@WebMvcTest(PostController.class)
public class PostRESTController {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private PostRepository postRepository;

	@Test
	public void createEmployeeAPI() throws Exception {

		
		Post post = new Post();
		post.setId("P1");
		post.setTitle("My first post");
		post.setContent("post content");
		post.setStatus("active");
		post.setTag("tag1,tag2,tag3");

		when(postRepository.save(any(Post.class))).thenReturn(post);

		mvc.perform(post("/service/posts").content(asJsonString(post)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.title").exists());
	}

	@Test
	public void getEmployeeByIdAPI() throws Exception {
		Post post = new Post();
		post.setId("P1");
		post.setTitle("My first post");
		post.setContent("Updated post content");
		post.setStatus("active");
		post.setTag("tag1,tag2,tag3");

		when(postRepository.findById(any(String.class))).thenReturn(Optional.of(post));

		mvc.perform(MockMvcRequestBuilders.get("/service/post/{postId}", "P1")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
