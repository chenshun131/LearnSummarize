//
//  BaseModel.m
//  LearnSummarize
//
//  Created by chenshun131 on 17/1/8.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "BaseModel.h"

@implementation BaseModel

- (instancetype)initWithDic:(NSDictionary *)dic
{
    if (self = [super init])
    {
        @try
        {
            [self setValuesForKeysWithDictionary:dic];
        }
        @catch (NSException *exception)
        {
            NSLog(@"后台键值映射错误");
        }
    }
    return self;
}

@end
