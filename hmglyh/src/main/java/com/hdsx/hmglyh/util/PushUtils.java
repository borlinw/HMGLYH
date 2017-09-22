package com.hdsx.hmglyh.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jiguang.common.ClientConfig;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;

public class PushUtils {
    protected static final Logger LOG = LoggerFactory.getLogger(PushUtils.class);

	private static final String appKey ="3a9ae6f76b1b65b2b210e2df";
	private static final String masterSecret = "ed99a146105806a721a3fe5f";

	
    public static PushPayload buildPushObject_android_tag_alertWithTitle(String phone,String title) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android())
                .setAudience(Audience.alias(phone))
                .setMessage(Message.newBuilder()
                .setTitle(title)
                .setMsgContent("11")
                .build())
                .build();
    }
    
    public static int sendPushWithCustomConfig(String phone,String title) {
        ClientConfig config = ClientConfig.getInstance();
        
        JPushClient jpushClient = new JPushClient(masterSecret, appKey, null, config);

        PushPayload payload = buildPushObject_android_tag_alertWithTitle(phone,title);
        PushResult result = null;
        try {
            result = jpushClient.sendPush(payload);
            LOG.info("Got result - " + result);
        } catch (Exception e) {
        	e.printStackTrace();
        }
        jpushClient.close();
        
        
        if( result != null ) {
        	return result.statusCode;
        }else{
        	return 0;
        }
        
    }

}

