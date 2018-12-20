package org.renhj.manager.pojo.domain;

import javax.persistence.*;

@Table(name = "student_book")
public class StudentBook {
    @Id
    @Column(name = "book_id")
    private Integer bookId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer time;

    private String teacher;

    private Integer price;

    private String url;

    @Column(name = "student_num")
    private Integer studentNum;

    @Column(name = "book_img")
    private String bookImg;

    private String direction;

    @Column(name = "knowledge_point_num")
    private Integer knowledgePointNum;

    private String name;

    private String level;

    /**
     * @return book_id
     */
    public Integer getBookId() {
        return bookId;
    }

    /**
     * @param bookId
     */
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return time
     */
    public Integer getTime() {
        return time;
    }

    /**
     * @param time
     */
    public void setTime(Integer time) {
        this.time = time;
    }

    /**
     * @return teacher
     */
    public String getTeacher() {
        return teacher;
    }

    /**
     * @param teacher
     */
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    /**
     * @return price
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return student_num
     */
    public Integer getStudentNum() {
        return studentNum;
    }

    /**
     * @param studentNum
     */
    public void setStudentNum(Integer studentNum) {
        this.studentNum = studentNum;
    }

    /**
     * @return book_img
     */
    public String getBookImg() {
        return bookImg;
    }

    /**
     * @param bookImg
     */
    public void setBookImg(String bookImg) {
        this.bookImg = bookImg;
    }

    /**
     * @return direction
     */
    public String getDirection() {
        return direction;
    }

    /**
     * @param direction
     */
    public void setDirection(String direction) {
        this.direction = direction;
    }

    /**
     * @return knowledge_point_num
     */
    public Integer getKnowledgePointNum() {
        return knowledgePointNum;
    }

    /**
     * @param knowledgePointNum
     */
    public void setKnowledgePointNum(Integer knowledgePointNum) {
        this.knowledgePointNum = knowledgePointNum;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return level
     */
    public String getLevel() {
        return level;
    }

    /**
     * @param level
     */
    public void setLevel(String level) {
        this.level = level;
    }
}