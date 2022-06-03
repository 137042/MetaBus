package com.example.metabus.persistence.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

public class MybatisUtil {

    private static MybatisUtil mybatisUtil;
    private SqlSessionFactory sqlSessionFactory;
    private InputStream is;

    private MybatisUtil() {
        try{
            is =this.getClass().getClassLoader().getResourceAsStream("com/example/metabus/config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
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
        if(mybatisUtil == null)
        {
            mybatisUtil = new MybatisUtil();
        }
        return mybatisUtil;
    }

    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}
