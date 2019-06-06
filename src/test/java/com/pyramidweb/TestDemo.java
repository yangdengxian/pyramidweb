package com.pyramidweb;

import com.pyramidweb.util.ImageIOUtil;
import org.junit.Test;

import java.awt.image.BufferedImage;
import java.net.URL;

public class TestDemo {
    @Test
    public void writeDZIByImagePathTest() {
        /*WriteDZIServiceImpl writeDZIService = new WriteDZIServiceImpl();
        String imagePath = "E:\\git\\high-image-view\\example\\images\\flower.jpg".replace("\\", "/"),
                outOath = "/E:/data/imageDZI" ;
        writeDZIService.writeDZIByImagePath(imagePath,outOath);*/
//        this.getClass().getResource("/static/").getPath();
    }

    @Test
    public void writeDZIByTileSourceTest() throws Exception{
        URL url = new URL("http://highresolution.photography/images/washer-main.jpg");
        BufferedImage img = ImageIOUtil.read(url);
        System.out.println(img);
    }
}
