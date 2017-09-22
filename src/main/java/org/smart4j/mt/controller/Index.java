package org.smart4j.mt.controller;


import org.apache.log4j.Logger;
import org.smart4j.annotation.Action;
import org.smart4j.annotation.Controller;
import org.smart4j.annotation.Inject;
import org.smart4j.bean.Param;
import org.smart4j.bean.View;
import org.smart4j.mt.model.Customer;
import org.smart4j.mt.service.CustomerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * controller
 * Created by dkw on 2017/7/4.
 */
@Controller
public class Index {
    private static final Logger log = Logger.getLogger(Index.class);
    @Inject
    private CustomerService customerService;

    @Action("get:/customer")
    public View indexs() {
        List<Customer> customerList = customerService.getCustomerList();
        return new View("customer.jsp").addModel("customerList", customerList);
    }

    @Action("get:/yanhua")
    public View yanhua() {
        List<Customer> customerList = this.customerService.getCustomerList();
        return new View("yanhua.jsp").addModel("aa", "1111");
    }
    @Action("post:/edit")
    public View edit(Param param){
        Map<String,Object> map=new HashMap<>();

        customerService.updateCustomer(param.getInt("id"),param.getMap());
        List<Customer> customerList = customerService.getCustomerList();
        return new View("customer.jsp").addModel("customerList", customerList);
    }
}
