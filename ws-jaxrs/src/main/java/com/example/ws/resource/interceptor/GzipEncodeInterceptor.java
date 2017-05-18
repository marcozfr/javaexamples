package com.example.ws.resource.interceptor;

import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;

@Provider
public class GzipEncodeInterceptor implements WriterInterceptor {

	@Override
	public void aroundWriteTo(WriterInterceptorContext context) throws IOException, WebApplicationException {
		GZIPOutputStream os = new GZIPOutputStream(context.getOutputStream());
		context.getHeaders().putSingle("Content-Encoding", "gzip");
		context.setOutputStream(os);
		context.proceed();
		return;
	}

}
