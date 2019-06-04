package com.pyramidweb.write.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 生成DZI接口
 * @author ydx
 * @date 2019-05-30
 * @version 1.0.0
 */
@Service
public interface WriteDZIService {
    /**
     * 根据目标图片路径，默认参数生成Deep Zoom Images
     * @param imagePath 目标图片路径
     * @param outpath 输出路径
     * @return 返回切片对象
     */
    public Map<String,Object>  writeDZIByImagePath(String imagePath, String outpath) throws Exception;

    /**
     * 根据目标图片路径和参数生成Deep Zoom Images
     * @param imagePath 目标图片路径
     * @param tileSource DZI格式参数
     * @param outpath 输出路径
     * @return 返回切片对象
     */
    public Map<String,Object> writeDZIByTileSource(String imagePath, HashMap<String,Object> tileSource, String outpath) throws Exception;
}
