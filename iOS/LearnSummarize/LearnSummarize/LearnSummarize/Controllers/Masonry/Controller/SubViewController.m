//
//  SubViewController.m
//  LearnSummarize
//
//  Created by chenshun131 on 17/3/4.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "SubViewController.h"

@interface SubViewController ()

@property (nonatomic, strong) Class viewClass;

@end

@implementation SubViewController

- (instancetype)initWithTitle:(NSString *)title viewClass:(Class)viewClass
{
    if (self == nil)
    {
        self = [super init];
    }
    self.title = title;
    self.viewClass = viewClass;
    return self;
}

- (void)loadView
{
    self.view = self.viewClass.new;
    self.view.backgroundColor = [UIColor whiteColor];
}

- (void)viewDidLoad
{
    [super viewDidLoad];
    // Do any additional setup after loading the view.
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
