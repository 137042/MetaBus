package com.example.metabus.persistence.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {

    private static MybatisUtil mybatisUtil;
    private SqlSessionFactory sqlSessionFactory = null;
    private InputStream is = null;

    private MybatisUtil() {
        try {
            is = Resources.getResourceAsStream("com/example/metabus_client/config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }

        public static synchronized MybatisUtil getInstance () {
            if(mybatisUtil==null)
            {
                mybatisUtil=new MybatisUtil();
            }
            return mybatisUtil;
    }

    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}
