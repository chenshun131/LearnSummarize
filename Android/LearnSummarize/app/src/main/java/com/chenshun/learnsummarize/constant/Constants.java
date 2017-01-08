package com.chenshun.learnsummarize.constant;

/**
 * User: chenshun <p />
 * Time: 16/10/13 16:06  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class Constants
{
    /** whether in debug model */
    public static final boolean IS_DEBUG = true;
    public static final String CACHE_IMAGELOADER_PATH = "LearnSummarize/imageLoaderCache";
    public static final int BACK_TIME = 2000;// exit App if click back button twice in 2 second

    public static final String BASE_IP = "192.168.0.11";
    public static final String BASE_PATH = "http://" + BASE_IP + ":8080/LearnSummarize";

    /******************************** 【Network Access Path】 *******************************************/
    public static final String GET_VERSIONINFO = BASE_PATH + "/getVersionInfo";// 获取 App 信息
    public static final String CAPTCHA = BASE_PATH + "/captcha";// 验证码
    public static final String LOGIN = BASE_PATH + "/login";// 登录

    /******************************** 【Network Status Code】 *******************************************/
    public static final String STATUS_CODE_OK = "0";// access server success
    public static final String STATUS_CODE_ACCESS_TIME_NOT = "-999";// long time not access server and need relogin

    /******************************** 【Network Security】 *******************************************/
    public static final String CER = "-----BEGIN CERTIFICATE-----\n" +
            "MIIDazCCAlOgAwIBAgIEHl0vmjANBgkqhkiG9w0BAQsFADBmMQswCQYDVQQGEwJ6aDELMAkGA1UE\n" +
            "CBMCZ2QxCzAJBgNVBAcTAmd6MRAwDgYDVQQKEwdkZXZlbG9wMREwDwYDVQQLEwhjaGVuc2h1bjEY\n" +
            "MBYGA1UEAxMPY2hlbnNodW4xMzEuY29tMB4XDTE2MTEyNDE0MDQ1MVoXDTE3MDIyMjE0MDQ1MVow\n" +
            "ZjELMAkGA1UEBhMCemgxCzAJBgNVBAgTAmdkMQswCQYDVQQHEwJnejEQMA4GA1UEChMHZGV2ZWxv\n" +
            "cDERMA8GA1UECxMIY2hlbnNodW4xGDAWBgNVBAMTD2NoZW5zaHVuMTMxLmNvbTCCASIwDQYJKoZI\n" +
            "hvcNAQEBBQADggEPADCCAQoCggEBAI+XnZoIYaWfNb/j0PffE8Z7dKnBau7Ty7gonDxJYaUlRumi\n" +
            "G8hA6R7LfEht9e5NT6YZsWiIVNSexUHArn4xfx/iVfr+1zvwNffXcFYOxnHLb1aAM99cq1N6lGMs\n" +
            "frnb4BeI+KxSs7LbbFipoB6OD50xacpUbnfJqpqnGYxf6NdnN679pQe46s4u+BqEOTsSpZGhNsEl\n" +
            "bN6gH2d+o0EzFo2S5pxfs15OwnYkRISg6YnOgasGdpOVnsaPl5aJ9vnRE7MkXVVm6xmHu5u3S5AS\n" +
            "zw6dxw/l2FqEuIYgzoaTYX7N2CCWLulPSxXSvYUEDLf0eollAlaowd7CNjHrkoZyw/ECAwEAAaMh\n" +
            "MB8wHQYDVR0OBBYEFGWb8VqmB52MhN1c2pzc42NoXSI2MA0GCSqGSIb3DQEBCwUAA4IBAQA51AKX\n" +
            "rtvwqJM2wrqCWYyE7IwexScZgfzyUQBQaVFQbGWZBGAjBr9LL8Gpfv1EUyfROPWsd3W1EQFcxB5Y\n" +
            "72H6brhHioAGm8NHTmGJbqp5UqDd+ikNIwgrGI82TjKSAaC3NrGZUbm5wNO0AF8ojpvEC5wNzbxf\n" +
            "NWM8qdGmnmyYi8nnqb67aluDzEgvgq5NNMzBWQjT1dGOlVMwbF8MX0hiJHrcubCGOBLV9+0KVeAR\n" +
            "Twdn33UqRlerfar7mECPIcCA3QIH6M165wY8w+7c23dwuS49NClpvBqAE3XQE659SP+poRvVUOu/\n" +
            "GAUTxTtRMaXLZkgZr0sUwCWiTRc1tlWw\n" +
            "-----END CERTIFICATE-----";
}
