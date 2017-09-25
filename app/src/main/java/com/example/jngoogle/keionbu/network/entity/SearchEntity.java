package com.example.jngoogle.keionbu.network.entity;

import java.util.List;

/**
 * Created by jngoogle on 2017/3/29.
 * Email: jammicnicoole@gmail.com
 */

public class SearchEntity {
    /**
     * error_code : 22000
     * result : [{
     * "strong":1,
     * "word":"薛之谦《高尚》",
     * "linktype":0,
     * "linkurl":""
     * },
     * {"strong":0,"word":"陈梓童《Don't Say》","linktype":0,"linkurl":""},{"strong":0,"word":"许嵩/洛天依《深夜书店》","linktype":0,"linkurl":""},{"strong":0,"word":"林俊杰","linktype":0,"linkurl":""},{"strong":0,"word":"By2","linktype":0,"linkurl":""},{"strong":0,"word":"刚好遇见你","linktype":0,"linkurl":""},{"strong":0,"word":"张杰","linktype":0,"linkurl":""},{"strong":0,"word":"周杰伦","linktype":0,"linkurl":""},{"strong":0,"word":"曲婉婷","linktype":0,"linkurl":""},{"strong":0,"word":"厉害了!我的歌","linktype":0,"linkurl":""},{"strong":0,"word":"因为遇见你","linktype":0,"linkurl":""},{"strong":0,"word":"邓丽君","linktype":0,"linkurl":""},{"strong":0,"word":"冷漠","linktype":0,"linkurl":""},{"strong":0,"word":"大王叫我来巡山","linktype":0,"linkurl":""},{"strong":0,"word":"郑源","linktype":0,"linkurl":""}]
     */

    private int error_code;
    private List<ResultBean> result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * strong : 1
         * word : 薛之谦《高尚》
         * linktype : 0
         * linkurl :
         */

        private int strong;
        private String word;
        private int linktype;
        private String linkurl;

        public int getStrong() {
            return strong;
        }

        public void setStrong(int strong) {
            this.strong = strong;
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public int getLinktype() {
            return linktype;
        }

        public void setLinktype(int linktype) {
            this.linktype = linktype;
        }

        public String getLinkurl() {
            return linkurl;
        }

        public void setLinkurl(String linkurl) {
            this.linkurl = linkurl;
        }
    }
}
