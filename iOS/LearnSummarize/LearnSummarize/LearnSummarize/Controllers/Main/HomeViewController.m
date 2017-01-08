//
//  HomeViewController.m
//  LearnSummarize
//
//  Created by chenshun131 on 17/1/8.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "HomeViewController.h"
#import "DateChooseViewController.h"

@interface HomeViewController ()

- (IBAction)dialogAction:(id)sender;

@end

@implementation HomeViewController

- (void)viewDidLoad
{
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
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

- (IBAction)dialogAction:(id)sender
{
    DateChooseViewController *dateChooseVC = [[DateChooseViewController alloc] initWithNibName:@"DateChooseViewController" bundle:nil];
    dateChooseVC.hidesBottomBarWhenPushed = YES;
    [self.navigationController pushViewController:dateChooseVC animated:YES];
}

@end
