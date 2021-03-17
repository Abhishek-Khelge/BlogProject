package com.blog.app.blog_project.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@ToString
public class Categories {
    @Id
    int categoriesId;
    String categoriesType;

    @OneToMany(mappedBy = "categories")
    @JsonManagedReference
    List<Blog> blogs = new ArrayList<>();

    public void addBlog(Blog blog) {
        this.blogs.add(blog);
    }

    public void removeBlog(Blog blog) {
        this.blogs.remove(blog);
    }

}
