//
//  DropDownMenu.m
//  LearnSummarize
//
//  Created by chenshun131 on 17/1/20.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "DropDownMenu.h"

@interface DropDownMenu () <UITableViewDataSource, UITableViewDelegate>

@property (strong, nonatomic) UITableView *tableView;

@property (strong, nonatomic) UIControl *control;

@end

#define kWidth  [UIScreen mainScreen].bounds.size.width
#define kHeight [UIScreen mainScreen].bounds.size.height

#define kDuration 0.3


@implementation DropDownMenu
{
    CGFloat _width;
    NSArray *_images;
    NSArray *_titles;
    
    UIWindow *_window;
    
    BOOL _isMenu;
}

- (instancetype)initWithWidth:(CGFloat)width images:(NSArray *)images titles:(NSArray *)titles
{
    if (self = [super init])
    {
        _width = width;
        _images = images;
        _titles = titles;
        
        _window = [UIApplication sharedApplication].keyWindow;
        
        _isMenu = NO;
        
        [self control];
        
        self.frame = CGRectMake(0, 64, kWidth, kHeight-64);
        [_window addSubview:self];
        
        self.backgroundColor = [UIColor whiteColor];
        self.alpha = 0.0f;
    }
    return self;
}

#pragma mark - private
- (void)showMenu
{
    [self tableView];
    
    if (!_isMenu)
    {
        [UIView animateWithDuration:kDuration animations:^{
            self.control.alpha = 0.3f;
            self.tableView.frame = CGRectMake(kWidth-_width-10, 10+10, _width, _titles.count*44);
            self.alpha = 1.0f;
        }];
        _isMenu = YES;
    }
    else
    {
        [self dismissControl];
    }
}

#pragma mark - public
- (void)selectedAtIndex:(SelectedAtIndex)block
{
    self.selectedAtIndex = block;
}

#pragma mark - <UITableViewDataSource>
- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section
{
    return _titles.count;
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    UITableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:@"cell"];
    if (!cell) {
        cell = [[UITableViewCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier:@"cell"];
    }
    if(nil != _images)
    {
        cell.imageView.image = [UIImage imageNamed:_images[indexPath.row]];
    }
    
    
    cell.textLabel.text = _titles[indexPath.row];
    cell.textLabel.textColor = [UIColor whiteColor];
    cell.backgroundColor = [UIColor blackColor];
    cell.textLabel.font = [UIFont systemFontOfSize:16];
    
    return cell;
}

#pragma mark - <UITableViewDelegate>
- (CGFloat)tableView:(UITableView *)tableView estimatedHeightForRowAtIndexPath:(nonnull NSIndexPath *)indexPath
{
    return UITableViewAutomaticDimension;
}

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath
{
    [tableView deselectRowAtIndexPath:indexPath animated:YES];
    
    [self dismissControl];
    
    self.selectedAtIndex(indexPath.row);
}

#pragma mark - 懒加载
- (UITableView *)tableView
{
    if (!_tableView)
    {
        _tableView = [[UITableView alloc] initWithFrame:CGRectMake(kWidth-_width-10, 10+10, _width, 0) style:UITableViewStylePlain];
        _tableView.dataSource = self;
        _tableView.delegate = self;
        _tableView.tableFooterView = [UIView new];
        _tableView.layer.cornerRadius = 5.0f;
        [self addSubview:_tableView];
    }
    return _tableView;
}

- (UIControl *)control
{
    if (!_control)
    {
        _control = [UIControl new];
        _control.backgroundColor = [UIColor blackColor];
        _control.alpha = 0.0f;
        [self addSubview:_control];
        [_control mas_makeConstraints:^(MASConstraintMaker *make) {
            make.edges.mas_equalTo(0);
        }];
        [_control addTarget:self action:@selector(clickControl:) forControlEvents:UIControlEventTouchUpInside];
    }
    return _control;
}

- (void)clickControl:(UIControl *)sender
{
    [self dismissControl];
}

- (void)dismissControl
{
    [UIView animateWithDuration:kDuration animations:^{
        self.tableView.frame = CGRectMake(kWidth-_width-10, 10+10, _width, 0);
        self.control.alpha = 0.0f;
        _isMenu = NO;
        self.alpha = 0.0f;
    } completion:^(BOOL finished) {
        [self.tableView removeFromSuperview];
        self.tableView = nil;
    }];
}

//  1.设置self的frame
//  2.把self添加到父视图中
//  才会调用改方法
- (void)drawRect:(CGRect)rect
{
    CGContextRef context = UIGraphicsGetCurrentContext();
    
    CGContextMoveToPoint(context, kWidth-10-20, 10);
    
    CGContextAddLineToPoint(context, kWidth-10-20-5, 10+10);
    
    CGContextAddLineToPoint(context, kWidth-10-20+5, 10+10);
    
    CGContextClosePath(context);
    
    [[UIColor blackColor] setStroke];
    
    [[UIColor blackColor] setFill];
    
    CGContextDrawPath(context, kCGPathFillStroke);
}

@end
