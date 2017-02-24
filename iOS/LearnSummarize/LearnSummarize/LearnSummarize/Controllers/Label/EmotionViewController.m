//
//  EmotionViewController.m
//  LearnSummarize
//
//  Created by chenshun131 on 17/2/24.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "EmotionViewController.h"
#import "UILabel+AttributedString.h"

@interface EmotionViewController ()

@property (weak, nonatomic) IBOutlet UILabel *testLabel;
@property (weak, nonatomic) IBOutlet UILabel *testLabel_1;

@end

@implementation EmotionViewController

- (void)viewDidLoad
{
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
    
    self.title = @"UILabel显示其它表情";
    
    NSString *orig = @"☞☞☞师姐说标题要长才☞☞☹☺能引起师妹们的关注！！！";
    self.testLabel.font = [UIFont boldSystemFontOfSize:15.0f];
    self.testLabel.numberOfLines = 0;
    self.testLabel.text = orig;
    
    //错误的示范
    self.testLabel_1.font = [UIFont boldSystemFontOfSize:15.0f];
    self.testLabel_1.numberOfLines = 0;
    self.testLabel_1.text = orig;
    
    //修复成功后的示范
    NSLog(@"%@",self.testLabel.attributedText);
    [self.testLabel as_setAttributedText];
    NSLog(@"%@",self.testLabel.attributedText);
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
