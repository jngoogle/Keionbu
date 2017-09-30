package com.example.jngoogle.keionbu.network.entity;

import java.util.List;

/**
 * Created by jngoogle on 2017/9/26.
 */

/**
 * 推荐电台实体
 */
public class RadioEntity {
    /**
     * error_code : 22000
     * list : [{"channelid":"11373552","itemid":"13496780","album_id":"13420707","title":"有待咖啡","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_019d01e1e994ba4e9d7890d9fc97f9eb.jpg","type":"lebo","desc":"音乐推荐"},{"channelid":"11373552","itemid":"13496374","album_id":"5945591","title":"这样的罗大佑，你可能不太熟","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_7894c83e731b9a8f4954fab18694db81.jpg","type":"lebo","desc":"音乐推荐"},{"channelid":"11373553","itemid":"13472541","album_id":"12774274","title":"人生：十二年一个圆满或者缺憾","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_01273c7cc2c630d44cbfd62d42a4c805.jpg","type":"lebo","desc":"都市情感"},{"channelid":"11373552","itemid":"13497641","album_id":"12380502","title":"胖友说，留言前100名让我带大家去吃小龙虾","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_df5523f3cfd5a3266d669e085b5f1a5a.jpg","type":"lebo","desc":"段子笑话"},{"channelid":"11373552","itemid":"13484227","album_id":"13384406","title":"罗大佑丨光阴带走青春，留下了故事","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1e1f1cd57cd27d41a4d7eba22deb94ea.jpg","type":"lebo","desc":"音乐推荐"},{"channelid":"11373555","itemid":"13487126","album_id":"13483086","title":"《小学生必背古诗词70+80》20：九月九日忆山东兄弟","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_7d8839a780a4d599e245cefcebdd1d70.jpg","type":"lebo","desc":"教育"}]
     */

    private int error_code;
    private List<RadioBean> list;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<RadioBean> getList() {
        return list;
    }

    public void setList(List<RadioBean> list) {
        this.list = list;
    }

    public static class RadioBean {
        /**
         * channelid : 11373552
         * itemid : 13496780
         * album_id : 13420707
         * title : 有待咖啡
         * pic : http://business.cdn.qianqian.com/qianqian/pic/bos_client_019d01e1e994ba4e9d7890d9fc97f9eb.jpg
         * type : lebo
         * desc : 音乐推荐
         */

        private String channelid;
        private String itemid;
        private String album_id;
        private String title;
        private String pic;
        private String type;
        private String desc;

        public String getChannelid() {
            return channelid;
        }

        public void setChannelid(String channelid) {
            this.channelid = channelid;
        }

        public String getItemid() {
            return itemid;
        }

        public void setItemid(String itemid) {
            this.itemid = itemid;
        }

        public String getAlbum_id() {
            return album_id;
        }

        public void setAlbum_id(String album_id) {
            this.album_id = album_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}
