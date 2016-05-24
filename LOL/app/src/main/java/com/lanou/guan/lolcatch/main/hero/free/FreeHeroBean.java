package com.lanou.guan.lolcatch.main.hero.free;

import java.util.List;

/**
 * Created by dllo on 16/5/24.
 */
public class FreeHeroBean {

    /**
     * free : [{"enName":"Swain","cnName":"斯维因","title":"策士统领","tags":"mage","rating":"2,6,9,8","location":"中单","price":"4800,3000"},{"enName":"Ziggs","cnName":"吉格斯","title":"爆破鬼才","tags":"mage","rating":"2,4,9,4","location":"中单","price":"6300,4500"},{"enName":"Brand","cnName":"布兰德","title":"复仇焰魂","tags":"mage","rating":"2,2,9,4","location":"中单","price":"4800,2000"},{"enName":"Poppy","cnName":"波比","title":"圣锤之毅","tags":"tank","rating":"6,7,2,6","location":"上单,打野","price":"450,1000"},{"enName":"XinZhao","cnName":"赵信","title":"德邦总管","tags":"fighter","rating":"8,6,3,2","location":"上单,打野","price":"3150,2500"},{"enName":"Malphite","cnName":"墨菲特","title":"熔岩巨兽","tags":"tank","rating":"5,9,7,2","location":"上单,打野","price":"1350,1000"},{"enName":"Lulu","cnName":"璐璐","title":"仙灵女巫","tags":"support","rating":"4,5,7,5","location":"中单,辅助","price":"6300,4500"},{"enName":"Corki","cnName":"库奇","title":"英勇投弹手","tags":"marksman","rating":"8,3,6,6","location":"中单,ADC","price":"6300,3500"},{"enName":"Twitch","cnName":"图奇","title":"瘟疫之源","tags":"marksman","rating":"9,2,3,6","location":"打野,ADC","price":"4800,3000"},{"enName":"Lucian","cnName":"卢锡安","title":"圣枪游侠","tags":"marksman","rating":"8,5,3,6","location":"ADC","price":"6300,4500"},{"enName":"Ashe","cnName":"艾希","title":"寒冰射手","tags":"marksman,female ","rating":"7,3,2,4","location":"ADC","price":"450,1000"},{"enName":"Garen","cnName":"盖伦","title":"德玛西亚之力","tags":"fighter","rating":"7,7,1,5","location":"上单","price":"3150,1000"},{"enName":"Ryze","cnName":"瑞兹","title":"流浪法师","tags":"mage","rating":"2,2,10,7","location":"上单,中单","price":"450,1000"}]
     * desc : *每周五更新周免
     */

    private String desc;
    /**
     * enName : Swain
     * cnName : 斯维因
     * title : 策士统领
     * tags : mage
     * rating : 2,6,9,8
     * location : 中单
     * price : 4800,3000
     */

    private List<FreeBean> free;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<FreeBean> getFree() {
        return free;
    }

    public void setFree(List<FreeBean> free) {
        this.free = free;
    }

    public static class FreeBean {
        private String enName;
        private String cnName;
        private String title;
        private String tags;
        private String rating;
        private String location;
        private String price;

        public String getEnName() {
            return enName;
        }

        public void setEnName(String enName) {
            this.enName = enName;
        }

        public String getCnName() {
            return cnName;
        }

        public void setCnName(String cnName) {
            this.cnName = cnName;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }
}
