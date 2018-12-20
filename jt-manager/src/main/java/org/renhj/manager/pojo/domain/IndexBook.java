package org.renhj.manager.pojo.domain;

import javax.persistence.*;

@Table(name = "index_book")
public class IndexBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String level;

    private Integer time;

    @Column(name = "book_img")
    private String bookImg;

    private String direction;

    private String teacher;

    private Integer price;

    @Column(name = "student_num")
    private Integer studentNum;

    private Integer rate;

    @Column(name = "knowledge_point_num")
    private Integer knowledgePointNum;

    /**
     * 1 入门课程 2最新课程 3免费课程 推荐课程
     */
    private Integer status;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
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
     * @return rate
     */
    public Integer getRate() {
        return rate;
    }

    /**
     * @param rate
     */
    public void setRate(Integer rate) {
        this.rate = rate;
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
     * 获取1 入门课程 2最新课程 3免费课程 推荐课程
     *
     * @return status - 1 入门课程 2最新课程 3免费课程 推荐课程
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置1 入门课程 2最新课程 3免费课程 推荐课程
     *
     * @param status 1 入门课程 2最新课程 3免费课程 推荐课程
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}