package com.example.jngoogle.keionbu.network.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jngoogle on 2017/3/24.
 * Email: jammicnicoole@gmail.com
 */

public class AdsEntity {
    @SerializedName("pic")
    private List<AdPic> adPics;// 广告位轮播图
    @SerializedName("error_code")
    private String errorCode;


    public List<AdPic> getAdPics() {
        return adPics;
    }

    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Created by jngoogle on 2017/3/16.
     * Email: jammicnicoole@gmail.com
     * 新曲板块中的广告位轮播图类
     * ============================================================
     * Attention!! 有坑
     * 获取广告宣传图片的时候，只有 randpic 这个字段能够保证一定有值 ！！
     * 默认使用 randpic 这个字段来获取图片
     */
    public class AdPic {

        /**
         * type : 6
         * mo_type : 4
         * code : http://music.baidu.com/h5pc/spec_detail?id=202&columnid=92
         * randpic : http://business.cdn.qianqian.com/qianqian/pic/bos_client_148963724944b91c33ed8954f65e6e062875cae21a.jpg
         * randpic_ios5 :
         * randpic_desc : 李霄云
         * randpic_ipad : http://business.cdn.qianqian.com/qianqian/pic/bos_client_1489637257ddad127c7d3da5b6d9cb96834940cf82.jpg
         * randpic_qq : http://business.cdn.qianqian.com/qianqian/pic/bos_client_14896372751aeb812a3967610ecd196546c42767a9.jpg
         * randpic_2 :
         * randpic_iphone6 :
         * special_type : 0
         * ipad_desc : 李霄云
         * is_publish : 110011
         */

        private int type;
        private int mo_type;
        private String code;
        private String randpic;// 默认使用此字段来获取图片，其他的字段可能为空值！！
        private String randpic_ios5;
        private String randpic_desc;
        private String randpic_ipad;
        private String randpic_qq;
        private String randpic_2;
        private String randpic_iphone6;
        private int special_type;
        private String ipad_desc;
        private String is_publish;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getMo_type() {
            return mo_type;
        }

        public void setMo_type(int mo_type) {
            this.mo_type = mo_type;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getRandpic() {
            return randpic;
        }

        public void setRandpic(String randpic) {
            this.randpic = randpic;
        }

        public String getRandpic_ios5() {
            return randpic_ios5;
        }

        public void setRandpic_ios5(String randpic_ios5) {
            this.randpic_ios5 = randpic_ios5;
        }

        public String getRandpic_desc() {
            return randpic_desc;
        }

        public void setRandpic_desc(String randpic_desc) {
            this.randpic_desc = randpic_desc;
        }

        public String getRandpic_ipad() {
            return randpic_ipad;
        }

        public void setRandpic_ipad(String randpic_ipad) {
            this.randpic_ipad = randpic_ipad;
        }

        public String getRandpic_qq() {
            return randpic_qq;
        }

        public void setRandpic_qq(String randpic_qq) {
            this.randpic_qq = randpic_qq;
        }

        public String getRandpic_2() {
            return randpic_2;
        }

        public void setRandpic_2(String randpic_2) {
            this.randpic_2 = randpic_2;
        }

        public String getRandpic_iphone6() {
            return randpic_iphone6;
        }

        public void setRandpic_iphone6(String randpic_iphone6) {
            this.randpic_iphone6 = randpic_iphone6;
        }

        public int getSpecial_type() {
            return special_type;
        }

        public void setSpecial_type(int special_type) {
            this.special_type = special_type;
        }

        public String getIpad_desc() {
            return ipad_desc;
        }

        public void setIpad_desc(String ipad_desc) {
            this.ipad_desc = ipad_desc;
        }

        public String getIs_publish() {
            return is_publish;
        }

        public void setIs_publish(String is_publish) {
            this.is_publish = is_publish;
        }
    }
}
