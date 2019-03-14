package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MysqlUtil {
    private static MysqlUtil connectionUtil = new MysqlUtil();
    public static final String DIRVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/zlx?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
    public static final String USER = "root";
    public static final String PASS = "root";
    public static Connection connection;

    private MysqlUtil() {

    }


    public static MysqlUtil getInstance() {
        if (connectionUtil == null) {
            synchronized (MysqlUtil.class) {
                if (connectionUtil == null) {
                    connectionUtil = new MysqlUtil();
                }
            }
        }
        return connectionUtil;
    }


    public Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
//        File config = new File("src/mysql.properties");
//        FileInputStream fis = new FileInputStream(config);
//        Properties properties = new Properties();
//        properties.load(fis);
        String jdbcDriver;
        //主机
        String jdbcUrl;
        //数据库用户名
        String userName;
        String password;
        jdbcDriver = DIRVER;
        jdbcUrl =URL;
        userName = USER;
        password = PASS;
        Class.forName(jdbcDriver);
        connection = DriverManager.getConnection(jdbcUrl, userName, password);
        return connection;

    }
}
