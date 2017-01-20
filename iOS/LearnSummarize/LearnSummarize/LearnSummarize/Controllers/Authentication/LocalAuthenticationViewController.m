//
//  LocalAuthenticationViewController.m
//  LearnSummarize
//
//  Created by chenshun131 on 17/1/20.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "LocalAuthenticationViewController.h"
#import "TouchID.h"

@interface LocalAuthenticationViewController ()

@property (weak, nonatomic) IBOutlet UILabel *stateL;

@end

@implementation LocalAuthenticationViewController

- (void)viewDidLoad
{
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
    
    self.title = @"指纹识别功能";
    
    [self setRightImageMenu:@"add" action:@selector(clickRightItem:)];
    
}

- (void)clickRightItem:(UIBarButtonItem *)sender
{
    [self showDropDownMenu:@[@"扫码", @"监控", @"设置"] andImages:@[@"menu_scan", @"menu_monitor", @"menu_setting"] andBlock:^(NSInteger index)
     {
         switch(index)
         {
             case 0:
                 Log(@"扫码");
                 break;
             case 1:
                 Log(@"监控");
                 break;
             case 2:
                 Log(@"设置");
                 break;
             default:
                 break;
         }
     }];
}


- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (IBAction)isTouchIDAvailableAction:(id)sender
{
    TouchIDStatus status = [TouchID isTouchIDAvailable];
    switch (status)
    {
        case TouchIDStatusAvailable:
            [self.stateL setText:@"指纹验证可用"];
            break;
        case TouchIDStatusNoTouchID:
            [self.stateL setText:@"没有设置指纹"];
            break;
        case TouchIDStatusNoAvailable:
            [self.stateL setText:@"不可用"];
            break;
        default:
            break;
    }
}

- (IBAction)verifyAction:(id)sender
{
    [TouchID isTouchIDAvailableAndCallBack:^(TouchIDStatus status)
    {
        dispatch_async(dispatch_get_main_queue(), ^{
            switch (status)
            {
                case TouchIDStatusVerifySuccess:// 验证成功
                    [self.stateL setText:@"验证成功"];
                    break;
                case TouchIDStatusClickCancel:// 点击取消按钮 -2
                    [self.stateL setText:@"取消"];
                    break;
                case TouchIDStatusClickInputPassword:// 点击输入密码按钮 -3
                    [self.stateL setText:@"输入密码"];
                    break;
                case TouchIDStatusVerifyFail:// 验证失败
                    [self.stateL setText:@"验证失败"];
                    break;
                default:
                    break;
            }
        });
    }];
}

@end
