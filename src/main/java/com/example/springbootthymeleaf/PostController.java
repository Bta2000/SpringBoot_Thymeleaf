package com.example.springbootthymeleaf;


import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


@Controller
public class PostController {


    @Autowired
    private PostService service;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Post> listPosts = service.listAll();
        model.addAttribute("listPosts", listPosts);

        return "index";
    }

    @RequestMapping("/new")
    public String showNewPostPage(Model model) {
        Post post = new Post();
        model.addAttribute("post", post);

        return "new_post";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String savePost(@ModelAttribute("post") Post post) {
        service.save(post);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditPostPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_post");
        Post post = service.get(id);
        mav.addObject("post", post);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deletePost(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }



    ////////////////////////////////////////////////////////




    //    @Autowired
    //    PostRespository postRespository;


//    @RequestMapping
//    public String getAllPost(Model model)
//    {
//        List<Post> list = service.getAllPost();
//
//        model.addAttribute("posts", list);
//        return "list-posts";
//    }
//
//    @RequestMapping(path = {"/edit", "/edit/{id}"})
//    public String editPostById(Model model, @PathVariable("id") Optional<Integer> id)
//    {
//        if (id.isPresent()) {
//            Post entity = service.getPostById(id.get());
//            model.addAttribute("employee", entity);
//        } else {
//            model.addAttribute("employee", new Post());
//        }
//        return "add-edit-post";
//    }
//
//    @RequestMapping(path = "/delete/{id}")
//    public String deletePostById(Model model, @PathVariable("id") int id)
//    {
//        service.deletePostById(id);
//        return "redirect:/";
//    }
//
//    @RequestMapping(path = "/createPost", method = RequestMethod.POST)
//    public String createOrUpdatePost(Post post)
//    {
//        service.createOrUpdatePost(post);
//        return "redirect:/";
//    }




}
