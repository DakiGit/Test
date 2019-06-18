package com.qf.controller;

import com.qf.pojo.TbMsg;
import com.qf.service.TbMsgService;
import com.qf.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description:
 * @Company: **
 * @Author: Daki
 * @Date: 0016 6-16
 * @Time: 20:04
 */
@Controller
public class TbMsgController {
    @Autowired
    private TbMsgService tbMsgService;
    @RequestMapping("/doAdd")
    @ResponseBody
    public R addMsg(TbMsg tbMsg){
        boolean b = tbMsgService.addMsg(tbMsg);
        if(b){
            return R.ok("新增成功");
        }else {
            return R.error("新增失败");
        }
    }
}
