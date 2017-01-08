//
//  LoginModel.m
//  LearnSummarize
//
//  Created by chenshun131 on 17/1/8.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "LoginModel.h"

@implementation LoginModel

- (void) encodeWithCoder: (NSCoder *)coder
{
    [coder encodeObject:self.password forKey:@"password"];
    [coder encodeObject:self.phone forKey:@"phone"];
}

- (id) initWithCoder: (NSCoder *) coder
{
    self.password = [[coder decodeObjectForKey:@"password"]copy];
    self.phone = [coder decodeObjectForKey:@"phone"];
    return self;
}

@end
