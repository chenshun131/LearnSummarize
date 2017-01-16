package com.chenshun.learnsummarize.image;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;

import com.chenshun.learnsummarize.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.DisplayImageOptions.Builder;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

/**
 * User: chenshun <p />
 * Time: 16/11/17 16:38  <p />
 * Version: V1.0  <p />
 * Description: ImageLoader DisplayImageOption <p />
 */
public final class DisplayImageOption
{
    /**
     * Show Http Image Default Option<BR />
     * Tips: you can set showImageOnLoading, Call Build() At the last
     * <p/>
     * <ul>
     * <li>save cache in Memory,in other words, loaded image will be cached in memory</li>
     * <li>save cache in File,in other words, loaded image will be cached on disk</li>
     * <li>image aware view will be reset (set null) before image loading start</li>
     * <li>ImageLoader will consider EXIF parameters of JPEG image (rotate, flip)</li>
     * <li>set bitmapConfig for image decoding with RGB_565,this will help avoid OOM Exception</li>
     * </ul>
     * <p/>
     * <pre>
     * 比如：
     * DisplayImageOptions option = DisplayImageOption.getHttpBuilder().build();
     * mImageLoader.displayImage(url, mAvatarImg, option);
     *
     * <pre/>
     */
    public static Builder getHttpBuilder()
    {
        return new Builder().cacheInMemory(true).cacheOnDisk(true).resetViewBeforeLoading(true).considerExifParams(true).bitmapConfig(Config.RGB_565);
    }

    /**
     * Show Http Image Default Option<BR />
     * Tips: Call Build() At the last
     * <p/>
     * <pre>
     * 比如：
     * DisplayImageOptions option = DisplayImageOption
     *              .getHttpBuilder(R.drawable.contact_default)
     *              .displayer(new RoundedBitmapDisplayer(Constant.CORNER_RADIUS_PIXELS))
     *              .build();
     * </pre>
     *
     * @param defaultImageResourceID
     *         the Stub Image when loading,load failed or URI is null or empty string
     */
    public static Builder getHttpBuilder(int defaultImageResourceID)
    {
        return getHttpBuilder(defaultImageResourceID, defaultImageResourceID, defaultImageResourceID);
    }

    /**
     * Show Http Image Default Option<BR />
     * Tips: Call Build() At the last
     * <p/>
     * <ul>
     * <li>save cache in Memory,in other words, loaded image will be cached in memory</li>
     * <li>save cache in File,in other words, loaded image will be cached on disk</li>
     * <li>set bitmapConfig for image decoding with RGB_565,this will help avoid OOM Exception</li>
     * <li>image aware view will be reset (set null) before image loading start</li>
     * <li>ImageLoader will consider EXIF parameters of JPEG image (rotate, flip)</li>
     * </ul>
     *
     * @param loadingImageResourceID
     * @param failImageResourceID
     * @param emptyImageResourceID
     * @return
     */
    public static Builder getHttpBuilder(int loadingImageResourceID, int failImageResourceID, int emptyImageResourceID)
    {
        return new Builder().cacheInMemory(true).cacheOnDisk(true).bitmapConfig(Config.RGB_565).resetViewBeforeLoading(true).considerExifParams(true).showImageOnLoading(loadingImageResourceID)
                .showImageOnFail(failImageResourceID).showImageForEmptyUri(emptyImageResourceID);
    }

    /**
     * Show Http Image Default Option<BR />
     * Tips: Call Build() At the last
     *
     * @param defaultImageResourceID
     *         the Stub Image when loading,load failed or URI is null or empty string
     */
    public static Builder getHttpBuilder(int defaultImageResourceID, int cornerPercentage)
    {
        return getHttpBuilder(defaultImageResourceID, defaultImageResourceID, defaultImageResourceID, cornerPercentage);
    }

    /**
     * Show Http Image Default Option<BR />
     * Tips: Call Build() At the last
     * <p/>
     * <ul>
     * <li>save cache in Memory,in other words, loaded image will be cached in memory</li>
     * <li>save cache in File,in other words, loaded image will be cached on disk</li>
     * <li>set bitmapConfig for image decoding with RGB_565,this will help avoid OOM Exception</li>
     * <li>image aware view will be reset (set null) before image loading start</li>
     * <li>ImageLoader will consider EXIF parameters of JPEG image (rotate, flip)</li>
     * </ul>
     *
     * @param loadingImageResourceID
     * @param failImageResourceID
     * @param emptyImageResourceID
     * @param cornerPercentage
     *         corner radius pixels
     * @return
     */
    public static Builder getHttpBuilder(int loadingImageResourceID, int failImageResourceID, int emptyImageResourceID, int cornerPercentage)
    {
        return new Builder().cacheInMemory(true).cacheOnDisk(true).bitmapConfig(Config.RGB_565).resetViewBeforeLoading(true).considerExifParams(true).showImageOnLoading(loadingImageResourceID)
                .showImageOnFail(failImageResourceID).showImageForEmptyUri(emptyImageResourceID).displayer(new RoundedBitmapDisplayer(cornerPercentage));
    }

    /**
     * <ul>
     * <li>save cache in Memory,in other words, loaded image will be cached in memory</li>
     * <li>save cache in File,in other words, loaded image will be cached on disk</li>
     * <li>set bitmapConfig for image decoding with RGB_565,this will help avoid OOM Exception</li>
     * <li>Sets scale type for decoding image. This parameter is used while define scale size for decoding image to Bitmap</li>
     * </ul>
     *
     * @param defaultImageResourceID
     * @return
     */
    public static Builder getAvatarBuilder(int defaultImageResourceID)
    {
        return new Builder().cacheInMemory(true).cacheOnDisk(true).bitmapConfig(Config.RGB_565).imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2).showImageOnLoading(defaultImageResourceID)
                .showImageOnFail(defaultImageResourceID).showImageForEmptyUri(defaultImageResourceID);
    }

    /**
     * this won't save the web image in cache
     * <ul>
     * <li>save cache in Memory,in other words, loaded image will be cached in memory</li>
     * <li>save cache in File,in other words, loaded image will be cached on disk</li>
     * <li>set bitmapConfig for image decoding with RGB_565,this will help avoid OOM Exception</li>
     * <li>Sets scale type for decoding image. This parameter is used while define scale size for decoding image to Bitmap</li>
     * </ul>
     *
     * @param defaultImageResourceID
     * @param cornerPercentage
     *         corner radius pixels
     * @return
     */
    public static Builder getTempBuilder(int defaultImageResourceID, int cornerPercentage)
    {
        return new Builder().cacheInMemory(true).cacheOnDisk(true).bitmapConfig(Config.RGB_565).imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2).showImageOnLoading(defaultImageResourceID)
                .showImageOnFail(defaultImageResourceID).showImageForEmptyUri(defaultImageResourceID).displayer(new RoundedBitmapDisplayer(cornerPercentage));
    }

    /**
     * Show Local Image Default Option Tips: Call Build() At the last
     * <p/>
     * <ul>
     * <li>Don't save cache in Memory</li>
     * <li>Don't save cache in File</li>
     * <li>bitmapConfig RGB_565</li>
     * </ul>
     */
    public static Builder getLocalBuilder()
    {
        return new Builder().cacheInMemory(false).cacheOnDisk(false).considerExifParams(true).resetViewBeforeLoading(true).bitmapConfig(Config.RGB_565);
    }

    public static DisplayImageOptions getDisplayImageOptions()
    {
        BitmapFactory.Options decodingOptions = new BitmapFactory.Options();
        decodingOptions.inPreferredConfig = Config.RGB_565;
        decodingOptions.inSampleSize = 200;
        decodingOptions.inPreferredConfig = null;// 设置让解码器以最佳方式解码
        // 下面两个字段需要组合使用
        decodingOptions.inPurgeable = true;
        decodingOptions.inInputShareable = true;
        return new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.icon_loading)
                .showImageForEmptyUri(R.drawable.icon_load_fail)
                .showImageOnFail(R.drawable.icon_load_fail)
                .cacheInMemory(false)// 设置下载的图片是否缓存在内存中
                .cacheOnDisk(true)// 设置下载的图片是否缓存在SD卡中
                .resetViewBeforeLoading(true)// 设置图片在下载前是否重置，复位
                .considerExifParams(true)
                .imageScaleType(ImageScaleType.IN_SAMPLE_INT)// 设置图片以如何的编码方式显示
                .decodingOptions(decodingOptions)// 设置图片的解码配置
                .displayer(new FadeInBitmapDisplayer(200))// 是否图片加载好后渐入的动画时间
                .considerExifParams(true) // 是否考虑JPEG图像EXIF参数（旋转，翻转）
                .bitmapConfig(Bitmap.Config.RGB_565).build();
    }
}
