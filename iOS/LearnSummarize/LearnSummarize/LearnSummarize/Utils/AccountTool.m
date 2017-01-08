//
//  AccountTool.m
//  LearnSummarize
//
//  Created by chenshun131 on 17/1/8.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "AccountTool.h"

#define AccountFile [[NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, YES) lastObject] stringByAppendingPathComponent:@"account.data"]
#define AccountProductInstructFile [[NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, YES) lastObject] stringByAppendingPathComponent:@"accountInstuct.data"]

@implementation AccountTool

+ (void)saveAccount:(LoginModel *)account
{
    [NSKeyedArchiver archiveRootObject:account toFile:AccountFile];
}

+ (LoginModel *)account
{
    // 取出账号
    LoginModel *account = [NSKeyedUnarchiver unarchiveObjectWithFile:AccountFile];
    return account;
}

+ (void)deleteAccount
{
    [NSKeyedArchiver archiveRootObject:[[LoginModel alloc]init] toFile:AccountFile];
}

@end
