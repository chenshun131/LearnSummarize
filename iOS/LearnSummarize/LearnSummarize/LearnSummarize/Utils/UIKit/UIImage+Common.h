//
//  UIImage+Common.h
//  LearnSummarize
//
//  Created by chenshun131 on 17/1/8.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "BaseModel.h"

@interface UIImage (Common)

/**
 *  加载最原始的图片，没有渲染
 */
+ (instancetype)imageWithOriginalName:(NSString *)imageName;

/**
 *  拉伸一张图片
 */
+ (UIImage *)resizeImage:(NSString *)imgName;

/**
 *  将目标图片，转为需要的尺寸信息
 */
+(UIImage *)imageByScalingAndCroppingForSize:(CGSize)targetSize image:(UIImage*)image;

/**
 * create UIImage with UIColor
 */
+ (UIImage *)imageWithColor:(UIColor *)color;

/**
 * create target size UIImage with UIColor
 */
+ (UIImage *)imageWithColor:(UIColor *)color withSize:(CGSize)size;

- (UIImage *)fixOrientation;

@end
