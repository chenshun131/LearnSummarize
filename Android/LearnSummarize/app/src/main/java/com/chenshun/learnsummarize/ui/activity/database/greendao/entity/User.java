package com.chenshun.learnsummarize.ui.activity.database.greendao.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;

/**
 * User: chenshun <p />
 * Time: 17/3/10 15:29 <p />
 * Version V1.0  <p />
 * Description: <p />
 */
@Entity
public class User
{
    @Id
    private Long id;
    private String name;
    @Transient
    private int tempUsageCount; // not persisted

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    @Generated(hash = 873297011)
    public User(Long id, String name)
    {
        this.id = id;
        this.name = name;
    }

    @Generated(hash = 586692638)
    public User()
    {
    }
}

