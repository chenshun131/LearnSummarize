//
//  UIImageView+Common.m
//  LearnSummarize
//
//  Created by chenshun131 on 17/1/8.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "UIImageView+Common.h"

@implementation UIImageView (BM)

/**
 *  通过url地址设置imageview的图片
 */
- (void)setImageWithUrl:(NSString *)url
{
    [self sd_setImageWithURL:[NSURL URLWithString:url]];
}

/**
 *  通过url地址设置imageview的图片
 *  @param url         图片url地址
 *  @param placeHolder 占位图片
 */
- (void)setImageWithUrl:(NSString *)url placeHolder:(NSString *)placeHolder
{
    [self sd_setImageWithURL:[NSURL URLWithString:url] placeholderImage:[UIImage imageNamed:placeHolder]];
}

/**
 * 显示网络图片，并对网络图片进行压缩
 */
+ (void)showWebImage:(UIImageView *)imageView withURL:(NSString *)imgURL
{
    __weak __typeof(&*imageView) weakImageView = imageView;
    [imageView sd_setImageWithURL:[NSURL URLWithString:imgURL] placeholderImage:[UIImage imageNamed:@"icon_load_fail"] options:SDWebImageRetryFailed|SDWebImageLowPriority|SDWebImageAvoidAutoSetImage  completed:^(UIImage *image, NSError *error, SDImageCacheType cacheType, NSURL *imageURL)
     {
         // 此处根据需要裁剪图片
         image = [UIImage imageWithData:[self zipImageWithImage:image]];
         
         dispatch_async(dispatch_get_main_queue(), ^{
             __typeof(&*weakImageView) strongImageView = weakImageView;
             if (strongImageView)
             {
                 strongImageView.image = image;
                 [strongImageView setNeedsLayout];
             }
         });
     }];
}

/**
 * 压图片质量
 *
 * @param image image
 * @return Data
 */
+ (NSData *)zipImageWithImage:(UIImage *)image
{
    if (!image)
    {
        return nil;
    }
    CGFloat maxFileSize = 32 * 1024;
    CGFloat compression = 0.9f;
    NSData *compressedData = UIImageJPEGRepresentation(image, compression);
    while ([compressedData length] > maxFileSize)
    {
        compression *= 0.9;
        compressedData = UIImageJPEGRepresentation([[self class] compressImage:image newWidth:image.size.width*compression], compression);
    }
    return compressedData;
}

/**
 * 等比缩放本图片大小
 *
 * @param newImageWidth 缩放后图片宽度，像素为单位
 *
 * @return self-->(image)
 */
+ (UIImage *)compressImage:(UIImage *)image newWidth:(CGFloat)newImageWidth
{
    if (!image) return nil;
    float imageWidth = image.size.width;
    float imageHeight = image.size.height;
    float width = newImageWidth;
    float height = image.size.height/(image.size.width/width);
    
    float widthScale = imageWidth /width;
    float heightScale = imageHeight /height;
    
    // 创建一个 bitmap 的 context 并把它设置成为当前正在使用的 context
    UIGraphicsBeginImageContext(CGSizeMake(width, height));
    if (widthScale > heightScale)
    {
        [image drawInRect:CGRectMake(0, 0, imageWidth / heightScale, height)];
    }
    else
    {
        [image drawInRect:CGRectMake(0, 0, width, imageHeight / widthScale)];
    }
    // 从当前 context 中创建一个改变大小后的图片
    UIImage *newImage = UIGraphicsGetImageFromCurrentImageContext();
    // 使当前的 context 出堆栈
    UIGraphicsEndImageContext();
    return newImage;
}

@end
