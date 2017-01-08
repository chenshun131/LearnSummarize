//
//  UIView+Extensions.h
//  LearnSummarize
//
//  Created by chenshun131 on 17/1/8.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

@interface UIView (Convenience)

@property (nonatomic, assign) CGFloat x;
@property (nonatomic, assign) CGFloat y;
@property (nonatomic, assign) CGFloat width;
@property (nonatomic, assign) CGFloat height;
@property (nonatomic, assign) CGPoint origin;
@property (nonatomic, assign) CGSize  size;
@property (nonatomic, assign) CGFloat centerX;
@property (nonatomic, assign) CGFloat centerY;

/**
 *  改变UIView制定几个角圆角
 */
- (void)cornerRectWith:(UIRectCorner)rectCorner;

/**
 *  获得当前视图的快照
 *
 *  @return 当前视图快照图片
 */
- (UIImage *)snapshoot;

@end
