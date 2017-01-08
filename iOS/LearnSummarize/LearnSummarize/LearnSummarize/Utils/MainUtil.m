//
//  MainUtil.m
//  LearnSummarize
//
//  Created by chenshun131 on 17/1/8.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "MainUtil.h"

@implementation MainUtil

/**
 * 根据View返回VC
 *
 **/
+ (UIViewController *)viewController:(UIView *)view;
{
    for (UIView *next = [view superview]; next; next = next.superview)
    {
        UIResponder* nextResponder = [next nextResponder];
        if ([nextResponder isKindOfClass:[UIViewController class]])
        {
            return (UIViewController*)nextResponder;
        }
    }
    return nil;
}

/**
 *  获得随机数
 *
 *  @param from 最小
 *  @param to   最大
 *
 *  @return 随机数
 */
+ (int)getRandomNumber:(int)from to:(int)to
{
    return (int)(from + (arc4random() % (to - from + 1)));
}

@end
