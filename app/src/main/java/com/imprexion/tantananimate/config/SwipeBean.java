package com.imprexion.tantananimate.config;

/**
 * @author : gongh
 * @date : 2020/3/20 14:09
 * @desc : TODO
 */
public class SwipeBean {
    private String url;
    private int number;

    public SwipeBean(int number, String url, String desc) {
        this.url = url;
        this.number = number;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    @Override
    public String toString() {
        return "SwipeBean{" +
                "url='" + url + '\'' +
                ", number=" + number +
                '}';
    }
}
