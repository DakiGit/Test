package com.qf.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Company: **
 * @Author: Daki
 * @Date: 0016 6-16
 * @Time: 23:24
 */
public class RedisUtils {
    private RedisTemplate<String,Object> redisTemplate;

    public void setRedisTemplate(RedisTemplate<String,Object>redisTemplate){
        this.redisTemplate=redisTemplate;
    }
    //key过期
    public boolean expire(String key,long time){
        try {
            redisTemplate.expire(key,time, TimeUnit.SECONDS);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    //删除key
    public void del(String key){
        if(StringUtils.isNotEmpty(key)){
            redisTemplate.delete(key);
        }
        throw new RuntimeException("键不能为空");
    }

    //批量删除
    public void del(String... keys){
        if(keys.length>0){
            if(keys.length==1){
                del(keys[0]);
            }else {
                redisTemplate.delete(CollectionUtils.arrayToList(keys));
            }
        }
    }

    public boolean set(String k,String v){
        try{
            redisTemplate.opsForValue().set(k,v);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public Object get(String k){
        return  k==null?null:redisTemplate.opsForValue().get(k);
    }
}
