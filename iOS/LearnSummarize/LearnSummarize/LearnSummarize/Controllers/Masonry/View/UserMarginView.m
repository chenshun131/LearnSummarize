//
//  UserMarginView.m
//  LearnSummarize
//
//  Created by chenshun131 on 17/3/4.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "UserMarginView.h"

@implementation UserMarginView

- (instancetype)init
{
    self = [super init];
    if (self)
    {
        UIView *lastView = self;
        for (int i = 0; i < 20; i++) {
            UIView *view = UIView.new;
            view.backgroundColor = [self randomColor];
            view.layer.borderColor = UIColor.blackColor.CGColor;
            view.layer.borderWidth = 2;
            view.layoutMargins = UIEdgeInsetsMake(10, 5, 10, 5);
            [self addSubview:view];
            
            [view mas_makeConstraints:^(MASConstraintMaker *make) {
                make.top.equalTo(lastView.mas_topMargin);
                make.bottom.equalTo(lastView.mas_bottomMargin);
                make.left.equalTo(lastView.mas_leftMargin);
                make.right.equalTo(lastView.mas_rightMargin);
            }];
            
            lastView = view;
        }
    }
    return self;
}

- (UIColor *)randomColor
{
    CGFloat hue = ( arc4random() % 256 / 256.0 );  //  0.0 to 1.0
    CGFloat saturation = ( arc4random() % 128 / 256.0 ) + 0.5;  //  0.5 to 1.0, away from white
    CGFloat brightness = ( arc4random() % 128 / 256.0 ) + 0.5;  //  0.5 to 1.0, away from black
    return [UIColor colorWithHue:hue saturation:saturation brightness:brightness alpha:1];
}


/*
// Only override drawRect: if you perform custom drawing.
// An empty implementation adversely affects performance during animation.
- (void)drawRect:(CGRect)rect {
    // Drawing code
}
*/

@end
