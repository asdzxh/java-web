package top.zxh.web.util;



import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class DownLoadUtil {
    public  static  String getFileName(String agent,String filename) throws UnsupportedEncodingException {
        if (agent.contains("MSIE")){
            filename= URLEncoder.encode(filename,"utf-8");
            filename=filename.replace("+"," ");

        }else  if (agent.contains("Firefox")){
            Base64 base64 = new Base64();
            filename="=?utf-8?B?"+base64.encode(filename.getBytes("utf-8")) + "?=";
        }else {
            filename=URLEncoder.encode(filename,"utf-8");
        }
        return filename;
    }
}
