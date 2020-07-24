package com.github.zk.springcloudstreamproducer.controller;

import com.github.zk.springcloudstreamproducer.service.ISendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author zk
 * @date 2019/3/7 11:25
 */
@RestController
public class ProducterController {
    @Autowired
    private ISendService iSendService;

    @RequestMapping("/send/{msg}")
    public void sendMsg(@PathVariable("msg") String msg){
        for (int i=0;i<10;i++) {
            //id为指定分区号，有yml配置partitionKeyExpression: payload.id 决定哪个字段为分区号
            String json = "{\"id\":\"0\",\"name\":\"zk\"}";
            iSendService.sendMsg(json + i);
        }
    }
    @RequestMapping("/send2/{msg}")
    public void sendMsg2(@PathVariable("msg") String msg){
        for (int i = 0;i<10;i++) {
            iSendService.sendTopicMsg(msg + i);
        }
    }
}
