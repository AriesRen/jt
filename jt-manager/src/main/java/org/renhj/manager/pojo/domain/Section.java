package org.renhj.manager.pojo.domain;

import javax.persistence.*;

public class Section {
    @Id
    @Column(name = "section_id")
    private Integer sectionId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String duration;

    @Column(name = "is_free")
    private String isFree;

    @Column(name = "video_id")
    private String videoId;

    @Column(name = "book_id")
    private Integer bookId;

    /**
     * @return section_id
     */
    public Integer getSectionId() {
        return sectionId;
    }

    /**
     * @param sectionId
     */
    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
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
     * @return duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * @param duration
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * @return is_free
     */
    public String getIsFree() {
        return isFree;
    }

    /**
     * @param isFree
     */
    public void setIsFree(String isFree) {
        this.isFree = isFree;
    }

    /**
     * @return video_id
     */
    public String getVideoId() {
        return videoId;
    }

    /**
     * @param videoId
     */
    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

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
}