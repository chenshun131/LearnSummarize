//
//  ImageModel.h
//  LearnSummarize
//
//  Created by chenshun131 on 17/2/25.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "BaseModel.h"

@interface ImageModel : BaseModel

@property(nonatomic, strong) NSString *bigURL;// 大图路径
@property(nonatomic, strong) NSString *smallURL;// 小图路径
@property(nonatomic, strong) NSString *describ;// 图片描述信息
@property(nonatomic, strong) NSString *title;// 图片标题

@end
