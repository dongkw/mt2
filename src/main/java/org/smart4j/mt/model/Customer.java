package org.smart4j.mt.model;

    /**
    * Created by dkw on 2017/6/27.
    */
public class Customer {
    private int id;
    private  String name;
    private  String code;
    private  String phone;
    private  String remark;

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getPhone() {

            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getCode() {

            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {

            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
