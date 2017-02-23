//
//  MailViewController.m
//  LearnSummarize
//
//  Created by chenshun131 on 17/2/14.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "MailViewController.h"
#import <SKPSMTPMessage.h>
#import <NSData+Base64Additions.h>

@interface MailViewController () <SKPSMTPMessageDelegate>

@property (weak, nonatomic) IBOutlet UITextField *sendMailTF;
@property (weak, nonatomic) IBOutlet UITextField *mailtoTF;
@property (weak, nonatomic) IBOutlet UITextField *ccTF;
@property (weak, nonatomic) IBOutlet UITextField *bccTF;
@property (weak, nonatomic) IBOutlet UITextField *subjectTF;
@property (weak, nonatomic) IBOutlet UITextView *bodyTV;

@end

@implementation MailViewController

- (void)viewDidLoad
{
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
    
    self.title = @"发送邮件";
    
    [self setBorderStyleWithView:[UIColor blackColor].CGColor withViews:self.bodyTV, nil];
    [self setRightTextBtn:@"发送" action:@selector(sendMail)];
}

- (void)sendMail
{
    SKPSMTPMessage *mail = [[SKPSMTPMessage alloc] init];
    [mail setSubject:self.subjectTF.text];// 设置邮件主题
    [mail setToEmail:self.mailtoTF.text];// 目标邮箱
    [mail setBccEmail:self.bccTF.text];// 密送邮件
    [mail setFromEmail:self.sendMailTF.text];// 发送者邮箱
    [mail setRelayHost:@"smtp.qq.com"];// 发送邮件代理服务器
    [mail setRequiresAuth:YES];
    [mail setLogin:self.sendMailTF.text];// 发送者邮箱账号
    [mail setPass:@"XXXXXXXXX"];// 发送者邮箱密码
    [mail setWantsSecure:YES];// 需要加密
    [mail setDelegate:self];
    
    NSString *content = [NSString stringWithCString:"测试内容" encoding:NSUTF8StringEncoding];
    NSDictionary *plainPart = [NSDictionary dictionaryWithObjectsAndKeys:@"text/plain; charset=UTF-8", kSKPSMTPPartContentTypeKey, content, kSKPSMTPPartMessageKey, @"8bit", kSKPSMTPPartContentTransferEncodingKey, nil];;
    
    // 添加附件
    NSString *vcfPath = [[NSBundle mainBundle] pathForResource:@"test" ofType:@"vcf"];
    NSData *vcfData = [NSData dataWithContentsOfFile:vcfPath];
    NSDictionary *vcfPart = [NSDictionary dictionaryWithObjectsAndKeys:@"text/directory;\r\n\tx-unix-mode=0644;\r\n\tname=\"test.vcf\"",kSKPSMTPPartContentTypeKey, @"attachment;\r\n\tfilename=\"test.vcf\"",kSKPSMTPPartContentDispositionKey, [vcfData encodeBase64ForData],kSKPSMTPPartMessageKey,@"base64",kSKPSMTPPartContentTransferEncodingKey,nil];
    [mail setParts:@[plainPart, vcfPart]]; // 邮件首部字段、邮件内容格式和传输编码
    
//    [mail send];
}

#pragma mark - SKPSMTPMessageDelegate
- (void)messageSent:(SKPSMTPMessage *)message
{
    NSLog(@"%@", message);
}

- (void)messageFailed:(SKPSMTPMessage *)message error:(NSError *)error
{
    NSLog(@"message - %@\nerror - %@", message, error);
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
