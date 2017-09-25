package com.example.jngoogle.keionbu.network.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/3/29.
 */

public class SongMenuEntity {

    /**
     * error_code : 22000
     * total : 8359
     * havemore : 1
     * contentList : [{"listid":"365291392","listenum":"488","collectnum":"1","title":"【环球之音】电力十足的欧美女声","pic_300":"http://musicugc.cdn.qianqian.com/ugcdiy/pic/0f2295b3eccd41b0bc6ccf97d1057ddd.jpg","tag":"欧美,电子","desc":"当劲爆激燃的电子音乐遇到充满魅力的女声，整首歌就会增添上一抹惊艳的色彩，唤你沉睡已久的听觉。这种充满别样魅力的女生不同以往的婉转轻柔，在电音坚硬的外壳下，透出不羁的气质与随性的表达。本单精选环球音乐旗下，那些小众的欧美独立电子音乐人，在她们充满想象力的作品中，电子音乐的动感节拍与精美的女声吟唱交融得以新生，让你感受淋漓极致的别样女声！","pic_w300":"http://musicugc.cdn.qianqian.com/ugcdiy/pic/0f2295b3eccd41b0bc6ccf97d1057ddd.jpg","width":"300","height":"300","songIds":["332130800","258026067","332131548","122787677","262715590","264909204","268234585","574342","122823659","269289987"]}]
     */

    private int error_code;
    private int total;
    private int havemore;
    private List<ContentBean> content;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getHavemore() {
        return havemore;
    }

    public void setHavemore(int havemore) {
        this.havemore = havemore;
    }

    public List<ContentBean> getContentList() {
        return content;
    }

    public void setContentList(List<ContentBean> contentList) {
        this.content = contentList;
    }

    public static class ContentBean {
        /**
         * listid : 365291392
         * listenum : 488
         * collectnum : 1
         * title : 【环球之音】电力十足的欧美女声
         * pic_300 : http://musicugc.cdn.qianqian.com/ugcdiy/pic/0f2295b3eccd41b0bc6ccf97d1057ddd.jpg
         * tag : 欧美,电子
         * desc : 当劲爆激燃的电子音乐遇到充满魅力的女声，整首歌就会增添上一抹惊艳的色彩，唤你沉睡已久的听觉。这种充满别样魅力的女生不同以往的婉转轻柔，在电音坚硬的外壳下，透出不羁的气质与随性的表达。本单精选环球音乐旗下，那些小众的欧美独立电子音乐人，在她们充满想象力的作品中，电子音乐的动感节拍与精美的女声吟唱交融得以新生，让你感受淋漓极致的别样女声！
         * pic_w300 : http://musicugc.cdn.qianqian.com/ugcdiy/pic/0f2295b3eccd41b0bc6ccf97d1057ddd.jpg
         * width : 300
         * height : 300
         * songIds : ["332130800","258026067","332131548","122787677","262715590","264909204","268234585","574342","122823659","269289987"]
         */

        private String listid;
        private String listenum;
        private String collectnum;
        private String title;
        private String pic_300;
        private String tag;
        private String desc;
        private String pic_w300;
        private String width;
        private String height;
        private List<String> songIds;

        public String getListid() {
            return listid;
        }

        public void setListid(String listid) {
            this.listid = listid;
        }

        public String getListenum() {
            return listenum;
        }

        public void setListenum(String listenum) {
            this.listenum = listenum;
        }

        public String getCollectnum() {
            return collectnum;
        }

        public void setCollectnum(String collectnum) {
            this.collectnum = collectnum;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPic_300() {
            return pic_300;
        }

        public void setPic_300(String pic_300) {
            this.pic_300 = pic_300;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPic_w300() {
            return pic_w300;
        }

        public void setPic_w300(String pic_w300) {
            this.pic_w300 = pic_w300;
        }

        public String getWidth() {
            return width;
        }

        public void setWidth(String width) {
            this.width = width;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public List<String> getSongIds() {
            return songIds;
        }

        public void setSongIds(List<String> songIds) {
            this.songIds = songIds;
        }
    }

    @Override
    public String toString() {
        return "SongMenuEntity{" +
                "error_code=" + error_code +
                ", total=" + total +
                ", havemore=" + havemore +
                ", contentList=" + content +
                '}';
    }
}
