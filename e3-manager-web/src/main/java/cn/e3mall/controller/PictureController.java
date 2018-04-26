package cn.e3mall.controller;

import cn.e3mall.common.utils.FastDFSClient;
import cn.e3mall.common.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HsY
 * @create 2018-04-26 22:32
 * @desc 图片上传controller
 **/
@Controller
public class PictureController {

    @Value("${image.server.url}")
    private String IMAGE_SERVER_REL;

    //produces = "text/plain;charset=utf-8"
    @RequestMapping(value = "/pic/upload",produces = MediaType.APPLICATION_JSON_UTF8_VALUE+";charset=utf-8")
    @ResponseBody
    public String uploadPicture(MultipartFile uploadFile) {
        try {
            //1)接收上传的图片
            //2)取文件原始名称
            String originalFilename = uploadFile.getOriginalFilename();
            //3）截取文件扩展名
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            //System.out.println(extName);
            //4）创建一个FastDFSClient对象
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:config/client.conf");

            //5)把文件上传到图片服务器
            String url = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
            //6)把url拼接成一个完整的url
            url = IMAGE_SERVER_REL + url;
            //7）创建一个Map对象，并设置属性
            Map result = new HashMap();
            result.put("error", 0);
            result.put("url", url);
            //8）返回Map对象
            return JsonUtils.objectToJson(result);
        } catch (Exception e) {
            Map result = new HashMap();
            result.put("error", 1);
            result.put("message", "文件上传失败！");
            return JsonUtils.objectToJson(result);
        }
    }
}
