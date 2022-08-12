package com.example.springbootthymeleaf;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRespository extends CrudRepository<Post, Integer> {


}
