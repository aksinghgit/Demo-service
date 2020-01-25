package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Post;

/**
 * @author amritesh
 *
 */
@Repository
public interface PostRepository extends JpaRepository<Post,String>{

}