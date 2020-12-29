package tech.jiangchen.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * @author JiangChen
 * @date 2020/06/10
 */
@Configuration
@MapperScan(value = "tech.jiangchen.mapper.test1", sqlSessionFactoryRef = "", sqlSessionTemplateRef = "")
public class FirstDataSourceConfig {
    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.first")
    public DataSourceProperties firstDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    public HikariDataSource firstDataSource() {
        return firstDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean
    public SqlSessionFactory firstSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(firstDataSource());
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/test1"));
        return bean.getObject();
    }

    @Bean
    public SqlSessionTemplate firstSqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(firstSqlSessionFactory());
    }
}
