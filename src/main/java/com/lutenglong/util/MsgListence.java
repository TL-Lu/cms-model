package com.lutenglong.util;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.listener.MessageListener;

import com.alibaba.fastjson.JSON;
import com.lutenglong.bean.Article;
import com.lutenglong.controller.UserController;
import com.lutenglong.service.ChannelService;
import com.lutenglong.service.UserService;

public class MsgListence implements  MessageListener<String, String> {
   
	@Autowired
	ChannelService service;
	@Override
	public void onMessage(ConsumerRecord<String, String> data) {
			String value = data.value();
			Article parseObject = JSON.parseObject(value,Article.class);
			System.out.println(value);
			service.add(parseObject);
	}

}
