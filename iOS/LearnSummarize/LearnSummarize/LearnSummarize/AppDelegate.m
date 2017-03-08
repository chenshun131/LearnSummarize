//
//  AppDelegate.m
//  LearnSummarize
//
//  Created by chenshun131 on 17/1/8.
//  Copyright © 2017年 chenshun131. All rights reserved.
//  com.chenshun.LearnSummarize

#import "AppDelegate.h"
#import "BaseNavigationViewController.h"
#import "BaseTabBarViewController.h"
#import "LoginViewController.h"
#import <UMMobClick/MobClick.h>
#import <SMS_SDK/SMSSDK.h>

@interface AppDelegate ()

@end

/*!
 * AppDelegate use singleton pattern
 */
@implementation AppDelegate

- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions
{
    // Override point for customization after application launch.
    
    // init
    [self initIQKeyboardManager];
    [self initUMeng];
    [self initMob];
    
    
    [[NSNotificationCenter defaultCenter] addObserver:self selector:@selector(loginSucc) name:@"loginSuccess" object:nil];
    
    LoginViewController *login = [[LoginViewController alloc]initWithNibName:@"LoginViewController" bundle:nil];
    BaseNavigationViewController * loginNav = [[BaseNavigationViewController alloc] initWithRootViewController:login];
    
    self.window = [[UIWindow alloc] initWithFrame:[UIScreen mainScreen].bounds];
    self.window.backgroundColor = [UIColor whiteColor];
    self.window.rootViewController = loginNav;
    [self.window makeKeyAndVisible];
    
    return YES;
}

- (void)applicationWillResignActive:(UIApplication *)application
{
    // Sent when the application is about to move from active to inactive state. This can occur for certain types of temporary interruptions (such as an incoming phone call or SMS message) or when the user quits the application and it begins the transition to the background state.
    // Use this method to pause ongoing tasks, disable timers, and invalidate graphics rendering callbacks. Games should use this method to pause the game.
}

- (void)applicationDidEnterBackground:(UIApplication *)application
{
    // Use this method to release shared resources, save user data, invalidate timers, and store enough application state information to restore your application to its current state in case it is terminated later.
    // If your application supports background execution, this method is called instead of applicationWillTerminate: when the user quits.
}

- (void)applicationWillEnterForeground:(UIApplication *)application
{
    // Called as part of the transition from the background to the active state; here you can undo many of the changes made on entering the background.
}

- (void)applicationDidBecomeActive:(UIApplication *)application
{
    // Restart any tasks that were paused (or not yet started) while the application was inactive. If the application was previously in the background, optionally refresh the user interface.
}

- (void)applicationWillTerminate:(UIApplication *)application
{
    // Called when the application is about to terminate. Save data if appropriate. See also applicationDidEnterBackground:.
}

- (BOOL) application:(UIApplication *)application shouldSaveApplicationState:(NSCoder *)coder
{
    return YES;// whether allow save state when exit Application
}

- (BOOL) application:(UIApplication *)application shouldRestoreApplicationState:(NSCoder *)coder
{
    return YES;// whether restore the last state when Application start
}

- (void) application:(UIApplication *)application willEncodeRestorableStateWithCoder:(NSCoder *)coder
{
    // this method save UI state or data when save
    [coder encodeFloat:1.0 forKey:@"Version"];
}

- (void) application:(UIApplication *)application didDecodeRestorableStateWithCoder:(NSCoder *)coder
{
    // restore UI state or data
    float lastVer = [coder decodeFloatForKey:@"Version"];
    NSLog(@"lastVer = %f", lastVer);
}

- (void)applicationDidReceiveMemoryWarning:(UIApplication *)application
{
    // 当 App 接收到内存警告时调用
    
    SDWebImageManager *manager = [SDWebImageManager sharedManager];
    [manager cancelAll];// 1.取消正在下载的操作
    [manager.imageCache clearMemory];// 2.清除内存缓存
    [[SDImageCache sharedImageCache] setValue:nil forKey:@"memCache"];
}

- (void)loginSucc
{
    self.window.rootViewController  =  [[BaseTabBarViewController alloc] init];
}

#pragma mark - init
- (void)initIQKeyboardManager
{
    IQKeyboardManager *manager = [IQKeyboardManager sharedManager];
    manager.enable = YES;
    manager.shouldResignOnTouchOutside = YES;
    manager.shouldToolbarUsesTextFieldTintColor = YES;
    manager.enableAutoToolbar = NO;
}

- (void)initUMeng
{
    UMConfigInstance.appKey = @"58889d7af29d9856c800175a";
    UMConfigInstance.secret = @"LearnSummarize";
#ifdef DEBUG
    [MobClick setLogEnabled:YES];
    UMConfigInstance.channelId = @"Develop";
#else
    UMConfigInstance.channelId = @"App Store";
#endif
    [MobClick startWithConfigure:UMConfigInstance];
}

- (void)initMob
{
    [SMSSDK registerApp:@"18dc1b3241f7c" withSecret:@"df159163b9cb52178d6dab55d9aaa796"];
}

@end
