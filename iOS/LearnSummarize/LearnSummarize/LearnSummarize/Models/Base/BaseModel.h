//
//  BaseModel.h
//  LearnSummarize
//
//  Created by chenshun131 on 17/1/8.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

@interface BaseModel : NSObject

@property (nonatomic, copy) NSString *code;/**<  返回状态码 (默认0:成功,1:失败) */
@property (nonatomic, copy) NSString *message;/**< 返回的中文消息,主要是错误描述信息 */
@property (nonatomic, copy) id data;/**< 成功时携带的数据 */

/**
 *  模型对应的选择状态。Tips:多用于本地选中删除
 */
- (instancetype)initWithDic:(NSDictionary *)dic;

@end
