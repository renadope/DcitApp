package com.dcit_remake.comp3275_group_project;

import java.io.Serializable;

/**
 * Created by Renado_Paria on 4/6/2017 at 11:23 PM for DcitApp.
 */

class News implements Serializable
{
    private String mTitle;
    private String mUrlToImage;
    private String mContent;

    public News(String title, String urlToImage, String content)
    {
        mTitle = title;
        mUrlToImage = urlToImage;
        mContent = content;
    }

    public News()
    {

    }

    public String getTitle()
    {
        return mTitle;
    }

    public void setTitle(String title)
    {
        mTitle = title;
    }

    public String getUrlToImage()
    {
        return mUrlToImage;
    }

    public void setUrlToImage(String urlToImage)
    {
        mUrlToImage = urlToImage;
    }

    public String getContent()
    {
        return mContent;
    }

    public void setContent(String content)
    {
        mContent = content;
    }

    @Override
    public String toString()
    {
        return "News{" +
                "mTitle='" + mTitle + '\'' +
                ", mUrlToImage='" + mUrlToImage + '\'' +
                ", mContent='" + mContent + '\'' +
                '}';
    }
}
