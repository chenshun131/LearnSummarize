//
//  PageModel.m
//  LearnSummarize
//
//  Created by chenshun131 on 17/1/8.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "PageModel.h"

@implementation PageModel

+ (instancetype)defaultPage
{
    PageModel *page = [[self alloc] init];
    page.pageNo = 0;
    page.pageCount = page.pageNo + 1;
    return page;
}

- (instancetype)init
{
    if (self = [super init])
    {
        _pageSize = 20;
    }
    return self;
}

- (NSMutableDictionary *)nextPage
{
    if (_pageNo >= _pageCount)
    {
        return nil;
    }
    NSMutableDictionary *params = [NSMutableDictionary dictionaryWithCapacity:2];
    params[@"pageNo"] = @(_pageNo + 1);
    params[@"pageSize"] = @(_pageSize);
    return params;
}

@end
