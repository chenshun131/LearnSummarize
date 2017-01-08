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

@end
