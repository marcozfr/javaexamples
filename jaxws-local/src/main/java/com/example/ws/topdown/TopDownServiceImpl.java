package com.example.ws.topdown;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.util.UUID;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.servlet.ServletContext;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Holder;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.handler.MessageContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.ws.process.server.handler.LogHeadersProtocolHandler;

@WebService(name = "TopDownService", targetNamespace = "http://topdown.ws.example.com/TopDownService/", endpointInterface="com.example.ws.topdown.TopDownService")
public class TopDownServiceImpl implements TopDownService {
	
    private static Logger logger = LoggerFactory.getLogger(LogHeadersProtocolHandler.class);
    
	@Resource
	private WebServiceContext webServiceContext;
	
	@Override
	public DataHandler downloadImage(String in) {
		ServletContext servletContext = (ServletContext) webServiceContext.getMessageContext().get(MessageContext.SERVLET_CONTEXT);
		String storageFolder = servletContext.getInitParameter("fileStorage");
		
		File f = new File(storageFolder+ in);
		if(f.exists()){
			DataHandler dataHandler = new DataHandler(new FileDataSource(f));
			DownloadImageResponse imgresp = new DownloadImageResponse();
			imgresp.setOut(dataHandler);

			return dataHandler;
			
		}else{
			throw new WebServiceException("file " + in + " does not exist");
		}
	}
	
	/**
	@Override
	public void downloadImage(DownloadImage parameters, Holder<DownloadImageStatusResponse> status,
			Holder<DownloadImageResponse> response) {
		ServletContext servletContext = (ServletContext) webServiceContext.getMessageContext().get(MessageContext.SERVLET_CONTEXT);
		String storageFolder = servletContext.getInitParameter("fileStorage");
		
		File f = new File(storageFolder+ parameters.getIn());
		if(f.exists()){
			DataHandler dataHandler = new DataHandler(new FileDataSource(f));
			DownloadImageResponse imgresp = new DownloadImageResponse();
			imgresp.setOut(dataHandler);

//			BufferedImage buffImg = new BufferedImage(240, 240, BufferedImage.TYPE_INT_ARGB);
//			try { 
//			    buffImg = ImageIO.read(f ); 
//			} 
//			catch (IOException e) { }
//			
//			imgresp.setOut(buffImg);

			response = new Holder<DownloadImageResponse>(imgresp);
			DownloadImageStatusResponse resp =  new DownloadImageStatusResponse();
			resp.setOut("retrieving " + parameters.getIn());
			status = new Holder<DownloadImageStatusResponse>(resp);
		}else{
			throw new WebServiceException("file " + parameters.getIn() + " does not exist");
		}
	}
	
	*/
	
	@Override
	public RegisterUserResponse registerUser(BasicInfo basicInfo) {
		RegisterUserResponse r = new RegisterUserResponse();
		r.setOut("Registered user: " + basicInfo.getFirstName() + " " + basicInfo.getLastName());

		ServletContext servletContext = (ServletContext) webServiceContext.getMessageContext().get(MessageContext.SERVLET_CONTEXT);
		String storageFolder = servletContext.getInitParameter("fileStorage");
		
		try {
			String cType = basicInfo.getDocumentation().getContentType();
			String cats[] = cType.split("name=");
			String title = null;
			if(cats.length < 2){
				throw new WebServiceException("File name could not be parsed,e.g. (image/jpeg; name=example.jpg). Check if MTOM-Client is enabled"); 
				//title = "unknown " + basicInfo.getDocumentation().toString();
			}else{
				title = cats[1];
			}
			InputStream initialStream = basicInfo.getDocumentation().getInputStream();
			OutputStream outputStream = new FileOutputStream(new File(storageFolder + title));
			byte[] buffer = new byte[1600];
			int Read = 0;
			while((Read =initialStream.read(buffer, 0, buffer.length)) != -1){
				outputStream.write(buffer, 0 , Read);
			}
			outputStream.flush();
			outputStream.close();
			
		} catch (IOException e) {
			throw new WebServiceException(e);
		}
		
		UUID uuidUser = UUID.randomUUID();
		String credentials = "<credentials>" + uuidUser.toString() + "</credentials>";
		r.setCredentials(new StreamSource(new StringReader(credentials)));
		
		return r;
	}

	private static BufferedImage resizeImage(BufferedImage originalImage, int width, int height){
		BufferedImage resizedImage = new BufferedImage(width, height, originalImage.getType());
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, width, height, null);
		g.dispose();

		return resizedImage;
	}
	
	@Override
	public void resizeImage(ResizeImageRequest parameters, Image file,Holder<ResizeImageResponse> response, Holder<Image> responseImg) {
		response.value = new ResizeImageResponse(){
			{
				setStatus("OK");
			}
		};
		
		Image img = TopDownServiceImpl.resizeImage((BufferedImage)file, parameters.getTargetWidth(), parameters.getTargetHeight());
		responseImg.value = img;
		
	}
	
	@Override
	public LookUpUserResponse lookUpUser(LookUpUser parameters, TransactionHeader transactionHeader)
	        throws LookUpUserFault_Exception {
	    return new LookUpUserResponse(){
	        {
	            setOut("Ok Response w transaction id: " + transactionHeader.getTransactionId());
	        }
	    };
	}
	
	@Override
	public void evaluateUser(String in) {
	   logger.info("Will evaluate user " + in);
	}

}
