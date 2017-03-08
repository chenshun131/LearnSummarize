//
//  ApplicationViewController.m
//  LearnSummarize
//
//  Created by chenshun131 on 17/2/13.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "ApplicationViewController.h"
#import "CommonTextTableViewCell.h"
#import "MailViewController.h"

@interface ApplicationViewController ()<UITableViewDataSource, UITableViewDelegate>
{
    NSMutableArray *listData;
    
    UIView *emptyDataV;
}

@end

@implementation ApplicationViewController

- (void)viewDidLoad
{
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
    
    self.title = @"AppDelegate中常用方法";
    
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
    [listData addObject:@"Open Web : Baidu"];
    [listData addObject:@"第三方Email"];
    [listData addObject:@"拨打电话"];
    [listData addObject:@"发送短信"];
    [listData addObject:@"调用系统E-mail"];
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
        case 0: // Open Web : Baidu
            [[UIApplication sharedApplication] openURL:[NSURL URLWithString:@"http://www.baidu.com"]];
            break;
        case 1: // Email
        {
            MailViewController *mailVC = [[MailViewController alloc] initWithNibName:@"MailViewController" bundle:nil];
            mailVC.hidesBottomBarWhenPushed = YES;
            [self.navigationController pushViewController:mailVC animated:YES];
        }
            break;
        case 2: // 拨打电话
            [[UIApplication sharedApplication] openURL:[NSURL URLWithString:@"tel://10086"]];
            break;
        case 3: // 发送短信
            [[UIApplication sharedApplication] openURL:[NSURL URLWithString:@"sms:10086"]];
            break;
        case 4: // 调用系统E-mail
            [[UIApplication sharedApplication] openURL:[NSURL URLWithString:@"mailto://chenshun131@163.com"]];
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
