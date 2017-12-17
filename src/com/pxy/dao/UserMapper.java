package com.pxy.dao;

import com.pxy.entity.User;

public interface UserMapper{
	/**
	 * 根据主键删除记录
	 * @param id
	 * @return
	 */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入记录
     * @param record
     * @return
     */
    int insert(User record);

    /**
     * 插入选择的记录
     * @param record
     * @return
     */
    int insertSelective(User record);

    /**
     * 根据主键选择记录
     * @param id
     * @return
     */
    User selectByPrimaryKey(Integer id);
    
    /**
     * 根据用户名选择记录
     * @param userName
     * @return
     */
    User selectByName(String userName);

    /**
     * 根据所有选择的主键更新记录
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * 根据主键更新记录
     * @param record
     * @return
     */
    int updateByPrimaryKey(User record);
}