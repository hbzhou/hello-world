package com.itsz.java.webservice.cxf;

import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

import javax.net.ssl.TrustManager;

public class WebServiceFactory {
	
	public static <T> T createWebService(Class<T> clazz, String wsdl, int readTimeout, int connectionTimeout) {
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        // 设置代理地址
        jaxWsProxyFactoryBean.setAddress(wsdl);
        // 设置接口类型
        jaxWsProxyFactoryBean.setServiceClass(clazz);
        // 创建一个代理接口实现
        T webService = (T) jaxWsProxyFactoryBean.create();

        Client client = ClientProxy.getClient(webService);
        if (client != null) {
            HTTPConduit conduit = (HTTPConduit) client.getConduit();
            TLSClientParameters tlscp = conduit.getTlsClientParameters();
            if (tlscp == null) {
                tlscp = new TLSClientParameters();
                tlscp.setSecureSocketProtocol("TLSv1");
                tlscp.setDisableCNCheck(true);
            }
            try {
                tlscp.setTrustManagers(trustAllHttpsCertificates());
            } catch (Exception e) {
                e.printStackTrace();
            }
            HTTPClientPolicy policy = new HTTPClientPolicy();
            policy.setConnectionTimeout(connectionTimeout);
            policy.setReceiveTimeout(readTimeout);
            conduit.setClient(policy);
            conduit.setTlsClientParameters(tlscp);
        }
        return webService;
    }
	
	 private static TrustManager[] trustAllHttpsCertificates() throws Exception {  
	        TrustManager[] trustAllCerts = new TrustManager[1];
	        TrustManager tm = new HttpsIgnoreTrustManager();
	        trustAllCerts[0] = tm;  
	        javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext  
	                .getInstance("TLSv1");  
	        sc.init(null, trustAllCerts, null);  
	        javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sc  
	                .getSocketFactory());
			return trustAllCerts;  
	    }

}
