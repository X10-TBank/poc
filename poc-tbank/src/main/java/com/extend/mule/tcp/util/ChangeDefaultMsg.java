package com.extend.mule.tcp.util;

import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

import com.extend.mule.tcp.obj.UserProfile;

public class ChangeDefaultMsg extends AbstractMessageTransformer{

	private Logger log = LogManager.getLogger(ChangeDefaultMsg.class);
	public Object transformMessage(MuleMessage message, String outputEncoding)
			throws TransformerException {
		String msg = "";
		UserProfile profile = new UserProfile();
		try {
			profile.setUserName(message.getPayloadAsString());
			
			log.info("message "+msg);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return profile;
	}
}
