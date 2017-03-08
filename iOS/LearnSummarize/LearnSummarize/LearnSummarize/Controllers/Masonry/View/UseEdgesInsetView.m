//
//  UseEdgesInsetView.m
//  LearnSummarize
//
//  Created by chenshun131 on 17/3/4.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "UseEdgesInsetView.h"

@implementation UseEdgesInsetView

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
        
        UIView *greenView = [[UIView alloc] init];
        greenView.backgroundColor = [UIColor greenColor];
        greenView.layer.borderWidth = 2;
        greenView.layer.borderColor = [[UIColor blackColor] CGColor];
        [self addSubview:greenView];
        
        [redView mas_remakeConstraints:^(MASConstraintMaker *make) {
            make.edges.equalTo(self).insets(UIEdgeInsetsMake(50, 50, 50, 50));
        }];
        [greenView mas_remakeConstraints:^(MASConstraintMaker *make) {
            make.edges.equalTo(redView).insets(UIEdgeInsetsMake(50, 50, 50, 50));
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
