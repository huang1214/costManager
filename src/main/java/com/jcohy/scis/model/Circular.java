package com.jcohy.scis.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by jiac on 2018/1/4 10:31.
 * ClassName  : Notice
 * Description  :日志实体类
 */
@Entity
@Table(name = "circular")
public class Circular  implements Serializable{
    private static final long serialVersionUID = 10L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "content")
    private String content;

    @Column(name = "start")
    private String start;

    @Column(name = "end")
    private String end;

    @Column(name = "target_url")
    private String targetUrl;

    @Column(name = "visible")
    private Integer visible;

    @Column(name = "url")
    private String url;

    @Column(name = "create_date")
    private String createDate;

    @Column(name = "update_date")
    private String updateDate;

    @OneToOne
    @JoinColumn(name = "book_circular_id")
    private Book book;

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Integer getVisible() {
        return visible;
    }

    public void setVisible(Integer visible) {
        this.visible = visible;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Circular{");
        sb.append("id=").append(id);
        sb.append(", content='").append(content).append('\'');
        sb.append(", start=").append(start);
        sb.append(", end=").append(end);
        sb.append(", targetUrl='").append(targetUrl).append('\'');
        sb.append(", visible=").append(visible);
        sb.append(", url='").append(url).append('\'');
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", book=").append(book);
        sb.append('}');
        return sb.toString();
    }
}
