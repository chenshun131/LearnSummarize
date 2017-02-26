//
//  DWParticleEmitter.h
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

#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>

/** 发射形状的样式 */
typedef enum : NSUInteger {
    caPonit,     /** 点 */
    caLine,      /** 线 */
    caRectangle, /** 矩形 */
    caCuboid,    /** 立方体 */
    caCircle,    /** 曲线 */
    caSphere,    /** 圆形 */
} CAEmitterShape;

/** 发射模式 */
typedef enum : NSUInteger {
    caPoint,     /** 点 */
    caOutline,   /** 线 */
    caSurface,   /** 面 */
    caVolume,    /** 团 */
}CAEmitterMode;


@interface DWParticleEmitter : NSObject

/**************************************发射器*****************************************/
/** 设置粒子发送器 每秒钟发送的数量 */
@property(assign, nonatomic) float                  emitterBirthRate;

/** 发射形状的样式 */
@property(assign, nonatomic) CAEmitterShape         caEmitterShape;

/** 发射模式 */
@property(assign, nonatomic) CAEmitterMode          caEmitterMode;


/**************************************粒子*****************************************/
/** 粒子内容 */
@property (strong, nonatomic) NSArray<UIImage *>   *cellContents;

/** 每秒粒子生成的数量 */
@property(assign, nonatomic) float                  cellBirthRate;

/** 每秒粒子的生命周期/(单位:s) */
@property(assign, nonatomic) float                  cellLifetime;

/** 生命周期范围 */
@property(assign, nonatomic) float                  cellLifetimeRange;

/** 发射的速度——>速度越快越远 */
@property(assign, nonatomic) CGFloat                cellVelocity;

/** 发射速度的范围 */
@property(assign, nonatomic) CGFloat                cellVelocityRange;

/** 发射的纬度(方向)——>弧度——>上下 */
@property(assign, nonatomic) CGFloat                cellEmissionLatitude;

/** 发射的经度(方向)——>弧度——>左右 */
@property(assign, nonatomic) CGFloat                cellEmissionLongitude;

/** 发射粒子的范围 */
@property(assign, nonatomic) CGFloat                cellEmissionRange;

/** X轴的加速度 */
@property(assign, nonatomic) CGFloat                cellXAcceleration;

/** Y轴的加速度 */
@property(assign, nonatomic) CGFloat                cellYAcceleration;

/** Z轴的加速度 */
@property(assign, nonatomic) CGFloat                cellZAcceleration;

/** 粒子旋转 */
@property(assign, nonatomic) CGFloat                cellSpin;

/** 旋转范围 */
@property(assign, nonatomic) CGFloat                cellSpinRange;

/** 缩放比例 */
@property(assign, nonatomic) CGFloat                cellScale;

/** 缩放速度 */
@property(assign, nonatomic) CGFloat                cellScaleSpeed;

/** 缩放范围 */
@property(assign, nonatomic) CGFloat                cellScaleRange;

/** 粒子颜色 */
@property(strong, nonatomic) UIColor               *cellColor;

/** 一个粒子的颜色red 能改变的范围 */
@property(assign, nonatomic) float                  cellRedRange;

/** 粒子red在生命周期内的改变速度 */
@property(assign, nonatomic) float                  cellRedSpeed;

/** 一个粒子的颜色blue 能改变的范围 */
@property(assign, nonatomic) float                  cellBlueRange;

/** 粒子blue在生命周期内的改变速度 */
@property(assign, nonatomic) float                  cellBlueSpeed;

/** 一个粒子的颜色green 能改变的范围 */
@property(assign, nonatomic) float                  cellGreenRange;

/** 粒子green在生命周期内的改变速度 */
@property(assign, nonatomic) float                  cellGreenSpeed;

/** 一个粒子的透明度 能改变的范围 */
@property(assign, nonatomic) float                  cellAlphaRange;

/** 粒子透明度在生命周期内的改变速度 */
@property(assign, nonatomic) float                  cellAlphaSpeed;


/**
 粒子效果

 @param emitterPosition 发射位置
 @param emitterSize     发射源的尺寸
 @param view            添加到的View
 @return                mySelf
 */
- (instancetype)addEmitterLayerPosition:(CGPoint)emitterPosition emitterSize:(CGSize)emitterSize view:(UIView *)view;

@end
