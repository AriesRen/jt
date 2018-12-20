package org.renhj.manager.pojo.domain;

import javax.persistence.*;

@Table(name = "tb_book")
public class TbBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "book_num")
    private Integer bookNum;

    @Column(name = "video_num")
    private Integer videoNum;

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
     * @return book_num
     */
    public Integer getBookNum() {
        return bookNum;
    }

    /**
     * @param bookNum
     */
    public void setBookNum(Integer bookNum) {
        this.bookNum = bookNum;
    }

    /**
     * @return video_num
     */
    public Integer getVideoNum() {
        return videoNum;
    }

    /**
     * @param videoNum
     */
    public void setVideoNum(Integer videoNum) {
        this.videoNum = videoNum;
    }
}