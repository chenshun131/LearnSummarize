//
//  AccountTool.h
//  LearnSummarize
//
//  Created by chenshun131 on 17/1/8.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "BaseModel.h"
#import "LoginModel.h"

@interface AccountTool : NSObject

/**
 *  存储账号信息
 *  @param account 需要存储的账号
 */
+ (void)saveAccount:(LoginModel *)account;

/**
 *  返回存储的账号信息
 */
+ (LoginModel *)account;

//覆盖账号中的存储信息
+ (void)deleteAccount;

@end
