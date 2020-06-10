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
@MapperScan(value = "tech.jiangchen.mapper.test2", sqlSessionFactoryRef = "", sqlSessionTemplateRef = "")
public class SecondDataSourceConfig {
    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.second")
    public DataSourceProperties secondDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    public HikariDataSource secondDataSource() {
        return secondDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean
    public SqlSessionFactory secondSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(secondDataSource());
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis/mapper/test2"));
        return bean.getObject();
    }

    @Bean
    public SqlSessionTemplate secondSqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(secondSqlSessionFactory());
    }
}
