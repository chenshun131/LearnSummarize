//
//  BaseNavigationViewController.m
//  LearnSummarize
//
//  Created by chenshun131 on 17/1/8.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "BaseNavigationViewController.h"
#import "ScanQrcodeViewController.h"
#import "UIBarButtonItem+Item.h"

@interface BaseNavigationViewController ()<ScanQrcodeValueDelegate>

@end

@implementation BaseNavigationViewController

- (void)viewDidLoad
{
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    
    [[UINavigationBar appearance] setBarTintColor:Color_Theme];// Navigation Bar Color
    [self.navigationBar setTranslucent:NO];// 默认带有一定透明效果，可以使用以下方法去除系统效果
    NSDictionary *dict = @{NSForegroundColorAttributeName : [UIColor whiteColor]};// 设置导航默认标题的颜色及字体大小
    [[UINavigationBar appearance]  setTitleTextAttributes:dict];
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

- (void)pushViewController:(UIViewController *)viewController animated:(BOOL)animated
{
    if (self.childViewControllers.count)
    {
        // 不是根控制器
        viewController.hidesBottomBarWhenPushed = YES;
        // 设置导航条的返回按钮
        UIBarButtonItem *left = [UIBarButtonItem barButtonItemWithImage:[UIImage imageNamed:@"back"] highImage:[UIImage imageNamed:@"back"] target:self action:@selector(popToPre) forControlEvents:UIControlEventTouchUpInside];
        viewController.navigationItem.leftBarButtonItem = left;
    }
    else
    {
        UIBarButtonItem *left = [UIBarButtonItem barButtonItemWithImage:[UIImage imageNamed:@"hanbao"] highImage:[UIImage imageNamed:@"hanbao"] target:self action:@selector(popToSet) forControlEvents:UIControlEventTouchUpInside];
        UIBarButtonItem *right = [UIBarButtonItem barButtonItemWithImage:[UIImage imageNamed:@"scan"] highImage:[UIImage imageNamed:@"scan"] target:self action:@selector(popToScan) forControlEvents:UIControlEventTouchUpInside];
        // 设置导航条的设置按钮
        viewController.navigationItem.leftBarButtonItem = left;
        // 设置导航条的扫描按钮
        viewController.navigationItem.rightBarButtonItem = right;
    }
    [super pushViewController:viewController animated:animated];
}

- (void)popToPre
{
    [self popViewControllerAnimated:YES];
}

- (void)popToSet
{
    [self popToRootViewControllerAnimated:YES];
}

- (void)popToScan
{
    ScanQrcodeViewController * scanQrcodeVC = [[ScanQrcodeViewController alloc]init];
    // scanQrcodeVC.delegate = self.visibleViewController;
    scanQrcodeVC.delegate = self;
    scanQrcodeVC.modalTransitionStyle=UIModalTransitionStyleCrossDissolve;
    [self.visibleViewController presentViewController:scanQrcodeVC animated:YES completion:nil];
}

#pragma mark - ScanQrcodeValueDelegate
- (void)passScanQrcodeValue:(NSString *)value
{
    Log(@"ScanQrcodeValue : %@", value);
}

@end
