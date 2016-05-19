package com.lanou.guan.lolcatch.main.information.News;

import java.util.List;

/**
 * Created by dllo on 16/5/18.
 */
public class NewsBean {

    /**
     * data : [{"id":"65882","title":"国服5月20日免费英雄更换公告","desc":"吉格斯、波比、斯维因周免啦","video_url":"","published":1463566430,"weight":"0","platform":"1","pic_url":"","recommend":0,"w":123},{"id":"65874","title":"石中回响 新英雄塔莉垭背景故事曝光","desc":"身为一名流浪法师，她洋溢着饱满的热情，天真而又坚定。","video_url":"","published":1463563208,"weight":"0","platform":"1","pic_url":"","recommend":0,"w":123},{"id":"65872","title":"拳头罚单：职业选手消极行为被禁赛","desc":"拳头在前段时间对LCS的俱乐部老板开出罚单，而今日又对职业选手进行了惩罚。","video_url":"","published":1463558400,"weight":"0","platform":"1","pic_url":"","recommend":0,"w":123},{"id":"65871","title":"6.10正式补丁：新英雄塔莉垭登场","desc":"6.10版本版本中除了新英雄以外，还对英雄、道具甚至游戏性方面进行了改动。","video_url":"","published":1463554858,"weight":"0","platform":"1","pic_url":"","recommend":0,"w":123},{"id":"65859","title":"冠军及勇者系列皮肤即将下架","desc":"皮肤即将下架，你还在等什么?","video_url":"","published":1463548822,"weight":"0","platform":"1","pic_url":"","recommend":0,"w":123},{"id":"65847","title":"五月幸运召唤师来临 试试手气吧！","desc":"看看你今天是幸运召唤师还是不幸召唤师。","video_url":"","published":1463538580,"weight":"0","platform":"1","pic_url":"","recommend":0,"w":123},{"id":"65845","title":"测试服5月18日：你们的皇帝驾崩啦！","desc":"比赛热门英雄削弱，三相迎来新改动，同时还推出了两款新皮肤。","video_url":"","published":1463535790,"weight":"0","platform":"1","pic_url":"","recommend":0,"w":123},{"id":"65826","title":"京东游戏妹子杯全明星周末看点大揭秘","desc":"这场比赛究竟除了\u201c全部都是妹子\u201d之外，还有哪些不为人知的看点呢？","video_url":"","published":1463533200,"weight":"0","platform":"1","pic_url":"","recommend":0,"w":123},{"id":"65833","title":"重生与变革 外媒谈新生的RNG战队","desc":"这支队伍阵容之豪华已经超过世界上的任何队伍，是否能超越现在的SKT？","video_url":"","published":1463481600,"weight":"0","platform":"1","pic_url":"","recommend":0,"w":123},{"id":"65823","title":"爆发与持续兼备 新英雄塔莉垭简要攻略","desc":"新英雄塔莉垭即将在明日登录美服，预计在未来一周之内也将登录国服。","video_url":"","published":1463470200,"weight":"0","platform":"1","pic_url":"","recommend":0,"w":123}]
     * code : 200
     * message : ok
     * api : 1
     */

    private int code;
    private String message;
    private int api;
    /**
     * id : 65882
     * title : 国服5月20日免费英雄更换公告
     * desc : 吉格斯、波比、斯维因周免啦
     * video_url :
     * published : 1463566430
     * weight : 0
     * platform : 1
     * pic_url :
     * recommend : 0
     * w : 123
     */

    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getApi() {
        return api;
    }

    public void setApi(int api) {
        this.api = api;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String id;
        private String title;
        private String desc;
        private String video_url;
        private int published;
        private String weight;
        private String platform;
        private String pic_url;
        private int recommend;
        private int w;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getVideo_url() {
            return video_url;
        }

        public void setVideo_url(String video_url) {
            this.video_url = video_url;
        }

        public int getPublished() {
            return published;
        }

        public void setPublished(int published) {
            this.published = published;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getPlatform() {
            return platform;
        }

        public void setPlatform(String platform) {
            this.platform = platform;
        }

        public String getPic_url() {
            return pic_url;
        }

        public void setPic_url(String pic_url) {
            this.pic_url = pic_url;
        }

        public int getRecommend() {
            return recommend;
        }

        public void setRecommend(int recommend) {
            this.recommend = recommend;
        }

        public int getW() {
            return w;
        }

        public void setW(int w) {
            this.w = w;
        }
    }
}
