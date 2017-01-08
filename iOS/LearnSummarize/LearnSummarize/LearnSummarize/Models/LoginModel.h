//
//  LoginModel.h
//  LearnSummarize
//
//  Created by chenshun131 on 17/1/8.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "BaseModel.h"

@interface LoginModel : BaseModel

@property (nonatomic,copy) NSString *password;// 用户密码
@property (nonatomic,copy) NSString *phone;// 用户手机号

@end
