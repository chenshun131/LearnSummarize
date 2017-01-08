//
//  SysUtil.h
//  LearnSummarize
//
//  Created by chenshun131 on 17/1/8.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

@interface SysUtil : NSObject

/**
 *  是否新版本
 *
 *  @return YES:表示为新版本
 */
+ (BOOL)showNewFeature;

/**
 *  更新版本信息
 */
+ (void)updateFeatureVersion;

/**
 *  发送短信
 */
+ (void)sendMessageWithPhoneNum:(NSString *)phone;

/**
 *  拨打电话
 *  @param phone  电话号码
 */
+ (void)callWithPhoneNumber:(NSString *)phone;

/**
 *  拨打电话
 *
 *  @param phone  电话号码
 *  @param target 目标view
 */
+ (void)callWithPhoneNumber:(NSString *)phone target:(id)target;

/**
 *  获取一个字符串 返回字符自适应高度
 *
 *  @param str       目标string
 *  @param theFont   目标标签font 字体大小
 *  @param titleSize 获取目标 标签size
 *
 *  @return   返回的是 自适应标签内容的高度
 */
+ (float)getNSStringWidth:(NSString *)str font:(UIFont *)theFont TitleSize:(CGSize)titleSize;

/**
 *  获取指定宽度width的字符串在UITextView上的高度
 *
 *  @param textView 待计算的UITextView
 *  @param width 限制字符串显示区域的宽度
 *  @result float 返回的高度
 */
+ (float)heightForString:(UITextView *)textView andWidth:(float)width;

/**
 *  textView高度
 *
 *  @param value    内容
 *  @param fontSize 字体大小
 *  @param width    宽度
 *
 *  @return 高度
 */
+ (float) heightForString:(NSString *)value fontSize:(float)fontSize andWidth:(float)width;

/**
 *  手机号码验证
 *
 *  @param mobileNum 手机号码字符串
 *
 *  @return 是否正确
 */
+ (BOOL)isMobileNumber:(NSString *)mobileNum;

/**
 *  QQ号验证
 *
 *  @param textString QQ号字符串
 *
 *  @return 是否正确
 */
+ (BOOL)validateNumber:(NSString *) textString;

/**
 *  添加轮播图
 *
 *  @param time 每张图片切换时间
 *  @param target 代理
 *  @imageUrlArray urlArray URL数组
 */
+ (UIView *)createAdViewWithFrame:(CGRect)frame delayTime:(float)time target:(id)target imageUrlArray:(NSArray *)urlArray;

@end
