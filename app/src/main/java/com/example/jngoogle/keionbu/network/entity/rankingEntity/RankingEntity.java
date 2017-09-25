package com.example.jngoogle.keionbu.network.entity.rankingEntity;

/**
 * Created by jngoogle on 2017/2/23 19:25.
 * email: guyuanhaofan@cnicg.cn
 */

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * 排行榜实体
 * songList:  歌曲列表
 * billboard: 榜单信息
 * errorCode: 错误码
 */
public class RankingEntity {
    @SerializedName("song_list")
    private List<SongList> songList;
    private Billboard billboard;
    @SerializedName("error_code")
    private String errorCode;

    public List<SongList> getSongList() {
        return songList;
    }

    public Billboard getBillboard() {
        return billboard;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
