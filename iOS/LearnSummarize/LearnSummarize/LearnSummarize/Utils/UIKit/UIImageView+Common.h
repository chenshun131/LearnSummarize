//
//  UIImageView+Common.h
//  LearnSummarize
//
//  Created by chenshun131 on 17/1/8.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

@interface UIImageView (Common)

/**
 *  通过url地址设置imageview的图片
 */
- (void)setImageWithUrl:(NSString *)url;

/**
 *  通过url地址设置imageview的图片
 *  @param url         图片url地址
 *  @param placeHolder 占位图片
 */
- (void)setImageWithUrl:(NSString *)url placeHolder:(NSString *)placeHolder;

/**
 * 显示网络图片，并对网络图片进行压缩
 */
+ (void)showWebImage:(UIImageView *)imageView withURL:(NSString *)imgURL;

/**
 * 压图片质量
 *
 * @param image image
 * @return Data
 */
+ (NSData *)zipImageWithImage:(UIImage *)image;

/**
 * 等比缩放本图片大小
 *
 * @param newImageWidth 缩放后图片宽度，像素为单位
 *
 * @return self-->(image)
 */
+ (UIImage *)compressImage:(UIImage *)image newWidth:(CGFloat)newImageWidth;

@end
