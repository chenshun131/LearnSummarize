//
//  SDWebImageViewController.m
//  LearnSummarize
//
//  Created by chenshun131 on 17/2/25.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "SDWebImageViewController.h"
#import "SDWebImageCollectionViewCell.h"
#import "ImageModel.h"

@interface SDWebImageViewController ()<UICollectionViewDataSource, UICollectionViewDelegate>

@end

@implementation SDWebImageViewController
{
    NSMutableArray *data;
}

- (void)viewDidLoad
{
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
    
    self.title = @"SDWebImage网络图片展示";
    self.view.backgroundColor = [UIColor whiteColor];
    
    [self initData];
    
    UICollectionViewFlowLayout *layout = [[UICollectionViewFlowLayout alloc] init];
    layout.scrollDirection = UICollectionViewScrollDirectionVertical;
    layout.itemSize = CGSizeMake(50, 100);
    UICollectionView *collect = [[UICollectionView alloc] initWithFrame:CGRectMake(10, 0, kScreenWidth - 20, kScreenHeight - 64) collectionViewLayout:layout];
    collect.delegate = self;
    collect.dataSource = self;
    collect.backgroundColor = [UIColor whiteColor];
    [collect registerClass:[SDWebImageCollectionViewCell class] forCellWithReuseIdentifier:@"SDWebImageCollectionViewCell"];
    [self.view addSubview:collect];
}

- (void)initData
{
    data = [NSMutableArray array];
    for(int i = 0;i < 20; i++)
    {
        ImageModel *imageModel1 = [[ImageModel alloc] init];
        imageModel1.bigURL = @"http://m.xxxiao.com/wp-content/uploads/sites/3/2017/02/m.xxxiao.com_93ea3469287a73d0d9ba1ba5c6548101-683x1024.jpg";
        imageModel1.describ = @"芝芝Booty陈芝 [IMISS爱蜜社] 20170124 VOL149 清秀脸庞窈窕玲珑凹凸必现美臀坚挺浑圆长滩写真";
        
        ImageModel *imageModel2 = [[ImageModel alloc] init];
        imageModel2.bigURL = @"http://m.xxxiao.com/wp-content/uploads/sites/3/2016/01/m.xxxiao.com_69a5c90a911f8be749ddfacb9baeb16a.jpg";
        imageModel2.describ = @"滑腻丰满于大小姐小睡衣圆润性感";
        
        ImageModel *imageModel3 = [[ImageModel alloc] init];
        imageModel3.bigURL = @"http://m.xxxiao.com/wp-content/uploads/sites/3/2016/08/m.xxxiao.com_fa57e004eadd6b414e1f90cdc835295e.jpg";
        imageModel3.describ = @"清纯妹子 李梦婷 养眼大尺度比基尼私密美拍";
        
        ImageModel *imageModel4 = [[ImageModel alloc] init];
        imageModel4.bigURL = @"http://m.xxxiao.com/wp-content/uploads/sites/3/2016/10/m.xxxiao.com_e661686c43f5c4d5df1e4cec4e89d9da.jpg";
        imageModel4.describ = @"前凸后翘 夏小秋秋秋 死库水+眼镜OL性感比基尼靓拍";
        
        ImageModel *imageModel5 = [[ImageModel alloc] init];
        imageModel5.bigURL = @"http://m.xxxiao.com/wp-content/uploads/sites/3/2017/01/m.xxxiao.com_140821485d31371d88d1c51a5c40f690.jpg";
        imageModel5.describ = @"周琰琳LIN [YOUMI尤蜜荟] 20161227 VOL002 圣诞艳红服饰秀丽绝俗眉目灵动媚态横生艳丽无匹";
        
        ImageModel *imageModel6 = [[ImageModel alloc] init];
        imageModel6.bigURL = @"http://m.xxxiao.com/wp-content/uploads/sites/3/2016/01/m.xxxiao.com_95fd89b4424800585cc36b73b563f765.jpg";
        imageModel6.describ = @"小萝莉徐cake童颜巨乳私房半裸写真";
        
        ImageModel *imageModel7 = [[ImageModel alloc] init];
        imageModel7.bigURL = @"http://m.xxxiao.com/wp-content/uploads/sites/3/2016/01/m.xxxiao.com_2cd4bd4406d335c51a9b4440e098ff75.jpg";
        imageModel7.describ = @"旗袍晚礼裙SISY思普吉岛性感美拍";
        
        ImageModel *imageModel8 = [[ImageModel alloc] init];
        imageModel8.bigURL = @"http://m.xxxiao.com/wp-content/uploads/sites/3/2017/02/m.xxxiao.com_558114faf35aff90a319bae457ec7a86.jpg";
        imageModel8.describ = @"泰美丽 Namwanmuay 泰国白皙美女惊艳性感美照";
        
        ImageModel *imageModel9 = [[ImageModel alloc] init];
        imageModel9.bigURL = @"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/12/m.xxxiao.com_3866b3cf09a70cf50756194c4fbd8ce3.jpg";
        imageModel9.describ = @"Angelababy高清人物壁纸";
        
        ImageModel *imageModel10 = [[ImageModel alloc] init];
        imageModel10.bigURL = @"http://m.xxxiao.com/wp-content/uploads/sites/3/2016/10/m.xxxiao.com_e53c127cdc6004d628765c71478470b5.jpg";
        imageModel10.describ = @"刘丽娜cn鱼丸 鱼丸小lo装 激萌可爱";
        
        ImageModel *imageModel11 = [[ImageModel alloc] init];
        imageModel11.bigURL = @"http://m.xxxiao.com/wp-content/uploads/sites/3/2017/02/m.xxxiao.com_d7ea17fcb0bc5bc2210122e4d3be2c66.jpg";
        imageModel11.describ = @"萌琪琪&莉恩&颜爱泽 [尤果圈爱尤物] VOL634 粉肌脂腻腰折杨柳 春节丁字裤大尺度灯迷福利";
        
        [data addObject:imageModel1];
        [data addObject:imageModel2];
        [data addObject:imageModel3];
        [data addObject:imageModel4];
        [data addObject:imageModel5];
        [data addObject:imageModel6];
        [data addObject:imageModel7];
        [data addObject:imageModel8];
        [data addObject:imageModel9];
        [data addObject:imageModel10];
        [data addObject:imageModel11];
    }
}

#pragma mark - UICollectionViewDataSource

- (NSInteger)collectionView:(UICollectionView *)collectionView numberOfItemsInSection:(NSInteger)section
{
    return data.count;
}

- (UICollectionViewCell *)collectionView:(UICollectionView *)collectionView cellForItemAtIndexPath:(NSIndexPath *)indexPath
{
    SDWebImageCollectionViewCell *cell = [collectionView dequeueReusableCellWithReuseIdentifier:@"SDWebImageCollectionViewCell" forIndexPath:indexPath];
    if(data.count > indexPath.row)
    {
        [cell setContent:data[indexPath.row]];
    }
    return cell;
}

#pragma mark - UICollectionViewDelegate
- (BOOL)collectionView:(UICollectionView *)collectionView shouldHighlightItemAtIndexPath:(NSIndexPath *)indexPath
{
    return YES;
}


- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
    
    [[SDWebImageManager sharedManager] cancelAll];
    [[SDImageCache sharedImageCache] clearMemory];
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
