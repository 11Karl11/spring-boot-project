package com.karl.apacheshiro.mapper;

import com.karl.apacheshiro.entity.SysUser;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Description TODO
 * @Date 2020/4/19 10:43
 * @Created karl xie
 */
@Repository
public interface SysUserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    /** 根据用户 Username 查询用户信息
     * @param username 用户名
     * @return 用户信息
     */
    @Select("Select user_id,username, password,user_role,user_permission From sys_user Where username=#{username}")
    SysUser selectByUsername(String username);

}