//
//  DateChooseViewController.m
//  LearnSummarize
//
//  Created by chenshun131 on 17/1/8.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "DateChooseViewController.h"
#import "LTSDateChoose.h"

@interface DateChooseViewController ()<UITableViewDelegate, UITableViewDataSource, LTSDateChooseDelegate>
{
    NSArray *types;
}

@property (weak, nonatomic) IBOutlet UITableView *tableView;

@end

@implementation DateChooseViewController

- (void)viewDidLoad
{
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
    
    self.title = @"一款简单实用的日期选择控件";
    types = @[@"UIDatePickerModeTime", @"UIDatePickerModeDate", @"UIDatePickerModeDateAndTime", @"UIDatePickerModeCountDownTimer"];
}

#pragma mark - UITableViewDataSource
- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section
{
    return 4;
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    UITableViewCell *cell = [UITableViewCell new];
    cell.textLabel.text = types[indexPath.row];
    return cell;
}

#pragma mark - UITableViewDelegate
- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView
{
    return 1;
}

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath
{
    UIDatePickerMode mode;
    switch (indexPath.row)
    {
        case 0:
            mode = UIDatePickerModeTime;
            break;
        case 1:
            mode = UIDatePickerModeDate;
            break;
        case 2:
            mode = UIDatePickerModeDateAndTime;
            break;
        default:
            mode = UIDatePickerModeCountDownTimer;
            break;
    }
    LTSDateChoose *dateChoose =  [[LTSDateChoose alloc]initWithType:mode title:@"日期选择"];
    [dateChoose setNowTime:[NSDate date]];
    dateChoose.delegate = self;
    [dateChoose showWithAnimation:YES];
}

#pragma mark - LTSDateChooseDelegate
- (void)changeTime:(LTSDateChoose *)choose date:(NSDate *)date
{
    Log(@"changeTime => %@", [date defaultDateStr]);
}

- (void)determine:(LTSDateChoose *)choose date:(NSDate *)date
{
     Log(@"determine => %@", [date defaultDateStr]);
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
