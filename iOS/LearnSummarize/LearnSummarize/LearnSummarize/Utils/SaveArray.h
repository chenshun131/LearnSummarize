//
//  SaveArray.h
//  LearnSummarize
//
//  Created by chenshun131 on 17/1/8.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

@interface SaveArray : NSObject

/**
 *  保存数组到沙盒中
 *
 *  @param array 要保存的内容
 */
+ (void)saveArrayWithArray:(NSMutableArray *)array;

/**
 *  获取沙盒中的数组内容
 *
 *  @return 返回获取的内容
 */
+ (NSMutableArray *)getArray;

@end
