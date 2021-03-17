package com.blog.app.blog_project.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
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
public class User {
    @Id
    int userId;
    String userName;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    List<Blog> blog = new ArrayList<>();

    public List<Blog> getBlog() {
        return blog;
    }

    public void addBlog(Blog blog) {
        this.blog.add(blog);
    }

    public void removeBlog(Blog blog) {
        this.blog.remove(blog);
    }

}
