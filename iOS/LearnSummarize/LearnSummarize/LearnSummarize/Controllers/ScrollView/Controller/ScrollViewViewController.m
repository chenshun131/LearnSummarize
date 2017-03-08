//
//  ScrollViewViewController.m
//  LearnSummarize
//
//  Created by chenshun131 on 17/3/2.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "ScrollViewViewController.h"

@interface ScrollViewViewController ()

@property (weak, nonatomic) IBOutlet UIScrollView *contentSV;

@end

@implementation ScrollViewViewController

- (void)viewDidLoad
{
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
    
    self.title = @"ScrollView";
    
    self.contentSV.contentInset = UIEdgeInsetsMake(10, 10, 10, 10);// 内容视图周围添加边框
    
    [self.contentSV setContentOffset:CGPointMake(20, 20)];// 视图坐标原点与 ScrollView 坐标原点的偏移量
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
