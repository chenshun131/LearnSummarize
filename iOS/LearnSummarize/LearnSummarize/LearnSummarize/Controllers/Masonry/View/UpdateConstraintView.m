//
//  UpdateConstraintView.m
//  LearnSummarize
//
//  Created by chenshun131 on 17/3/4.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "UpdateConstraintView.h"

@interface UpdateConstraintView ()

@property (nonatomic, strong) UIButton *button;
@property (nonatomic, assign) CGSize buttonSize;

@end

@implementation UpdateConstraintView
{
    BOOL isBig;
}

- (instancetype)init
{
    self = [super init];
    if (self)
    {
        self.buttonSize = CGSizeMake(100, 100);
        
        self.button = [[UIButton alloc] init];
        [self.button addTarget:self action:@selector(tapButton:) forControlEvents:UIControlEventTouchUpInside];
        self.button.backgroundColor = [UIColor redColor];
        self.button.layer.borderWidth = 5;
        self.button.layer.borderColor = [[UIColor blackColor] CGColor];
        [self.button setTitle:@"约束更新" forState:UIControlStateNormal];
        [self addSubview:self.button];
    }
    return self;
}

// 添加这句话就会执行 updateConstraints方法，约束的 Layout 方式是 lazily 使用的。如果你在 -updateConstraints 中来初始化你的约束，
// 但是如果没有添加约束的话，系统就不会调用这个 -updateConstraints 接口
+ (BOOL)requiresConstraintBasedLayout
{
    return YES;
}

- (void)updateConstraints
{
    [super updateConstraints];
    [self.button mas_updateConstraints:^(MASConstraintMaker *make) {
        make.center.equalTo(self);
        make.size.mas_equalTo(self.buttonSize);
    }];
}

- (void)tapButton:(UIButton *)sender
{
    if(isBig)
    {
        self.buttonSize = CGSizeMake(300, 300);
    }
    else
    {
        self.buttonSize = CGSizeMake(100, 100);
    }
    isBig = !isBig;
    [self setNeedsUpdateConstraints];
    [self updateConstraintsIfNeeded];
    [UIView animateWithDuration:0.5 animations:^{
        [self layoutIfNeeded];
    }];
}

/*
// Only override drawRect: if you perform custom drawing.
// An empty implementation adversely affects performance during animation.
- (void)drawRect:(CGRect)rect {
    // Drawing code
}
*/

@end
