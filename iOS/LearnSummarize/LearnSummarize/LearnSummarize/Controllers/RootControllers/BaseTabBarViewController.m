//
//  BaseTabBarViewController.m
//  LearnSummarize
//
//  Created by chenshun131 on 17/1/8.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "BaseTabBarViewController.h"
#import "BaseNavigationViewController.h"
#import "HomeViewController.h"
#import "LocalAuthenticationViewController.h"

@interface BaseTabBarViewController ()

@property (nonatomic, strong) NSMutableArray *items;

@end

@implementation BaseTabBarViewController

- (void)viewDidLoad
{
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    
    // 添加所有子控制器
    [self setUpAllChildViewController];
    
    // 未选中字体颜色
    [[UITabBarItem appearance] setTitleTextAttributes:@{NSForegroundColorAttributeName:[UIColor lightGrayColor],NSFontAttributeName:[UIFont fontWithName:@"HelveticaNeue-Bold"  size:13.0f]} forState:UIControlStateNormal];
    // 选中字体颜色
    [[UITabBarItem appearance] setTitleTextAttributes:@{NSForegroundColorAttributeName:[UIColor whiteColor],NSFontAttributeName:[UIFont fontWithName:@"HelveticaNeue-Bold"  size:13.0f]} forState:UIControlStateSelected];
    [[UITabBar appearance] setBarTintColor:Color_Theme];
}

#pragma mark - 添加所有的子控制器
- (void)setUpAllChildViewController
{
    // 电梯维保
    HomeViewController *homeVC = [[HomeViewController alloc] initWithNibName:@"HomeViewController" bundle:nil];
    [self setUpOneChildViewController:homeVC image:nil selectedImage:nil title:@"电梯维保"];
    
    LocalAuthenticationViewController *localAuthenticationVC = [[LocalAuthenticationViewController alloc] initWithNibName:@"LocalAuthenticationViewController" bundle:nil];
    [self setUpOneChildViewController:localAuthenticationVC image:nil selectedImage:nil title:@"电梯维修"];
    
    // 电梯天地
    HomeViewController *home3VC = [[HomeViewController alloc] initWithNibName:@"HomeViewController" bundle:nil];
    [self setUpOneChildViewController:home3VC image:nil selectedImage:nil title:@"电梯天地"];
}

#pragma mark - 添加一个子控制器
- (void)setUpOneChildViewController:(UIViewController *)vc image:(UIImage *)image selectedImage:(UIImage *)selectedImage title:(NSString *)title
{
    // 设置子控件对应tabBarItem的模型属性
    vc.title = title;
    vc.tabBarItem.image = image;
    vc.tabBarItem.selectedImage = selectedImage;
    
    // 保存tabBarItem模型到数组
    [self.items addObject:vc.tabBarItem];
    
    BaseNavigationViewController *nav = [[BaseNavigationViewController alloc] initWithRootViewController:vc];
    vc.navigationController.navigationBar.hidden = NO;
    [self addChildViewController:nav];
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
