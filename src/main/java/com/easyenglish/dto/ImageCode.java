package com.easyenglish.dto;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @Auther: Way Leung wayleung13@163.com
 * @Date: 9/21/2018 15:08
 * @Description:
 */
public class ImageCode {

    /**
     * 图片 展示用
     */
    private BufferedImage image;
    /**
     * 随机数
     */
    private String code;
    /**
     * 过期时间
     */
    private LocalDateTime localDateTime;

    public ImageCode(BufferedImage image, String code, int second) {
        this.image = image;
        this.code = code;
        // 多少秒后
        this.localDateTime = LocalDateTime.now().plusSeconds(second);
    }

    public ImageCode(BufferedImage image, String code, LocalDateTime localDateTime) {
        this.image = image;
        this.code = code;
        this.localDateTime = localDateTime;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}


