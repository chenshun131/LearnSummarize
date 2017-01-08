//
//  ScrollAdView.h
//  LearnSummarize
//
//  Created by chenshun131 on 17/1/8.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "JScrollView+PageControl+AutoScroll.h"

@interface ScrollAdView : UIView

- (instancetype)initAdViewWithFrame:(CGRect)frame delayTime:(float)time target:(id)target imageUrlArray:(NSArray *)urlArray pageIndicatorTintColor:(UIColor *)color;

@end
