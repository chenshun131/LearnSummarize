package com.chenshun.learnsummarize.ui.activity.realm.bean;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

/**
 * User: chenshun <p />
 * Time: 17/1/14 21:26 <p />
 * Version V1.0  <p />
 * Description: <p />
 */
@RealmClass
public class CountryBean extends RealmObject
{
    @PrimaryKey
    private String id;// set PrimaryKey by annotation
    private String name;
    private int population;
    private RealmList<UserBean> friends;
    @Ignore
    private float area;// not save this field

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getPopulation()
    {
        return population;
    }

    public void setPopulation(int population)
    {
        this.population = population;
    }

    public RealmList<UserBean> getFriends()
    {
        return friends;
    }

    public void setFriends(RealmList<UserBean> friends)
    {
        this.friends = friends;
    }

    public float getArea()
    {
        return area;
    }

    public void setArea(float area)
    {
        this.area = area;
    }
}
