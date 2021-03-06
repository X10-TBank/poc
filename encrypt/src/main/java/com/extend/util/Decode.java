package com.extend.util;

import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;
import org.mule.transformer.codec.Base64Decoder;
import org.mule.transformer.codec.Base64Encoder;

public class Decode extends AbstractMessageTransformer{
	
	private Logger log = LogManager.getLogger(Decode.class);
	public Object transformMessage(MuleMessage message, String outputEncoding)
			throws TransformerException {
		Base64Decoder de = new Base64Decoder();
		try {
			//String encode = (String) en.transform("hello".getBytes(), "utf8");
			//System.out.println("encode  "+encode);
			
			Map<String, Object> map = (Map<String, Object>) message.getPayload();
			String encode = (String) map.get("OrderingAcct");
			byte[] decode = (byte[]) de.transform(encode.getBytes(), "utf8");
			map.put("OrderingAcct",new String(decode));
			
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

}
