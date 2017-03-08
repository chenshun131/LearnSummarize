//
//  MasonryTableViewController.m
//  LearnSummarize
//
//  Created by chenshun131 on 17/3/4.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "MasonryTableViewController.h"
#import "UpdateConstraintView.h"
#import "SubViewController.h"
#import "RemakeConstraintView.h"
#import "UseConstantsView.h"
#import "UseEdgesInsetView.h"
#import "AspectFitWithRatioView.h"
#import "BasicAnimatedView.h"
#import "UserMarginView.h"
#import "UpdateArrayViews.h"

static NSString * const CELL_IDENTIFER = @"tableCellIdentifer";

@interface MasonryTableViewController () <UITableViewDataSource, UITableViewDelegate>

@property (nonatomic, strong) NSArray *viewClasses;
@property (nonatomic, strong) NSDictionary *cellTitles;

@end

@implementation MasonryTableViewController
{
    UITableView *tableView;
}

- (void)viewDidLoad
{
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    
    self.title = @"Masonry";
    tableView = [[UITableView alloc] initWithFrame:CGRectMake(0, 0, kScreenWidth, kScreenHeight) style:UITableViewStylePlain];
    [tableView registerClass:UITableViewCell.class forCellReuseIdentifier:CELL_IDENTIFER];
    tableView.delegate = self;
    tableView.dataSource = self;
    [self.view addSubview:tableView];
    
    self.viewClasses = @[UpdateConstraintView.class,
                         RemakeConstraintView.class,
                         UseConstantsView.class,
                         UseEdgesInsetView.class,
                         AspectFitWithRatioView.class,
                         BasicAnimatedView.class,
                         UpdateArrayViews.class,
                         UserMarginView.class
                         ];
    self.cellTitles = @{NSStringFromClass(UpdateConstraintView.class): @"约束更新",
                        NSStringFromClass(RemakeConstraintView.class): @"重加约束",
                        NSStringFromClass(UseConstantsView.class): @"使用链式调用添加常量约束值",
                        NSStringFromClass(UseEdgesInsetView.class): @"使用内边距",
                        NSStringFromClass(AspectFitWithRatioView.class): @"使用宽高比",
                        NSStringFromClass(BasicAnimatedView.class): @"基本动画",
                        NSStringFromClass(UpdateArrayViews.class): @"使用数组更新动画",
                        NSStringFromClass(UserMarginView.class): @"使用外边距"
                        };
    [tableView reloadData];
}

#pragma mark - UITableViewDataSource
- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView
{
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section
{
    return self.viewClasses.count;
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    UITableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:CELL_IDENTIFER forIndexPath:indexPath];
    cell.textLabel.text = self.cellTitles[NSStringFromClass(self.viewClasses[indexPath.row])];
    return cell;
}

#pragma mark - UITableViewDelegate
- (CGFloat)tableView:(UITableView *)tableView heightForRowAtIndexPath:(NSIndexPath *)indexPath
{
    return 50;
}

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath
{
    Class viewClass = self.viewClasses[indexPath.row];
    NSString *title = self.cellTitles[NSStringFromClass(self.viewClasses[indexPath.row])];
    SubViewController *subViewController = [[SubViewController alloc] initWithTitle:title viewClass:viewClass];
    [self.navigationController pushViewController:subViewController animated:YES];
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
