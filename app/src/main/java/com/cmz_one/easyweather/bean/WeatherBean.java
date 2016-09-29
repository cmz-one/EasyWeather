package com.cmz_one.easyweather.bean;



import java.io.Serializable;
import java.util.List;

/**
 * Created by cmz_o on 2016/8/8.
 */
public class WeatherBean implements Serializable {


    /**
     * errNum : 0
     * errMsg : success
     * retData : {"city":"澄海","cityid":"101280503","today":{"date":"2016-08-08","week":"星期一","curTemp":"29℃","aqi":null,"fengxiang":"无持续风向","fengli":"微风级","hightemp":"31℃","lowtemp":"26℃","type":"雷阵雨","index":[{"name":"感冒指数","code":"gm","index":"","details":"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。","otherName":""},{"code":"fs","details":"属中等强度紫外辐射天气，外出时应注意防护，建议涂擦SPF指数高于15，PA+的防晒护肤品。","index":"中等","name":"防晒指数","otherName":""},{"code":"ct","details":"天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。","index":"热","name":"穿衣指数","otherName":""},{"code":"yd","details":"有降水，推荐您在室内进行健身休闲运动；若坚持户外运动，须注意携带雨具并注意避雨防滑。","index":"较不宜","name":"运动指数","otherName":""},{"code":"xc","details":"不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。","index":"不宜","name":"洗车指数","otherName":""},{"code":"ls","details":"有降水，不适宜晾晒。若需要晾晒，请在室内准备出充足的空间。","index":"不宜","name":"晾晒指数","otherName":""}]},"forecast":[{"date":"2016-08-09","week":"星期二","fengxiang":"无持续风向","fengli":"微风级","hightemp":"30℃","lowtemp":"26℃","type":"中雨"},{"date":"2016-08-10","week":"星期三","fengxiang":"无持续风向","fengli":"微风级","hightemp":"30℃","lowtemp":"26℃","type":"中雨"},{"date":"2016-08-11","week":"星期四","fengxiang":"无持续风向","fengli":"微风级","hightemp":"30℃","lowtemp":"27℃","type":"阵雨"},{"date":"2016-08-12","week":"星期五","fengxiang":"无持续风向","fengli":"微风级","hightemp":"32℃","lowtemp":"27℃","type":"多云"}],"history":[{"date":"2016-08-01","week":"星期一","aqi":null,"fengxiang":"东北风","fengli":"4-5级","hightemp":"32℃","lowtemp":"25℃","type":"阵雨"},{"date":"2016-08-02","week":"星期二","aqi":null,"fengxiang":"东南风","fengli":"5-6级","hightemp":"29℃","lowtemp":"25℃","type":"大雨"},{"date":"2016-08-03","week":"星期三","aqi":null,"fengxiang":"东南风","fengli":"3-4级","hightemp":"32℃","lowtemp":"26℃","type":"阵雨"},{"date":"2016-08-04","week":"星期四","aqi":null,"fengxiang":"南风","fengli":"微风级","hightemp":"31℃","lowtemp":"26℃","type":"多云"},{"date":"2016-08-05","week":"星期五","aqi":null,"fengxiang":"西南风","fengli":"微风级","hightemp":"32℃","lowtemp":"27℃","type":"多云"},{"date":"2016-08-06","week":"星期六","aqi":null,"fengxiang":"无持续风向","fengli":"微风级","hightemp":"35℃","lowtemp":"27℃","type":"多云"},{"date":"2016-08-07","week":"星期天","aqi":null,"fengxiang":"无持续风向","fengli":"微风级","hightemp":"30℃","lowtemp":"26℃","type":"雷阵雨"}]}
     */

    private int errNum;
    private String errMsg;
    /**
     * city : 澄海
     * cityid : 101280503
     * today : {"date":"2016-08-08","week":"星期一","curTemp":"29℃","aqi":null,"fengxiang":"无持续风向","fengli":"微风级","hightemp":"31℃","lowtemp":"26℃","type":"雷阵雨","index":[{"name":"感冒指数","code":"gm","index":"","details":"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。","otherName":""},{"code":"fs","details":"属中等强度紫外辐射天气，外出时应注意防护，建议涂擦SPF指数高于15，PA+的防晒护肤品。","index":"中等","name":"防晒指数","otherName":""},{"code":"ct","details":"天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。","index":"热","name":"穿衣指数","otherName":""},{"code":"yd","details":"有降水，推荐您在室内进行健身休闲运动；若坚持户外运动，须注意携带雨具并注意避雨防滑。","index":"较不宜","name":"运动指数","otherName":""},{"code":"xc","details":"不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。","index":"不宜","name":"洗车指数","otherName":""},{"code":"ls","details":"有降水，不适宜晾晒。若需要晾晒，请在室内准备出充足的空间。","index":"不宜","name":"晾晒指数","otherName":""}]}
     * forecast : [{"date":"2016-08-09","week":"星期二","fengxiang":"无持续风向","fengli":"微风级","hightemp":"30℃","lowtemp":"26℃","type":"中雨"},{"date":"2016-08-10","week":"星期三","fengxiang":"无持续风向","fengli":"微风级","hightemp":"30℃","lowtemp":"26℃","type":"中雨"},{"date":"2016-08-11","week":"星期四","fengxiang":"无持续风向","fengli":"微风级","hightemp":"30℃","lowtemp":"27℃","type":"阵雨"},{"date":"2016-08-12","week":"星期五","fengxiang":"无持续风向","fengli":"微风级","hightemp":"32℃","lowtemp":"27℃","type":"多云"}]
     * history : [{"date":"2016-08-01","week":"星期一","aqi":null,"fengxiang":"东北风","fengli":"4-5级","hightemp":"32℃","lowtemp":"25℃","type":"阵雨"},{"date":"2016-08-02","week":"星期二","aqi":null,"fengxiang":"东南风","fengli":"5-6级","hightemp":"29℃","lowtemp":"25℃","type":"大雨"},{"date":"2016-08-03","week":"星期三","aqi":null,"fengxiang":"东南风","fengli":"3-4级","hightemp":"32℃","lowtemp":"26℃","type":"阵雨"},{"date":"2016-08-04","week":"星期四","aqi":null,"fengxiang":"南风","fengli":"微风级","hightemp":"31℃","lowtemp":"26℃","type":"多云"},{"date":"2016-08-05","week":"星期五","aqi":null,"fengxiang":"西南风","fengli":"微风级","hightemp":"32℃","lowtemp":"27℃","type":"多云"},{"date":"2016-08-06","week":"星期六","aqi":null,"fengxiang":"无持续风向","fengli":"微风级","hightemp":"35℃","lowtemp":"27℃","type":"多云"},{"date":"2016-08-07","week":"星期天","aqi":null,"fengxiang":"无持续风向","fengli":"微风级","hightemp":"30℃","lowtemp":"26℃","type":"雷阵雨"}]
     */

    private RetDataBean retData;

    public int getErrNum() {
        return errNum;
    }

    public void setErrNum(int errNum) {
        this.errNum = errNum;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public RetDataBean getRetData() {
        return retData;
    }

    public void setRetData(RetDataBean retData) {
        this.retData = retData;
    }



    public static class RetDataBean {
        private String city;
        private String cityid;
        /**
         * date : 2016-08-08
         * week : 星期一
         * curTemp : 29℃
         * aqi : null
         * fengxiang : 无持续风向
         * fengli : 微风级
         * hightemp : 31℃
         * lowtemp : 26℃
         * type : 雷阵雨
         * index : [{"name":"感冒指数","code":"gm","index":"","details":"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。","otherName":""},{"code":"fs","details":"属中等强度紫外辐射天气，外出时应注意防护，建议涂擦SPF指数高于15，PA+的防晒护肤品。","index":"中等","name":"防晒指数","otherName":""},{"code":"ct","details":"天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。","index":"热","name":"穿衣指数","otherName":""},{"code":"yd","details":"有降水，推荐您在室内进行健身休闲运动；若坚持户外运动，须注意携带雨具并注意避雨防滑。","index":"较不宜","name":"运动指数","otherName":""},{"code":"xc","details":"不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。","index":"不宜","name":"洗车指数","otherName":""},{"code":"ls","details":"有降水，不适宜晾晒。若需要晾晒，请在室内准备出充足的空间。","index":"不宜","name":"晾晒指数","otherName":""}]
         */

        private TodayBean today;
        /**
         * date : 2016-08-09
         * week : 星期二
         * fengxiang : 无持续风向
         * fengli : 微风级
         * hightemp : 30℃
         * lowtemp : 26℃
         * type : 中雨
         */

        private List<ForecastBean> forecast;
        /**
         * date : 2016-08-01
         * week : 星期一
         * aqi : null
         * fengxiang : 东北风
         * fengli : 4-5级
         * hightemp : 32℃
         * lowtemp : 25℃
         * type : 阵雨
         */

        private List<HistoryBean> history;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCityid() {
            return cityid;
        }

        public void setCityid(String cityid) {
            this.cityid = cityid;
        }

        public TodayBean getToday() {
            return today;
        }

        public void setToday(TodayBean today) {
            this.today = today;
        }

        public List<ForecastBean> getForecast() {
            return forecast;
        }

        public void setForecast(List<ForecastBean> forecast) {
            this.forecast = forecast;
        }

        public List<HistoryBean> getHistory() {
            return history;
        }

        public void setHistory(List<HistoryBean> history) {
            this.history = history;
        }

        public static class TodayBean {
            private String date;
            private String week;
            private String curTemp;
            private int aqi;
            private String fengxiang;
            private String fengli;
            private String hightemp;
            private String lowtemp;
            private String type;
            /**
             * name : 感冒指数
             * code : gm
             * index :
             * details : 各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。
             * otherName :
             */

            private List<IndexBean> index;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getCurTemp() {
                return curTemp;
            }

            public void setCurTemp(String curTemp) {
                this.curTemp = curTemp;
            }

            public int getAqi() {
                return aqi;
            }

            public void setAqi(int aqi) {
                this.aqi = aqi;
            }

            public String getFengxiang() {
                return fengxiang;
            }

            public void setFengxiang(String fengxiang) {
                this.fengxiang = fengxiang;
            }

            public String getFengli() {
                return fengli;
            }

            public void setFengli(String fengli) {
                this.fengli = fengli;
            }

            public String getHightemp() {
                return hightemp;
            }

            public void setHightemp(String hightemp) {
                this.hightemp = hightemp;
            }

            public String getLowtemp() {
                return lowtemp;
            }

            public void setLowtemp(String lowtemp) {
                this.lowtemp = lowtemp;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<IndexBean> getIndex() {
                return index;
            }

            public void setIndex(List<IndexBean> index) {
                this.index = index;
            }

            public static class IndexBean {
                private String name;
                private String code;
                private String index;
                private String details;
                private String otherName;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getCode() {
                    return code;
                }

                public void setCode(String code) {
                    this.code = code;
                }

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getDetails() {
                    return details;
                }

                public void setDetails(String details) {
                    this.details = details;
                }

                public String getOtherName() {
                    return otherName;
                }

                public void setOtherName(String otherName) {
                    this.otherName = otherName;
                }
            }
        }

        public static class ForecastBean {
            private String date;
            private String week;
            private String fengxiang;
            private String fengli;
            private String hightemp;
            private String lowtemp;
            private String type;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getFengxiang() {
                return fengxiang;
            }

            public void setFengxiang(String fengxiang) {
                this.fengxiang = fengxiang;
            }

            public String getFengli() {
                return fengli;
            }

            public void setFengli(String fengli) {
                this.fengli = fengli;
            }

            public String getHightemp() {
                return hightemp;
            }

            public void setHightemp(String hightemp) {
                this.hightemp = hightemp;
            }

            public String getLowtemp() {
                return lowtemp;
            }

            public void setLowtemp(String lowtemp) {
                this.lowtemp = lowtemp;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }

        public static class HistoryBean {
            private String date;
            private String week;
            private Object aqi;
            private String fengxiang;
            private String fengli;
            private String hightemp;
            private String lowtemp;
            private String type;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public Object getAqi() {
                return aqi;
            }

            public void setAqi(Object aqi) {
                this.aqi = aqi;
            }

            public String getFengxiang() {
                return fengxiang;
            }

            public void setFengxiang(String fengxiang) {
                this.fengxiang = fengxiang;
            }

            public String getFengli() {
                return fengli;
            }

            public void setFengli(String fengli) {
                this.fengli = fengli;
            }

            public String getHightemp() {
                return hightemp;
            }

            public void setHightemp(String hightemp) {
                this.hightemp = hightemp;
            }

            public String getLowtemp() {
                return lowtemp;
            }

            public void setLowtemp(String lowtemp) {
                this.lowtemp = lowtemp;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }
}
