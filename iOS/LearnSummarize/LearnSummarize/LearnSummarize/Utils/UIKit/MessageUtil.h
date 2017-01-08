//
//  MessageUtil.h
//  LearnSummarize
//
//  Created by chenshun131 on 17/1/8.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

@interface MessageUtil : NSObject

/**
 *  屏幕上显示一个消息，需要调用hideMessage隐藏
 */
+ (void)showMessage:(NSString *)msg;

/**
 *  隐藏屏幕上的消息
 */
+ (void)hideMessage;

/**
 *  显示一个信息在指定时间后删除
 *
 *  @param msg   消息内容
 *  @param delay 显示的时间
 */
+ (void)showToast:(NSString *)msg delay:(NSUInteger)delay;

@end
