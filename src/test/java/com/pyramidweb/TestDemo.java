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
        /*WriteDZIServiceImpl writeDZIService = new WriteDZIServiceImpl();
        String imagePath = "E:\\git\\high-image-view\\example\\images\\flower.jpg".replace("\\", "/"),
                outOath = "/E:/data/imageDZI" ;
        HashMap<String,Object> tileSource = new HashMap<String,Object>();
        tileSource.put("tileSize",254);
        tileSource.put("overlap",1);
        tileSource.put("tileFormat","png");
        tileSource.put("descriptorExt","dzi");
//        writeDZIService.writeDZIByTileSource(imagePath,tileSource,outOath);
        URL url = new URL("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2075649881,780283213&fm=26&gp=0.jpg");
        BufferedImage image = ImageIO.read(url);
        File file = new File("downloaded.jpg");
        String format = FilenameUtils.getExtension(url.getPath());*/
        HashMap<String,Object> tileSource = new HashMap<String,Object>();
        tileSource.put("tileSize",254);
        tileSource.put("overlap",1);
        tileSource.put("tileFormat","png");
        tileSource.put("descriptorExt","dzi");
        this.getClass().getResource("classpath:/");
        File file = new File(this.getClass().getResource("/static/").getFile());
    }
}
