package com.qf.service.impl;

import com.alibaba.fastjson.JSON;
import com.qf.mapper.TbMsgMapper;
import com.qf.pojo.TbMsg;
import com.qf.service.TbMsgService;
import com.qf.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Company: **
 * @Author: Daki
 * @Date: 0016 6-16
 * @Time: 20:02
 */
@Service
public class TbMsgServiceImpl implements TbMsgService {
    @Autowired
    private TbMsgMapper tbMsgMapper;
    @Autowired
    private RedisUtils redisUtils;
    @Override
    public boolean addMsg(TbMsg msg) {
        int i = tbMsgMapper.addMsg(msg);
        if(i>0){
            System.out.println("--->保证数据和redis同步，干掉");
            redisUtils.expire("msgs",0);
        }
        return i>0;
    }

    @Override
    public boolean updateMsg(TbMsg msg) {
        int i = tbMsgMapper.updateMsg(msg);
        if(i>0){
            System.out.println("--->保证数据和redis同步，干掉");
            redisUtils.expire("msgs",0);
        }

        return i>0;
    }

    @Override
    public boolean deleteMsg(int id) {
        int i = tbMsgMapper.deleteMsg(id);
        if(i>0){
            System.out.println("--->保证数据和redis同步，干掉");
            redisUtils.expire("msgs",0);
        }
        return i>0;
    }

    @Override
    public List<TbMsg> findAll() {
        List<TbMsg> list = null;
        Object msgs = redisUtils.get("msgs");
        if(msgs==null){
            System.out.println("------>走的是数据库");
            list=tbMsgMapper.findAll();
            System.out.println("------>走完数据库需要把数据同步到redis中");
            String json = JSON.toJSONString(list);
            redisUtils.set("msgs",json);
        }else {
            System.out.println("------>走的缓存");
            String json = msgs+"";
            list =JSON.parseArray(json,TbMsg.class);
        }
        return list;
    }
}
