package com.db.pojo;

public class compstockKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column compstock.id
     *
     * @mbggenerated Fri Dec 09 10:36:56 CST 2022
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column compstock.quality
     *
     * @mbggenerated Fri Dec 09 10:36:56 CST 2022
     */
    private String quality;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column compstock.id
     *
     * @return the value of compstock.id
     *
     * @mbggenerated Fri Dec 09 10:36:56 CST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column compstock.id
     *
     * @param id the value for compstock.id
     *
     * @mbggenerated Fri Dec 09 10:36:56 CST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column compstock.quality
     *
     * @return the value of compstock.quality
     *
     * @mbggenerated Fri Dec 09 10:36:56 CST 2022
     */
    public String getQuality() {
        return quality;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column compstock.quality
     *
     * @param quality the value for compstock.quality
     *
     * @mbggenerated Fri Dec 09 10:36:56 CST 2022
     */
    public void setQuality(String quality) {
        this.quality = quality == null ? null : quality.trim();
    }
}