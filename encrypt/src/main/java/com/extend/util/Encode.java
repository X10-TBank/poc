package com.extend.util;

import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;
import org.mule.transformer.codec.Base64Decoder;
import org.mule.transformer.codec.Base64Encoder;

public class Encode extends AbstractMessageTransformer{
	
	private Logger log = LogManager.getLogger(Encode.class);
	public Object transformMessage(MuleMessage message, String outputEncoding)
			throws TransformerException {
		Base64Encoder en = new Base64Encoder();
		Map<String, Object> map = (Map<String, Object>) message.getPayload();
		
		String encode = new String((String) en.transform(map.get("OrderingAcct"), "utf8"));
		
		map.put("OrderingAcct", encode);
			
		return message;
	}

}
