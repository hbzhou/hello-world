package com.itsz.java.webservice.cxf;

public class HttpsIgnoreTrustManager implements javax.net.ssl.TrustManager, javax.net.ssl.X509TrustManager {

    @Override
    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
        return null;
    }

    public boolean isServerTrusted(java.security.cert.X509Certificate[] certs) {
        return true;
    }

    public boolean isClientTrusted(java.security.cert.X509Certificate[] certs) {
        return true;
    }

    @Override
    public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
        return;
    }

    @Override
    public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
        return;
    }
}  
