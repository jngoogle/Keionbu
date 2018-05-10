package com.example.jngoogle.keionbu.network.entity;

import java.util.List;

/**
 * Created by jngoogle on 2017/10/17.
 */

/**
 * 新专辑上架
 * 层级结构略复杂
 */
public class NewAlbumEntity {


    /**
     * error_code : 22000
     * plaze_album_list : {"RM":{"album_list":{"list":[{"album_id":"560376866","title":"了不起寂寞","publishcompany":"Sony Music","country":"内地","songs_total":"0","pic_small":"http://musicdata.baidu.com/data2/pic/b8041067913fd1f654cf0440a4bfe3ad/560376868/560376868.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/b8041067913fd1f654cf0440a4bfe3ad/560376868/560376868.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/b8041067913fd1f654cf0440a4bfe3ad/560376868/560376868.jpg@s_1,w_300,h_300","artist_id":"1073","all_artist_id":"1073","author":"戴爱玲","publishtime":"2017-10-16","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"556192886","title":"学不会妥协","publishcompany":"塔堡文化","country":"内地","songs_total":"3","pic_small":"http://musicdata.baidu.com/data2/pic/7aae4f3ec27ded5aac4a078dc78a3ee8/556190953/556190953.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/7aae4f3ec27ded5aac4a078dc78a3ee8/556190953/556190953.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/7aae4f3ec27ded5aac4a078dc78a3ee8/556190953/556190953.jpg@s_1,w_300,h_300","artist_id":"28788020","all_artist_id":"28788020","author":"风小筝","publishtime":"2017-09-26","resource_type_ext":"3","price":"2.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"560424502","title":"Hey My Dear","publishcompany":"华宇世博","country":"内地","songs_total":"1","pic_small":"http://musicdata.baidu.com/data2/pic/0c70d4124c2954f26a0221d3e6c36f6b/560424492/560424492.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/0c70d4124c2954f26a0221d3e6c36f6b/560424492/560424492.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/0c70d4124c2954f26a0221d3e6c36f6b/560424492/560424492.jpg@s_1,w_300,h_300","artist_id":"546627839","all_artist_id":"546627839","author":"徐露露","publishtime":"2017-10-17","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"560400001","title":"虽然前途未卜 我愿陪你吃土","publishcompany":"冬曦音乐","country":"内地","songs_total":"2","pic_small":"http://musicdata.baidu.com/data2/pic/77ea5342bca6ca590d2a6feaeeff7dfc/560399089/560399089.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/77ea5342bca6ca590d2a6feaeeff7dfc/560399089/560399089.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/77ea5342bca6ca590d2a6feaeeff7dfc/560399089/560399089.jpg@s_1,w_300,h_300","artist_id":"1985895","all_artist_id":"1985895,293679542","author":"艾伦,马丽","publishtime":"2017-10-13","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"560390608","title":"永不消逝","publishcompany":"自在天浩","country":"内地","songs_total":"1","pic_small":"http://musicdata.baidu.com/data2/pic/bb4ed17cf0252c0a5b6cbd3451aaf557/560410401/560410401.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/bb4ed17cf0252c0a5b6cbd3451aaf557/560410401/560410401.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/bb4ed17cf0252c0a5b6cbd3451aaf557/560410401/560410401.jpg@s_1,w_300,h_300","artist_id":"1843","all_artist_id":"1843","author":"金志文","publishtime":"2017-10-16","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"559844060","title":"I Feel So Good","publishcompany":"ROKON滚石电音","country":"内地","songs_total":"3","pic_small":"http://musicdata.baidu.com/data2/pic/5b9bef379781ac632e5a5019813180fd/559843769/559843769.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/5b9bef379781ac632e5a5019813180fd/559843769/559843769.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/5b9bef379781ac632e5a5019813180fd/559843769/559843769.jpg@s_1,w_300,h_300","artist_id":"539881578","all_artist_id":"539881578","author":"妮可酱","publishtime":"2017-10-16","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"560125207","title":"太难","publishcompany":"华宇世博","country":"内地","songs_total":"2","pic_small":"http://musicdata.baidu.com/data2/pic/692b8965ec3b093f415528fb79eb91c3/560122522/560122522.JPG@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/692b8965ec3b093f415528fb79eb91c3/560122522/560122522.JPG@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/692b8965ec3b093f415528fb79eb91c3/560122522/560122522.JPG@s_1,w_300,h_300","artist_id":"14378906","all_artist_id":"14378906,267336016","author":"夏天Alex,臧恰","publishtime":"2017-10-16","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"560007197","title":"Romance","publishcompany":"Sony Music","country":"欧美","songs_total":"0","pic_small":"http://musicdata.baidu.com/data2/pic/2772cb8e5c648d1bbc3453707b7ac48e/560007198/560007198.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/2772cb8e5c648d1bbc3453707b7ac48e/560007198/560007198.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/2772cb8e5c648d1bbc3453707b7ac48e/560007198/560007198.jpg@s_1,w_300,h_300","artist_id":"2371","all_artist_id":"2371","author":"郎朗","publishtime":"2017-10-13","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"559843718","title":"Leave Me Alone","publishcompany":"ROKON滚石电音","country":"内地","songs_total":"1","pic_small":"http://musicdata.baidu.com/data2/pic/d436ee4f595802371ece467714c58d2d/559843707/559843707.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/d436ee4f595802371ece467714c58d2d/559843707/559843707.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/d436ee4f595802371ece467714c58d2d/559843707/559843707.jpg@s_1,w_300,h_300","artist_id":"539880444","all_artist_id":"539880444","author":"郑平","publishtime":"2017-10-13","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"559949680","title":"天籁 Studio Version ","publishcompany":"Sony Music","country":"内地","songs_total":"0","pic_small":"http://musicdata.baidu.com/data2/pic/7c0e4039955b69c7e6117743f79d5585/559949681/559949681.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/7c0e4039955b69c7e6117743f79d5585/559949681/559949681.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/7c0e4039955b69c7e6117743f79d5585/559949681/559949681.jpg@s_1,w_300,h_300","artist_id":"162","all_artist_id":"162","author":"莫文蔚","publishtime":"2017-10-12","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"560088842","title":"AquafinA","publishcompany":"摩登天空","country":"内地","songs_total":"1","pic_small":"http://musicdata.baidu.com/data2/pic/8981a1749fb7a15c9f4cfb592662eac6/560088542/560088542.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/8981a1749fb7a15c9f4cfb592662eac6/560088542/560088542.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/8981a1749fb7a15c9f4cfb592662eac6/560088542/560088542.jpg@s_1,w_300,h_300","artist_id":"337672357","all_artist_id":"337672357","author":"OB03","publishtime":"2017-10-13","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"560090231","title":"红线","publishcompany":"畅和文化","country":"内地","songs_total":"1","pic_small":"http://musicdata.baidu.com/data2/pic/71ffd7716295cc1c50f2e7586c9cefa9/560089591/560089591.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/71ffd7716295cc1c50f2e7586c9cefa9/560089591/560089591.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/71ffd7716295cc1c50f2e7586c9cefa9/560089591/560089591.jpg@s_1,w_300,h_300","artist_id":"277251819","all_artist_id":"277251819","author":"叶炫清","publishtime":"2017-10-13","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"}],"havemore":1}}}
     */

    private int error_code;
    private PlazeAlbumListBean plaze_album_list;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public PlazeAlbumListBean getPlaze_album_list() {
        return plaze_album_list;
    }

    public void setPlaze_album_list(PlazeAlbumListBean plaze_album_list) {
        this.plaze_album_list = plaze_album_list;
    }

    public static class PlazeAlbumListBean {
        /**
         * RM : {"album_list":{"list":[{"album_id":"560376866","title":"了不起寂寞","publishcompany":"Sony Music","country":"内地","songs_total":"0","pic_small":"http://musicdata.baidu.com/data2/pic/b8041067913fd1f654cf0440a4bfe3ad/560376868/560376868.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/b8041067913fd1f654cf0440a4bfe3ad/560376868/560376868.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/b8041067913fd1f654cf0440a4bfe3ad/560376868/560376868.jpg@s_1,w_300,h_300","artist_id":"1073","all_artist_id":"1073","author":"戴爱玲","publishtime":"2017-10-16","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"556192886","title":"学不会妥协","publishcompany":"塔堡文化","country":"内地","songs_total":"3","pic_small":"http://musicdata.baidu.com/data2/pic/7aae4f3ec27ded5aac4a078dc78a3ee8/556190953/556190953.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/7aae4f3ec27ded5aac4a078dc78a3ee8/556190953/556190953.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/7aae4f3ec27ded5aac4a078dc78a3ee8/556190953/556190953.jpg@s_1,w_300,h_300","artist_id":"28788020","all_artist_id":"28788020","author":"风小筝","publishtime":"2017-09-26","resource_type_ext":"3","price":"2.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"560424502","title":"Hey My Dear","publishcompany":"华宇世博","country":"内地","songs_total":"1","pic_small":"http://musicdata.baidu.com/data2/pic/0c70d4124c2954f26a0221d3e6c36f6b/560424492/560424492.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/0c70d4124c2954f26a0221d3e6c36f6b/560424492/560424492.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/0c70d4124c2954f26a0221d3e6c36f6b/560424492/560424492.jpg@s_1,w_300,h_300","artist_id":"546627839","all_artist_id":"546627839","author":"徐露露","publishtime":"2017-10-17","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"560400001","title":"虽然前途未卜 我愿陪你吃土","publishcompany":"冬曦音乐","country":"内地","songs_total":"2","pic_small":"http://musicdata.baidu.com/data2/pic/77ea5342bca6ca590d2a6feaeeff7dfc/560399089/560399089.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/77ea5342bca6ca590d2a6feaeeff7dfc/560399089/560399089.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/77ea5342bca6ca590d2a6feaeeff7dfc/560399089/560399089.jpg@s_1,w_300,h_300","artist_id":"1985895","all_artist_id":"1985895,293679542","author":"艾伦,马丽","publishtime":"2017-10-13","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"560390608","title":"永不消逝","publishcompany":"自在天浩","country":"内地","songs_total":"1","pic_small":"http://musicdata.baidu.com/data2/pic/bb4ed17cf0252c0a5b6cbd3451aaf557/560410401/560410401.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/bb4ed17cf0252c0a5b6cbd3451aaf557/560410401/560410401.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/bb4ed17cf0252c0a5b6cbd3451aaf557/560410401/560410401.jpg@s_1,w_300,h_300","artist_id":"1843","all_artist_id":"1843","author":"金志文","publishtime":"2017-10-16","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"559844060","title":"I Feel So Good","publishcompany":"ROKON滚石电音","country":"内地","songs_total":"3","pic_small":"http://musicdata.baidu.com/data2/pic/5b9bef379781ac632e5a5019813180fd/559843769/559843769.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/5b9bef379781ac632e5a5019813180fd/559843769/559843769.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/5b9bef379781ac632e5a5019813180fd/559843769/559843769.jpg@s_1,w_300,h_300","artist_id":"539881578","all_artist_id":"539881578","author":"妮可酱","publishtime":"2017-10-16","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"560125207","title":"太难","publishcompany":"华宇世博","country":"内地","songs_total":"2","pic_small":"http://musicdata.baidu.com/data2/pic/692b8965ec3b093f415528fb79eb91c3/560122522/560122522.JPG@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/692b8965ec3b093f415528fb79eb91c3/560122522/560122522.JPG@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/692b8965ec3b093f415528fb79eb91c3/560122522/560122522.JPG@s_1,w_300,h_300","artist_id":"14378906","all_artist_id":"14378906,267336016","author":"夏天Alex,臧恰","publishtime":"2017-10-16","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"560007197","title":"Romance","publishcompany":"Sony Music","country":"欧美","songs_total":"0","pic_small":"http://musicdata.baidu.com/data2/pic/2772cb8e5c648d1bbc3453707b7ac48e/560007198/560007198.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/2772cb8e5c648d1bbc3453707b7ac48e/560007198/560007198.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/2772cb8e5c648d1bbc3453707b7ac48e/560007198/560007198.jpg@s_1,w_300,h_300","artist_id":"2371","all_artist_id":"2371","author":"郎朗","publishtime":"2017-10-13","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"559843718","title":"Leave Me Alone","publishcompany":"ROKON滚石电音","country":"内地","songs_total":"1","pic_small":"http://musicdata.baidu.com/data2/pic/d436ee4f595802371ece467714c58d2d/559843707/559843707.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/d436ee4f595802371ece467714c58d2d/559843707/559843707.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/d436ee4f595802371ece467714c58d2d/559843707/559843707.jpg@s_1,w_300,h_300","artist_id":"539880444","all_artist_id":"539880444","author":"郑平","publishtime":"2017-10-13","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"559949680","title":"天籁 Studio Version ","publishcompany":"Sony Music","country":"内地","songs_total":"0","pic_small":"http://musicdata.baidu.com/data2/pic/7c0e4039955b69c7e6117743f79d5585/559949681/559949681.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/7c0e4039955b69c7e6117743f79d5585/559949681/559949681.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/7c0e4039955b69c7e6117743f79d5585/559949681/559949681.jpg@s_1,w_300,h_300","artist_id":"162","all_artist_id":"162","author":"莫文蔚","publishtime":"2017-10-12","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"560088842","title":"AquafinA","publishcompany":"摩登天空","country":"内地","songs_total":"1","pic_small":"http://musicdata.baidu.com/data2/pic/8981a1749fb7a15c9f4cfb592662eac6/560088542/560088542.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/8981a1749fb7a15c9f4cfb592662eac6/560088542/560088542.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/8981a1749fb7a15c9f4cfb592662eac6/560088542/560088542.jpg@s_1,w_300,h_300","artist_id":"337672357","all_artist_id":"337672357","author":"OB03","publishtime":"2017-10-13","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"560090231","title":"红线","publishcompany":"畅和文化","country":"内地","songs_total":"1","pic_small":"http://musicdata.baidu.com/data2/pic/71ffd7716295cc1c50f2e7586c9cefa9/560089591/560089591.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/71ffd7716295cc1c50f2e7586c9cefa9/560089591/560089591.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/71ffd7716295cc1c50f2e7586c9cefa9/560089591/560089591.jpg@s_1,w_300,h_300","artist_id":"277251819","all_artist_id":"277251819","author":"叶炫清","publishtime":"2017-10-13","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"}],"havemore":1}}
         */

        private RMBean RM;

        public RMBean getRM() {
            return RM;
        }

        public void setRM(RMBean RM) {
            this.RM = RM;
        }

        public static class RMBean {
            /**
             * album_list : {"list":[{"album_id":"560376866","title":"了不起寂寞","publishcompany":"Sony Music","country":"内地","songs_total":"0","pic_small":"http://musicdata.baidu.com/data2/pic/b8041067913fd1f654cf0440a4bfe3ad/560376868/560376868.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/b8041067913fd1f654cf0440a4bfe3ad/560376868/560376868.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/b8041067913fd1f654cf0440a4bfe3ad/560376868/560376868.jpg@s_1,w_300,h_300","artist_id":"1073","all_artist_id":"1073","author":"戴爱玲","publishtime":"2017-10-16","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"556192886","title":"学不会妥协","publishcompany":"塔堡文化","country":"内地","songs_total":"3","pic_small":"http://musicdata.baidu.com/data2/pic/7aae4f3ec27ded5aac4a078dc78a3ee8/556190953/556190953.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/7aae4f3ec27ded5aac4a078dc78a3ee8/556190953/556190953.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/7aae4f3ec27ded5aac4a078dc78a3ee8/556190953/556190953.jpg@s_1,w_300,h_300","artist_id":"28788020","all_artist_id":"28788020","author":"风小筝","publishtime":"2017-09-26","resource_type_ext":"3","price":"2.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"560424502","title":"Hey My Dear","publishcompany":"华宇世博","country":"内地","songs_total":"1","pic_small":"http://musicdata.baidu.com/data2/pic/0c70d4124c2954f26a0221d3e6c36f6b/560424492/560424492.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/0c70d4124c2954f26a0221d3e6c36f6b/560424492/560424492.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/0c70d4124c2954f26a0221d3e6c36f6b/560424492/560424492.jpg@s_1,w_300,h_300","artist_id":"546627839","all_artist_id":"546627839","author":"徐露露","publishtime":"2017-10-17","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"560400001","title":"虽然前途未卜 我愿陪你吃土","publishcompany":"冬曦音乐","country":"内地","songs_total":"2","pic_small":"http://musicdata.baidu.com/data2/pic/77ea5342bca6ca590d2a6feaeeff7dfc/560399089/560399089.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/77ea5342bca6ca590d2a6feaeeff7dfc/560399089/560399089.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/77ea5342bca6ca590d2a6feaeeff7dfc/560399089/560399089.jpg@s_1,w_300,h_300","artist_id":"1985895","all_artist_id":"1985895,293679542","author":"艾伦,马丽","publishtime":"2017-10-13","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"560390608","title":"永不消逝","publishcompany":"自在天浩","country":"内地","songs_total":"1","pic_small":"http://musicdata.baidu.com/data2/pic/bb4ed17cf0252c0a5b6cbd3451aaf557/560410401/560410401.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/bb4ed17cf0252c0a5b6cbd3451aaf557/560410401/560410401.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/bb4ed17cf0252c0a5b6cbd3451aaf557/560410401/560410401.jpg@s_1,w_300,h_300","artist_id":"1843","all_artist_id":"1843","author":"金志文","publishtime":"2017-10-16","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"559844060","title":"I Feel So Good","publishcompany":"ROKON滚石电音","country":"内地","songs_total":"3","pic_small":"http://musicdata.baidu.com/data2/pic/5b9bef379781ac632e5a5019813180fd/559843769/559843769.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/5b9bef379781ac632e5a5019813180fd/559843769/559843769.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/5b9bef379781ac632e5a5019813180fd/559843769/559843769.jpg@s_1,w_300,h_300","artist_id":"539881578","all_artist_id":"539881578","author":"妮可酱","publishtime":"2017-10-16","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"560125207","title":"太难","publishcompany":"华宇世博","country":"内地","songs_total":"2","pic_small":"http://musicdata.baidu.com/data2/pic/692b8965ec3b093f415528fb79eb91c3/560122522/560122522.JPG@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/692b8965ec3b093f415528fb79eb91c3/560122522/560122522.JPG@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/692b8965ec3b093f415528fb79eb91c3/560122522/560122522.JPG@s_1,w_300,h_300","artist_id":"14378906","all_artist_id":"14378906,267336016","author":"夏天Alex,臧恰","publishtime":"2017-10-16","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"560007197","title":"Romance","publishcompany":"Sony Music","country":"欧美","songs_total":"0","pic_small":"http://musicdata.baidu.com/data2/pic/2772cb8e5c648d1bbc3453707b7ac48e/560007198/560007198.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/2772cb8e5c648d1bbc3453707b7ac48e/560007198/560007198.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/2772cb8e5c648d1bbc3453707b7ac48e/560007198/560007198.jpg@s_1,w_300,h_300","artist_id":"2371","all_artist_id":"2371","author":"郎朗","publishtime":"2017-10-13","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"559843718","title":"Leave Me Alone","publishcompany":"ROKON滚石电音","country":"内地","songs_total":"1","pic_small":"http://musicdata.baidu.com/data2/pic/d436ee4f595802371ece467714c58d2d/559843707/559843707.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/d436ee4f595802371ece467714c58d2d/559843707/559843707.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/d436ee4f595802371ece467714c58d2d/559843707/559843707.jpg@s_1,w_300,h_300","artist_id":"539880444","all_artist_id":"539880444","author":"郑平","publishtime":"2017-10-13","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"559949680","title":"天籁 Studio Version ","publishcompany":"Sony Music","country":"内地","songs_total":"0","pic_small":"http://musicdata.baidu.com/data2/pic/7c0e4039955b69c7e6117743f79d5585/559949681/559949681.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/7c0e4039955b69c7e6117743f79d5585/559949681/559949681.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/7c0e4039955b69c7e6117743f79d5585/559949681/559949681.jpg@s_1,w_300,h_300","artist_id":"162","all_artist_id":"162","author":"莫文蔚","publishtime":"2017-10-12","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"560088842","title":"AquafinA","publishcompany":"摩登天空","country":"内地","songs_total":"1","pic_small":"http://musicdata.baidu.com/data2/pic/8981a1749fb7a15c9f4cfb592662eac6/560088542/560088542.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/8981a1749fb7a15c9f4cfb592662eac6/560088542/560088542.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/8981a1749fb7a15c9f4cfb592662eac6/560088542/560088542.jpg@s_1,w_300,h_300","artist_id":"337672357","all_artist_id":"337672357","author":"OB03","publishtime":"2017-10-13","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"560090231","title":"红线","publishcompany":"畅和文化","country":"内地","songs_total":"1","pic_small":"http://musicdata.baidu.com/data2/pic/71ffd7716295cc1c50f2e7586c9cefa9/560089591/560089591.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/71ffd7716295cc1c50f2e7586c9cefa9/560089591/560089591.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/71ffd7716295cc1c50f2e7586c9cefa9/560089591/560089591.jpg@s_1,w_300,h_300","artist_id":"277251819","all_artist_id":"277251819","author":"叶炫清","publishtime":"2017-10-13","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"}],"havemore":1}
             */

            private AlbumListBean album_list;

            public AlbumListBean getAlbum_list() {
                return album_list;
            }

            public void setAlbum_list(AlbumListBean album_list) {
                this.album_list = album_list;
            }

            public static class AlbumListBean {
                /**
                 * list : [{"album_id":"560376866","title":"了不起寂寞","publishcompany":"Sony Music","country":"内地","songs_total":"0","pic_small":"http://musicdata.baidu.com/data2/pic/b8041067913fd1f654cf0440a4bfe3ad/560376868/560376868.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/b8041067913fd1f654cf0440a4bfe3ad/560376868/560376868.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/b8041067913fd1f654cf0440a4bfe3ad/560376868/560376868.jpg@s_1,w_300,h_300","artist_id":"1073","all_artist_id":"1073","author":"戴爱玲","publishtime":"2017-10-16","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"556192886","title":"学不会妥协","publishcompany":"塔堡文化","country":"内地","songs_total":"3","pic_small":"http://musicdata.baidu.com/data2/pic/7aae4f3ec27ded5aac4a078dc78a3ee8/556190953/556190953.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/7aae4f3ec27ded5aac4a078dc78a3ee8/556190953/556190953.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/7aae4f3ec27ded5aac4a078dc78a3ee8/556190953/556190953.jpg@s_1,w_300,h_300","artist_id":"28788020","all_artist_id":"28788020","author":"风小筝","publishtime":"2017-09-26","resource_type_ext":"3","price":"2.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"560424502","title":"Hey My Dear","publishcompany":"华宇世博","country":"内地","songs_total":"1","pic_small":"http://musicdata.baidu.com/data2/pic/0c70d4124c2954f26a0221d3e6c36f6b/560424492/560424492.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/0c70d4124c2954f26a0221d3e6c36f6b/560424492/560424492.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/0c70d4124c2954f26a0221d3e6c36f6b/560424492/560424492.jpg@s_1,w_300,h_300","artist_id":"546627839","all_artist_id":"546627839","author":"徐露露","publishtime":"2017-10-17","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"560400001","title":"虽然前途未卜 我愿陪你吃土","publishcompany":"冬曦音乐","country":"内地","songs_total":"2","pic_small":"http://musicdata.baidu.com/data2/pic/77ea5342bca6ca590d2a6feaeeff7dfc/560399089/560399089.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/77ea5342bca6ca590d2a6feaeeff7dfc/560399089/560399089.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/77ea5342bca6ca590d2a6feaeeff7dfc/560399089/560399089.jpg@s_1,w_300,h_300","artist_id":"1985895","all_artist_id":"1985895,293679542","author":"艾伦,马丽","publishtime":"2017-10-13","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"560390608","title":"永不消逝","publishcompany":"自在天浩","country":"内地","songs_total":"1","pic_small":"http://musicdata.baidu.com/data2/pic/bb4ed17cf0252c0a5b6cbd3451aaf557/560410401/560410401.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/bb4ed17cf0252c0a5b6cbd3451aaf557/560410401/560410401.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/bb4ed17cf0252c0a5b6cbd3451aaf557/560410401/560410401.jpg@s_1,w_300,h_300","artist_id":"1843","all_artist_id":"1843","author":"金志文","publishtime":"2017-10-16","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"559844060","title":"I Feel So Good","publishcompany":"ROKON滚石电音","country":"内地","songs_total":"3","pic_small":"http://musicdata.baidu.com/data2/pic/5b9bef379781ac632e5a5019813180fd/559843769/559843769.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/5b9bef379781ac632e5a5019813180fd/559843769/559843769.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/5b9bef379781ac632e5a5019813180fd/559843769/559843769.jpg@s_1,w_300,h_300","artist_id":"539881578","all_artist_id":"539881578","author":"妮可酱","publishtime":"2017-10-16","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"560125207","title":"太难","publishcompany":"华宇世博","country":"内地","songs_total":"2","pic_small":"http://musicdata.baidu.com/data2/pic/692b8965ec3b093f415528fb79eb91c3/560122522/560122522.JPG@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/692b8965ec3b093f415528fb79eb91c3/560122522/560122522.JPG@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/692b8965ec3b093f415528fb79eb91c3/560122522/560122522.JPG@s_1,w_300,h_300","artist_id":"14378906","all_artist_id":"14378906,267336016","author":"夏天Alex,臧恰","publishtime":"2017-10-16","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"560007197","title":"Romance","publishcompany":"Sony Music","country":"欧美","songs_total":"0","pic_small":"http://musicdata.baidu.com/data2/pic/2772cb8e5c648d1bbc3453707b7ac48e/560007198/560007198.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/2772cb8e5c648d1bbc3453707b7ac48e/560007198/560007198.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/2772cb8e5c648d1bbc3453707b7ac48e/560007198/560007198.jpg@s_1,w_300,h_300","artist_id":"2371","all_artist_id":"2371","author":"郎朗","publishtime":"2017-10-13","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"559843718","title":"Leave Me Alone","publishcompany":"ROKON滚石电音","country":"内地","songs_total":"1","pic_small":"http://musicdata.baidu.com/data2/pic/d436ee4f595802371ece467714c58d2d/559843707/559843707.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/d436ee4f595802371ece467714c58d2d/559843707/559843707.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/d436ee4f595802371ece467714c58d2d/559843707/559843707.jpg@s_1,w_300,h_300","artist_id":"539880444","all_artist_id":"539880444","author":"郑平","publishtime":"2017-10-13","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"559949680","title":"天籁 Studio Version ","publishcompany":"Sony Music","country":"内地","songs_total":"0","pic_small":"http://musicdata.baidu.com/data2/pic/7c0e4039955b69c7e6117743f79d5585/559949681/559949681.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/7c0e4039955b69c7e6117743f79d5585/559949681/559949681.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/7c0e4039955b69c7e6117743f79d5585/559949681/559949681.jpg@s_1,w_300,h_300","artist_id":"162","all_artist_id":"162","author":"莫文蔚","publishtime":"2017-10-12","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"560088842","title":"AquafinA","publishcompany":"摩登天空","country":"内地","songs_total":"1","pic_small":"http://musicdata.baidu.com/data2/pic/8981a1749fb7a15c9f4cfb592662eac6/560088542/560088542.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/8981a1749fb7a15c9f4cfb592662eac6/560088542/560088542.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/8981a1749fb7a15c9f4cfb592662eac6/560088542/560088542.jpg@s_1,w_300,h_300","artist_id":"337672357","all_artist_id":"337672357","author":"OB03","publishtime":"2017-10-13","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"},{"album_id":"560090231","title":"红线","publishcompany":"畅和文化","country":"内地","songs_total":"1","pic_small":"http://musicdata.baidu.com/data2/pic/71ffd7716295cc1c50f2e7586c9cefa9/560089591/560089591.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/71ffd7716295cc1c50f2e7586c9cefa9/560089591/560089591.jpg@s_1,w_150,h_150","pic_radio":"http://musicdata.baidu.com/data2/pic/71ffd7716295cc1c50f2e7586c9cefa9/560089591/560089591.jpg@s_1,w_300,h_300","artist_id":"277251819","all_artist_id":"277251819","author":"叶炫清","publishtime":"2017-10-13","resource_type_ext":"0","price":"0.00","is_recommend_mis":"0","is_first_publish":"0","is_exclusive":"0"}]
                 * havemore : 1
                 */

                private int havemore;
                private List<ListBean> list;

                public int getHavemore() {
                    return havemore;
                }

                public void setHavemore(int havemore) {
                    this.havemore = havemore;
                }

                public List<ListBean> getList() {
                    return list;
                }

                public void setList(List<ListBean> list) {
                    this.list = list;
                }

                public static class ListBean {
                    /**
                     * album_id : 560376866
                     * title : 了不起寂寞
                     * publishcompany : Sony Music
                     * country : 内地
                     * songs_total : 0
                     * pic_small : http://musicdata.baidu.com/data2/pic/b8041067913fd1f654cf0440a4bfe3ad/560376868/560376868.jpg@s_1,w_90,h_90
                     * pic_big : http://musicdata.baidu.com/data2/pic/b8041067913fd1f654cf0440a4bfe3ad/560376868/560376868.jpg@s_1,w_150,h_150
                     * pic_radio : http://musicdata.baidu.com/data2/pic/b8041067913fd1f654cf0440a4bfe3ad/560376868/560376868.jpg@s_1,w_300,h_300
                     * artist_id : 1073
                     * all_artist_id : 1073
                     * author : 戴爱玲
                     * publishtime : 2017-10-16
                     * resource_type_ext : 0
                     * price : 0.00
                     * is_recommend_mis : 0
                     * is_first_publish : 0
                     * is_exclusive : 0
                     */

                    private String album_id;
                    private String title;
                    private String publishcompany;
                    private String country;
                    private String songs_total;
                    private String pic_small;
                    private String pic_big;
                    private String pic_radio;
                    private String artist_id;
                    private String all_artist_id;
                    private String author;
                    private String publishtime;
                    private String resource_type_ext;
                    private String price;
                    private String is_recommend_mis;
                    private String is_first_publish;
                    private String is_exclusive;

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

                    public String getPublishcompany() {
                        return publishcompany;
                    }

                    public void setPublishcompany(String publishcompany) {
                        this.publishcompany = publishcompany;
                    }

                    public String getCountry() {
                        return country;
                    }

                    public void setCountry(String country) {
                        this.country = country;
                    }

                    public String getSongs_total() {
                        return songs_total;
                    }

                    public void setSongs_total(String songs_total) {
                        this.songs_total = songs_total;
                    }

                    public String getPic_small() {
                        return pic_small;
                    }

                    public void setPic_small(String pic_small) {
                        this.pic_small = pic_small;
                    }

                    public String getPic_big() {
                        return pic_big;
                    }

                    public void setPic_big(String pic_big) {
                        this.pic_big = pic_big;
                    }

                    public String getPic_radio() {
                        return pic_radio;
                    }

                    public void setPic_radio(String pic_radio) {
                        this.pic_radio = pic_radio;
                    }

                    public String getArtist_id() {
                        return artist_id;
                    }

                    public void setArtist_id(String artist_id) {
                        this.artist_id = artist_id;
                    }

                    public String getAll_artist_id() {
                        return all_artist_id;
                    }

                    public void setAll_artist_id(String all_artist_id) {
                        this.all_artist_id = all_artist_id;
                    }

                    public String getAuthor() {
                        return author;
                    }

                    public void setAuthor(String author) {
                        this.author = author;
                    }

                    public String getPublishtime() {
                        return publishtime;
                    }

                    public void setPublishtime(String publishtime) {
                        this.publishtime = publishtime;
                    }

                    public String getResource_type_ext() {
                        return resource_type_ext;
                    }

                    public void setResource_type_ext(String resource_type_ext) {
                        this.resource_type_ext = resource_type_ext;
                    }

                    public String getPrice() {
                        return price;
                    }

                    public void setPrice(String price) {
                        this.price = price;
                    }

                    public String getIs_recommend_mis() {
                        return is_recommend_mis;
                    }

                    public void setIs_recommend_mis(String is_recommend_mis) {
                        this.is_recommend_mis = is_recommend_mis;
                    }

                    public String getIs_first_publish() {
                        return is_first_publish;
                    }

                    public void setIs_first_publish(String is_first_publish) {
                        this.is_first_publish = is_first_publish;
                    }

                    public String getIs_exclusive() {
                        return is_exclusive;
                    }

                    public void setIs_exclusive(String is_exclusive) {
                        this.is_exclusive = is_exclusive;
                    }
                }
            }
        }
    }
}
