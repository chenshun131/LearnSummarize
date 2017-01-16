package com.chenshun.learnsummarize.io;

/**
 * User: chenshun <p />
 * Time: 16/10/13 15:17  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public enum FileType
{
    Photo("Photo"), Video("Video"), Audio("Audio"), VCard("VCard"), Other("Other"), TEMP("Temp"), ZIP("ZIP"), LOG("Log");

    String subDirectory;

    FileType(String subDirectory)
    {
        this.subDirectory = subDirectory;
    }

    public String getSubDirectory()
    {
        return subDirectory;
    }
}
