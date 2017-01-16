package com.chenshun.learnsummarize.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.chenshun.learnsummarize.R;
import com.chenshun.learnsummarize.util.Logs;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;

/**
 * User: chenshun <p />
 * Time: 16/11/17 16:43  <p />
 * Version: V1.0  <p />
 * Description:  Can display bitmap with rounded corners. This implementation works only with ImageViews wrapped in ImageViewAware.
 * <p/>
 * <p>
 * Laotian fixed center scale bug exists in the original ImageLoader RoundedBitmapDisplayer<BR />
 * <p>
 * If ImageView scaleType="centerCrop" , then the roundImage will be centerCrop<BR />
 * If ImageView scaleType="fitXY", then the roundImage will show as fitXY。
 * <p>
 * <br />
 */
public class RoundedBitmapDisplayer implements BitmapDisplayer
{
    protected final int cornerPercentage;
    protected int maxWidth;
    protected int maxHeight;

    public RoundedBitmapDisplayer(int cornerPercentage)
    {
        this.cornerPercentage = cornerPercentage;
    }

    @Override
    public void display(Bitmap bitmap, ImageAware imageAware, LoadedFrom loadedFrom)
    {
        if (!(imageAware instanceof ImageViewAware))
        {
            throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
        }
        Context context = null;
        View v = imageAware.getWrappedView();
        if (null != v)
        {
            context = v.getContext();
        }
        int maxSize = 320;
        if (null != context)
        {
            maxSize = context.getResources().getDimensionPixelOffset(R.dimen.chat_img_max_size);
            Logs.d("RoundedBitmapDisplayer", "maxSize = " + maxSize);
        }
        boolean cropCenter = false;
        if (imageAware.getScaleType() == ViewScaleType.CROP)
        {
            cropCenter = true;
        }
        if (cropCenter)
        {
            RoundedAvartarDrawable drawable = new RoundedAvartarDrawable(bitmap, cornerPercentage);
            imageAware.setImageDrawable(drawable);
        }
        else
        {
            RoundedAutoSizeDrawable drawable = new RoundedAutoSizeDrawable(bitmap, cornerPercentage, maxSize, maxSize);
            imageAware.setImageDrawable(drawable);
        }
    }

    /**
     * Rounded Corner For Solid Size Square who's scale type is set to be "cropCenter"<BR />
     * for example Avartar
     *
     * @author root
     */
    public static class RoundedAvartarDrawable extends Drawable
    {
        protected final int size;
        protected final Paint paint;
        protected final BitmapShader bitmapShader;
        protected RectF mRect, mBitmapRect;
        protected final int cornerSize;

        public RoundedAvartarDrawable(Bitmap bitmap, int cornerSize)
        {
            if (cornerSize < 0)
            {
                throw new IllegalArgumentException("cornerSize must >=0");
            }
            this.cornerSize = cornerSize;
            int bitmapWidth = bitmap.getWidth();
            int bitmapHeight = bitmap.getHeight();
            this.size = Math.min(bitmapWidth, bitmapHeight);
            // Resize the original bitmap to fit the new bound
            Matrix shaderMatrix = new Matrix();
            if (bitmapHeight < bitmapWidth)
            {
                int left = (bitmapWidth - bitmapHeight) / 2;
                int right = (bitmapWidth + bitmapHeight) / 2;
                mBitmapRect = new RectF(left, 0, right, bitmapHeight);
            }
            else
            {
                int top = (bitmapHeight - bitmapWidth) / 2;
                int bottom = (bitmapWidth + bitmapHeight) / 2;
                mBitmapRect = new RectF(0, top, bitmapWidth, bottom);
            }
            mRect = new RectF(0, 0, size, size);
            shaderMatrix.setRectToRect(mBitmapRect, mRect, Matrix.ScaleToFit.FILL);
            bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            bitmapShader.setLocalMatrix(shaderMatrix);
            paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL);
            paint.setShader(bitmapShader);
        }

        @Override
        public int getIntrinsicWidth()
        {
            return size;
        }

        @Override
        public int getIntrinsicHeight()
        {
            return size;
        }

        @Override
        public void draw(Canvas canvas)
        {
            int corner = cornerSize * size / 100;
            canvas.drawRoundRect(mRect, corner, corner, paint);
        }

        @Override
        public int getOpacity()
        {
            return PixelFormat.TRANSLUCENT;
        }

        @Override
        public void setAlpha(int alpha)
        {
            paint.setAlpha(alpha);
        }

        @Override
        public void setColorFilter(ColorFilter cf)
        {
            paint.setColorFilter(cf);
        }
    }

    /**
     * Designed for AutoSize Bitmap in QIXIN ComposeMessageActivity <Br />
     * WRAP_CONTENT IMAGEVIEW with maxWith and maxHeight;
     *
     * @author laotian
     */
    public static class RoundedAutoSizeDrawable extends Drawable
    {
        protected final float cornerRadius;
        protected RectF mRect = new RectF(), mBitmapRect;
        protected final BitmapShader bitmapShader;
        protected final Paint paint;
        protected float bitmapWidth;
        protected float bitmapHeight;
        final float maxWidth;
        final float maxHeight;
        float scale = 1;

        public RoundedAutoSizeDrawable(Bitmap bitmap, int cornerRadius, int maxWidth, int maxHeight)
        {
            this.cornerRadius = cornerRadius;
            this.maxWidth = maxWidth;
            this.maxHeight = maxHeight;
            bitmapWidth = bitmap.getWidth();
            bitmapHeight = bitmap.getHeight();
            if (bitmapWidth > maxWidth || bitmapHeight > maxHeight)
            {
                float w = bitmapWidth / maxWidth;
                float h = bitmapHeight / maxHeight;
                scale = Math.max(w, h);
                bitmapWidth = bitmapWidth / scale;
                bitmapHeight = bitmapHeight / scale;
            }
            bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            mBitmapRect = new RectF(0, 0, bitmapWidth, bitmapHeight);
            paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL);
            paint.setShader(bitmapShader);
        }

        @Override
        public int getIntrinsicWidth()
        {
            return (int) bitmapWidth;
        }

        @Override
        public int getIntrinsicHeight()
        {
            return (int) bitmapHeight;
        }

        @Override
        protected void onBoundsChange(Rect bounds)
        {
            super.onBoundsChange(bounds);
            mRect.set(0, 0, bounds.width(), bounds.height());
            // Resize the original bitmap to fit the new bound
            Matrix shaderMatrix = new Matrix();
            // bitmapShader.getLocalMatrix(shaderMatrix);
            shaderMatrix.setRectToRect(mBitmapRect, mRect, Matrix.ScaleToFit.FILL);
            shaderMatrix.setScale(1 / scale, 1 / scale);
            bitmapShader.setLocalMatrix(shaderMatrix);
            paint.setShader(bitmapShader);
        }

        @Override
        public void draw(Canvas canvas)
        {
            float min = Math.min(bitmapWidth, bitmapHeight);
            float corner = cornerRadius * min / 100;
            canvas.drawRoundRect(mBitmapRect, corner, corner, paint);
        }

        @Override
        public int getOpacity()
        {
            return PixelFormat.TRANSLUCENT;
        }

        @Override
        public void setAlpha(int alpha)
        {
            paint.setAlpha(alpha);
        }

        @Override
        public void setColorFilter(ColorFilter cf)
        {
            paint.setColorFilter(cf);
        }
    }
}

