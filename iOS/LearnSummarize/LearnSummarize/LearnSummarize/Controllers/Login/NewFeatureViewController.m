//
//  NewFeatureViewController.m
//  LearnSummarize
//
//  Created by chenshun131 on 17/1/8.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "NewFeatureViewController.h"
#import "BaseNavigationViewController.h"
#import "UIView+Extensions.h"
#import "LoginViewController.h"

const CGFloat kMaxFeatureCount = 3;

@interface NewFeatureViewController ()<UIScrollViewDelegate>
{
    UIPageControl *_pageControl;
}

@end

@implementation NewFeatureViewController

- (void)viewDidLoad
{
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    
    self.navigationController.navigationBarHidden = YES;
    UIScrollView *scrollView = [[UIScrollView alloc] initWithFrame:self.view.bounds];
    scrollView.showsVerticalScrollIndicator = NO;
    scrollView.showsHorizontalScrollIndicator = NO;
    scrollView.bounces = YES;
    scrollView.pagingEnabled = YES;
    scrollView.delegate = self;
    // 添加新特性图片
    for (int i = 0; i < kMaxFeatureCount; i++)
    {
        NSString *imgName = [NSString stringWithFormat:@"%d", i];
        UIImageView *imageView = [[UIImageView alloc] initWithImage:[UIImage imageNamed:imgName]];
        imageView.origin = CGPointMake(kScreenWidth * i, 0);
        imageView.size = CGSizeMake(kScreenWidth, kScreenHeight);
        imageView.backgroundColor = RandomColor;
        [scrollView addSubview:imageView];
    }
    scrollView.contentSize = CGSizeMake(kScreenWidth * kMaxFeatureCount, 0);
    [self.view addSubview:scrollView];
    
    UIButton *button = [UIButton buttonWithType:UIButtonTypeSystem];
    button.frame = CGRectMake(kScreenWidth * (kMaxFeatureCount - 1) + self.view.centerX - 85, kScreenHeight * 0.93 - 30 - 30 - 20, 170, 70);
    [scrollView addSubview:button];
    button.backgroundColor = [UIColor clearColor];
    button.layer.cornerRadius = 10.0f;
    button.layer.borderWidth = 1.0f;
    button.layer.borderColor = [UIColor clearColor].CGColor;
    [button addTarget:self action:@selector(enterApplication) forControlEvents:UIControlEventTouchUpInside];
    
    UIPageControl *control = [[UIPageControl alloc] initWithFrame:CGRectMake(0, 0, kScreenWidth, 30.f)];
    control.center = CGPointMake(kScreenWidth * 0.5, kScreenHeight * 0.9);
    control.numberOfPages = kMaxFeatureCount;
    control.pageIndicatorTintColor = [UIColor clearColor];
    control.currentPageIndicatorTintColor = [UIColor clearColor];

    [self.view addSubview:control];
    _pageControl = control;
    _pageControl.hidden = YES;
}

- (void)enterApplication
{
    NSString *version = [NSBundle mainBundle].infoDictionary[(__bridge NSString *)kCFBundleVersionKey];
    NSUserDefaults *userDefaults = [NSUserDefaults standardUserDefaults];
    [userDefaults setObject:version forKey:@"previewFeatureVersion"];
    [userDefaults synchronize];
    
    LoginViewController *login = [[LoginViewController alloc]initWithNibName:@"LoginViewController" bundle:nil];
    BaseNavigationViewController * loginNav = [[BaseNavigationViewController alloc] initWithRootViewController:login];
    kWindow.rootViewController = loginNav;
}

#pragma mark - UIScrollViewDelegate
- (void)scrollViewDidScroll:(UIScrollView *)scrollView
{
    _pageControl.currentPage = (scrollView.contentOffset.x / kScreenWidth) + 0.5;
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
