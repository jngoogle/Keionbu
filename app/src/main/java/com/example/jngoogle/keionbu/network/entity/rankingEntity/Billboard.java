package com.example.jngoogle.keionbu.network.entity.rankingEntity;

/**
 * Created by jngoogle on 2017/2/23 15:47.
 * email: guyuanhaofan@cnicg.cn
 */


/**
 * 音乐榜单实体
 */

public class Billboard {

    /**
     * billboard_type : 200
     * name : 原创音乐榜
     * pic_s192 : http://y.baidu.com/cms/app/192-192.jpg
     * pic_s210 : http://y.baidu.com/cms/app/210-210.jpg
     * pic_s260 : http://y.baidu.com/cms/app/260-260.jpg
     * pic_s444 : http://y.baidu.com/cms/app/444-444.jpg
     * pic_s640 : http://y.baidu.com/cms/app/640-640.jpg
     * pic_s238 : http://business.cdn.qianqian.com/qianqian/file/5746a2d18e954_287.jpg
     * web_url : http://y.baidu.com/top?play_top=top&pst=music_top
     */

    private int billboard_type;
    private String name;
    private String pic_s192;
    // 这四种尺寸的图常用
    private String pic_s210;
    private String pic_s260;
    private String pic_s444;
    private String pic_s640;

    private String pic_s238;
    private String web_url;

    public int getBillboard_type() {
        return billboard_type;
    }

    public String getName() {
        return name;
    }

    public String getPic_s192() {
        return pic_s192;
    }

    public String getPic_s210() {
        return pic_s210;
    }

    public String getPic_s260() {
        return pic_s260;
    }

    public String getPic_s444() {
        return pic_s444;
    }

    public String getPic_s640() {
        return pic_s640;
    }

    public String getPic_s238() {
        return pic_s238;
    }

    public String getWeb_url() {
        return web_url;
    }
}
