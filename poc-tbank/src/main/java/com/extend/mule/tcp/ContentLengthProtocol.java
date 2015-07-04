package com.extend.mule.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.mule.api.annotations.expressions.Lookup;
import org.mule.api.endpoint.ImmutableEndpoint;
import org.mule.transport.tcp.protocols.AbstractByteProtocol;

public class ContentLengthProtocol extends AbstractByteProtocol {

	@Lookup("atm-inbound")
	private ImmutableEndpoint inboundEndpoint;

	public ContentLengthProtocol() {
		super(true);
	}

	public Object read(InputStream is) throws IOException {
		return getStringFromInputStream(is);
	}

	private static String getStringFromInputStream(InputStream is) {

		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return sb.toString();

	}

}
