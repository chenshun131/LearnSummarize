//
//  HomeViewController.m
//  LearnSummarize
//
//  Created by chenshun131 on 17/1/8.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "HomeViewController.h"
#import "DateChooseViewController.h"
#import "CommonTextTableViewCell.h"
#import "ApplicationViewController.h"
#import "EmotionViewController.h"
#import "ParticleEmitterViewController.h"
#import "SDWebImageViewController.h"
#import "SoftKeyViewController.h"
#import "ScrollViewViewController.h"
#import "MasonryTableViewController.h"

@interface HomeViewController ()<UITableViewDataSource, UITableViewDelegate>
{
    NSMutableArray *listData;
    
    UIView *emptyDataV;
}

@end

@implementation HomeViewController

- (void)viewDidLoad
{
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
    
    emptyDataV = [[UIView alloc] initWithFrame:CGRectMake(kScreenWidth / 2 - 50, kScreenHeight / 2 - 50, 100, 100)];
    UIImageView *emptyIV = [[UIImageView alloc] initWithFrame:CGRectMake(20, 0, 60, 65)];
    emptyIV.image = [UIImage imageNamed:@"empty_data.png"];
    [emptyDataV addSubview:emptyIV];
    UILabel *emptyL = [[UILabel alloc] initWithFrame:CGRectMake(0, 70, 100, 30)];
    emptyL.textAlignment = NSTextAlignmentCenter;
    emptyL.text = @"暂无记录";
    [emptyDataV addSubview:emptyL];
    emptyDataV.hidden = YES;
    [self.view addSubview:emptyDataV];
    
    listData = [NSMutableArray array];
    [listData addObject:@"0> 一款简单实用的日期选择控件"];
    [listData addObject:@"1> AppDelegate中常用方法"];
    [listData addObject:@"2> UILabel 显示额外的表情"];
    [listData addObject:@"3> 离子效果背景添加到 UIView"];
    [listData addObject:@"4> SDWebImage网络图片展示"];
    [listData addObject:@"5> 软键盘"];
    [listData addObject:@"6> ScrollView"];
    [listData addObject:@"7> Masonry"];
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

#pragma mark - UITableViewDataSource
- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section
{
    return listData.count;
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    static NSString *identifier = @"identifier";
    CommonTextTableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:identifier];
    if(cell == nil)
    {
        cell = [[[NSBundle mainBundle] loadNibNamed:@"CommonTextTableViewCell" owner:nil options:nil] firstObject];
    }
    [cell showContent:[listData objectAtIndex:indexPath.row]];
    return cell;
}

#pragma mark - UITableViewDelegate
- (CGFloat)tableView:(UITableView *)tableView heightForRowAtIndexPath:(NSIndexPath *)indexPath
{
    return 50;
}

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath
{
    switch(indexPath.row)
    {
        case 0:// 0> 一款简单实用的日期选择控件
        {
            DateChooseViewController *dateChooseVC = [[DateChooseViewController alloc] initWithNibName:@"DateChooseViewController" bundle:nil];
            dateChooseVC.hidesBottomBarWhenPushed = YES;
            [self.navigationController pushViewController:dateChooseVC animated:YES];
        }
            break;
        case 1:// 1> AppDelegate中常用方法
        {
            ApplicationViewController *applicationVC = [[ApplicationViewController alloc] initWithNibName:@"ApplicationViewController" bundle:nil];
            applicationVC.hidesBottomBarWhenPushed = YES;
            [self.navigationController pushViewController:applicationVC animated:YES];
        }
            break;
        case 2:// 2> UILabel 显示额外的表情
        {
            EmotionViewController *emotionVC = [[EmotionViewController alloc] initWithNibName:@"EmotionViewController" bundle:nil];
            emotionVC.hidesBottomBarWhenPushed = YES;
            [self.navigationController pushViewController:emotionVC animated:YES];
        }
            break;
        case 3:// 3> 离子效果背景添加到 UIView
        {
            ParticleEmitterViewController *particleEmitterVC = [[ParticleEmitterViewController alloc] initWithNibName:@"ParticleEmitterViewController" bundle:nil];
            particleEmitterVC.hidesBottomBarWhenPushed = YES;
            [self.navigationController pushViewController:particleEmitterVC animated:YES];
        }
            break;
        case 4:// 4> SDWebImage网络图片展示
        {
            SDWebImageViewController *SDWebImageVC = [[SDWebImageViewController alloc] init];
            SDWebImageVC.hidesBottomBarWhenPushed = YES;
            [self.navigationController pushViewController:SDWebImageVC animated:YES];
        }
            break;
        case 5:// 5> 软键盘
        {
            SoftKeyViewController *softKeyVC = [[SoftKeyViewController alloc] initWithNibName:@"SoftKeyViewController" bundle:nil];
            softKeyVC.hidesBottomBarWhenPushed = YES;
            [self.navigationController pushViewController:softKeyVC animated:YES];
        }
            break;
        case 6:// 6> ScrollView
        {
            ScrollViewViewController *scrollViewVC = [[ScrollViewViewController alloc] initWithNibName:@"ScrollViewViewController" bundle:nil];
            scrollViewVC.hidesBottomBarWhenPushed = YES;
            [self.navigationController pushViewController:scrollViewVC animated:YES];
        }
            break;
        case 7:// 7> Masonry
        {
            MasonryTableViewController *masonryTableVC = [[MasonryTableViewController alloc] init];
            masonryTableVC.hidesBottomBarWhenPushed = YES;
            [self.navigationController pushViewController:masonryTableVC animated:YES];
        }
            break;
    }
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
