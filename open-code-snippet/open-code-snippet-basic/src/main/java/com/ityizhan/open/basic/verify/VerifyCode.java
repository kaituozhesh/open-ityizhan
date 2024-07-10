package com.ityizhan.open.basic.verify;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.captcha.ShearCaptcha;
import cn.hutool.core.util.RandomUtil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static cn.hutool.core.img.ImgUtil.toBufferedImage;

/**
 * @Description:
 * @ClassName: VerifyCode
 * @Auther: lin
 * @Date: 2024/7/10 13:31
 * @Version: 1.0
 */
public class VerifyCode {

    //获取扭曲干扰的验证码
    public void getShearCaptcha() {

        //定义图形验证码的长、宽、验证码字符数、干扰线宽度
        ShearCaptcha shearCaptcha = CaptchaUtil.createShearCaptcha(150, 50, 4, 3);
        //设置背景颜色
        shearCaptcha.setBackground(new Color(249, 251, 220));
        //生成四位验证码
        String code = RandomUtil.randomNumbers(4);
        //生成验证码图片
        Image image = shearCaptcha.createImage(code);
        responseCode(code, image);
    }

    //获取线条干扰的验证码
    public static void getLineCaptcha() {

        //定义图形验证码的长、宽、验证码位数、干扰线数量
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(150, 50, 4, 80);
        //设置背景颜色
        lineCaptcha.setBackground(new Color(249, 251, 220));
        //生成四位验证码
        String code = "llcc0911hh";
        Image image = lineCaptcha.createImage(code);
        responseCode(code, image);
    }

    //获取圆圈干扰的验证码
    public static void getCircleCaptcha() {

        //定义图形验证码的长、宽、验证码位数、干扰圈圈数量
        CircleCaptcha circleCaptcha = CaptchaUtil.createCircleCaptcha(150, 50, 4, 30);
        //设置背景颜色
        circleCaptcha.setBackground(new Color(249, 251, 220));
        //生成四位验证码
        String code = "llcc0911hh";
        Image image = circleCaptcha.createImage(code);
        responseCode(code, image);
    }

    private static void responseCode(String code, Image image) {
        try {
            BufferedImage bufferedImage = toBufferedImage(image);
            // 写入图片数据到ByteArrayOutputStream
            ImageIO.write(bufferedImage, "jpeg", new BufferedOutputStream(Files.newOutputStream(Paths.get("output.jpeg"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        getLineCaptcha();
    }
}
