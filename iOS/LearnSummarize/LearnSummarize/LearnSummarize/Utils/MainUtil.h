//
//  MainUtil.h
//  LearnSummarize
//
//  Created by chenshun131 on 17/1/8.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

@interface MainUtil : NSObject

/**
 * 根据 View 返回VC
 **/
+ (UIViewController *)viewController:(UIView *)view;


/**
 *  获得随机数
 *
 *  @param from 最小
 *  @param to   最大
 *
 *  @return 随机数
 */
+ (int)getRandomNumber:(int)from to:(int)to;

@end
