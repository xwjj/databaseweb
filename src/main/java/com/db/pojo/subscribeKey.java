package com.db.pojo;

public class subscribeKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column subscribe.username
     *
     * @mbggenerated Sat Dec 10 21:27:11 CST 2022
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column subscribe.foodid
     *
     * @mbggenerated Sat Dec 10 21:27:11 CST 2022
     */
    private Integer foodid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column subscribe.quality
     *
     * @mbggenerated Sat Dec 10 21:27:11 CST 2022
     */
    private String quality;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column subscribe.username
     *
     * @return the value of subscribe.username
     *
     * @mbggenerated Sat Dec 10 21:27:11 CST 2022
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column subscribe.username
     *
     * @param username the value for subscribe.username
     *
     * @mbggenerated Sat Dec 10 21:27:11 CST 2022
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column subscribe.foodid
     *
     * @return the value of subscribe.foodid
     *
     * @mbggenerated Sat Dec 10 21:27:11 CST 2022
     */
    public Integer getFoodid() {
        return foodid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column subscribe.foodid
     *
     * @param foodid the value for subscribe.foodid
     *
     * @mbggenerated Sat Dec 10 21:27:11 CST 2022
     */
    public void setFoodid(Integer foodid) {
        this.foodid = foodid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column subscribe.quality
     *
     * @return the value of subscribe.quality
     *
     * @mbggenerated Sat Dec 10 21:27:11 CST 2022
     */
    public String getQuality() {
        return quality;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column subscribe.quality
     *
     * @param quality the value for subscribe.quality
     *
     * @mbggenerated Sat Dec 10 21:27:11 CST 2022
     */
    public void setQuality(String quality) {
        this.quality = quality == null ? null : quality.trim();
    }
}