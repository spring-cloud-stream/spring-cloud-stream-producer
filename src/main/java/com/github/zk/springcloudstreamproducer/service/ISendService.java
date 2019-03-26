package com.github.zk.springcloudstreamproducer.service;

/**
 * @author zk
 * @date 2019/3/7 11:16
 */
public interface ISendService {
    public void sendMsg(String msg);

    public void sendTopicMsg(String msg);
}
