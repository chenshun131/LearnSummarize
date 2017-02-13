//
//  ScanQrcodeViewController.h
//  LearnSummarize
//
//  Created by chenshun131 on 17/1/8.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "BaseViewController.h"

@protocol ScanQrcodeValueDelegate <NSObject>

- (void)passScanQrcodeValue:(NSString *)value;

@end

@interface ScanQrcodeViewController : BaseViewController

// 这里用assign而不用retain是为了防止引起循环引用。
@property(nonatomic, weak) NSObject<ScanQrcodeValueDelegate> *delegate;

@end
