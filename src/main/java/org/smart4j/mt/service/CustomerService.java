package org.smart4j.mt.service;



import org.smart4j.annotation.Service;
import org.smart4j.annotation.Transaction;
import org.smart4j.helper.DatabaseHelper;
import org.smart4j.mt.model.Customer;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by dkw on 2017/6/28.
 */
@Service
public class CustomerService {
    private static final Logger log = Logger.getLogger(CustomerService.class);


    /**
     * 获取所有用户
     * @return
     */
    public List<Customer> getCustomerList() {
            String sql = "select * from customer";
        return  DatabaseHelper.queryEntityList(Customer.class,sql);
    }

    public Customer getCustomer(int id) {
        String sql="select * from customer where id =?";
        List<Object> paramList = new ArrayList<>();
        paramList.add(id);
        Object[] params = paramList.toArray();
        return DatabaseHelper.queryEntity(Customer.class,sql,params);
    }
    @Transaction
    public boolean createCustomer(Map<String, Object> fieldMap) {
        return DatabaseHelper.insertEntity(Customer.class,fieldMap);
    }
    @Transaction
    public boolean updateCustomer(int id,Map<String, Object> fieldMap) {
        return DatabaseHelper.updateEntity(Customer.class,id,fieldMap);
    }

    public boolean deleteCustomer(int id) {
        return DatabaseHelper.deleteEntity(Customer.class,id);
    }
}

