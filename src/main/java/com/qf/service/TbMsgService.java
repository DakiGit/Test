package com.qf.service;

import com.qf.pojo.TbMsg;

import java.util.List;

/**
 * @Description:
 * @Company: 千锋互联
 * @Author: 李丽婷
 * @Date: 2019/6/14
 * @Time: 下午4:37
 */
public interface TbMsgService {

    public boolean  addMsg(TbMsg msg);

    public boolean  updateMsg(TbMsg msg);

    public boolean  deleteMsg(int id);

    public List<TbMsg> findAll();
}
