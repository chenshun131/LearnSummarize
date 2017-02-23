//
//  CommonTextTableViewCell.m
//  LearnSummarize
//
//  Created by chenshun131 on 17/2/14.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "CommonTextTableViewCell.h"

@interface CommonTextTableViewCell ()

@property (weak, nonatomic) IBOutlet UILabel *contentL;

@end

@implementation CommonTextTableViewCell

- (void)awakeFromNib
{
    [super awakeFromNib];
    // Initialization code
}

- (void)setSelected:(BOOL)selected animated:(BOOL)animated
{
    [super setSelected:selected animated:animated];
    // Configure the view for the selected state
}

- (void)showContent:(NSString *)content
{
    self.contentL.text = content;
}

@end
