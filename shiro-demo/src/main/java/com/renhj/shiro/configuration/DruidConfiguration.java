package com.renhj.shiro.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource(value = "classpath:druid.properties")
public class DruidConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    @Primary
    public DataSource dataSource(){
        return new DruidDataSource();
    }


    @Bean
    public ServletRegistrationBean<StatViewServlet> druidServelt(){
        ServletRegistrationBean<StatViewServlet> regBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        regBean.addInitParameter("allow", "127.0.0.1");
        regBean.addInitParameter("loginUsername", "admin");
        regBean.addInitParameter("loginPassword", "admin");
        regBean.addInitParameter("resetEnable", "false");
        return regBean;
    }

    @Bean
    public FilterRegistrationBean<WebStatFilter> druidFilter(){
        FilterRegistrationBean<WebStatFilter> regBean = new FilterRegistrationBean<>(new WebStatFilter());
        regBean.addUrlPatterns("/*");
        regBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return regBean;
    }

}
