
package com.example.ws.process;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.example.ws.process package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RunSecureResponse_QNAME = new QName("http://process.ws.example.com", "runSecureResponse");
    private final static QName _RunResponse_QNAME = new QName("http://process.ws.example.com", "runResponse");
    private final static QName _DownloadWithswaRef_QNAME = new QName("http://process.ws.example.com", "downloadWithswaRef");
    private final static QName _Run_QNAME = new QName("http://process.ws.example.com", "run");
    private final static QName _DownloadWithswaRefResponse_QNAME = new QName("http://process.ws.example.com", "downloadWithswaRefResponse");
    private final static QName _RunUploadResponse_QNAME = new QName("http://process.ws.example.com", "runUploadResponse");
    private final static QName _FileRef_QNAME = new QName("http://process.ws.example.com", "fileRef");
    private final static QName _RunLong_QNAME = new QName("http://process.ws.example.com", "runLong");
    private final static QName _DownloadResponse_QNAME = new QName("http://process.ws.example.com", "downloadResponse");
    private final static QName _Arg0_QNAME = new QName("http://process.ws.example.com", "arg0");
    private final static QName _RunUpload_QNAME = new QName("http://process.ws.example.com", "runUpload");
    private final static QName _ProcessException_QNAME = new QName("http://process.ws.example.com", "ProcessException");
    private final static QName _Download_QNAME = new QName("http://process.ws.example.com", "download");
    private final static QName _File_QNAME = new QName("http://process.ws.example.com", "file");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.ws.process
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DownloadWithswaRefResponse }
     * 
     */
    public DownloadWithswaRefResponse createDownloadWithswaRefResponse() {
        return new DownloadWithswaRefResponse();
    }

    /**
     * Create an instance of {@link DownloadWithswaRef }
     * 
     */
    public DownloadWithswaRef createDownloadWithswaRef() {
        return new DownloadWithswaRef();
    }

    /**
     * Create an instance of {@link Run }
     * 
     */
    public Run createRun() {
        return new Run();
    }

    /**
     * Create an instance of {@link RunResponse }
     * 
     */
    public RunResponse createRunResponse() {
        return new RunResponse();
    }

    /**
     * Create an instance of {@link ProcessException }
     * 
     */
    public ProcessException createProcessException() {
        return new ProcessException();
    }

    /**
     * Create an instance of {@link Download }
     * 
     */
    public Download createDownload() {
        return new Download();
    }

    /**
     * Create an instance of {@link File }
     * 
     */
    public File createFile() {
        return new File();
    }

    /**
     * Create an instance of {@link DownloadResponse }
     * 
     */
    public DownloadResponse createDownloadResponse() {
        return new DownloadResponse();
    }

    /**
     * Create an instance of {@link RunLong }
     * 
     */
    public RunLong createRunLong() {
        return new RunLong();
    }

    /**
     * Create an instance of {@link FileRef }
     * 
     */
    public FileRef createFileRef() {
        return new FileRef();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://process.ws.example.com", name = "runSecureResponse")
    public JAXBElement<String> createRunSecureResponse(String value) {
        return new JAXBElement<String>(_RunSecureResponse_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RunResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://process.ws.example.com", name = "runResponse")
    public JAXBElement<RunResponse> createRunResponse(RunResponse value) {
        return new JAXBElement<RunResponse>(_RunResponse_QNAME, RunResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DownloadWithswaRef }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://process.ws.example.com", name = "downloadWithswaRef")
    public JAXBElement<DownloadWithswaRef> createDownloadWithswaRef(DownloadWithswaRef value) {
        return new JAXBElement<DownloadWithswaRef>(_DownloadWithswaRef_QNAME, DownloadWithswaRef.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Run }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://process.ws.example.com", name = "run")
    public JAXBElement<Run> createRun(Run value) {
        return new JAXBElement<Run>(_Run_QNAME, Run.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DownloadWithswaRefResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://process.ws.example.com", name = "downloadWithswaRefResponse")
    public JAXBElement<DownloadWithswaRefResponse> createDownloadWithswaRefResponse(DownloadWithswaRefResponse value) {
        return new JAXBElement<DownloadWithswaRefResponse>(_DownloadWithswaRefResponse_QNAME, DownloadWithswaRefResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://process.ws.example.com", name = "runUploadResponse")
    public JAXBElement<String> createRunUploadResponse(String value) {
        return new JAXBElement<String>(_RunUploadResponse_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FileRef }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://process.ws.example.com", name = "fileRef")
    public JAXBElement<FileRef> createFileRef(FileRef value) {
        return new JAXBElement<FileRef>(_FileRef_QNAME, FileRef.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RunLong }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://process.ws.example.com", name = "runLong")
    public JAXBElement<RunLong> createRunLong(RunLong value) {
        return new JAXBElement<RunLong>(_RunLong_QNAME, RunLong.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DownloadResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://process.ws.example.com", name = "downloadResponse")
    public JAXBElement<DownloadResponse> createDownloadResponse(DownloadResponse value) {
        return new JAXBElement<DownloadResponse>(_DownloadResponse_QNAME, DownloadResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://process.ws.example.com", name = "arg0")
    public JAXBElement<String> createArg0(String value) {
        return new JAXBElement<String>(_Arg0_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link File }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://process.ws.example.com", name = "runUpload")
    public JAXBElement<File> createRunUpload(File value) {
        return new JAXBElement<File>(_RunUpload_QNAME, File.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcessException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://process.ws.example.com", name = "ProcessException")
    public JAXBElement<ProcessException> createProcessException(ProcessException value) {
        return new JAXBElement<ProcessException>(_ProcessException_QNAME, ProcessException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Download }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://process.ws.example.com", name = "download")
    public JAXBElement<Download> createDownload(Download value) {
        return new JAXBElement<Download>(_Download_QNAME, Download.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link File }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://process.ws.example.com", name = "file")
    public JAXBElement<File> createFile(File value) {
        return new JAXBElement<File>(_File_QNAME, File.class, null, value);
    }

}
