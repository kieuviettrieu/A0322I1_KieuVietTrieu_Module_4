package com.codegym.cms.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class BlogType {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String tenBlogType;

    @OneToMany(mappedBy = "blogType",cascade = CascadeType.REMOVE)
    private Set<Blog> setBlog;

    public BlogType() {
    }

    public BlogType(Long id, String tenBlogType, Set<Blog> setBlog) {
        this.id = id;
        this.tenBlogType = tenBlogType;
        this.setBlog = setBlog;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenBlogType() {
        return tenBlogType;
    }

    public void setTenBlogType(String tenBlogType) {
        this.tenBlogType = tenBlogType;
    }

    public Set<Blog> getSetBlog() {
        return setBlog;
    }

    public void setSetBlog(Set<Blog> blog) {
        this.setBlog = blog;
    }

    @Override
    public String toString() {
        return "BlogType{" +
                "id=" + id +
                ", tenBlogType='" + tenBlogType +
                '}';
    }
}
