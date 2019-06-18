package com.qf.mapper;

import com.qf.pojo.TbMsg;

import java.util.List;

/**
 * @Description:
 * @Company: **
 * @Author: Daki
 * @Date: 0016 6-16
 * @Time: 19:51
 */
public interface TbMsgMapper {
    public int addMsg(TbMsg tbMsg);

    public int updateMsg(TbMsg tbMsg);

    public int deleteMsg(int id);

    public List<TbMsg> findAll();
}
