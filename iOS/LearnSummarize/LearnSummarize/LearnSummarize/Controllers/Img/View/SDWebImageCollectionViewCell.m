//
//  SDWebImageCollectionViewCell.m
//  LearnSummarize
//
//  Created by chenshun131 on 17/2/25.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "SDWebImageCollectionViewCell.h"

@implementation SDWebImageCollectionViewCell
{
    UIImageView *imageIV;
    UILabel *textL;
}


- (id)initWithFrame:(CGRect)frame
{
    self = [super initWithFrame:frame];
    if (self)
    {
        imageIV  = [[UIImageView alloc] initWithFrame:CGRectMake(0, 0, 50, 75)];
        imageIV.backgroundColor = [UIColor whiteColor];
        [self.contentView addSubview:imageIV];
        
        textL = [[UILabel alloc] initWithFrame:CGRectMake(0, 76, 50, 24)];
        textL.textAlignment = NSTextAlignmentCenter;
        textL.textColor = [UIColor colorWithHexString:TextBlack];
        textL.font = [UIFont systemFontOfSize:15];
        [self.contentView addSubview:textL];
    }
    
    return self;
}


- (void)awakeFromNib
{
    [super awakeFromNib];
    // Initialization code
}

- (void)setContent:(ImageModel *)model
{
    [imageIV sd_setImageWithURL:[NSURL URLWithString:model.bigURL] placeholderImage:[UIImage imageNamed:@"icon_load_fail"] options:SDWebImageLowPriority];
    textL.text = model.describ;
}

@end
