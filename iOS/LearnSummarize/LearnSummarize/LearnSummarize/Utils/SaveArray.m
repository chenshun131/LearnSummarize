//
//  SaveArray.m
//  LearnSummarize
//
//  Created by chenshun131 on 17/1/8.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "SaveArray.h"

#define MsgFile [[NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, YES) lastObject] stringByAppendingPathComponent:@"myMessage.data"]

@implementation SaveArray

+(void)saveArrayWithArray:(NSMutableArray *)array
{
    [NSKeyedArchiver archiveRootObject:array toFile:MsgFile];
}

+(NSMutableArray *)getArray
{
    return [NSKeyedUnarchiver unarchiveObjectWithFile:MsgFile];
}

@end
