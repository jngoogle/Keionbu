package com.example.jngoogle.keionbu.util;

/**
 * Created by jngoogle on 2017/1/18 18:24.
 * email: guyuanhaofan@cnicg.cn
 */

public class Const {

    public static int DELAY_TIME = 1;

    public static String newSongs = "新曲";
    public static String songslist = "歌单";
    public static String ranking = "排行榜";

    // base url
    public static String BASE_URL = "http://tingapi.ting.baidu.com/";

    // 获取榜单歌曲
    public static String methodBillboardPara = "baidu.ting.billboard.billList";
    public static int OFFSET = 0;// 偏移量

    // 获取宣传图的参数
    public static String methodAdsPicPara = "baidu.ting.plaza.getFocusPic";
    public static int ADS_PIC_NUM = 7;// 设置宣传图的总个数
    public static int BILLBORAD_SIZE = 3;// 返回榜单的总数

    // 获取搜索热词的参数
    public static String methodSearchWordsPara = "baidu.ting.search.hot";

    // 获取歌单参数
    public static String methodSonglistPara = "baidu.ting.diy.gedan";
    public static int PAGE_SIZE = 10;// 分页时，每页获取数据的条数

    // 获取歌单内歌曲的参数
    public static String methodSongsInSongListPara = "baidu.ting.diy.gedanInfo";

    // 获取电台参数
    public static String methodRadioPara = "baidu.ting.radio.getRecommendRadioList";

    //榜单类别
    //新歌榜
    public static int BILLBOARD_NEW_MUSIC = 1;
    //原创音乐榜
    public static int BILLBOARD_ORIGINAL = 200;
    //热歌榜
    public static int BILLBOARD_HOT_MUSIC = 2;
    //欧美金曲榜
    public static int BILLBOARD_EU_UK = 21;
    //King榜
    public static int BILLBOARD_KING = 100;
    //华语金曲榜
    public static int BILLBOARD_NET_MUSIC = 25;
    //经典老哥榜
    public static int BILLBOARD_CLASSIC_OLD = 22;

}
