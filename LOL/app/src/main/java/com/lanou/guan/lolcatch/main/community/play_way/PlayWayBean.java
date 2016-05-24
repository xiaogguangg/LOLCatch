package com.lanou.guan.lolcatch.main.community.play_way;

import java.util.List;

/**
 * Created by dllo on 16/5/24.
 */
public class PlayWayBean {

    /**
     * data : [{"id":"708784","role_id":"75","map":"经典模式-召唤师峡谷","userid":"17039001","title":"不死超神","equips":"13068,13055,13077,13016,13101,13065,","good":"0","comment":"0","hot":"0","content_md5":"1a6ed15915b3b83e4a10ebdb62db2b7a","json":"file/lol/user_plays/1a/1a6ed15915b3b83e4a10ebdb62db2b7a","season":"8","created":1464059379,"area":"巨龙之巢","summoner":"哎呀快溜","zdl":"6906","nickname":"浪子盖伦","avatar":"http://avatar.zhangyoubao.com/pic/user/avatar/33/571c033417039001s.crop_image","file_url":"http://anzo-file.oss-cn-qingdao.aliyuncs.com/file/lol/user_plays/1a/1a6ed15915b3b83e4a10ebdb62db2b7a"},{"id":"708783","role_id":"114","map":"经典模式-召唤师峡谷","userid":"9952722","title":"这不单纯只是屠戮 这是我的杰作","equips":"13064,13036,13114,13133,13055,12999,","good":"0","comment":"0","hot":"0","content_md5":"6b2e4c03762080a3d296512b77559dd9","json":"file/lol/user_plays/6b/6b2e4c03762080a3d296512b77559dd9","season":"7","created":1464059341,"area":"祖安","summoner":"Devil丶丨Aatrox","zdl":"10505","nickname":"丿溺水半码垫","avatar":"http://avatar.zhangyoubao.com/pic/user/avatar/defaults.jpg","file_url":"http://anzo-file.oss-cn-qingdao.aliyuncs.com/file/lol/user_plays/6b/6b2e4c03762080a3d296512b77559dd9"},{"id":"708782","role_id":"95","map":"经典模式-召唤师峡谷","userid":"23448090","title":"一Q秒人","equips":"13313,13129,13021,13064,13132,12999,","good":"0","comment":"0","hot":"0","content_md5":"45eab2f647e3bf8427e50c4f2d85e9f1","json":"file/lol/user_plays/45/45eab2f647e3bf8427e50c4f2d85e9f1","season":"8","created":1464059165,"area":"影流","summoner":"超神的午夜","zdl":"4923","nickname":"神丿情灬殇","avatar":"http://avatar.zhangyoubao.com/pic/user/avatar/defaults.jpg","file_url":"http://anzo-file.oss-cn-qingdao.aliyuncs.com/file/lol/user_plays/45/45eab2f647e3bf8427e50c4f2d85e9f1"},{"id":"708781","role_id":"9","map":"经典模式-召唤师峡谷","userid":"18209138","title":"暴击流，狂暴输出。","equips":"13064,13021,12999,14090,13021,13036,","good":"0","comment":"0","hot":"0","content_md5":"4d254b7703d64c02fc50509a19b28382","json":"file/lol/user_plays/4d/4d254b7703d64c02fc50509a19b28382","season":"8","created":1464059153,"area":"卡拉曼达","summoner":"续写你的情","zdl":"4784","nickname":"有人看病","avatar":"http://avatar.zhangyoubao.com/pic/user/avatar/c2/5634d1a218209138s.jpg","file_url":"http://anzo-file.oss-cn-qingdao.aliyuncs.com/file/lol/user_plays/4d/4d254b7703d64c02fc50509a19b28382"},{"id":"708780","role_id":"13","map":"经典模式-召唤师峡谷","userid":"9611180","title":"国服第一","equips":"14032,13283,13125,14059,14013,13031,","good":"0","comment":"0","hot":"0","content_md5":"5d0d7347a5861d2a46f0354c14ce6da1","json":"file/lol/user_plays/5d/5d0d7347a5861d2a46f0354c14ce6da1","season":"8","created":1464059115,"area":"钢铁烈阳","summoner":"SWing丶曦羽陌","zdl":"10382","nickname":"520zzw","avatar":"http://avatar.zhangyoubao.com/pic/user/avatar/defaults.jpg","file_url":"http://anzo-file.oss-cn-qingdao.aliyuncs.com/file/lol/user_plays/5d/5d0d7347a5861d2a46f0354c14ce6da1"}]
     * code : 200
     * message : ok
     * api : 1
     */

    private int code;
    private String message;
    private int api;
    /**
     * id : 708784
     * role_id : 75
     * map : 经典模式-召唤师峡谷
     * userid : 17039001
     * title : 不死超神
     * equips : 13068,13055,13077,13016,13101,13065,
     * good : 0
     * comment : 0
     * hot : 0
     * content_md5 : 1a6ed15915b3b83e4a10ebdb62db2b7a
     * json : file/lol/user_plays/1a/1a6ed15915b3b83e4a10ebdb62db2b7a
     * season : 8
     * created : 1464059379
     * area : 巨龙之巢
     * summoner : 哎呀快溜
     * zdl : 6906
     * nickname : 浪子盖伦
     * avatar : http://avatar.zhangyoubao.com/pic/user/avatar/33/571c033417039001s.crop_image
     * file_url : http://anzo-file.oss-cn-qingdao.aliyuncs.com/file/lol/user_plays/1a/1a6ed15915b3b83e4a10ebdb62db2b7a
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
        private String role_id;
        private String map;
        private String userid;
        private String title;
        private String equips;
        private String good;
        private String comment;
        private String hot;
        private String content_md5;
        private String json;
        private String season;
        private int created;
        private String area;
        private String summoner;
        private String zdl;
        private String nickname;
        private String avatar;
        private String file_url;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getRole_id() {
            return role_id;
        }

        public void setRole_id(String role_id) {
            this.role_id = role_id;
        }

        public String getMap() {
            return map;
        }

        public void setMap(String map) {
            this.map = map;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getEquips() {
            return equips;
        }

        public void setEquips(String equips) {
            this.equips = equips;
        }

        public String getGood() {
            return good;
        }

        public void setGood(String good) {
            this.good = good;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getHot() {
            return hot;
        }

        public void setHot(String hot) {
            this.hot = hot;
        }

        public String getContent_md5() {
            return content_md5;
        }

        public void setContent_md5(String content_md5) {
            this.content_md5 = content_md5;
        }

        public String getJson() {
            return json;
        }

        public void setJson(String json) {
            this.json = json;
        }

        public String getSeason() {
            return season;
        }

        public void setSeason(String season) {
            this.season = season;
        }

        public int getCreated() {
            return created;
        }

        public void setCreated(int created) {
            this.created = created;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getSummoner() {
            return summoner;
        }

        public void setSummoner(String summoner) {
            this.summoner = summoner;
        }

        public String getZdl() {
            return zdl;
        }

        public void setZdl(String zdl) {
            this.zdl = zdl;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getFile_url() {
            return file_url;
        }

        public void setFile_url(String file_url) {
            this.file_url = file_url;
        }
    }
}
