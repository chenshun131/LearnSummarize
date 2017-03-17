//
//  WifiViewController.m
//  LearnSummarize
//
//  Created by yanfabu-chenshun on 17/3/16.
//  Copyright © 2017年 chenshun131. All rights reserved.
//  显示当前 Wifi 信息

#import "WifiViewController.h"
#import <SystemConfiguration/CaptiveNetwork.h>
#import <SystemConfiguration/SystemConfiguration.h>

@interface WifiViewController ()

@end

@implementation WifiViewController
{
    UILabel *ssidL, *macIpL;
}

- (void)viewDidLoad
{
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    
    self.title = @"Wifi";
    
    UILabel *ssidTitleL = [[UILabel alloc] init];
    ssidTitleL.text = @"WiFi名称 : ";
    [self.view addSubview:ssidTitleL];
    [ssidTitleL mas_makeConstraints:^(MASConstraintMaker *make) {
        make.top.equalTo(@10);
        make.left.equalTo(@10);
        make.width.equalTo(@80);
        make.height.equalTo(@30);
    }];
    
    ssidL = [[UILabel alloc] init];
    [self.view addSubview:ssidL];
    [ssidL mas_remakeConstraints:^(MASConstraintMaker *make) {
        make.top.equalTo(ssidTitleL.mas_top);
        make.left.equalTo(ssidTitleL.mas_right).offset(5);
        make.right.equalTo(@-10);
        make.height.equalTo(ssidTitleL.mas_height);
    }];
    
    UILabel *macIpTitleL = [[UILabel alloc] init];
    macIpTitleL.text = @"Mac地址 : ";
    [self.view addSubview:macIpTitleL];
    [macIpTitleL mas_makeConstraints:^(MASConstraintMaker *make) {
        make.top.equalTo(ssidTitleL.mas_bottom).offset(10);
        make.left.equalTo(ssidTitleL.mas_left);
        make.width.equalTo(ssidTitleL.mas_width);
        make.height.equalTo(ssidTitleL.mas_height);
    }];
    
    macIpL = [[UILabel alloc] init];
    [self.view addSubview:macIpL];
    [macIpL mas_remakeConstraints:^(MASConstraintMaker *make) {
        make.top.equalTo(macIpTitleL.mas_top);
        make.left.equalTo(macIpTitleL.mas_right).offset(5);
        make.right.equalTo(@-10);
        make.height.equalTo(macIpTitleL.mas_height);
    }];
    [self getWiFiMac];
}

- (void)getWiFiMac
{
    NSString *ssid = @"Not Found";
    NSString *macIp = @"Not Found";
    CFArrayRef myArray = CNCopySupportedInterfaces();
    if(myArray != nil)
    {
        CFDictionaryRef myDict = CNCopyCurrentNetworkInfo(CFArrayGetValueAtIndex(myArray,0));
        if (myDict != nil)
        {
            NSDictionary *dict = (NSDictionary*)CFBridgingRelease(myDict);
            ssid = [dict valueForKey:@"SSID"]; // WiFi名称
            macIp = [dict valueForKey:@"BSSID"]; // Mac地址
        }
    }
    ssidL.text = ssid;
    macIpL.text = macIp;
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
