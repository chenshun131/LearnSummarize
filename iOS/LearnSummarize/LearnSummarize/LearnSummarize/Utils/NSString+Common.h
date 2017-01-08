//
//  NSString+Common.h
//  LearnSummarize
//
//  Created by chenshun131 on 17/1/8.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

@interface NSString (Common)

/**
 *  转换字符串成拼音
 *  不支持多音字
 *  @return 返回字符串对应的拼音
 */
- (NSString *)transformToPinyin;

/**
 *  是否为中文
 */
- (BOOL)isChinese;

/**
 * 判断字符串是否为空，该字符串如果是 nil NULL NSNull length＝＝0 则返回 YES
 */
- (BOOL) isBlankString;

/**
 * 判断是否为整形
 */
+ (BOOL)isPureInt:(NSString*)string;

/**
 * 判断是否为浮点形
 */
+ (BOOL)isPureFloat:(NSString*)string;

/**
 * 获取一个随机数
 */
+ (NSString *)getRandomStr;

/**
 * 获取 URL 指定参数对应值
 */
+ (NSString *) paramValueOfUrl:(NSString *) url withParam:(NSString *) param;

/**
 *  @param time target String
 *  @param timeSet target String Format,like yyyy-MM-dd HH:mm
 */
+ (NSString *)dealWithTime:(NSString *)time andTimeSet:(NSString *)timeSet;

/**
 *  在一个字符串里面设置不同的字体颜色
 */
+ (NSMutableAttributedString *)attributedStr:(NSString *)titleShowsString integer:(NSInteger)integerLenth startStringPoint:(NSInteger)startPoint attributeColor:(UIColor *)attributeColor;

#pragma mark - Validate
/**
 *  邮箱验证
 */
- (BOOL)isValidateEmail:(NSString *)email;

/**
 *  手机号码验证
 */
- (BOOL)isValidateMobile:(NSString *)mobile;

/**
 *  身份证号码验证
 */
- (BOOL)isValidateIDCard:(NSString *)identityCard;

/**
 *  车牌号验证
 */
- (BOOL)isValidateCarNo:(NSString *)carNo;

/**
 *  判断传入的价格小数点后面是否带有非零数字
 *
 *  @param price 价格
 *
 *  @return 是整数还是浮点数
 */
+ (NSString *) priceIsIntValue:(NSString *)price;

@end
