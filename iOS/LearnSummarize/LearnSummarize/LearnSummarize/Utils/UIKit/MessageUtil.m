//
//  MessageUtil.m
//  LearnSummarize
//
//  Created by chenshun131 on 17/1/8.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "MessageUtil.h"
#import <MBProgressHUD.h>

@implementation MessageUtil

/**
 * 屏幕上显示一个消息，需要调用hideMessage隐藏
 */
+ (void)showMessage:(NSString *)msg
{
    dispatch_async(dispatch_get_main_queue(), ^{
        MBProgressHUD *hud = [MBProgressHUD showHUDAddedTo:kWindow animated:YES];
        hud.labelText = [NSString stringWithFormat:@"\r\n%@", msg];
        Log(@"%@", hud.labelText);
    });
}

/**
 *  隐藏屏幕上的消息
 */
+ (void)hideMessage
{
    dispatch_async(dispatch_get_main_queue(), ^{
        [MBProgressHUD hideHUDForView:kWindow animated:NO];
    });
}

/**
 *  显示一个信息在指定时间后删除
 *
 *  @param msg   消息内容
 *  @param delay 显示的时间
 */
+ (void)showToast:(NSString *)msg delay:(NSUInteger)delay
{
    dispatch_async(dispatch_get_main_queue(), ^{
        MBProgressHUD *hud = [MBProgressHUD showHUDAddedTo:kWindow animated:YES];
        hud.labelText = msg;
        hud.mode = MBProgressHUDModeText;
        [hud hide:YES afterDelay:delay];
    });
}


@end
