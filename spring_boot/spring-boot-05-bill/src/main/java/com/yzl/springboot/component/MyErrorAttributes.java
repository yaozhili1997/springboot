package com.yzl.springboot.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**自定义数据进行相应
 * @Author: 姚志立
 * @Date: 2020/4/6 18:21
 * @Version: 1.0
 */

@Component  //向对象容器中添加该组件
public class MyErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("company", "yzl.com");
        return map;
    }
}
