package tk.mybatis.simple.model.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import tk.mybatis.simple.MyMapperProxy;
import tk.mybatis.simple.mapper.UserMapper;
import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

import java.lang.reflect.Proxy;
import java.util.List;

public class UserMapperTest extends BaseMapperTest {

    @Test
    public void testSelectById() {
        // 获取sqlSession
        SqlSession sqlSession = getSqlSession();
        try {

            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = userMapper.selectById(1L);
            // user不为空
            Assert.assertNotNull(user);
            // userName = admin
            Assert.assertEquals("admin", user.getUserName());
        } finally {
            // 一定要关闭sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testSelectAll() {
        // 获取sqlSession
        SqlSession sqlSession = getSqlSession();
        try {

            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysUser> userList = userMapper.selectAll();
            // user不为空
            Assert.assertNotNull(userList);
            // 用户数量大于0个
            Assert.assertTrue(userList.size() > 0);
        } finally {
            // 一定要关闭sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testSelectRolesByUserId() {
        // 获取sqlSession
        SqlSession sqlSession = getSqlSession();
        try {

            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysRole> roleList = userMapper.selectRolesByUserId(1L);
            // user不为空
            Assert.assertNotNull(roleList);
            // 角色数量大于0个
            Assert.assertTrue(roleList.size() > 0);
        } finally {
            // 一定要关闭sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testUpdateById() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = mapper.selectById(1L);
            // 当前用户为admin
            Assert.assertEquals("admin", user.getUserName());
            // 修改用户名
            user.setUserName("admin_test");
            // 修改邮箱
            user.setUserEmail("test@mybatis.th");
            // 返回更新语句影响的行数
            int result = mapper.updateById(user);
            // 只更新了一条数据
            Assert.assertEquals(1, result);
            user = mapper.selectById(1L);
            // 修改后的名字是admin_test
            Assert.assertEquals("admin_test", user.getUserName());
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testMyMapperProxy() {
        SqlSession sqlSession = getSqlSession();
        MyMapperProxy userMapperProxy = new MyMapperProxy(UserMapper.class, sqlSession);
        UserMapper userMapper = (UserMapper)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{UserMapper.class}, userMapperProxy);
        List<SysUser> user = userMapper.selectAll();
        System.out.println(user);
    }
}
