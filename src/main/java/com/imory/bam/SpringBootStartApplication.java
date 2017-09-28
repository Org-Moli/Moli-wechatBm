package com.imory.bam;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/7/13
 */
//该类主要用于打包成war Tomcat部署时使用
public class SpringBootStartApplication extends SpringBootServletInitializer{
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder)
    {
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(App.class);
    }
}
