package com.chenshun.learnsummarize.ui.activity.database.bean;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

/**
 * User: chenshun <p />
 * Time: 17/1/14 22:35 <p />
 * Version V1.0  <p />
 * Description: <p />
 */
@RealmClass
public class UserBean extends RealmObject
{
    @PrimaryKey
    private String id;
    private String name;
    private int age;
    private RealmList<UserBean> friends;

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

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public RealmList<UserBean> getFriends()
    {
        return friends;
    }

    public void setFriends(RealmList<UserBean> friends)
    {
        this.friends = friends;
    }
}
