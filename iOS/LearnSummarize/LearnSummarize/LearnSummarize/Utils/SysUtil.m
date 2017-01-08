//
//  SysUtil.m
//  LearnSummarize
//
//  Created by chenshun131 on 17/1/8.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "SysUtil.h"
#import "JScrollView+PageControl+AutoScroll.h"

@implementation SysUtil

/**
 *  是否新版本
 *
 *  @return YES:表示为新版本
 */
+ (BOOL)showNewFeature
{
    NSString *previewFeatureVersion = [[NSUserDefaults standardUserDefaults] stringForKey:@"previewFeatureVersion"];
    if (![previewFeatureVersion isBlankString])
    {
        return YES;
    }
    NSString *version = [NSBundle mainBundle].infoDictionary[(__bridge NSString *)kCFBundleVersionKey];
    if ([previewFeatureVersion isEqualToString:version])
    {
        return NO;
    }
    return YES;
}

/**
 *  更新版本信息
 */
+ (void)updateFeatureVersion
{
    NSString *version = [NSBundle mainBundle].infoDictionary[(__bridge NSString *)kCFBundleVersionKey];
    NSUserDefaults *userDefaults = [NSUserDefaults standardUserDefaults];
    [userDefaults setObject:version forKey:@"previewFeatureVersion"];
    [userDefaults synchronize];
}

/**
 *  发送短信
 */
+ (void)sendMessageWithPhoneNum:(NSString *)phone
{
    NSURL *url = [NSURL URLWithString:[NSString stringWithFormat:@"telprompt://%@", phone]];
    [[UIApplication sharedApplication] openURL:url];
}

/**
 *  拨打电话
 *  @param phone  电话号码
 */
+ (void)callWithPhoneNumber:(NSString *)phone
{
    NSURL *url = [NSURL URLWithString:[NSString stringWithFormat:@"telprompt://%@", phone]];
    [[UIApplication sharedApplication] openURL:url];
}

/**
 *  拨打电话
 *
 *  @param phone  电话号码
 *  @param target 目标view
 */
+ (void)callWithPhoneNumber:(NSString *)phone target:(id)target
{
    UIWebView *callWebview;
    if (!callWebview) {
        callWebview = [[UIWebView alloc] init];
    }
    
    NSURL *telURL =[NSURL URLWithString:[NSString stringWithFormat:@"tel:%@",phone]];
    [callWebview loadRequest:[NSURLRequest requestWithURL:telURL]];
    //记得添加到view上
    [target addSubview:callWebview];
}

/**
 *  获取一个字符串 返回字符自适应高度
 *
 *  @param str       目标string
 *  @param theFont   目标标签font 字体大小
 *  @param titleSize 获取目标 标签size
 *
 *  @return   返回的是 自适应标签内容的高度
 */
+ (float)getNSStringWidth:(NSString *)str font:(UIFont *)theFont TitleSize:(CGSize)titleSize{
    
    NSDictionary *attributesDict   =@{NSFontAttributeName:theFont};
    CGRect  rect   = [str boundingRectWithSize:titleSize options:NSStringDrawingUsesLineFragmentOrigin | NSStringDrawingTruncatesLastVisibleLine attributes:attributesDict context:nil];
    return rect.size.height + 10;
}

/**
 *  获取指定宽度width的字符串在UITextView上的高度
 *
 *  @param textView 待计算的UITextView
 *  @param width 限制字符串显示区域的宽度
 *  @result float 返回的高度
 */
+ (float)heightForString:(UITextView *)textView andWidth:(float)width
{
    return [textView sizeThatFits:CGSizeMake(width, MAXFLOAT)].height;
}

/**
 *  textView高度
 *
 *  @param value    内容
 *  @param fontSize 字体大小
 *  @param width    宽度
 *
 *  @return 高度
 */
+ (float) heightForString:(NSString *)value fontSize:(float)fontSize andWidth:(float)width
{
    UITextView *detailTextView = [[UITextView alloc] initWithFrame:CGRectMake(0, 0, width, 0)];
    detailTextView.font = [UIFont systemFontOfSize:fontSize];
    detailTextView.text = value;
    CGSize deSize = [detailTextView sizeThatFits:CGSizeMake(width, CGFLOAT_MAX)];
    return deSize.height;
}

/**
 *  手机号码验证
 *
 *  @param mobileNum 手机号码字符串
 *
 *  @return 是否正确
 */
+ (BOOL)isMobileNumber:(NSString *)mobileNum
{
    if (mobileNum.length != 11)
    {
        return NO;
    }
    /**
     * 手机号码:
     * 13[0-9], 14[5,7], 15[0, 1, 2, 3, 5, 6, 7, 8, 9], 17[6, 7, 8], 18[0-9], 170[0-9]
     * 移动号段: 134,135,136,137,138,139,150,151,152,157,158,159,182,183,184,187,188,147,178,1705
     * 联通号段: 130,131,132,155,156,185,186,145,176,1709
     * 电信号段: 133,153,180,181,189,177,1700
     */
    NSString *MOBILE = @"^1(3[0-9]|4[57]|5[0-35-9]|8[0-9]|70)\\d{8}$";
    /**
     * 中国移动：China Mobile
     * 134,135,136,137,138,139,150,151,152,157,158,159,182,183,184,187,188,147,178,1705
     */
    NSString *CM = @"(^1(3[4-9]|4[7]|5[0-27-9]|7[8]|8[2-478])\\d{8}$)|(^1705\\d{7}$)";
    /**
     * 中国联通：China Unicom
     * 130,131,132,155,156,185,186,145,176,1709
     */
    NSString *CU = @"(^1(3[0-2]|4[5]|5[56]|7[6]|8[56])\\d{8}$)|(^1709\\d{7}$)";
    /**
     * 中国电信：China Telecom
     * 133,153,180,181,189,177,1700
     */
    NSString *CT = @"(^1(33|53|77|8[019])\\d{8}$)|(^1700\\d{7}$)";
    
    NSPredicate *regextestmobile = [NSPredicate predicateWithFormat:@"SELF MATCHES %@", MOBILE];
    NSPredicate *regextestcm = [NSPredicate predicateWithFormat:@"SELF MATCHES %@", CM];
    NSPredicate *regextestcu = [NSPredicate predicateWithFormat:@"SELF MATCHES %@", CU];
    NSPredicate *regextestct = [NSPredicate predicateWithFormat:@"SELF MATCHES %@", CT];
    
    if (([regextestmobile evaluateWithObject:mobileNum] == YES)
        || ([regextestcm evaluateWithObject:mobileNum] == YES)
        || ([regextestct evaluateWithObject:mobileNum] == YES)
        || ([regextestcu evaluateWithObject:mobileNum] == YES))
    {
        return YES;
    }
    else
    {
        return NO;
    }
}

/**
 *  QQ号验证
 *
 *  @param textString QQ号字符串
 *
 *  @return 是否正确
 */
+ (BOOL)validateNumber:(NSString *) textString
{
    NSString* number = @"[1-9][0-9]\{4,11}";
    NSPredicate *numberPre = [NSPredicate predicateWithFormat:@"SELF MATCHES %@",number];
    return [numberPre evaluateWithObject:textString];
}

/**
 *  添加轮播图
 *
 *  @param time 每张图片切换时间
 *  @param target 代理
 *  @imageUrlArray urlArray URL数组
 */
+(UIView *)createAdViewWithFrame:(CGRect)frame delayTime:(float)time target:(id)target imageUrlArray:(NSArray *)urlArray
{
    JScrollView_PageControl_AutoScroll *scrollView = [[JScrollView_PageControl_AutoScroll alloc]initWithFrame:frame];
    
    scrollView.isShowTimerDelay = YES;
    NSMutableArray *tempArray = [NSMutableArray array];
    for (int i = 0; i < urlArray.count; i++)
    {
        UIImageView *imageView = [[UIImageView alloc]init];
        imageView.clipsToBounds = YES;
        imageView.contentMode = UIViewContentModeScaleAspectFill;
        [imageView setImageWithUrl:urlArray[i] placeHolder:@"home_ad"];
        [tempArray addObject:imageView];
    }
    
    scrollView.autoScrollDelayTime = time;
    scrollView.delegate = target;
    [scrollView setViewsArray:tempArray];
    [scrollView shouldAutoShow:YES];
    [scrollView.pageControl setCurrentPageIndicatorTintColor:[UIColor colorWithRed:(1)/255.f green:(160)/255.f blue:(211)/255.f alpha:1.f]];
    return (UIView *)scrollView;
}

@end
