package com.karl.apacheshiro.service;

import com.karl.apacheshiro.common.MyResponse;
import com.karl.apacheshiro.shiro.RsaUtils.TokenUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.karl.apacheshiro.entity.SysUser;
import com.karl.apacheshiro.mapper.SysUserMapper;

/**
 * @Description TODO
 * @Date 2020/4/19 10:43
 * @Created karl xie
 */
@Service
public class SysUserService {


    /**
     * Hash 加密的盐
     **/
    private final String SALT = "#4d1*dlmmddewd@34%";
    @Resource
    private TokenUtils tokenUtils;

    @Resource
    private SysUserMapper sysUserMapper;


    public int deleteByPrimaryKey(Long userId) {
        return sysUserMapper.deleteByPrimaryKey(userId);
    }


    public int insert(SysUser record) {
        return sysUserMapper.insert(record);
    }


    public int insertSelective(SysUser record) {
        return sysUserMapper.insertSelective(record);
    }


    public SysUser selectByPrimaryKey(Long userId) {
        return sysUserMapper.selectByPrimaryKey(userId);
    }


    public int updateByPrimaryKeySelective(SysUser record) {
        return sysUserMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(SysUser record) {
        return sysUserMapper.updateByPrimaryKey(record);
    }



    /** 用户登录 **/
    public MyResponse login(SysUser sysUser) {
        // 从 数据库查询用户信息
        SysUser user = sysUserMapper.selectByUsername(sysUser.getUsername());
        if (user == null || user.getUsername() == null || user.getPassword() == null
                || user.getUserRole() == null || user.getUserPermission() == null) {
            return new MyResponse("error", "用户信息不存在");
        }
        String password = new SimpleHash("SHA-512", sysUser.getPassword(), this.SALT).toString();
        if (!password.equals(user.getPassword())) {
            return new MyResponse("error", "密码错误");
        }
        // 生成 Token
        return new MyResponse("SUCCESS",
                tokenUtils.createToken(user));
    }

    /** 用户注册
     * @param sysUser 用户注册信息
     * @return 用户注册结果
     */
    public MyResponse save(SysUser sysUser) throws DataAccessException {
        try {
            // 密码加密存储
            String password = new SimpleHash("SHA-512", sysUser.getPassword(), this.SALT).toString();
            sysUser.setPassword(password);
            sysUserMapper.insert(sysUser);
        } catch (DataAccessException e) {
            return new MyResponse("ERROR", "已经存在该用户名或者用户昵称，或者用户权限出错");
        }
        return new MyResponse("SUCCESS", "用户新增成功");
    }
}
