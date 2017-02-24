//
//  UILabel+AttributedString.m
//  testFor64
//
//  Created by chen Yuheng on 15/8/3.
//  Copyright (c) 2015年 chen Yuheng. All rights reserved.
//

#import "UILabel+AttributedString.h"

static NSString *characterSetString = @"☮☯☹☺☻✓✗✪✩❄❀⌘⌥⇧♪♫♬☹☺☻✓✔✗✘☚☛☜☝☞☟✌✉✍✎✏✐✑✒✁✂✃✄✆✇✈♩♪♫♬♭♮♯⌘⌥⇧^⌛©®™π♃♄♅♆♇♈♉♊♋♌♍♎♏♐♑♒♓☥✝✡☠☢☣☤☨✠☩☮☯☪☭☫☬☸☀☁☂☃☼❂☆☎☏♔♕♖♗♘♙☑♚♛♜♝♞♟☒♠♣♥♦♀♂♤♧♡♢♁☿❛❜❝❞❡❢❣❤❥❦❧❖♨✪✩✫✬✭✮✻✽✾❃❇❈✥✵✶✹✱❄❅❆✿❀❁✦✧←↑→↓↔↕↳➪➫➭➳➷➸➹➟➠➡➥➦➔❶❷❸❹❺❻❼❽❾❿➀➁➂➃➄➅➆➇➈➉➊➋➌➍➎➏➐➑➒➓①②③④⑤⑥⑦⑧⑨⑩⑪⑫⑬⑭⑮⑯⑰⑱⑲⑳⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽⑾⑿⒀⒁⒂⒃⒄⒅⒆⒇⓪ⒶⒷⒸⒹⒺⒻⒼⒽⒾⒿⓀⓁⓂⓃⓄⓅⓆⓇⓈⓉⓊⓋⓌⓍⓎⓏⓐⓑⓒⓓⓔⓕⓖⓗⓘⓙⓚⓛⓜⓝⓞⓟⓠⓡⓢⓣⓤⓥⓦⓧⓨⓩ℀℁ℂ℃℄℅℆ℇ℈℉ℊℋℌℍℎℏℐℑℒ℔ℓℕ№℗℘ℙℚℛℜℝ℞℟℠℡™℣ℤ℥Ω℧ℨ℩KÅℬℭ℮ℯℰℱℲℳℴℵℶℷ℺℻⅁⅂⅄⅃⅋⅍ⅎ⒜⒝⒞⒟⒠⒡⒢⒣⒤⒥⒦⒧⒨⒩⒪⒫⒬⒭⒮⒯⒰⒱⒲⒳⒴⒵✙✚✛✜✝✞✟✠✡✢✣✤✥✦✧✩✫✪✬✭✮✯✰✱✲✳✴✵✶✷✸✹✺✻✼✽✾✿❀❁❂❃❄❅❆❇❈❉❊❋❍❏❐❑❒❖▁▂▃▄▅▆▇█▉▊▋▌▍▎▏▐░▒▓▀▔▕❘❙❚■□▢▣▤▥▦▧▨▩▪▫▬▭▮▯▰▱▲△▴▵▶▷▸▹►▻▼▽▾▿◀◁◂◃◄◅◆◇◈◉◊○◌◍◎●◐◑◒◓◔◕◖◗◘◙◚◛◜◝◞◟◠◡◢◣◤◥◦◧◨◩◪◫◬◭◮◯⑀⑁⑂⑃⑄⑅⑆⑇⑈⑊⑉←↑→↓↔↕↖↗↘↙↚↛↜↝↞↟↠↡↢↣↤↥↦↧↨↩↪↫↬↭↮↯↰↱↲↳↴↵↶↷↸↹↺↻↼↽↾↿⇀⇁⇂⇃⇄⇅⇆⇇⇈⇉⇊⇋⇌⇍⇎⇏⇐⇑⇒⇓⇔⇖⇕⇗⇘⇙⇚⇛⇜⇝⇞⇟⇠⇡⇢⇣⇤⇥⇦⇧⇨⇩⇪⅓⅔¼½¾⅕⅖⅗⅘⅙⅚⅛⅜⅝⅞⅟°⁰º¹²³⁴⁵⁶⁷⁸⁹ⁱ⁺⁻⁼⁽⁾ⁿ₀₁₂₃₄₅₆₇₈₉₊₋₌₍₎ₐₑₒₓₔ✁✂✃✄✆✇✈✉✌✍✎✏✐✑✒✓✔✕✖✗✘☀☁☂☃☄★☆☇☈☉☊☋☌☍☎☏☐☑☒☚☜☛☝☞☟☠☡☢☣☤☥☦☧☨☩☪☫☬☭☮☯☰☱☲☳☴☵☶☷☸☹☺☻☼☽☾☿♀♂♁♃♄♅♆♇♈♉♊♋♌♍♎♏♐♑♒♓♔♕♖♗♘♙♚♛♜♝♞♟♠♣♥♦♤♧♡♢♨♩♪♫♬♭♮♯ɐɑɒɓɔɕɖɗɘəɚɛɜɝɞɟɠɡɢɣɤɥɦɧɨɩɪɫɬɭɮɯɰɱɲɳɴɵɶɷɸɹɺɻɼɽɾɿʀʁʂʃʅʄʆʇʈʉʊʋʌʍʎʏʐʑʒʓʔʕʖʗʘʙʚʛʜʝʞʟʠʡʢʣʤʥʦʧʨʩʪʫʬʭʮᴁᴈᴉᴎᴑᴒᴓᴔᴖᴗᴘᴙᴚᴝᴞᴟᵃᵄᵅᵆᵇᵈᵉᵊᵋᵌᵍᵎᵏᵐᵑᵒᵓᵔᵕᵖᵗᵘᵙᵚᵛᵝᵞᵟᵡᵢᵣᵤᵥᵦᵧᵨᵪᵫᵬᵭᵮᵱᵲᵳᵵᵺƒ†‡ˆ‰Š‹ŒŽ•™š›œžŸ¡¢£¤¥¦§©ª¬®¯±µ¶‰‱·†‡•‣¿×÷‐‑‒–—―‖‗«»‛‘’‚“”„‟‚„…․‥…¸‧–—¨˜´′″‴‵‶‷‸‹›※‼‽‾‿⁀⁁⁂⁃⁅⁄⁆⁇⁈⁉⁊⁋⁌⁍⁎⁏⁐⁑⁒⁓⁔⁕⁗⁖⁘⁙⁚⁛⁜⁝⁞∀∁∂∃∄∅∆∇∈∉∊∋∌∍∎∏∐∑−∓∔∕∖∗∘∙√∛∜∝∞∟∠∡∢∣∤∥∦∧∨∩∪∫∬∭∮∯∰∱∲∳∴∵∶∷∹∸∺∻∼∽∾∿≀≁≂≃≄≅≆≇≈≉≊≋≌≍≎≏≐≑≒≓≔≕≖≗≘≙≚≛≜≝≞≟≠≡≢≣≤≥≦≧≨≩≪≫≬≭≮≯≰≱≲≳≴≵≶≷≸≹≺≻≼≽≾≿⊀⊁⊂⊃⊄⊅⊆⊇⊈⊉⊊⊋⊌⊍⊎⊏⊐⊑⊒⊓⊔⊕⊖⊗⊘⊙⊚⊛⊜⊝⊞⊟⊠⊡⊢⊣⊤⊥⊦⊧⊨⊩⊪⊫⊬⊭⊮⊯⊰⊱⊲⊳⊴⊵⊶⊷⊸⊹⊺⊻⊼⊽⊾⊿⋀⋁⋂⋃⋄⋅⋆⋇⋈⋉⋊⋋⋌⋍⋎⋏⋐⋑⋒⋓⋔⋕⋖⋗⋘⋙⋚⋛⋜⋝⋞⋟⋠⋡⋢⋣⋤⋥⋦⋧⋨⋩⋪⋫⋬⋭⋮⋯⋰⋱⌀⌁⌂⌃⌄⌅⌆⌇⌈⌉⌊⌋⌌⌍⌎⌏⌐⌑⌒⌓⌔⌕⌖⌗⌘⌙⌚⌛⌜⌝⌞⌟⌠⌡⌢⌣⌤⌥⌦⌧⌨〈〉⌫⌬⌭⌮⌯⌰⌱⌲⌳⌴⌵⌶⌷⌸⌹⌺⌻⌼⌽⌾⌿⍀⍁⍂⍃⍄⍅⍆⍇⍈⍉⍊⍋⍌⍍⍎⍏⍐⍑⍒⍓⍔⍕⍖⍗⍘⍙⍚⍛⍜⍝⍞⍟⍠⍡⍢⍣⍤⍥⍦⍧⍨⍩⍪⍫⍬⍭⍮⍯⍰⍱⍲⍳⍴⍵⍶⍷⍸⍹⍺⏎₠₡₢₣₤₥₦₧₨₩₪₫€₭₮₱₲₳₴₵$¢£¤¥ƒ৲৳฿㍐元円圆圎圓圜＄￠￡￥ԱԲԳԴԵԶԷԸԹԺԻԼԽԾԿՀՁՂՃՄՅՆՇՈՉՊՋՌՍՎՏՐՑՒՓՔՕՖՙ՚՛՜՝՞՟աբգդեզէըթժիլխծկհձղճմյնշոչպջռսվտրցւփքօֆև։ਠਅਆਇਈਉਊਏਐਓਔਕਖਗਘਙਚਛਜਝਞਟਠਡਢਣਤਥਦਧਨਪਫਬਭਮਯਰਲਵਸ਼ਸਹਖ਼ਗ਼ਜ਼ੜਫ਼੦੧੨੩੪੫੬੭੮੯ੲੳੴਠЀЁЂЃЄЅІЇЈЉЊЋЌЍЎЏАБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдежзийклмнопрстуфхцчшщъыьэюяѐёђѓєѕіїјљњћќѝўџѢѣѤѥѦѧѨѩѪѫѬѭѰѱѲѳѴѵѶѷѸѹҌҍҐґҒғҖҗҘҙҚқҜҝҠҡҢңҤҥҪҫҬҭҮүҰұҲҳҴҵҶҷҸҹҺһҼҽҾҿӀӁӂӇӈӏӐӑӒӓӔӕӖӗӘәӚӛӜӝӞӟӠӡӢӣӤӥӦӧӨөӪӫӬӭӮӯӰӱӲӳӴӵӶӷӸӹӾӿԀԁԐԑԒԓठअआइईउऊऋऌऍऎएऐऑऒओऔकखगघङचछजझञटठडढणतथदधनऩपफबभमयरऱलळऴवशषसहक़ख़ग़ज़ड़ढ़फ़य़ॠॡ॥०१२३४५६७८९ႠႡႢႣႤႥႦႧႨႩႪႫႬႭႮႯႰႱႲႳႴႵႶႷႸႹႺႻႼႽႾႿჀჁჂჃჄჅაბგდევზთიკლმნოპჟრსტუფქღყშჩცძწჭხჯჰჱჲჳჴჵჶΑΒΓΔΕΖΗΘΙΚΛΜΝΞΟΠΡΣΤΥΦΧΨΩΪΫάέήίΰαβγδεζηθικλμνξοπρςστυφχψωϊϋόύώϐϑϒϓϔϕϖϚϜϞϠϰϱϲϳϴϵ϶ϷϸϹϺϻϼϽϾϿͻͼͽ;ΆΈΉΊΌΎΏΐઠઅઆઇઈઉઊઋઍએઐઑઓઔકખગઘઙચછજઝઞટઠડઢણતથદધનપફબભમયરલળવશષસહૐૠ૦૧૨૩૪૫૬૭૮૯וזחטיטיךכלםמןנסעףפץצקרשתװױײ׳״אבגדהוזחÀàÁáÂâÃãÄäÅåĀāĂăĄąÆæÇçĆćĈĉĊċČčĎďĐđÈèÉéÊêËëĒēĔĕĖėĘęĚěĜĝĞğĠġĢģĤĥĦħÌìÍíÎîÏïĨĩĪīĬĭĮįİıĲĳĴĵĶķĸĹĺĻļĽľĿŀŁłÑñŃńŅņŇňŉÒòÓóÔôÕõÖöØøŌōŎŏŐőŒœŔŕŖŗŘřŚśŜŝŞşŠšŢţŤťŦŧÙùÚúÛûÜüŨũŪūŬŭŮůŰűŲųŴŵÝýÿŶŷŸŹźŻżŽžǞǟǠǡǍǎǺǻȀȁȂȃȦȧḀḁẚẠạẢảẤấẦầẨẩẪẫẬậẮắẰằẲẳẴẵẶặǢǣǼǽḂḃḄḅḆḇḈḉḊḋḌḍḎḏḐḑḒḓǝȨȩȄȅȆȇḔḕḖḗḘḙḚḛḜḝẸẹẺẻẼẽẾếỀềỂểỄễỆệḞḟẛǤǥǦǧǴǵḠḡȞȟḢḣḤḥḦḧḨḩḪḫẖǏǐȈȉȊȋḬḭḮḯỈỉỊịǰǨǩḰḱḲḳḴḵḶḷḸḹḺḻḼḽḾḿṀṁṂṃǸǹṄṅṆṇṈṉṊṋǑǒǪǫǬǭȌȍȎȏȪȫȬȭȮȯȰȱṌṍṎṏṐṑṒṓỌọỎỏỐốỒồỔổỖỗỘộỚớỜờỞởỠỡỢợṔṕṖṗȐȑȒȓṘṙṚṛṜṝṞṟȘșṠṡṢṣṤṥṦṧṨṩȚțṪṫṬṭṮṯṰṱẗǓǔǕǖǗǘǙǚǛǜȔȕȖȗṲṳṴṵṶṷṸṹṺṻỤụỦủỨứỪừỬửỮữỰựṼṽṾṿẀẁẂẃẄẅẆẇẈẉẘẊẋẌẍȲȳẎẏẙỲỳỴỵỶỷỸỹȤȥẐẑẒẓẔẕÞþßÐðŊŋſƀƁƂƃƄƅƆƇƈƉƊƋƌƍƎƏƐƑƒƓƔƕƖƗƘƙƚƛƜƝƞƟƠơƢƣƤƥƦƧƨƩƪƫƬƭƮƯưƱƲƳƴƵƶƷƸƹƺƻƼƽƾƿǀǁǂǃǄǅǆǇǈǉǊǋǌǱǲǳȠȷȸȹȺȼȽȾɁɂɃɄɅɆɇɈɉɊɋɌɍɎɏȜȝǾǿǷǮǯபஃஅஆஇஈஉஊஎஏஐஒஓஔகஙசஜஞடணதநனபமயரறலளழவஷஸஹ௦௧௨௩௪௫௬௭௮௯௰௱௲กขฃคฅฆงจฉชซฌญฎฏฐฑฒณดตถทธนบปผฝพฟภมยรฤลฦวศษสหฬอฮฯะ฿เแโใไๅๆ๏๐๑๒๓๔๕๖๗๘๙ༀ༁༂༃༄༅༆༇༈༉༊་༌།༎༏༐༑༒༓༔༕༖༗ང༚༛༜༝༞༟༠༡༢༣༤༥༦༧༨༩༪༫༬༭༮༯༰༱༲༳༴༺༻༼༽ཀཁགགྷཅཆཇཉཊཋཌཌྷཎཏཐདདྷནཔཕབབྷམཙཚཛཛྷཝཞཟའཡརལཤཥསཧཨཀྵཪ";

@implementation UILabel(AttributedString)

- (void)as_setText:(NSString *)string
{
    UITextView *tmp = [[UITextView alloc]init];
    tmp.text = string;
    tmp.font = [self font];
    tmp.textColor = [self textColor];
    tmp.textAlignment = [self textAlignment];
    
    self.attributedText = tmp.attributedText;
    tmp = nil;
}

- (void)as_setAttributedText
{
    NSCharacterSet *set = [NSCharacterSet characterSetWithCharactersInString:characterSetString];
    NSMutableArray *t_chracterSet = [NSMutableArray array];
    NSMutableAttributedString *t_string = [[NSMutableAttributedString alloc]initWithAttributedString:self.attributedText];
    for (NSInteger i=0;i<self.text.length;i++)
    {
        unichar chrac = [self.text characterAtIndex:i];
        if ([set characterIsMember:chrac])
        {
            [t_chracterSet addObject:[NSString stringWithCharacters:&chrac length:1]];
            
            NSDictionary *dict = [NSDictionary dictionaryWithObjects:@[[UIFont fontWithName:@"HiraKakuProN-W6" size:self.font.pointSize]] forKeys:@[NSFontAttributeName]];
            [t_string setAttributes:dict range:NSMakeRange(i,1)];
        }
    }
    self.attributedText = t_string;
}
@end
