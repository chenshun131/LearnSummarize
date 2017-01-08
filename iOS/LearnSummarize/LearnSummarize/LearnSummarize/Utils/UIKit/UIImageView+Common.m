//
//  UIImageView+Common.m
//  LearnSummarize
//
//  Created by chenshun131 on 17/1/8.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "UIImageView+Common.h"

@implementation UIImageView (BM)

- (void)setImageWithUrl:(NSString *)url
{
    [self sd_setImageWithURL:[NSURL URLWithString:url]];
}

- (void)setImageWithUrl:(NSString *)url placeHolder:(NSString *)placeHolder
{
    [self sd_setImageWithURL:[NSURL URLWithString:url] placeholderImage:[UIImage imageNamed:placeHolder]];
}

@end
