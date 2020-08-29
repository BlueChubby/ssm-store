package itcast.Utils;

import itcast.Pojo.SendResult;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

/*
pom.xml
<dependency>
  <groupId>com.aliyun</groupId>
  <artifactId>aliyun-java-sdk-core</artifactId>
  <version>4.5.0</version>
</dependency>
*/
public class SendSms {
    public static SendResult sendCode(String phone) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4G495kTyXRSNQqFMgmte", "e1EEJKESmXnXsd2tjC8sx12DzzvTb3");
        String phonenumber=phone;
        int httpStatus=0;
        IAcsClient client = new DefaultAcsClient(profile);
        Integer i=(int)((Math.random()*9+1)*100000);
        String str="{\"code\":"+i+"}";
//        String str="{\"code\":111111}";
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phonenumber);
        request.putQueryParameter("SignName", "叮当ABC影视");
        request.putQueryParameter("TemplateCode", "SMS_192542438");
        request.putQueryParameter("TemplateParam",str );
        try {
            CommonResponse response = client.getCommonResponse(request);
            httpStatus = response.getHttpStatus();
            System.out.println(httpStatus);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        SendResult sendResult=new SendResult();
        sendResult.setCode(i);
        sendResult.setStatus(httpStatus);
        return sendResult;
    }
}

