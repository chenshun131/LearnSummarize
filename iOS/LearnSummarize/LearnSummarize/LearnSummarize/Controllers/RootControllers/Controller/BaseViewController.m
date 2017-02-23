//
//  BaseViewController.m
//  LearnSummarize
//
//  Created by chenshun131 on 17/1/8.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "BaseViewController.h"
#import <UMMobClick/MobClick.h>

@interface BaseViewController ()

@end

@implementation BaseViewController
{
    DropDownMenu *dropDownMenu;
}

- (void)viewDidLoad
{
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    
    self.view.backgroundColor = [UIColor whiteColor];
    self.automaticallyAdjustsScrollViewInsets=NO;
}

- (void)viewWillAppear:(BOOL)animated
{
    [super viewWillAppear:animated];
    [MobClick beginLogPageView:NSStringFromClass([self class])];
#ifdef DEBUG
    Log(@"viewWillAppear => %@", NSStringFromClass([self class]));
#endif
}

- (void)viewWillDisappear:(BOOL)animated
{
    [super viewWillDisappear:animated];
    [MobClick endLogPageView:NSStringFromClass([self class])];
#ifdef DEBUG
    Log(@"viewWillDisappear => %@", NSStringFromClass([self class]));
#endif
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

#pragma mark - Menu
- (void)showDropDownMenu:(NSArray *)titles andImages:(NSArray *)images andBlock:(SelectedAtIndex)block
{
    dropDownMenu = nil;
    dropDownMenu = [[DropDownMenu alloc] initWithWidth:150.0f images:images titles:titles];
    [dropDownMenu selectedAtIndex:block];
    [dropDownMenu showMenu];
}

- (void)setRightImageMenu:(NSString *)image action:(nullable SEL)action
{
    UIBarButtonItem *rightItem = [[UIBarButtonItem alloc] initWithImage:[UIImage imageNamed:image] style:UIBarButtonItemStylePlain target:self action:action];
    self.navigationItem.rightBarButtonItem = rightItem;
}

/*!
 * set right text
 */
- (void)setRightTextBtn:(NSString *)text action:(nullable SEL)action
{
    UIBarButtonItem *rightBarItem = [[UIBarButtonItem alloc] initWithTitle:text style:UIBarButtonItemStylePlain target:self action:action];
    self.navigationItem.rightBarButtonItem = rightBarItem;
}

/*!
 * set View Round Border
 * @param borderColor border Color
 */
- (void)setBorderStyleWithView:(CGColorRef)borderColor withViews:(UIView *)view, ...
{
    view.layer.borderColor = borderColor;
    view.layer.borderWidth = 1.0;
    view.layer.cornerRadius = 5;
    
    va_list list;
    va_start(list, view);
    UIView* param;
    while ((param = va_arg(list, UIView *)))
    {
        if(param)
        {
            param.layer.borderColor = borderColor;
            param.layer.borderWidth = 1.0;
            param.layer.cornerRadius = 5;
        }
    }
    va_end(list);
}

/*!
 * limit word count of UITextField
 */
- (void)wordCountLimit:(UITextField *)tf withWordCount:(NSUInteger)count
{
    tf.tag = count;
    [tf addTarget:self action:@selector(textChangeAction:) forControlEvents:UIControlEventEditingChanged];
}

- (void) textChangeAction:(UITextField *) sender
{
    if (sender.text.length > sender.tag)
    {
        UITextRange *markedRange = [sender markedTextRange];
        if (markedRange)
        {
            return;
        }
        NSRange range = [sender.text rangeOfComposedCharacterSequenceAtIndex:sender.tag];
        sender.text = [sender.text substringToIndex:range.location];
    }
}

@end
