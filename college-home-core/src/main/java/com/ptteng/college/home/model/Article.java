package com.ptteng.college.home.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


@Entity
@Table(name = "article")
public class Article implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 3420634783566795776L;


    private Long id;


    private Long rank;

    private String author;


    private String url;


    private String img;


    private Long status;


    private String title;


    private String content;


    private Long createBy;


    private Long updateBy;


    private Long createAt;


    private Long updateAt;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "rank")
    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    @Column(name = "author")
    public String getAuthor() {return author;}

    public void setAuthor(String author) {this.author = author;}

    @Column(name = "url")
    public String getUrl() {return url;}

    public void setUrl(String url) {this.url = url;}

    @Column(name = "img")
    public String getImg() {
        return img;
    }


    public void setImg(String img) {
        this.img = img;
    }

    @Column(name = "status")
    public Long getStatus() {
        return status;
    }


    public void setStatus(Long status) {
        this.status = status;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "content")
    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "create_by")
    public Long getCreateBy() {
        return createBy;
    }


    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    @Column(name = "update_by")
    public Long getUpdateBy() {
        return updateBy;
    }


    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    @Column(name = "create_at")
    public Long getCreateAt() {
        return createAt;
    }


    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    @Column(name = "update_at")
    public Long getUpdateAt() {
        return updateAt;
    }


    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this,
                ToStringStyle.MULTI_LINE_STYLE);
    }

}

