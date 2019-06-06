package com.pyramidweb.write.service.impl;


import java.awt.image.BufferedImage;
import java.io.*;

import com.pyramidweb.util.ImageIOUtil;
import com.pyramidweb.write.service.WriteDZIService;
import com.pyramidweb.util.WebFilesArchiverFactory;
import gov.nist.isg.pyramidio.BufferedImageReader;
import gov.nist.isg.pyramidio.PartialImageReader;
import gov.nist.isg.pyramidio.ScalablePyramidBuilder;
import gov.nist.isg.archiver.*;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * 生成DZI实现
 * @author ydx
 * @date 2019-05-30
 * @version 1.0.0
 */
@Service
public class WriteDZIServiceImpl implements WriteDZIService {
    @Value("${tileSize}")
    int tileSize;
    @Value("${overlap}")
    int overlap;
    @Value("${tileFormat}")
    String tileFormat;
    @Value("${descriptorExt}")
    String descriptorExt;

    /**
     * 根据目标图片路径，默认参数生成Deep Zoom Images
     * @param imagePath 目标图片路径
     * @param outpath 输出路径
     * @return 返回切片对象
     */
    public Map<String,Object> writeDZIByImagePath(String imagePath, String outpath) {
        /*//输出文件
        FilesArchiver archiver = null;
        //输入文件
        File imageFile = null;
        //输出文件夹名称
        String inputFileBaseName = null;

        ScalablePyramidBuilder spb = new ScalablePyramidBuilder(254, 1, "jpg", "dzi");

        try {
            imageFile = new File(imagePath);
            archiver = FilesArchiverFactory
                    .createFromURI(outpath);
            inputFileBaseName = FilenameUtils.getBaseName(
                    imageFile.getName());
            PartialImageReader pir = new BufferedImageReader(imageFile);
            spb.buildPyramid(pir, inputFileBaseName, archiver, 8);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        return null;

    }

    /**
     * 根据目标图片路径和参数生成Deep Zoom Images
     * @param imagePath 目标图片路径
     * @param tileSource DZI格式参数
     * @param outpath 输出路径
     * @return 返回切片对象
     */
    public Map<String,Object> writeDZIByTileSource(String imagePath, HashMap<String, Object> tileSource, String outpath) {
        //输入文件
        File imageFile = null;
        //输出文件
        FilesArchiver archiver = null;
        //输出文件夹名称
        String inputFileBaseName = null;
        //结果对象
        Map resultMap = new HashMap<String,Object>();

        ScalablePyramidBuilder spb = getPyramidBuilder(getTileSource(tileSource));

        try {
            outpath = outpath != null
                    ? outpath
                    : this.getClass().getResource("/static/fileserver").getPath();

            imageFile = new File(imagePath);
            archiver = WebFilesArchiverFactory
                    .createFromURI(outpath);
            inputFileBaseName = FilenameUtils.getBaseName(
                    imageFile.getName());

            URL url = new URL(imagePath);
//            BufferedImage img = ImageIOUtil.read(url);
            BufferedImage img = ImageIO.read(url);
            PartialImageReader pir = new BufferedImageReader(img);
            spb.buildPyramid(pir, inputFileBaseName, archiver, 8);

            //输出结果
            resultMap.put("tilesPath", String.join("/",inputFileBaseName + ".dzi"));
            resultMap.put("sourceImageName", inputFileBaseName);
            resultMap.put("tileSource",getTileSource(tileSource));
            return resultMap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultMap;
    }

    /**
     * 获取金字塔实例
     * @param tileSource
     * @return
     */
    private ScalablePyramidBuilder getPyramidBuilder(HashMap<String, Object> tileSource) {
        if (null != tileSource) {
            tileSize = tileSource.get("tileSize") != null ? (Integer) tileSource.get("tileSize") : 254;
            overlap = tileSource.get("overlap") != null ? (Integer) tileSource.get("overlap") : 1;
            tileFormat = tileSource.get("tileFormat") != null ? (String) tileSource.get("tileFormat") : "jpg";
            descriptorExt = tileSource.get("descriptorExt") != null ? (String) tileSource.get("descriptorExt") : "dzi";
        }

        ScalablePyramidBuilder spb = new ScalablePyramidBuilder(
                tileSize, overlap, tileFormat, descriptorExt);
        return spb;
    }

    /**
     * 返回切片参数
     * @param tileSource
     * @return HashMap
     */
    private HashMap<String,Object> getTileSource(HashMap<String, Object> tileSource) {
        HashMap<String, Object> newTileSource = new HashMap<>();

        if (null != tileSource) {
            newTileSource.putAll(tileSource);
        } else {
            newTileSource.put("tileSize",tileSize);
            newTileSource.put("overlap",overlap);
            newTileSource.put("tileFormat",tileFormat);
            newTileSource.put("descriptorExt",descriptorExt);
        }
        return newTileSource;
    }
}
