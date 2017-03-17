//
//  DMDropDownMenu.m
//  DMDropDownMenu
//
//  Created by 王佳斌 on 16/5/19.
//  Copyright © 2016年 Draven_M. All rights reserved.
//

#import "DMDropDownMenu.h"

#define tableRowH 35
#define DEGREES_TO_RADIANS(angle) ((angle)/180.0 * M_PI)
#define kBorderColor [UIColor colorWithRed:219/255.0 green:217/255.0 blue:216/255.0 alpha:1]

@implementation DMDropDownMenu

- (id)initWithFrame:(CGRect)frame 
{
    self = [super initWithFrame:frame];
    if (self)
    {
        [self p_setUpView];
    }
    return self;
}

-(void)awakeFromNib
{
    [super awakeFromNib];
    [self p_setUpView];
}

- (void)setListArray:(NSArray *)arr
{
    self.listArr = arr;
    [_menuTableView reloadData];
    if(self.listArr.count > 0)
    {
        _curText.text = self.listArr[0];
    }
}

- (void)p_setUpView
{
    self.arrowImageName = @"down";
    
    _isOpen = NO;
    self.menuBtn = [UIButton buttonWithType:UIButtonTypeCustom];
#ifdef DEBUG
    NSLog(@"width = %f  height = %f", self.frame.size.width, self.frame.size.height);
#endif
    _menuBtn.frame = CGRectMake(0, 0, self.frame.size.width, self.frame.size.height);
    _menuBtn.layer.borderColor = kBorderColor.CGColor;
    [_menuBtn.layer setMasksToBounds:YES];
    [_menuBtn.layer setCornerRadius:3.0];
    _menuBtn.layer.borderWidth = 1;
    _menuBtn.clipsToBounds = YES;
    _menuBtn.layer.masksToBounds = YES;
    
    [_menuBtn addTarget:self action:@selector(tapAction) forControlEvents:UIControlEventTouchUpInside];
    [self addSubview:_menuBtn];
    
    self.curText = [[UILabel alloc] initWithFrame:CGRectMake(10, 0, self.frame.size.width - 30, self.frame.size.height)];
    _curText.textColor = [UIColor blackColor];
    _curText.textAlignment = NSTextAlignmentLeft;
    [_menuBtn addSubview:_curText];
    
    UIImage *image = [UIImage imageNamed:_arrowImageName];
    self.arrowImg = [[UIImageView alloc] initWithImage:image];
    _arrowImg.center = CGPointMake(self.frame.size.width - 15, self.frame.size.height/2);
    [_menuBtn addSubview:_arrowImg];
    
    self.menuTableView = [[UITableView alloc] initWithFrame:CGRectMake(self.frame.origin.x, self.frame.origin.y + self.frame.size.height, self.frame.size.width, 0) style:UITableViewStylePlain];
    _menuTableView.delegate = self;
    _menuTableView.dataSource = self;
    _menuTableView.tableFooterView = [UIView new];
    [_menuTableView registerClass:[UITableViewCell class] forCellReuseIdentifier:@"MenuCell"];
    _menuTableView.layer.borderWidth = 1;
    _menuTableView.layer.borderColor = kBorderColor.CGColor;
    [self.superview addSubview:_menuTableView];
}

- (void)setTitle:(NSString *)str
{
    _titleLabel.text = str;
}

- (void)setTitleHeight:(CGFloat)height
{
    CGRect frame = CGRectMake(0, self.frame.origin.y - height, self.frame.size.width, height);
    _titleLabel.frame = frame;
}

- (void)tapAction
{
    [self closeOtherJRView];
    if (_isOpen)
    {
        _isOpen = NO;
        [UIView animateWithDuration:0.3 animations:^{
            CGRect frame = _menuTableView.frame;
            frame.size.height = 0;
            [_menuTableView setFrame:frame];
        } completion:^(BOOL finished) {
            [_menuTableView removeFromSuperview];
            _arrowImg.transform = CGAffineTransformRotate(_arrowImg.transform, DEGREES_TO_RADIANS(180));
        }];
    }
    else
    {
        _isOpen = YES;
        [UIView animateWithDuration:0.3 animations:^{
            if(self.listArr.count > 0)
            {
                [_menuTableView scrollToRowAtIndexPath:[NSIndexPath indexPathForRow:0 inSection:0] atScrollPosition:UITableViewScrollPositionTop animated:YES];
            }
            [self.superview addSubview:_menuTableView];
            [self.superview bringSubviewToFront:_menuTableView];
            CGRect frame = _menuTableView.frame;
            frame.size.height = tableRowH *_listArr.count>200?200:tableRowH *_listArr.count;
            [_menuTableView setFrame:frame];
        } completion:^(BOOL finished) {
            _arrowImg.transform = CGAffineTransformRotate(_arrowImg.transform, DEGREES_TO_RADIANS(180));
        }];
    }
    if ([self.delegate respondsToSelector:@selector(tapAction:)])
    {
         [self.delegate tapAction:_isOpen];
    }
}

- (void)closeOtherJRView
{
    for (UIView *view in self.superview.subviews)
    {
        if ([view isKindOfClass:[DMDropDownMenu class]] && view != self)
        {
            DMDropDownMenu *otherView = (DMDropDownMenu *)view;
            if (otherView.isOpen)
            {
                otherView.isOpen = NO;
                [UIView animateWithDuration:0.3 animations:^{
                    CGRect frame = otherView.menuTableView.frame;
                    frame.size.height = 0;
                    [otherView.menuTableView setFrame:frame];
                } completion:^(BOOL finished) {
                    [otherView.menuTableView removeFromSuperview];
                    otherView.arrowImg.transform = CGAffineTransformRotate(otherView.arrowImg.transform, DEGREES_TO_RADIANS(180));
                }];
            }
        }
    }
}

-(NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section
{
    return self.listArr.count;
}

-(UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    UITableViewCell * cell = [tableView dequeueReusableCellWithIdentifier:@"MenuCell"];
    if(self.listArr.count > indexPath.row)
    {
        cell.textLabel.text = self.listArr[indexPath.row];
    }
    cell.textLabel.font = [UIFont systemFontOfSize:14];
    [cell setSeparatorInset:UIEdgeInsetsMake(0, 0, 0, 0)];
    cell.selectionStyle = UITableViewCellSelectionStyleNone;
    return cell;
}

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath
{
    [self tapAction];
    if(self.listArr.count > indexPath.row)
    {
        _curText.text = self.listArr[indexPath.row];
    }
    if ([_delegate respondsToSelector:@selector(selectIndex:AtDMDropDownMenu:)])
    {
        [_delegate selectIndex:indexPath.row AtDMDropDownMenu:self];
    }
}

- (void)reset
{
    if(self.listArr != nil && self.listArr.count > 0)
    {
        _curText.text = self.listArr[0];
    }
    if ([_delegate respondsToSelector:@selector(selectIndex:AtDMDropDownMenu:)])
    {
        [_delegate selectIndex:0 AtDMDropDownMenu:self];
    }
}

-(CGFloat)tableView:(UITableView *)tableView heightForRowAtIndexPath:(NSIndexPath *)indexPath
{

    return tableRowH;
}

@end
