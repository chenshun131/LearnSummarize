//
//  ConsoleToChineseViewController.m
//  LearnSummarize
//
//  Created by chenshun131 on 17/2/12.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "ConsoleToChineseViewController.h"

@interface ConsoleToChineseViewController ()

@property (weak, nonatomic) IBOutlet UIButton *showB;

- (IBAction)showAction:(id)sender;

@end

@implementation ConsoleToChineseViewController

- (void)viewDidLoad
{
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
    
    [self setBorderStyleWithView:[UIColor colorWithHexString:SeperatGray].CGColor withViews:self.showB, nil];
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

- (IBAction)showAction:(id)sender
{
    NSString *str = @"我是转换成data格式的字符串";
    NSData *dataString = [NSData dataWithBytes:str.UTF8String length:str.length];
    NSDictionary *dataSet = @{@"key": @"字典转成data",
                              @"key1": @"在set、数组、字典中嵌套"};
    NSData *dataSetItem = [NSJSONSerialization dataWithJSONObject:dataSet options:NSJSONWritingPrettyPrinted error:nil];
    
    NSMutableSet *set = [NSMutableSet setWithArray:@[@"可变集合", @"字典->不可变集合->可变集合", dataSetItem]];
    NSDictionary *dict = @{@"name"  : @"技术博客",
                           @"title" : @"http://www.baidu.com",
                           @"count" : @(11),
                           @"dataString" : dataString,
                           @"results" : [NSSet setWithObjects:@"集合值1", @"集合值2", set , nil],
                           @"summaries" : @[@"sm1", @"sm2", @{@"keysm": @{@"stkey": @"字典->数组->字典->字典"}}, dataSetItem],
                           @"parameters" : @{@"key1" : @"value1", @"key2": @{@"key11" : @"value11", @"key12" : @[@"三层", @"字典->字典->数组"]}, @"key13": dataSetItem},
                           @"hasBug": @[@"YES",@"NO"],
                           @"contact" : @[@"百度地址：http://www.baidu.com", @"QQ群: 123456", @"关注微博：Tony", @"关注GITHUB：CoderJackyHuang"]};
    NSLog(@"%@", dict);
}

@end
