package com.chenshun.learnsummarize.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * User: chenshun <p />
 * Time: 16/10/13 16:53  <p />
 * Version: V1.0  <p />
 * Description: <ul>
 * <li>Auto copy databse form assets to /data/data/package_name/databases</li>
 * <li>You can use it like {@link SQLiteDatabase}, use
 * {@link #getWritableDatabase()} to create and/or open a database that will be
 * used for reading and writing. use {@link #getReadableDatabase()} to create
 * and/or open a database that will be used for reading only.</li>
 * </ul> <p />
 */
public final class AssetDatabaseOpenHelper
{
    private Context context;
    private String databaseName;

    public AssetDatabaseOpenHelper(Context context, String databaseName)
    {
        this.context = context;
        this.databaseName = databaseName;
    }

    /**
     * Create and/or open a database that will be used for reading and writing.
     *
     * @return SQLiteDatabase对象
     * @throws RuntimeException
     *         if cannot copy database from assets
     */
    public synchronized SQLiteDatabase getWritableDatabase()
    {
        File dbFile = context.getDatabasePath(databaseName);
        if (dbFile != null && !dbFile.exists())
        {
            try
            {
                copyDatabase(dbFile);
            }
            catch (IOException e)
            {
                throw new RuntimeException("Error creating source database", e);
            }
        }
        assert dbFile != null;
        return SQLiteDatabase.openDatabase(dbFile.getPath(), null, SQLiteDatabase.OPEN_READWRITE);
    }

    /**
     * Create and/or open a database that will be used for reading only.
     *
     * @return SQLiteDatabase对象
     * @throws RuntimeException
     *         if cannot copy database from assets
     */
    public synchronized SQLiteDatabase getReadableDatabase()
    {
        File dbFile = context.getDatabasePath(databaseName);
        if (dbFile != null && !dbFile.exists())
        {
            try
            {
                copyDatabase(dbFile);
            }
            catch (IOException e)
            {
                throw new RuntimeException("Error creating source database", e);
            }
        }
        return SQLiteDatabase.openDatabase(dbFile.getPath(), null, SQLiteDatabase.OPEN_READONLY);
    }

    /**
     * 获取数据库名称
     *
     * @return the database name
     */
    public String getDatabaseName()
    {
        return databaseName;
    }

    private void copyDatabase(File dbFile) throws IOException
    {
        InputStream stream = context.getAssets().open(databaseName);
        FileUtils.writeFile(dbFile, stream);
        stream.close();
    }
}

