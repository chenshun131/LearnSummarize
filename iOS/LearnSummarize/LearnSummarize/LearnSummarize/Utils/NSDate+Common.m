//
//  NSDate+Common.m
//  LearnSummarize
//
//  Created by chenshun131 on 17/1/8.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "NSDate+Common.h"

@implementation NSDate (Common)

- (id)dateFormatterWithFormat:(NSString *)dateFormat
{
    NSDateFormatter *dateFormatter = [[NSDateFormatter alloc] init];
    dateFormatter.dateFormat = dateFormat;
    return dateFormatter;
}

/**
 *  yyyy-MM-dd HH:mm:ss
 */
- (id)defaultDateFormatter
{
    return [self dateFormatterWithFormat:@"yyyy-MM-dd HH:mm:ss"];
}

/**
 *  get current Date NSString yyyy-MM-dd HH:mm:ss
 */
- (NSString *)defaultDateStr
{
    return [[self defaultDateFormatter] stringFromDate:self];
}

/**
 * 将时间字符串由 yyyy-MM-dd HH:mm 转换成 yyyy年MM月dd日 HH:mm
 */
- (NSString *) changeTimeFormat:(NSString *)dateString
{
    if([dateString isBlankString])
    {
        return @"";
    }
    NSDateFormatter *dateFormatter = [[NSDateFormatter alloc] init];
    [dateFormatter setDateFormat:@"yyyy-MM-dd HH:mm"];
    NSDate *currentDate = [dateFormatter dateFromString:dateString];
    NSDateFormatter *targetFormatter = [[NSDateFormatter alloc] init];
    [targetFormatter setDateFormat:@"yyyy年MM月dd日 HH:mm"];
    return [targetFormatter stringFromDate:currentDate];
}

/**
 *  是否为今天
 */
- (BOOL)isToday
{
    NSCalendar *calendar = [NSCalendar currentCalendar];
    int unit = NSCalendarUnitDay | NSCalendarUnitMonth |  NSCalendarUnitYear;
    // 1.获得当前时间的年月日
    NSDateComponents *nowCmps = [calendar components:unit fromDate:[NSDate date]];
    // 2.获得self的年月日
    NSDateComponents *selfCmps = [calendar components:unit fromDate:self];
    return (selfCmps.year == nowCmps.year) && (selfCmps.month == nowCmps.month) && (selfCmps.day == nowCmps.day);
}

/**
 *  是否为昨天
 */
- (BOOL)isYesterday
{
    NSDate *nowDate = [[NSDate date] dateWithYMD];
    NSDate *selfDate = [self dateWithYMD];
    // 获得nowDate和selfDate的差距
    NSCalendar *calendar = [NSCalendar currentCalendar];
    NSDateComponents *cmps = [calendar components:NSCalendarUnitDay fromDate:selfDate toDate:nowDate options:0];
    return cmps.day == 1;
}

/**
 *  返回一个只有年月日的时间，格式为 yyyy-MM-dd
 */
- (NSDate *)dateWithYMD
{
    NSDateFormatter *fmt = [[NSDateFormatter alloc] init];
    fmt.dateFormat = @"yyyy-MM-dd";
    return [fmt dateFromString:[fmt stringFromDate:self]];
}

/**
 *  是否为今年
 */
- (BOOL)isThisYear
{
    NSCalendar *calendar = [NSCalendar currentCalendar];
    int unit = NSCalendarUnitYear;
    // 1.获得当前时间的年月日
    NSDateComponents *nowCmps = [calendar components:unit fromDate:[NSDate date]];
    // 2.获得self的年月日
    NSDateComponents *selfCmps = [calendar components:unit fromDate:self];
    return nowCmps.year == selfCmps.year;
}

/**
 *  获得与当前时间的差距
 */
- (NSDateComponents *)deltaWithNow
{
    NSCalendar *calendar = [NSCalendar currentCalendar];
    int unit = NSCalendarUnitHour | NSCalendarUnitMinute | NSCalendarUnitSecond;
    return [calendar components:unit fromDate:self toDate:[NSDate date] options:0];
}

/**
 *  计算两个日期之间的天数
 *
 *  @return 两个日期之间的天数
 */
+ (NSInteger) calcDaysFromBegin:(NSDate *)beginDate end:(NSDate *)endDate
{
    // 取两个日期对象的时间间隔：这里的NSTimeInterval 并不是对象，是基本型，其实是double类型，是由c定义的:typedef double NSTimeInterval;
    NSTimeInterval time = [endDate timeIntervalSinceDate:beginDate];
    int days = ((int)time) / (3600 * 24);
    return days;
}

/**
 *  根据格式获取当前日期
 *
 *  @param formatterStr 日期格式
 *
 *  @return 当前日期对应格式的字符串
 */
+ (NSString *)obtainNowDateWithFormatter:(NSString *)formatterStr
{
    NSDateFormatter *formatter = [[NSDateFormatter alloc] init];
    [formatter setDateFormat:formatterStr];
    return [formatter stringFromDate:[NSDate date]];
}

/**
 *  将字符串根据格式转换为日期
 *
 *  @param str          要转换的时间
 *  @param formatterStr 日期格式
 *
 *  @return 转换后的日期
 */
+ (NSDate *)obtainNowDateWithStr:(NSString *)str formatter:(NSString *)formatterStr
{
    if (!str || [str isEqualToString:@""])
    {
        return nil;
    }
    NSDateFormatter *formatter = [[NSDateFormatter alloc] init];
    [formatter setDateFormat:formatterStr];
    return [formatter dateFromString:str];
}

/**
 *  将时间转换成字符串
 *
 *  @param date         时间
 *  @param formatterStr 时间格式
 *
 *  @return 转换后的字符串
 */
+ (NSString *)obtainDateWithDate:(NSString *)date formatter:(NSString *)formatterStr
{
    NSDateFormatter *formatter = [[NSDateFormatter alloc] init];
    [formatter setDateFormat:formatterStr];
    return [formatter stringFromDate:[formatter dateFromString:date]];
}

/**
 *  获取当前周的周一
 *
 *  @return 当前周周一日期的字符串,格式为yyyy-MM-dd
 */
+ (NSString *)obtainMonday
{
    unsigned units = NSCalendarUnitMonth | NSCalendarUnitDay | NSCalendarUnitYear | NSCalendarUnitWeekday;
    NSCalendar *mycal = [[NSCalendar alloc] initWithCalendarIdentifier:NSCalendarIdentifierGregorian];
    NSDate *now = [NSDate date];
    
    NSCalendar *gregorian = [NSCalendar currentCalendar];
    NSInteger daycount;
    NSDateComponents *dateComps = [gregorian components:NSCalendarUnitWeekday fromDate:now];
    if ([dateComps weekday] == 1)
    {
        // 由于美国每周是从周日(周日：1，周一：2)开始，中国每周是从周一开始，需要特别转换
        daycount = 6;
    }
    else
    {
        daycount = [dateComps weekday] - 2;
    }
    NSDate *weekdaybegin = [now dateByAddingTimeInterval:-daycount * 60 * 60 * 24];
    NSDateFormatter *formatter = [[NSDateFormatter alloc] init];
    NSLocale *mylocal = [[NSLocale alloc] initWithLocaleIdentifier:@"zh_CN"];
    [formatter setLocale:mylocal];
    [formatter setDateFormat:@"yyyy-MM-dd"];
    now = weekdaybegin;
    NSDateComponents *comp = [mycal components:units fromDate:now];
    return [NSString stringWithFormat:@"%ld-%02ld-%02ld", (long)[comp year], (long)[comp month], (long)[comp day]];// 所要求的周一的日期
}

/**
 *  获取当前周几
 *
 *  @param date 时间
 *
 *  @return 周几的字符串
 */
+ (NSString *)obtainWeekDay:(NSDate *)date
{
    NSString *weekday;
    NSDateComponents *dateComps = [[NSCalendar currentCalendar] components:NSCalendarUnitWeekday fromDate:date];
    switch ([dateComps weekday])
    {
        case 1:
            weekday = @"星期日";
            break;
        case 2:
            weekday = @"星期一";
            break;
        case 3:
            weekday = @"星期二";
            break;
        case 4:
            weekday = @"星期三";
            break;
        case 5:
            weekday = @"星期四";
            break;
        case 6:
            weekday = @"星期五";
            break;
        case 7:
            weekday = @"星期六";
            break;
        default:
            weekday = @"星期日";
            break;
    }
    return weekday;
}

/**
 *  判断日期是不是在可输入范围内
 *
 *  @return 是否在可输入日期范围内
 */
+ (BOOL)date:(NSDate *)date
{
    // 取两个日期对象的时间间隔：这里的NSTimeInterval 并不是对象，是基本型，其实是double类型，是由c定义的:typedef double NSTimeInterval;
    NSTimeInterval time = [date timeIntervalSinceDate:[NSDate date]];
    int days = ((int)time) / (3600 * 24);
    if (days < 0)
    {
        return NO;
    }
    return YES;
}

@end
