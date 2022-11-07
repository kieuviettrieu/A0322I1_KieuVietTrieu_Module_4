package com.codegym.cms.model;

import javax.persistence.*;

@Entity
@Table(name = "blogs")
public class Blog {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String tenBlog;
    private String noiDung;
    private String moTa;
    private String tenTacGia;

//    @ManyToOne(cascade = CascadeType.ALL)
    @ManyToOne
    @JoinColumn(name = "blog_type_id", referencedColumnName = "id")
    private BlogType blogType;

    public Blog() {
    }

    public Blog(String tenBlog, String noiDung, String moTa, String tenTacGia) {
        this.tenBlog = tenBlog;
        this.noiDung = noiDung;
        this.moTa = moTa;
        this.tenTacGia = tenTacGia;
    }

    public Blog(Long id, String tenBlog, String noiDung, String moTa, String tenTacGia) {
        this.id = id;
        this.tenBlog = tenBlog;
        this.noiDung = noiDung;
        this.moTa = moTa;
        this.tenTacGia = tenTacGia;
    }

    public Blog(Long id, String tenBlog, String noiDung, String moTa, String tenTacGia, BlogType blogType) {
        this.id = id;
        this.tenBlog = tenBlog;
        this.noiDung = noiDung;
        this.moTa = moTa;
        this.tenTacGia = tenTacGia;
        this.blogType = blogType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenBlog() {
        return tenBlog;
    }

    public void setTenBlog(String tenBlog) {
        this.tenBlog = tenBlog;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public BlogType getBlogType() {
        return blogType;
    }

    public void setBlogType(BlogType blogType) {
        this.blogType = blogType;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", tenBlog='" + tenBlog + '\'' +
                ", noiDung='" + noiDung + '\'' +
                ", moTa='" + moTa + '\'' +
                ", tenTacGia='" + tenTacGia + '\'' +
                ", blogType=" + blogType +
                '}';
    }
}
