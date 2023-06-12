package top.zxh.web.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * JDBC工具类
 */
public class jdbcUtil {
    private static final DataSource ds;

    private static jdbcUtil jdbcUtil = null;

    static {
        //加载配置文件
        System.out.println("执行静态代码块");
        Properties properties = new Properties();
        InputStream is = jdbcUtil.class.getClassLoader().getResourceAsStream("durid.properties");
        try {
            properties.load(is);
            //初始化连接池
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static DataSource getDataSource(){
        return ds;
    }

    private jdbcUtil() {
        System.out.println("执行构造方法");
    }

    public static jdbcUtil getJdbcUtilInstance() {
        if (jdbcUtil == null) {
            jdbcUtil = new jdbcUtil();
            return jdbcUtil;
        } else {
            return jdbcUtil;
        }

    }

}
