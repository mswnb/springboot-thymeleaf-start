package cn.msw.springbootthymeleafstart.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * @Author 毛送文
 * @Date 2021/1/23 19:12
 * @Version 1.0
 */
//@Configuration
@Deprecated
public class MyDataSourceConfig{
//    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource getDruidDataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
       /* druidDataSource.setUrl();
        druidDataSource.setUsername();
        druidDataSource.setPassword();
        druidDataSource.setDriverClassName();*/
        druidDataSource.setFilters("stat,wall");
        return druidDataSource;
    }
//    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        StatViewServlet servlet=new StatViewServlet();
        ServletRegistrationBean registrationBean=new ServletRegistrationBean(servlet,"/druid/*");
        registrationBean.addInitParameter("loginUsername","msw");
        registrationBean.addInitParameter("loginPassword","123456");
        return registrationBean;
    }

//    @Bean
    public FilterRegistrationBean webStatFilter(){
        WebStatFilter webStatFilter=new WebStatFilter();
        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean(webStatFilter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;

    }
}
