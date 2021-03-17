package com.blog.app.blog_project.service;

import com.blog.app.blog_project.entity.Blog;
import com.blog.app.blog_project.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class BlogService {

    @Autowired
    BlogRepository blogRepository;

    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    public Blog insertBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    public Blog updateBlog(Blog blog) {
        Blog blog1 = blogRepository.findById(blog.getBlogId()).get();
        blog1.setBlogDescription(blog.getBlogDescription());
        blogRepository.save(blog1);
        return blog1;
    }

    public boolean deleteBlog(int blogId) {
        Blog blog = blogRepository.findById(blogId).get();
        try {
            blogRepository.delete(blog);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

//    public List<Blog> getAll

}
