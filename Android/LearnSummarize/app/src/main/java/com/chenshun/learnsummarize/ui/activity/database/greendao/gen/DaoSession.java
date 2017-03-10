package com.chenshun.learnsummarize.ui.activity.database.greendao.gen;

import com.chenshun.learnsummarize.ui.activity.database.greendao.entity.User;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import java.util.Map;

/**
 * User: chenshun <p />
 * Time: 17/3/10 15:33 <p />
 * Version V1.0  <p />
 * Description:  <p />
 */
public class DaoSession extends AbstractDaoSession
{
    private final DaoConfig userDaoConfig;
    private final UserDao userDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig> daoConfigMap)
    {
        super(db);
        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);
        userDao = new UserDao(userDaoConfig, this);
        registerDao(User.class, userDao);
    }

    public void clear()
    {
        userDaoConfig.getIdentityScope().clear();
    }

    public UserDao getUserDao()
    {
        return userDao;
    }

}

