//
//  UIView+Extensions.m
//  LearnSummarize
//
//  Created by chenshun131 on 17/1/8.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "UIView+Extensions.h"

@implementation UIView (Convenience)

#pragma mark - 属性set方法
- (void)setX:(CGFloat)x
{
    CGRect frame      = self.frame;
    frame.origin.x    = x;
    self.frame        = frame;
}

- (void)setY:(CGFloat)y
{
    CGRect frame      = self.frame;
    frame.origin.y    = y;
    self.frame        = frame;
}

- (void)setOrigin:(CGPoint)origin
{
    CGRect frame      = self.frame;
    frame.origin      = origin;
    self.frame        = frame;
}

- (void)setWidth:(CGFloat)width
{
    CGRect frame      = self.frame;
    frame.size.width  = width;
    self.frame        = frame;
}

- (void)setHeight:(CGFloat)height
{
    CGRect frame      = self.frame;
    frame.size.height = height;
    self.frame        = frame;
}

- (void)setSize:(CGSize)size
{
    CGRect frame      = self.frame;
    frame.size        = size;
    self.frame        = frame;
}

- (void)setCenterX:(CGFloat)centerX
{
    CGPoint center    = self.center;
    center.x          = centerX;
    self.center       = center;
}

- (void)setCenterY:(CGFloat)centerY
{
    CGPoint center    = self.center;
    center.y          = centerY;
    self.center       = center;
}

#pragma mark - 属性get方法
- (CGFloat)x
{
    return self.frame.origin.x;
}

- (CGFloat)y
{
    return self.frame.origin.y;
}

- (CGPoint)origin
{
    return self.frame.origin;
}

- (CGFloat)width
{
    return self.frame.size.width;
}

- (CGFloat)height
{
    return self.frame.size.height;
}

- (CGSize)size
{
    return self.frame.size;
}

- (CGFloat)centerX
{
    return self.center.x;
}

- (CGFloat)centerY
{
    return self.center.y;
}

- (void)cornerRectWith:(UIRectCorner)rectCorner
{
    UIBezierPath *maskPath = [UIBezierPath bezierPathWithRoundedRect:self.bounds byRoundingCorners:rectCorner cornerRadii:CGSizeMake(5.f, 5.f)];
    CAShapeLayer *maskLayer = [[CAShapeLayer alloc] init];
    maskLayer.frame = self.bounds;
    maskLayer.path = maskPath.CGPath;
    self.layer.mask = maskLayer;
}

- (UIImage *)snapshoot
{
    UIGraphicsBeginImageContextWithOptions(self.size, NO, self.layer.contentsScale);//[UIScreen mainScreen].scale
    [self.layer renderInContext:UIGraphicsGetCurrentContext()];
    UIImage *snapshootImage = UIGraphicsGetImageFromCurrentImageContext();
    UIGraphicsEndImageContext();
    return snapshootImage;
}

@end
