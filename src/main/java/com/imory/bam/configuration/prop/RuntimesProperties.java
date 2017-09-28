package com.imory.bam.configuration.prop;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/7/19
 */
@Component
@ConfigurationProperties(prefix = "runtime")
@PropertySource("classpath:config/runtimes.properties")
public class RuntimesProperties {

   private String upload;

    public String getUpload()
    {
        return upload;
    }

    public void setUpload(String upload)
    {
        this.upload = upload;
    }
}
