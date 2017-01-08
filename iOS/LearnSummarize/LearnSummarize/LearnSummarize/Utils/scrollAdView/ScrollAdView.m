//
//  ScrollAdView.m
//  LearnSummarize
//
//  Created by chenshun131 on 17/1/8.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "ScrollAdView.h"

@interface ScrollAdView ()<JScrollViewViewDelegate>

@property(nonatomic,strong) JScrollView_PageControl_AutoScroll *scrollView;

@end

@implementation ScrollAdView

- (instancetype)initAdViewWithFrame:(CGRect)frame delayTime:(float)time target:(id)target imageUrlArray:(NSArray *)urlArray pageIndicatorTintColor:(UIColor *)color
{
    self = [super initWithFrame:frame];
    if (self)
    {
        [self createAdViewWithFrame:frame delayTime:time target:target imageUrlArray:urlArray pageIndicatorTintColor:color];
    }
    return self;
}

-(void)createAdViewWithFrame:(CGRect)frame delayTime:(float)time target:(id)target imageUrlArray:(NSArray *)urlArray pageIndicatorTintColor:(UIColor *)color
{
    _scrollView = [[JScrollView_PageControl_AutoScroll alloc]initWithFrame:frame];
    _scrollView.isShowTimerDelay = YES;
    NSMutableArray *tempArray = [NSMutableArray array];
    for (int i = 0; i < urlArray.count; i++)
    {
        UIImageView *imageView = [[UIImageView alloc]init];
        imageView.clipsToBounds = YES;
        imageView.contentMode = UIViewContentModeScaleAspectFill;
        [imageView setImageWithUrl:urlArray[i]];
        [tempArray addObject:imageView];
    }
    _scrollView.autoScrollDelayTime = time;
    _scrollView.delegate = target;
    [_scrollView setViewsArray:tempArray];
    [_scrollView shouldAutoShow:YES];
    [_scrollView.pageControl setCurrentPageIndicatorTintColor:color];
    [self addSubview:_scrollView];
}

/*
 // Only override drawRect: if you perform custom drawing.
 // An empty implementation adversely affects performance during animation.
 - (void)drawRect:(CGRect)rect {
 // Drawing code
 }
 */


@end
