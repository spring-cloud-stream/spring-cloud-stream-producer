package com.github.zk.springcloudstreamproducer.service.impl;

import com.github.zk.springcloudstreamproducer.service.ISendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.binding.BinderAwareChannelResolver;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @author zk
 * @date 2019/3/7 11:15
 */
@EnableBinding(Source.class)
public class SendServiceImpl implements ISendService {

    @Autowired
    private Source source;

    @Autowired
    private BinderAwareChannelResolver resolver;

    @Override
    public void sendMsg(String msg) {
        source.output().send(MessageBuilder.withPayload(msg).build());
    }

    @Override
    public void sendTopicMsg(String msg) {
        resolver.resolveDestination("stream-demo").send(new GenericMessage<>(msg.getBytes()));
    }
}
