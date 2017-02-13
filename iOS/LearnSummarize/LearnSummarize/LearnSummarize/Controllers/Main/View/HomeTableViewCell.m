//
//  HomeTableViewCell.m
//  LearnSummarize
//
//  Created by chenshun131 on 17/2/13.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "HomeTableViewCell.h"

@interface HomeTableViewCell ()

@property (weak, nonatomic) IBOutlet UILabel *contentL;

@end

@implementation HomeTableViewCell

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
