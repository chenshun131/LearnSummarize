package com.chenshun.learnsummarize.model;

/**
 * User: chenshun <p />
 * Time: 17/3/8 16:49  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class MovieModel
{
    public String name;
    public int length;
    public int price;
    public String content;

    public MovieModel(String name, int length, int price, String content)
    {
        this.length = length;
        this.name = name;
        this.price = price;
        this.content = content;
    }
}
