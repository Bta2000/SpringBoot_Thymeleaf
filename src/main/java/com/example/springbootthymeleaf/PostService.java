package com.example.springbootthymeleaf;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PostService {

    @Autowired
    private PostRespository repo;

    public List<Post> listAll() {
        return (List<Post>) repo.findAll();
    }

    public void save(Post post) {
        repo.save(post);
    }

    public Post get(int id) {
        return repo.findById(id).get();
    }

    public void delete(int id) {
        repo.deleteById(id);
    }



























    ///////////////////////////////////////////////////////////////////////////////////

//    @Autowired
//    PostRespository repository;
//
//    public List<Post> getAllPost()
//    {
//        List<Post> result = (List<Post>) repository.findAll();
//
//        if(result.size() > 0) {
//            return result;
//        } else {
//            return new ArrayList<Post>();
//        }
//    }
//
//    public Post getPostById(int id)
//    {
//        Optional<Post> post = repository.findById(id);
//
//        return post.get();
//
//    }
//
//    public Post createOrUpdatePost(Post entity)
//    {
////        if(entity.getId()  == null)
////        {
////            entity = repository.save(entity);
////
////            return entity;
////        }
////        else
////        {
//            Optional<Post> post = repository.findById(entity.getId());
//
//            if(post.isPresent())
//            {
//                Post newEntity = post.get();
//                newEntity.setContent(entity.getContent());
//                newEntity.setTitle(entity.getTitle());
//
//                newEntity = repository.save(newEntity);
//
//                return newEntity;
//            } else {
//                entity = repository.save(entity);
//
//                return entity;
//            }
//        }
//   // }
//
//    public void deletePostById(int id)
//    {
//        Optional<Post> post = repository.findById(id);
//
//        if(post.isPresent())
//        {
//            repository.deleteById(id);
//        }
//    }




}
