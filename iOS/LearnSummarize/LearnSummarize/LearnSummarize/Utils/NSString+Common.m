//
//  NSString+Common.m
//  LearnSummarize
//
//  Created by chenshun131 on 17/1/8.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "NSString+Common.h"

@implementation NSString (Common)

/**
 *  转换字符串成拼音
 *  不支持多音字
 *  @return 返回字符串对应的拼音
 */
- (NSString *)transformToPinyin
{
    NSMutableString *mutableString = [NSMutableString stringWithString:self];
    CFStringTransform((CFMutableStringRef)mutableString, NULL, kCFStringTransformToLatin, false);
    mutableString = (NSMutableString *)[mutableString stringByFoldingWithOptions:NSDiacriticInsensitiveSearch locale:[NSLocale currentLocale]];
    return mutableString;
}

/**
 *  是否为中文
 */
- (BOOL)isChinese
{
    NSPredicate *predicate = [NSPredicate predicateWithFormat:@"SELF matches %@", @"(^[\u4e00-\u9fa5]+$)"];
    return [predicate evaluateWithObject:self];
}

/**
 * 判断字符串是否为空，该字符串如果是 nil NULL NSNull length＝＝0 则返回 YES
 */
- (BOOL) isBlankString
{
    if (self == nil || self == NULL)
    {
        return YES;
    }
    if ([self isKindOfClass:[NSNull class]])
    {
        return YES;
    }
    if ([[self stringByTrimmingCharactersInSet:[NSCharacterSet whitespaceCharacterSet]] length]==0)
    {
        return YES;
    }
    if([@"(null)" isEqualToString:self])
    {
        return YES;
    }
    return NO;
}

/**
 * 判断是否为整形
 */
+ (BOOL)isPureInt:(NSString*)string
{
    NSScanner* scan = [NSScanner scannerWithString:string];
    int val;
    return [scan scanInt:&val] && [scan isAtEnd];
}

/**
 * 判断是否为浮点形
 */
+ (BOOL)isPureFloat:(NSString*)string
{
    NSScanner* scan = [NSScanner scannerWithString:string];
    float val;
    return[scan scanFloat:&val] && [scan isAtEnd];
}

/**
 * 获取一个随机数
 */
+ (NSString *)getRandomStr
{
    NSDateFormatter *dateFormatter = [[NSDateFormatter alloc] init];
    [dateFormatter setDateFormat:@"yyyyMMddHHmmssSSS"];
    NSString *dateStr = [dateFormatter stringFromDate:[NSDate date]];
    return [NSString stringWithFormat:@"%@%i", dateStr, (arc4random() % 1000)];
}

/**
 * 获取 URL 指定参数对应值
 */
+ (NSString *) paramValueOfUrl:(NSString *) url withParam:(NSString *) param
{
    NSError *error;
    NSString *regTags = [[NSString alloc] initWithFormat:@"(^|&|\\?)+%@=+([^&]*)(&|$)", param];
    NSRegularExpression *regex = [NSRegularExpression regularExpressionWithPattern:regTags options:NSRegularExpressionCaseInsensitive error:&error];
    // 执行匹配的过程
    NSArray *matches = [regex matchesInString:url options:0 range:NSMakeRange(0, [url length])];
    for (NSTextCheckingResult *match in matches)
    {
        NSString *tagValue = [url substringWithRange:[match rangeAtIndex:2]];// 分组2所对应的串
        return tagValue;
    }
    return nil;
}

/**
 *  @param time target String
 *  @param timeSet target String Format,like yyyy-MM-dd HH:mm
 */
+ (NSString *)dealWithTime:(NSString *)time andTimeSet:(NSString *)timeSet
{
    //2015-11-4 14:25
    NSDateFormatter *formatter = [[NSDateFormatter alloc] init] ;
    [formatter setDateFormat:timeSet];
    NSDate *date = [formatter dateFromString:time];
    NSTimeInterval  timeInterval = [date timeIntervalSinceNow];
    timeInterval = -timeInterval;
    NSString *result;
    long temp = timeInterval / (24 * 3600);
    switch (temp)
    {
        case 1:
        case 2:
        {
            NSString *yesterDayOrTheDayBeforeYes;
            if (temp == 1)
            {
                yesterDayOrTheDayBeforeYes = @"昨天";
            }
            else
            {
                yesterDayOrTheDayBeforeYes = @"前天";
            }
            result = [NSString stringWithFormat:@"%@", yesterDayOrTheDayBeforeYes];
        }
            break;
        default:
            result = time;
            break;
    }
    return  result;
}

/**
 *  在一个字符串里面设置不同的字体颜色
 */
+ (NSMutableAttributedString *)attributedStr:(NSString *)titleShowsString integer:(NSInteger)integerLenth startStringPoint:(NSInteger)startPoint attributeColor:(UIColor *)attributeColor
{
    NSMutableAttributedString *str = [[NSMutableAttributedString alloc] initWithString:titleShowsString];
    [str addAttribute:NSForegroundColorAttributeName value:attributeColor range:NSMakeRange(startPoint, integerLenth)];
    [str addAttribute:NSFontAttributeName value:[UIFont fontWithName:@"Arial-BoldItalicMT" size:15.0] range:NSMakeRange(startPoint, integerLenth)];
    return str;
}

#pragma mark - Validate
/**
 *  邮箱验证
 */
- (BOOL)isValidateEmail:(NSString *)email
{
    NSString *emailRegex = @"[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}";
    NSPredicate *emailTest = [NSPredicate predicateWithFormat:@"SELF MATCHES %@", emailRegex];
    return [emailTest evaluateWithObject:email];
}

/**
 *  手机号码验证
 */
- (BOOL)isValidateMobile:(NSString *)mobile
{
    // 手机号以13， 15，18开头，八个 \d 数字字符
    NSString *phoneRegex = @"^((13[0-9])|(15[^4,\\D])|(18[0,0-9]))\\d{8}$";
    NSPredicate *phoneTest = [NSPredicate predicateWithFormat:@"SELF MATCHES %@", phoneRegex];
    return [phoneTest evaluateWithObject:mobile];
}

/**
 *  身份证号码验证
 */
- (BOOL)isValidateIDCard:(NSString *)identityCard
{
    if (identityCard.length <= 0)
    {
        return NO;
    }
    NSPredicate *identityCardPredicate = [NSPredicate predicateWithFormat:@"SELF MATCHES %@", @"^(\\d{14}|\\d{17})(\\d|[xX])$"];
    return [identityCardPredicate evaluateWithObject:identityCard];
}

/**
 *  车牌号验证
 */
- (BOOL)isValidateCarNo:(NSString *)carNo
{
    NSString *carRegex = @"^[A-Za-z]{1}[A-Za-z_0-9]{5}$";
    NSPredicate *carTest = [NSPredicate predicateWithFormat:@"SELF MATCHES %@", carRegex];
    return [carTest evaluateWithObject:carNo];
}

/**
 *  判断传入的价格小数点后面是否带有非零数字
 *
 *  @param price 价格
 *
 *  @return 是整数还是浮点数
 */
+ (NSString *) priceIsIntValue:(NSString *)price
{
    if (![price containsString:@"."])
    {
        return price;
    }
    NSArray *array = [price componentsSeparatedByCharactersInSet:[NSCharacterSet characterSetWithCharactersInString:@"."]];
    if (array.count == 1)
    {
        return price;
    }
    if (array.count == 2 && ([(NSString *)array[1] integerValue] > 0))
    {
        return [NSString stringWithFormat:@"%.2f",[price floatValue]];
    }
    else
    {
        return array[0];
    }
}

@end
