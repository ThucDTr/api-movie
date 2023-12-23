package com.example.apimovie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apimovie.entity.Comment;
import com.example.apimovie.repo.CommentRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:3000" ,"https://group8-power-of-love.netlify.app/"})
@RequestMapping("/api/comment")
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;


    @GetMapping("/getAll")
    public List<Comment>getAllComment(){
        return commentRepository.findAll();
    }

    @GetMapping("/getAllOrderByTime")
    public List<Comment>getAllCommentOrderByTime(){
        return commentRepository.findAllByOrderByTimeDesc();
    }
    @GetMapping("/byMovie/{id}")
    public List<Comment>getCommentByMovie(@PathVariable int id){
        return commentRepository.getCommentByMovie(id);
    }


    @GetMapping("/byMovieDto/{id}")
    public List<Object[]>getCommentDtoByMovie(@PathVariable int id){
        return commentRepository.getCommentDtoByMovie(id);
    }
    @GetMapping("/byMovieDtoOrderByTime/{id}")
    public List<Object[]>getCommentDtoByMovieOrderByTime(@PathVariable int id){
        return commentRepository.getCommentDtoByMovieOrderByTime(id);
    }

    @PostMapping("/add")
    public Comment addComment(@RequestBody Comment comment){
            return commentRepository.save(comment);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteComment(@PathVariable int id){
        commentRepository.deleteById(id);
    }
}
