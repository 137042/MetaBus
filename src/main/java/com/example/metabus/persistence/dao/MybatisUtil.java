package com.example.metabus.persistence.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {

    private static MybatisUtil mybatisUtil=null;
    private SqlSessionFactory sqlSessionFactory = null;
    private InputStream is = null;

    private MybatisUtil() {
        try {
            is = Resources.getResourceAsStream("main/resources/config.xml");
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

        public SqlSessionFactory getInstance () {
            if(sqlSessionFactory==null)
            {
                mybatisUtil=new MybatisUtil();
                    return sqlSessionFactory;
            }
            return sqlSessionFactory;
    }
}
