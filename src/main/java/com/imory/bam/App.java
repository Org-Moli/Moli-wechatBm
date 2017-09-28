package com.imory.bam;

import com.imory.bam.configuration.prop.RuntimesProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/7/11
 */
@SpringBootApplication
@EntityScan(basePackages = "com.imory.bam")
@EnableConfigurationProperties({RuntimesProperties.class})
public class App {

    public static void main(String args[])
    {
        SpringApplication.run(App.class,args);
    }
}
