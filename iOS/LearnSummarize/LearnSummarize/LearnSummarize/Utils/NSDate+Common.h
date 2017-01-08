//
//  NSDate+Common.h
//  LearnSummarize
//
//  Created by chenshun131 on 17/1/8.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

@interface NSDate (Common)

- (id)dateFormatterWithFormat:(NSString *)dateFormat;

/**
 *  yyyy-MM-dd HH:mm:ss
 */
- (id)defaultDateFormatter;

/**
 *  get current Date NSString yyyy-MM-dd HH:mm:ss
 */
- (NSString *)defaultDateStr;

/**
 * 将时间字符串由 yyyy-MM-dd HH:mm 转换成 yyyy年MM月dd日 HH:mm
 */
- (NSString *) changeTimeFormat:(NSString *)dateString;

/**
 *  是否为今天
 */
- (BOOL)isToday;

/**
 *  是否为昨天
 */
- (BOOL)isYesterday;

/**
 *  是否为今年
 */
- (BOOL)isThisYear;

/**
 *  返回一个只有年月日的时间，格式为 yyyy-MM-dd
 */
- (NSDate *)dateWithYMD;

/**
 *  获得与当前时间的差距
 */
- (NSDateComponents *)deltaWithNow;

/**
 *  计算两个日期之间的天数
 *
 *  @return 两个日期之间的天数
 */
+ (NSInteger) calcDaysFromBegin:(NSDate *)beginDate end:(NSDate *)endDate;

/**
 *  根据格式获取当前日期
 *
 *  @param formatterStr 日期格式
 *
 *  @return 当前日期对应格式的字符串
 */
+ (NSString *)obtainNowDateWithFormatter:(NSString *)formatterStr;

/**
 *  将字符串根据格式转换为日期
 *
 *  @param str          要转换的时间
 *  @param formatterStr 日期格式
 *
 *  @return 转换后的日期
 */
+ (NSDate *)obtainNowDateWithStr:(NSString *)str formatter:(NSString *)formatterStr;

/**
 *  将时间转换成字符串
 *
 *  @param date         时间
 *  @param formatterStr 时间格式
 *
 *  @return 转换后的字符串
 */
+ (NSString *)obtainDateWithDate:(NSString *)date formatter:(NSString *)formatterStr;

/**
 *  获取当前周的周一
 *
 *  @return 当前周周一日期的字符串,格式为yyyy-MM-dd
 */
+ (NSString *)obtainMonday;

/**
 *  获取当前周几
 *
 *  @param date 时间
 *
 *  @return 周几的字符串
 */
+ (NSString *)obtainWeekDay:(NSDate *)date;

/**
 *  判断日期是不是在可输入范围内
 *
 *  @return 是否在可输入日期范围内
 */
+ (BOOL)date:(NSDate *)date;

@end
