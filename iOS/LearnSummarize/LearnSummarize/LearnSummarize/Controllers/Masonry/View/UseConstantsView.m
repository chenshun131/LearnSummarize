//
//  UseConstantsView.m
//  LearnSummarize
//
//  Created by chenshun131 on 17/3/4.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "UseConstantsView.h"

@implementation UseConstantsView

- (instancetype)init
{
    self = [super init];
    if (self)
    {
        UIView *redView = [[UIView alloc] init];
        redView.backgroundColor = [UIColor redColor];
        redView.layer.borderWidth = 5;
        redView.layer.borderColor = [[UIColor blackColor] CGColor];
        [self addSubview:redView];
        [redView mas_remakeConstraints:^(MASConstraintMaker *make) {
            make.top.equalTo(@30);
            make.left.equalTo(@30);
            make.right.equalTo(@-30);
            make.bottom.equalTo(@-30);
        }];
        
        
        UIView *greenView = [[UIView alloc] init];
        greenView.backgroundColor = [UIColor greenColor];
        greenView.layer.borderWidth = 5;
        greenView.layer.borderColor = [[UIColor blackColor] CGColor];
        [self addSubview:greenView];
        [greenView mas_remakeConstraints:^(MASConstraintMaker *make) {
            make.center.mas_equalTo(CGPointMake(0, 0));
            make.size.mas_equalTo(CGSizeMake(300, 200));
        }];
    }
    return self;
}

/*
// Only override drawRect: if you perform custom drawing.
// An empty implementation adversely affects performance during animation.
- (void)drawRect:(CGRect)rect {
    // Drawing code
}
*/

@end
