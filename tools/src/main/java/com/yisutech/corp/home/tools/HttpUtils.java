package com.yisutech.corp.home.tools;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.SocketConfig;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.*;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Map;

/**
 * httpClient工具包
 *
 * @author guangzhong.wgz
 */
public class HttpUtils {

    private static CloseableHttpClient defaultClient = null;

    private static Logger LOG = LoggerFactory.getLogger(HttpUtils.class);

    static {
        SocketConfig sctConf = SocketConfig.custom().setSoKeepAlive(true).setSoTimeout(3000).build();
        RequestConfig reqConf = RequestConfig.custom().setConnectionRequestTimeout(2000).setSocketTimeout(3000).build();

        HostnameVerifier hv = new HostnameVerifier() {
            public boolean verify(String urlHostName, SSLSession session) {
                System.out.println("Warning: URL Host: " + urlHostName + " vs. "
                        + session.getPeerHost());
                return true;
            }
        };

        try {
            defaultClient = HttpClientBuilder.create()
                    .setMaxConnTotal(500)
                    .setMaxConnPerRoute(50)
                    .setDefaultSocketConfig(sctConf).setDefaultRequestConfig(reqConf)
                    .setSSLContext(createIgnoreVerifySSL())
                    .setSSLHostnameVerifier(hv)
                    .build();
        } catch (Throwable e) {

        }
    }

    /**
     * httpPost请求
     *
     * @param url     请求url
     * @param charset 返回内容编码
     * @return
     */
    public static String postReq(String url, Map<String, Object> params, Charset charset) {
        CloseableHttpResponse response = null;
        try {
            String mineType = "text/plain";
            ContentType contentType = ContentType.create(mineType, charset);

            HttpPost httpPost = new HttpPost(url);
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();

            params.forEach((key, value) -> {
                if (value instanceof String) {
                    builder.addTextBody(key, value.toString(), contentType);

                } else if (value instanceof Integer || value instanceof Long) {
                    builder.addTextBody(key, String.valueOf(value), contentType);

                } else if (value instanceof File) {
                    builder.addBinaryBody(key, (File) value);

                } else if (value instanceof InputStream) {
                    builder.addBinaryBody(key, (InputStream) value);

                } else if (value instanceof byte[]) {
                    builder.addBinaryBody(key, (byte[]) value);

                } else {
                    throw new RuntimeException(value.getClass().getName() + " is not support");

                }
            });
            response = defaultClient.execute(httpPost);
            return EntityUtils.toString(response.getEntity(), charset);

        } catch (Throwable e) {
            LOG.error("postReq_error", e);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (Throwable e) {
                }
            }
        }
        return "";
    }

    /**
     * httpPost请求
     *
     * @param url     请求url
     * @param charset 返回内容编码
     * @return
     */
    public static String postReq(String url, String body, ContentType contentType, Charset charset) {
        CloseableHttpResponse response = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(new StringEntity(body, contentType));

            response = defaultClient.execute(httpPost);
            return EntityUtils.toString(response.getEntity(), charset);

        } catch (Throwable e) {
            LOG.error("postReq_error", e);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (Throwable e) {
                }
            }
        }
        return "";
    }

    /**
     * httpGet请求
     *
     * @param url     请求url
     * @param charset 返回内容编码
     * @return
     */
    public static String getReq(String url, Charset charset) {
        CloseableHttpResponse response = null;
        try {
            response = defaultClient.execute(new HttpGet(url));
            return EntityUtils.toString(response.getEntity(), charset);

        } catch (Throwable e) {
            LOG.error("getReq_error", e);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (Throwable e) {
                }
            }
        }
        return "";
    }

    /**
     * 绕过验证
     *
     * @return
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    static SSLContext createIgnoreVerifySSL() throws NoSuchAlgorithmException, KeyManagementException {

        SSLContext sc = SSLContext.getInstance("SSLv3");

        // 实现一个X509TrustManager接口，用于绕过验证，不用修改里面的方法
        X509TrustManager trustManager = new X509TrustManager() {
            @Override
            public void checkClientTrusted(
                    java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
                    String paramString) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(
                    java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
                    String paramString) throws CertificateException {
            }

            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };

        sc.init(null, new TrustManager[]{trustManager}, null);
        return sc;
    }
}
