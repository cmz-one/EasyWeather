package com.cmz_one.easyweather.bean;

import java.util.List;

/**
 * Created by cmz_o on 2016/9/20.
 */
public class Citybean {


    /**
     * province : 北京
     * city : [{"name":"北京","area":["东城区","西城区","崇文区","宣武区","朝阳区","丰台区","石景山区","海淀区","门头沟区","房山区","通州区","顺义区","昌平区","大兴区","平谷区","怀柔区","密云县","延庆县"]}]
     */

    private List<ChinaBean> china;

    public List<ChinaBean> getChina() {
        return china;
    }

    public void setChina(List<ChinaBean> china) {
        this.china = china;
    }

    public static class ChinaBean {
        private String province;
        /**
         * name : 北京
         * area : ["东城区","西城区","崇文区","宣武区","朝阳区","丰台区","石景山区","海淀区","门头沟区","房山区","通州区","顺义区","昌平区","大兴区","平谷区","怀柔区","密云县","延庆县"]
         */

        private List<CityBean> city;

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public List<CityBean> getCity() {
            return city;
        }

        public void setCity(List<CityBean> city) {
            this.city = city;
        }

        public static class CityBean {
            private String name;
            private List<String> area;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<String> getArea() {
                return area;
            }

            public void setArea(List<String> area) {
                this.area = area;
            }
        }
    }
}
