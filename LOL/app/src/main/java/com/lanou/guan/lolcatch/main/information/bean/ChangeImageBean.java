package com.lanou.guan.lolcatch.main.information.bean;

import java.util.List;

/**
 * Created by dllo on 16/5/20.
 */
public class ChangeImageBean {

    /**
     * data : [{"id":"65900","title":"高校联赛","desc":"高校联赛","goto_target":"topic","goto_param":{"topicid":"50","name":"第13期 第四届全国高校联赛总决赛","desc":"英雄联盟全国高校联赛总决赛将于5月20日-22日在天津工业大学重磅开战，来自全国各地共计14支最强高校队伍向着总冠军的荣誉发起冲击","pic_url":"http://avatar.anzogame.com/pic_v1/lol/topic/50h573d2b24.jpg"},"platform":"1","pic_ad_url":"http://avatar.anzogame.com/pic_v1/lol/news/20160519/picad65900h573d2b6b.jpg"},{"id":"65785","title":"掌游宝寻人","desc":"掌游宝寻人","goto_target":"item","goto_param":{"itemid":"65784","title":"掌游宝寻人","desc":"掌游宝寻人"},"platform":"1","pic_ad_url":"http://avatar.anzogame.com/pic_v1/lol/news/20160516/picad65785h57396bc4.jpg"},{"id":"65506","title":"国服5月10日更新至6.9版本","desc":"国服5月10日更新至6.9版本","goto_target":"item","goto_param":{"itemid":"65502","title":"国服5月10日更新至6.9版本","desc":"国服5月10日更新至6.9版本"},"platform":"1","pic_ad_url":"http://avatar.anzogame.com/pic_v1/lol/news/20160509/picad65506h573031f7.jpg"}]
     * code : 200
     * message : ok
     * api : 1
     */

    private int code;
    private String message;
    private int api;
    /**
     * id : 65900
     * title : 高校联赛
     * desc : 高校联赛
     * goto_target : topic
     * goto_param : {"topicid":"50","name":"第13期 第四届全国高校联赛总决赛","desc":"英雄联盟全国高校联赛总决赛将于5月20日-22日在天津工业大学重磅开战，来自全国各地共计14支最强高校队伍向着总冠军的荣誉发起冲击","pic_url":"http://avatar.anzogame.com/pic_v1/lol/topic/50h573d2b24.jpg"}
     * platform : 1
     * pic_ad_url : http://avatar.anzogame.com/pic_v1/lol/news/20160519/picad65900h573d2b6b.jpg
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
        private String goto_target;
        /**
         * topicid : 50
         * name : 第13期 第四届全国高校联赛总决赛
         * desc : 英雄联盟全国高校联赛总决赛将于5月20日-22日在天津工业大学重磅开战，来自全国各地共计14支最强高校队伍向着总冠军的荣誉发起冲击
         * pic_url : http://avatar.anzogame.com/pic_v1/lol/topic/50h573d2b24.jpg
         */

        private GotoParamBean goto_param;
        private String platform;
        private String pic_ad_url;

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

        public String getGoto_target() {
            return goto_target;
        }

        public void setGoto_target(String goto_target) {
            this.goto_target = goto_target;
        }

        public GotoParamBean getGoto_param() {
            return goto_param;
        }

        public void setGoto_param(GotoParamBean goto_param) {
            this.goto_param = goto_param;
        }

        public String getPlatform() {
            return platform;
        }

        public void setPlatform(String platform) {
            this.platform = platform;
        }

        public String getPic_ad_url() {
            return pic_ad_url;
        }

        public void setPic_ad_url(String pic_ad_url) {
            this.pic_ad_url = pic_ad_url;
        }

        public static class GotoParamBean {
            private String topicid;
            private String name;
            private String desc;
            private String pic_url;

            public String getTopicid() {
                return topicid;
            }

            public void setTopicid(String topicid) {
                this.topicid = topicid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPic_url() {
                return pic_url;
            }

            public void setPic_url(String pic_url) {
                this.pic_url = pic_url;
            }
        }
    }
}
