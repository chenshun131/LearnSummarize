//
//  ParticleEmitterViewController.m
//  LearnSummarize
//
//  Created by chenshun131 on 17/2/25.
//  Copyright © 2017年 chenshun131. All rights reserved.
//  粒子效果

#import "ParticleEmitterViewController.h"
#import "DWParticleEmitter.h"

@interface ParticleEmitterViewController ()

@end

@implementation ParticleEmitterViewController

- (void)viewDidLoad
{
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
    
    self.title = @"粒子效果";
    
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

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
