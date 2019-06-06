package com.pyramidweb;

import com.pyramidweb.write.service.impl.WriteDZIServiceImpl;
import gov.nist.isg.pyramidio.BufferedImageReader;
import gov.nist.isg.pyramidio.PartialImageReader;
import org.apache.commons.io.FilenameUtils;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.HashMap;

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
        BufferedImage img = ImageIO.read(url);
        System.out.println(img);
    }
}
