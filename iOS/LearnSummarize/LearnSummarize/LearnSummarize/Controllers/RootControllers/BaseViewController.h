//
//  BaseViewController.h
//  LearnSummarize
//
//  Created by chenshun131 on 17/1/8.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "DropDownMenu.h"

@interface BaseViewController : UIViewController

#pragma mark - Menu
- (void)showDropDownMenu:(NSArray *__nonnull)titles andImages:(nullable NSArray *)images andBlock:(__nonnull SelectedAtIndex)block;

- (void)setRightImageMenu:(NSString *__nonnull)image action:(nullable SEL)action;

@end
