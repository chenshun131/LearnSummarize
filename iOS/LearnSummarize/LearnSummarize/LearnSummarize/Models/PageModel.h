//
//  PageModel.h
//  LearnSummarize
//
//  Created by chenshun131 on 17/1/8.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "BaseModel.h"

@interface PageModel : BaseModel

@property (nonatomic, assign) NSUInteger pageCount;
@property (nonatomic, assign) NSUInteger pageNo;
@property (nonatomic, assign) NSUInteger pageSize;
@property (nonatomic, assign) NSUInteger total;

/**
 *  生成一个默认的page对象，默认pageSize为15，pageNo为1;
 */
+ (instancetype)defaultPage;

- (NSMutableDictionary *)nextPage;

@end
