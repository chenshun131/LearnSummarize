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

/*!
 * set right text
 */
- (void)setRightTextBtn:(NSString * _Nonnull)text action:(nullable SEL)action;

/*!
 * set View Round Border
 * @param borderColor border Color
 */
- (void)setBorderStyleWithView:(CGColorRef _Nonnull)borderColor withViews:(UIView * _Nonnull)view, ...;

/*!
 * limit word count of UITextField
 */
- (void)wordCountLimit:(UITextField * _Nonnull)tf withWordCount:(NSUInteger)count;

@end
