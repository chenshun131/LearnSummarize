//
//  DropDownMenu.h
//  LearnSummarize
//
//  Created by chenshun131 on 17/1/20.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

typedef void(^SelectedAtIndex)(NSInteger index);

@interface DropDownMenu : UIView

@property (copy, nonatomic) SelectedAtIndex selectedAtIndex;

- (void)selectedAtIndex:(SelectedAtIndex)block;

- (instancetype)initWithWidth:(CGFloat)width images:(NSArray *)images titles:(NSArray *)titles;

- (void)showMenu;

@end
