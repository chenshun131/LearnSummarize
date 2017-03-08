//
//  BasicAnimatedView.m
//  LearnSummarize
//
//  Created by chenshun131 on 17/3/4.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "BasicAnimatedView.h"
#import "DWParticleEmitter.h"

@interface BasicAnimatedView ()

@property (nonatomic, assign) int width;
@property (nonatomic, strong) UIView *view;

@end

@implementation BasicAnimatedView

- (instancetype)init
{
    self = [super init];
    if (self)
    {
        UIImageView *imageView = [[UIImageView alloc] initWithImage:[UIImage imageNamed:@"heart"]];
        [imageView setContentMode:UIViewContentModeScaleAspectFit];
        [self addSubview:imageView];
        
        self.width = 50;
        [imageView mas_makeConstraints:^(MASConstraintMaker *make) {
            make.width.equalTo(@(self.width));
            make.height.equalTo(imageView.mas_width);
            make.centerY.equalTo(self).offset(-30);
            make.centerX.equalTo(self);
        }];
        _view = imageView;
        
        DWParticleEmitter *emitter = [[DWParticleEmitter alloc] init];
        emitter.cellContents = @[[UIImage imageNamed:@"yuandanr"]];
        emitter.caEmitterMode = caVolume;
        emitter.caEmitterShape = caLine;
        emitter.cellVelocity = -10.0f;
        emitter.cellYAcceleration = 10.0f;
        emitter.cellEmissionLatitude = -M_PI / 2;
        emitter.cellEmissionRange = M_PI / 4;
        emitter.cellSpin = 0.8 * M_PI;
        emitter.cellSpinRange = 10.0f;
        emitter.cellScale = 0.5f;
        emitter.cellScaleSpeed = 0.1f;
        emitter.cellScaleRange = 1.0f;
        emitter.cellColor = [UIColor colorWithRed:(0.6f / 255.0f) green:(0.6f / 255.0f) blue:(0.6f / 255.0f) alpha:1.0f];
        emitter.cellRedRange = 1.0f;
        emitter.cellRedSpeed = 0.1f;
        emitter.cellBlueRange = 1.0f;
        emitter.cellBlueSpeed = 0.1f;
        emitter.cellGreenRange = 1.0f;
        emitter.cellGreenSpeed = 0.1f;
        emitter.cellAlphaRange = 1.0f;
        emitter.cellGreenSpeed = 0.05f;
        [emitter addEmitterLayerPosition:CGPointMake(self.view.frame.size.width / 2, -22) emitterSize:CGSizeMake(self.view.frame.size.width, 0.0) view:self.view];
    }
    return self;
}

#pragma - mark 视图回调
//视图加载后开始动画
- (void)didMoveToWindow
{
    [self animateWithInvertedInsets:NO];
}

- (void)animateWithInvertedInsets:(BOOL)invertedInsets
{
    self.width = invertedInsets ? 50 : 200;
    // 更新约束
    [_view mas_updateConstraints:^(MASConstraintMaker *make) {
        make.width.equalTo(@(self.width));
    }];
    
    [UIView animateWithDuration:1 animations:^{
        [self layoutIfNeeded];
    } completion:^(BOOL finished) {
        // repeat!
        [self animateWithInvertedInsets:!invertedInsets];
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
