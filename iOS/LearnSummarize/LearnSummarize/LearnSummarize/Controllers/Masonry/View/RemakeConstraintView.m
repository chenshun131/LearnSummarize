//
//  RemakeConstraintView.m
//  LearnSummarize
//
//  Created by chenshun131 on 17/3/4.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "RemakeConstraintView.h"

@interface RemakeConstraintView ()

@property (nonatomic, strong) UIButton * button;
@property (nonatomic, assign) CGPoint buttonCenter;

@end

@implementation RemakeConstraintView
{
    NSUInteger type;
}

- (instancetype)init
{
    self = [super init];
    if (self)
    {
        type = 0;
        self.buttonCenter = CGPointMake(0, 0);
        
        self.button = [[UIButton alloc] init];
        [self.button addTarget:self action:@selector(tapButton:) forControlEvents:UIControlEventTouchUpInside];
        self.button.backgroundColor = [UIColor redColor];
        self.button.layer.borderWidth = 5;
        self.button.layer.borderColor = [[UIColor blackColor] CGColor];
        [self.button setTitle:@"重加约束" forState:UIControlStateNormal];
        [self addSubview:self.button];
    }
    return self;
}

+ (BOOL)requiresConstraintBasedLayout
{
    return YES;
}

- (void)updateConstraints
{
    [super updateConstraints];
    [self.button mas_remakeConstraints:^(MASConstraintMaker *make) {
        make.center.mas_equalTo(self.buttonCenter);
        make.size.mas_equalTo(CGSizeMake(100, 100));
    }];
}

- (void)tapButton:(UIButton *)sender
{
    if(type == 0)
    {
        self.buttonCenter = CGPointMake(0, 0);
        
    }
    else if(type == 1)
    {
        self.buttonCenter = CGPointMake(-100, -100);
    }
    else if(type == 2)
    {
        self.buttonCenter = CGPointMake(100, -100);
    }
    else if(type == 3)
    {
        self.buttonCenter = CGPointMake(-100, 100);
    }
    else if(type == 4)
    {
        self.buttonCenter = CGPointMake(100, 100);
    }
    type++;
    if(type > 5)
    {
        type = 0;
    }
    [self setNeedsUpdateConstraints];
    [self updateConstraintsIfNeeded];
    [UIView animateWithDuration:0.5 animations:^{
        [self layoutIfNeeded];
    }];
}

@end
