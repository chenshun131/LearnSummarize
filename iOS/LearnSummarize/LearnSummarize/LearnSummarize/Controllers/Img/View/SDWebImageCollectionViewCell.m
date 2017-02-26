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
    // 当图片显示过多时，或在列表中重复滚动时很有可能导致内存溢出
//    [imageIV sd_setImageWithURL:[NSURL URLWithString:model.bigURL] placeholderImage:[UIImage imageNamed:@"icon_load_fail"] options:SDWebImageLowPriority];
    
    // 测试一屏显示 42 张超过 1.5M 的网络图片的 UITableView，不会出现顿卡或是明显的内存溢出崩溃现象，只是图像显示少有模糊但可接受
    [UIImageView showWebImage:imageIV withURL:model.bigURL newWidth:50];
    textL.text = model.describ;
}

@end
