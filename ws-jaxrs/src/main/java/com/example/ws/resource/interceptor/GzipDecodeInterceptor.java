package com.example.ws.resource.interceptor;

import java.io.IOException;
import java.util.zip.GZIPInputStream;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;

@Provider
public class GzipDecodeInterceptor implements ReaderInterceptor {

	@Override
	public Object aroundReadFrom(ReaderInterceptorContext context) throws IOException, WebApplicationException {
		String encoding = context.getHeaders().getFirst("Content-Encoding");
		if (!"gzip".equalsIgnoreCase(encoding)) {
			return context.proceed();
		}
		GZIPInputStream is = new GZIPInputStream(context.getInputStream());
		context.setInputStream(is);
		return context.proceed();
	}

}
