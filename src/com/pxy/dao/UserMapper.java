package com.pxy.dao;

import com.pxy.entity.User;

public interface UserMapper{
	/**
	 * ��������ɾ����¼
	 * @param id
	 * @return
	 */
    int deleteByPrimaryKey(Integer id);

    /**
     * �����¼
     * @param record
     * @return
     */
    int insert(User record);

    /**
     * ����ѡ��ļ�¼
     * @param record
     * @return
     */
    int insertSelective(User record);

    /**
     * ��������ѡ���¼
     * @param id
     * @return
     */
    User selectByPrimaryKey(Integer id);
    
    /**
     * �����û���ѡ���¼
     * @param userName
     * @return
     */
    User selectByName(String userName);

    /**
     * ��������ѡ����������¼�¼
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * �����������¼�¼
     * @param record
     * @return
     */
    int updateByPrimaryKey(User record);
}