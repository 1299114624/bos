package com.archforce.bos.identity.web.controller;

import com.alibaba.fastjson.JSON;
import com.archforce.arc.common.log.LogUtils;
import com.archforce.arc.common.utils.ResBody;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 不需要登录的校验接口
 */
@RestController
public class ValidateCodeController {

    @Autowired
    private Producer defaultKaptcha;

    @Value("${identity.login.validateCode:#{''}}")
    private String validateSwitch;

    /**
     * 获取当前的登录方式
     */
    @RequestMapping(path = "/getParam", method = RequestMethod.GET)
    public ResBody getParam() {
        Map<String, String> map = new HashMap<>();
        map.put("validateSwitch", validateSwitch);
        return ResBody.ok(JSON.toJSON(map));
    }

    @GetMapping("/img/getValidateCode")
    public void getValidateCode(HttpServletRequest req, HttpServletResponse response) {
        byte[] kaptchaBytes = null;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        String kaptchaText = defaultKaptcha.createText();
        BufferedImage bufferedImage = defaultKaptcha.createImage(kaptchaText);
        try {
            ImageIO.write(bufferedImage, "jpg", outputStream);
        } catch (IOException e) {
            LogUtils.error(getClass(), "Identity", "生成验证码异常");
            return;
        }
        LogUtils.info(getClass(), SecurityUtils.getSubject().getSession().getId().toString(), "");
        SecurityUtils.getSubject().getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, kaptchaText);
        SecurityUtils.getSubject().getSession().setAttribute(Constants.KAPTCHA_SESSION_DATE, new Date());
        kaptchaBytes = outputStream.toByteArray();
        Map<String, Object> res = new HashMap<>();
        res.put("code", 0);
        res.put("body", kaptchaBytes);
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.addHeader("Pragma", "no-cache");
//        response.setContentType("image/jpeg");
        ServletOutputStream servletOutputStream = null;
        try {
            servletOutputStream = response.getOutputStream();
            servletOutputStream.write(JSON.toJSONString(res).getBytes());
            servletOutputStream.flush();
            servletOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
