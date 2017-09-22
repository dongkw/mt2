package org.smart4j.mt.aspect;

import org.apache.log4j.Logger;
import org.smart4j.annotation.Aspect;
import org.smart4j.annotation.Controller;
import org.smart4j.framework.proxy.AspectProxy;

import java.lang.reflect.Method;

/**
 * controllerAspect
 * Created by dkw on 2017/7/25.
 */
@Aspect(Controller.class)
public class ControllerAspect extends AspectProxy {
    private static final Logger log = Logger.getLogger(AspectProxy.class);
    private Long begin;

    @Override
    public void before(Class<?> cls, Method method, Object[] params) throws Throwable {
        //      super.before(cls, method, params);
        log.debug("------------begin-------------");
        log.debug(String.format("[Class: %s <%s>]", cls.getName(), method.getName()));

        begin = System.currentTimeMillis();
    }

    @Override
    public void after(Class<?> cls, Method method, Object[] params, Object result) throws Throwable {
        //   super.after(cls, method, params);
        log.debug(String.format("Time: %s", System.currentTimeMillis() - begin));
        log.debug("-------------end--------------");
    }
}
