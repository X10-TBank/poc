package com.extend.mule.tcp.util;

import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

import com.extend.mule.tcp.obj.UserProfile;

public class ChangeMsg extends AbstractMessageTransformer{

	private Logger log = LogManager.getLogger(ChangeMsg.class);
	public Object transformMessage(MuleMessage message, String outputEncoding)
			throws TransformerException {
		String msg = "";
		UserProfile profile = new UserProfile();
		try {
			msg = message.getPayloadAsString();
			//System.out.println("hello "+message.getPayloadAsString());
			
			//profile.setZipCode(msg);
			
			if(msg.length() >= 10){
				profile.setUserName(msg.substring(0,5));
				profile.setLastName(msg.substring(5,10));
				profile.setZipCode("");
				profile.setTimeZone("");
			}else{
				throw new Exception("msg not valid");
			}
			
			log.info("message "+msg);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return profile;
	}
}
