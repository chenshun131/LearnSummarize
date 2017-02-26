//
//  DWParticleEmitter.m
//  DWParticleEmitterTest
//
//  Created by dwng.vip on 2017/2/22.
//  Copyright © 2017年 dwang. All rights reserved.
//
/*****************************Github:https://github.com/dwanghello/DWParticleEmitter*********************/
/*****************************邮箱:dwang.hello@outlook.com***********************************************/
/*****************************QQ:739814184**************************************************************/
/*****************************QQ交流群:577506623*********************************************************/
/*****************************codedata官方群:157937068***************************************************/

#import "DWParticleEmitter.h"
#import <QuartzCore/QuartzCore.h>
#import <Foundation/Foundation.h>

@interface DWParticleEmitter (){
    CAEmitterLayer *emitterLayer;
}

@end

@implementation DWParticleEmitter

- (instancetype)addEmitterLayerPosition:(CGPoint)emitterPosition emitterSize:(CGSize)emitterSize view:(UIView *)view {
    
    emitterLayer = [CAEmitterLayer layer];
    
    emitterLayer.backgroundColor = [UIColor clearColor].CGColor;
    
    //设置粒子发送器 每秒钟发送的数量
    emitterLayer.birthRate = self.emitterBirthRate?self.emitterBirthRate:1.0f;
    
    //发射源位置
    emitterLayer.emitterPosition = emitterPosition;
    
    //发射源尺寸
    emitterLayer.emitterSize = emitterSize;
    
    //发射形状的样式
    switch (self.caEmitterShape) {
        case 0:
            emitterLayer.emitterShape = kCAEmitterLayerPoint;
            break;
        case 1:
            emitterLayer.emitterShape = kCAEmitterLayerLine;
            break;
        case 2:
            emitterLayer.emitterShape = kCAEmitterLayerRectangle;
            break;
        case 3:
            emitterLayer.emitterShape = kCAEmitterLayerCuboid;
            break;
        case 4:
            emitterLayer.emitterShape = kCAEmitterLayerCircle;
            break;
        case 5:
            emitterLayer.emitterShape = kCAEmitterLayerSphere;
            break;
        default:
            break;
    }
    
    //发射模式
    switch (self.caEmitterMode) {
        case 0:
            emitterLayer.emitterMode = kCAEmitterLayerPoints;
            break;
        case 1:
            emitterLayer.emitterMode = kCAEmitterLayerOutline;
            break;
        case 2:
            emitterLayer.emitterMode = kCAEmitterLayerSurface;
            break;
        case 3:
            emitterLayer.emitterMode = kCAEmitterLayerVolume;
            break;
        default:
            break;
    }
    
    
    NSMutableArray *cellArrM = [NSMutableArray array];
    for (int i = 0; i < self.cellContents.count; i ++) {
        
        //粒子
        CAEmitterCell *emitterCell = [CAEmitterCell emitterCell];
        
        //粒子内容
        emitterCell.contents = (__bridge id _Nullable)(self.cellContents[i].CGImage);
        
        //粒子出生量
        emitterCell.birthRate = self.cellBirthRate?self.cellBirthRate:10.0f;
        
        //生命周期
        emitterCell.lifetime = self.cellLifetime?self.cellLifetime:120.0f;
        
        //生命周期范围
        emitterCell.lifetimeRange = self.cellLifetimeRange?self.cellLifetimeRange:10.50f;
        
        //发射的速度
        emitterCell.velocity = self.cellVelocity?self.cellVelocity:0.0f;
        
        //发射速度的范围
        emitterCell.velocityRange = self.cellVelocityRange?self.cellVelocityRange:10.0f;
        
        //发射的纬度
        emitterCell.emissionLatitude = self.cellEmissionLatitude?self.cellEmissionLatitude:0.0f;
        emitterCell.emissionLongitude = self.cellEmissionLongitude?self.cellEmissionLongitude:0.0f;
        
        //发射的范围
        emitterCell.emissionRange = self.cellEmissionRange?self.cellEmissionRange:M_PI/4;
        
        //加速度
        emitterCell.xAcceleration = self.cellXAcceleration?self.cellXAcceleration:0.0f;
        emitterCell.yAcceleration = self.cellYAcceleration?self.cellYAcceleration:0.0f;
        emitterCell.zAcceleration = self.cellZAcceleration?self.cellZAcceleration:0.0f;
        
        //旋转
        emitterCell.spin = self.cellSpin?self.cellSpin:0.0f;
        
        //旋转范围
        emitterCell.spinRange = self.cellSpinRange?self.cellSpinRange:0.0f;
        
        //缩放比例
        emitterCell.scale = self.cellScale?self.cellScale:0.0f;
        
        //缩放速度
        emitterCell.scaleSpeed = self.cellScaleSpeed?self.cellScaleSpeed:0.0f;
        
        //缩放范围
        emitterCell.scaleRange = self.cellScaleRange?self.cellScaleRange:0.0f;
        
        //粒子颜色
        emitterCell.color = self.cellColor?self.cellColor.CGColor:[UIColor whiteColor].CGColor;
        
        //一个粒子的颜色red 能改变的范围
        emitterCell.redRange = self.cellRedRange?self.cellRedRange:0.0f;
        
        //粒子red在生命周期内的改变速度
        emitterCell.redSpeed = self.cellRedSpeed?self.cellRedSpeed:0.0f;
        
        //一个粒子的颜色blue 能改变的范围
        emitterCell.greenRange = self.cellGreenRange?self.cellGreenRange:0.0f;
        
        //粒子blue在生命周期内的改变速度
        emitterCell.greenSpeed = self.cellGreenSpeed?self.cellGreenSpeed:0.0f;
        
        //一个粒子的颜色green 能改变的范围
        emitterCell.blueRange = self.cellBlueRange?self.cellBlueRange:0.0f;
        
        //粒子green在生命周期内的改变速度
        emitterCell.blueSpeed = self.cellBlueSpeed?self.cellBlueSpeed:0.0f;
        
        //一个粒子的透明度 能改变的范围
        emitterCell.alphaRange = self.cellAlphaRange?self.cellAlphaRange:0.0f;
        
        //粒子透明度在生命周期内的改变速度
        emitterCell.alphaSpeed = self.cellAlphaSpeed?self.cellAlphaSpeed:0.0f;
        
        emitterCell.name = [NSString stringWithFormat:@"emitterCell_%.02d", i];
        
        [cellArrM addObject:emitterCell];
        
    }
    
    //把粒子的cell 放到粒子发射器上
    emitterLayer.emitterCells = cellArrM;
    
    [view.layer addSublayer:emitterLayer];
    
    return self;
}

@end
