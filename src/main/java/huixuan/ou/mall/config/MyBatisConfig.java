package huixuan.ou.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @program: mall
 * @description: Mybatis配置类
 * @author: ouhuixuan
 * @create: 2019-11-25 16:58
 **/
@Configuration
@MapperScan("huixuan.ou.mall.mbg.mapper")
public class MyBatisConfig {

}
