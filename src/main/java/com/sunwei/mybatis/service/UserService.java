package com.sunwei.mybatis.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sunwei.mybatis.mapper.User;
import com.sunwei.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.Collections;
import java.util.List;

public class UserService {
    public User findById(int id) {
        SqlSession sqlSession = null;
        try {
            Reader resourceAsReader = Resources.getResourceAsReader("mybatisconfig.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
            sqlSession = build.openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.findById(id);
            return user;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (sqlSession == null) {
                sqlSession.close();
            }
        }
        return null;
    }


    public void saveUser(User user) {
        SqlSession sqlSession = null;
        try {
            Reader resourceAsReader = Resources.getResourceAsReader("mybatisconfig.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
            sqlSession = build.openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.save(user);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (sqlSession == null) {
                sqlSession.close();
            }
        }
    }

    public int updateUser(User user) {
        SqlSession sqlSession = null;
        try {
            Reader resourceAsReader = Resources.getResourceAsReader("mybatisconfig.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
            sqlSession = build.openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            int update = userMapper.updateUser(user);
            //??????  ??????
            int i = 10/0;
            sqlSession.commit();
            return update;
//            ????????? sqlSession = build.openSession(true);  true????????????
        } catch (IOException e) {
            e.printStackTrace();
            //??????????????????
            sqlSession.rollback(true);
        }finally {
            if (sqlSession == null) {
                sqlSession.close();
            }
        }
        return -1;
    }

    public int deleteUserById(int id) {
        SqlSession sqlSession = null;
        try {
            Reader resourceAsReader = Resources.getResourceAsReader("mybatisconfig.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
            //????????????
            sqlSession = build.openSession(true);
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.deleteUserById(id);
//            ????????? sqlSession = build.openSession(true);  true????????????
//            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (sqlSession == null) {
                sqlSession.close();
            }
        }
        return -1;
    }

    public List<User> findAgeById(int age) {
        SqlSession sqlSession = null;
        try {
            Reader resourceAsReader = Resources.getResourceAsReader("mybatisconfig.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
            sqlSession = build.openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> ageById = userMapper.findAgeById(age);
            return ageById;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (sqlSession == null) {
                sqlSession.close();
            }
        }
        return Collections.emptyList();
    }

    /**
     *
     * @param page  ????????????
     * @param pageSize ????????????????????????
     * @return
     */
    public List<User> limitUser(int page , int pageSize) {
        SqlSession sqlSession = null;
        try {
            Reader resourceAsReader = Resources.getResourceAsReader("mybatisconfig.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
            sqlSession = build.openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            int count = userMapper.countAllInfo();
            System.out.println("????????????" + count );
            int index = (page - 1)  *  pageSize; //1 0 , 2 1 , 3 2.......
            int size = pageSize;
            List<User> users = userMapper.limtUser(index, size);
            return users;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (sqlSession == null) {
                sqlSession.close();
            }
        }
        return Collections.emptyList();
    }

    /**
     * ????????????????????????
     * @param page
     * @param pageSize
     * @return
     */
    public List<User> limitUserPlugin(int page , int pageSize) {
        SqlSession sqlSession = null;
        try {
            Reader resourceAsReader = Resources.getResourceAsReader("mybatisconfig.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
            sqlSession = build.openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //????????????
            PageHelper.startPage(page , pageSize);
            Page<User> userPage = userMapper.limitUserTwo();
            System.out.println("????????????" + userPage.getTotal());
            System.out.println("????????????" + userPage.getPages());
            return userPage.getResult();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (sqlSession == null) {
                sqlSession.close();
            }
        }
        return Collections.emptyList();
    }

    public List<User> findByAgeWhereService(int age) {
        SqlSession sqlSession = null;
        try {
            Reader resourceAsReader = Resources.getResourceAsReader("mybatisconfig.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
            sqlSession = build.openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //????????????
            List<User> byAgeWhere = userMapper.findByAgeWhere(age);
            return byAgeWhere;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (sqlSession == null) {
                sqlSession.close();
            }
        }
        return Collections.emptyList();
    }

    public List<User> findUserListByIds(List<Integer> userId) {
        SqlSession sqlSession = null;
        try {
            Reader resourceAsReader = Resources.getResourceAsReader("mybatisconfig.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
            sqlSession = build.openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //????????????
            List<User> byAgeWhere = userMapper.findUserListByIds(userId);
            return byAgeWhere;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (sqlSession == null) {
                sqlSession.close();
            }
        }
        return Collections.emptyList();
    }
}
