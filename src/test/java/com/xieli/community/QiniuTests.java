package com.xieli.community;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.xieli.community.util.CommunityUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by xieli on 2021/2/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class QiniuTests {

    @Autowired
    private ThreadPoolTaskScheduler taskScheduler;

    @Value("${qiniu.key.access}")
    private String accessKey;

    @Value("${qiniu.key.secret}")
    private String secretKey;

    @Value("${qiniu.bucket.share.name}")
    private String shareBucketName;

    @Value("${qiniu.bucket.header.name}")
    private String headerBucketName;

    private static final Logger logger = LoggerFactory.getLogger(QiniuTests.class);

    @Test
    public void testQiniu() {
        String fileName = "e0b40a96b43c49cbbce82387c566d9eb";
        String path = "d:/work/data/wk-images/" + fileName + ".png";

        Configuration cfg = new Configuration(Region.region0());
        UploadManager manager = new UploadManager(cfg);

        StringMap policy = new StringMap();
        policy.put("returnBody", CommunityUtil.getJSONString(0));
        Auth auth = Auth.create(accessKey, secretKey);
        String uploadToken = auth.uploadToken(shareBucketName, fileName, 3600, policy);
        System.out.println(uploadToken);

        try {
            Response response = manager.put(path, fileName, uploadToken);
            System.out.println(response.toString());
            JSONObject json = JSONObject.parseObject(response.bodyString());
            if (json == null || json.get("code") == null || !json.get("code").toString().equals("0")) {
                System.out.println("false");
            } else {
                System.out.println("success");
            }
        } catch (QiniuException e) {
            System.out.println("上传失败！");
        }
    }

    @Test
    public void testQiniuSimple() {
        String fileName = "e0b40a96b43c49cbbce82387c566d9eb";
        String path = "d:/work/data/wk-images/" + fileName + ".png";

        Configuration cfg = new Configuration(Region.region0());
        UploadManager manager = new UploadManager(cfg);

        Auth auth = Auth.create(accessKey, secretKey);
        String uploadToken = auth.uploadToken(shareBucketName);

        try {
            Response response = manager.put(path, null, uploadToken);
            System.out.println(response.toString());
            JSONObject json = JSONObject.parseObject(response.bodyString());
            if (json == null || json.get("code") == null || !json.get("code").toString().equals("0")) {
                System.out.println("false");
            } else {
                System.out.println("success");
            }
        } catch (QiniuException e) {
            System.out.println("上传失败！");
        }
    }

    @Test
    public void testQiniuSimpler() {
        Configuration cfg = new Configuration(Region.region0());
        UploadManager uploadManager = new UploadManager(cfg);
        String localFilePath = "d:/work/data/wk-images/e0b40a96b43c49cbbce82387c566d9eb.png";
        String key = null;

        Auth auth = Auth.create(accessKey, secretKey);
//        String upToken = auth.uploadToken(shareBucketName);
        String upToken = auth.uploadToken(headerBucketName);

        try {
            Response response = uploadManager.put(localFilePath, key, upToken);
            //解析上传成功的结果
            JSONObject json = JSONObject.parseObject(response.bodyString());
            if (json == null || json.get("code") == null || !json.get("code").toString().equals("0")) {
                System.out.println("false");
            } else {
                System.out.println("true");
            }
        } catch (QiniuException ex) {
            System.out.println("上传失败！");
        }

    }

    @Test
    public void testQiniuSimplest() {
        Configuration cfg = new Configuration(Region.region2());
        UploadManager uploadManager = new UploadManager(cfg);
        String fileName = "975da425d508448fa01a66a9e13edc92";
        String localFilePath = "d:/work/data/wk-images/" + fileName + ".png";

        StringMap policy = new StringMap();
        policy.put("returnBody", CommunityUtil.getJSONString(0));

        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(shareBucketName, fileName, 3600, policy);

        try {
            Response response = uploadManager.put(localFilePath, fileName, upToken);
            //解析上传成功的结果
            JSONObject json = JSONObject.parseObject(response.bodyString());

            if (json == null || json.get("code") == null || !json.get("code").toString().equals("0")) {
                logger.info("false");
            } else {
                logger.info("success");
                logger.info("上传成功！");
            }
        } catch (QiniuException ex) {
            logger.info("上传失败！");
        }

    }

}
