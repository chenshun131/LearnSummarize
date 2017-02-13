//
//  Common.h
//  LearnSummarize
//
//  Created by chenshun131 on 17/1/8.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#ifndef Common_h
#define Common_h

// 设置字体
#define SystemFont(s) [UIFont fontWithName:@"Avenir-Light" size:s]


// 定义本地的数据库和缓存文件位置
#define kDocumentFolder [NSHomeDirectory() stringByAppendingPathComponent:@"Library/Caches"] // 缓存目录
#define kTempFolder [NSHomeDirectory() stringByAppendingPathComponent:@"tmp"] // 临时目录


// 本地数据库名称
#define DATABASE_LOCAL_NAME @"LearnSummarize.db"


// RGB
#define RGBA(r, g, b, a) [UIColor colorWithRed:r/255.0f green:g/255.0f blue:b/255.0f alpha:a]
#define RGB(r, g, b) RGBA(r, g, b, 1.0f)
#define ColorWithHex(hexValue) [UIColor colorWithRed:((float)((hexValue & 0xFF0000) >> 16)) / 255.0 green:((float)((hexValue & 0xFF00) >> 8)) / 255.0 blue:((float)(hexValue & 0xFF)) / 255.0 alpha:1.0f]
#define RandomColor RGB(arc4random_uniform(256), arc4random_uniform(256), arc4random_uniform(256))


// 全局颜色
#define Color_Theme RGB(114, 230, 200) // 标题栏背景色
#define LightGrey @"0xD3D3D3"
#define TextGray @"0xECEEEE"
#define TextBlack @"0x333333"
#define TextLightBlack @"0x555555"
#define LightBlue @"0x53C5E7"
#define SeperatGray @"0xEFEFEF"
#define CheckRed @"0xFE352A"

// 日志控制
#ifdef DEBUG
#define Log(format, ...) NSLog(@"DEBUG MESSAGE:\n%s第%d行：" format, __func__, __LINE__, ##__VA_ARGS__)
#else
#define Log(...)
#endif


// 屏幕宽高
#define kScreenHeight [UIScreen mainScreen].bounds.size.height // 获取设备的物理高度
#define kScreenWidth [UIScreen mainScreen].bounds.size.width // 获取设备的物理宽度


// window
#define kWindow [UIApplication sharedApplication].keyWindow


// 系统版本
#define SYSTEM_VERSION [[UIDevice currentDevice].systemVersion floatValue]


#endif /* Common_h */
