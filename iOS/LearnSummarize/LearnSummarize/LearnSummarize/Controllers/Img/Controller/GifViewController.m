//
//  GifViewController.m
//  LearnSummarize
//
//  Created by chenshun131 on 17/1/21.
//  Copyright © 2017年 chenshun131. All rights reserved.
//

#import "GifViewController.h"
#import <FLAnimatedImage.h>
#import "DebugView.h"

@interface GifViewController ()

@property (weak, nonatomic) IBOutlet FLAnimatedImageView *imageView1;
@property (weak, nonatomic) IBOutlet FLAnimatedImageView *imageView2;
@property (weak, nonatomic) IBOutlet FLAnimatedImageView *imageView3;

@end

// Internal properties on FLAnimatedImage and FLAnimatedImageView, only availabe in debug and used exclusively for the sample project.
#if defined(DEBUG) && DEBUG

@interface FLAnimatedImage (Private)
@property (nonatomic, weak) id debug_delegate;
@end

@implementation FLAnimatedImage (Private)
@dynamic debug_delegate;
@end

@interface FLAnimatedImageView (Private)
@property (nonatomic, weak) id debug_delegate;
@end

@implementation FLAnimatedImageView (Private)
@dynamic debug_delegate;
@end

#endif

@implementation GifViewController

- (void)viewDidLoad
{
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
    
    // load local Gif
    self.imageView1.contentMode = UIViewContentModeScaleAspectFill;
    self.imageView1.clipsToBounds = YES;
    NSURL *url1 = [[NSBundle mainBundle] URLForResource:@"gif1" withExtension:@"gif"];
    NSData *data1 = [NSData dataWithContentsOfURL:url1];
    self.imageView1.animatedImage = [FLAnimatedImage animatedImageWithGIFData:data1];
    
    // load URL Gif with Debug View
    self.imageView2.contentMode = UIViewContentModeScaleAspectFill;
    self.imageView2.clipsToBounds = YES;
    self.imageView2.frame = CGRectMake(self.imageView2.frame.origin.x, self.imageView2.frame.origin.y, self.imageView2.frame.size.width, self.imageView2.frame.size.height);
    NSURL *url2 = [NSURL URLWithString:@"https://upload.wikimedia.org/wikipedia/commons/2/2c/Rotating_earth_%28large%29.gif"];
    [self loadAnimatedImageWithURL:url2 completion:^(FLAnimatedImage *animatedImage)
    {
        self.imageView2.animatedImage = animatedImage;
    
        // Set up debug UI for image 2
#if defined(DEBUG) && DEBUG
        DebugView *debugView2 = [[DebugView alloc] init];
        debugView2.style = DebugViewStyleCondensed;
        [self.imageView2 addSubview:debugView2];
        debugView2.frame = self.imageView2.bounds;
    
        self.imageView2.debug_delegate = debugView2;
        animatedImage.debug_delegate = debugView2;
#endif
        debugView2.imageView = self.imageView2;
        debugView2.image = animatedImage;
        self.imageView2.userInteractionEnabled = YES;
    }];
    
    //
    self.imageView3.contentMode = UIViewContentModeScaleAspectFill;
    self.imageView3.clipsToBounds = YES;
    NSURL *url3 = [NSURL URLWithString:@"https://cloud.githubusercontent.com/assets/1567433/10417835/1c97e436-7052-11e5-8fb5-69373072a5a0.gif"];
    self.imageView3.animatedImage = [FLAnimatedImage animatedImageWithGIFData:[NSData dataWithContentsOfURL:url3]];
}

/// Even though NSURLCache *may* cache the results for remote images, it doesn't guarantee it.
/// Cache control headers or internal parts of NSURLCache's implementation may cause these images to become uncache.
/// Here we enfore strict disk caching so we're sure the images stay around.
- (void)loadAnimatedImageWithURL:(NSURL *const)url completion:(void (^)(FLAnimatedImage *animatedImage))completion
{
    NSString *const filename = url.lastPathComponent;
    NSString *const diskPath = [NSHomeDirectory() stringByAppendingPathComponent:filename];
    
    NSData * __block animatedImageData = [[NSFileManager defaultManager] contentsAtPath:diskPath];
    FLAnimatedImage * __block animatedImage = [[FLAnimatedImage alloc] initWithAnimatedGIFData:animatedImageData];
    
    if (animatedImage) {
        if (completion) {
            completion(animatedImage);
        }
    } else {
        [[[NSURLSession sharedSession] dataTaskWithURL:url completionHandler:^(NSData *data, NSURLResponse *response, NSError *error) {
            animatedImageData = data;
            animatedImage = [[FLAnimatedImage alloc] initWithAnimatedGIFData:animatedImageData];
            if (animatedImage) {
                if (completion) {
                    dispatch_async(dispatch_get_main_queue(), ^{
                        completion(animatedImage);
                    });
                }
                [data writeToFile:diskPath atomically:YES];
            }
        }] resume];
    }
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
