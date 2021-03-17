package com.blog.app.blog_project.controller;

import com.blog.app.blog_project.entity.Blog;
import com.blog.app.blog_project.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping("/blogs")
    public List<Blog> getAllBlogs() {
        return blogService.getAllBlogs();
    }

    @PostMapping("/blog")
    public Blog insertBlog(@RequestBody Blog blog) {
        return blogService.insertBlog(blog);
    }

    @PutMapping("/blog")
    public Blog updateBlog(@RequestBody Blog blog) {
        return blogService.updateBlog(blog);
    }

    @DeleteMapping("/blog/{id}")
    public String deleteBlog(@PathVariable("id") int blogId) {
        boolean flag = blogService.deleteBlog(blogId);
        if (flag)
            return "Blog Deleted";
        else
            return "Fail to Delete this blog";
    }
}
