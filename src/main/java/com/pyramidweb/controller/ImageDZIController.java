package com.pyramidweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import com.pyramidweb.write.service.*;

/**
 * 生成DZIcontroller
 * @author ydx
 * @date 2019-06-03
 * @version 1.0.0
 */
@RestController
@RequestMapping("/imageDZI")
public class ImageDZIController {
    @Autowired
    WriteDZIService writeDZIService;

    @RequestMapping(value = "/writeImageDZI", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> WriteImageDZI(
            @RequestParam(value = "imagePath",required = true) String imagePath,
            @RequestParam(value = "tileSource",required = false) HashMap<String,Object> tileSource,
            @RequestParam(value = "outpath",required = false) String outpath) throws Exception{
        Map<String,Object> resultMap = null;
        if (writeDZIService != null) {
            resultMap = writeDZIService.writeDZIByTileSource(imagePath,tileSource,outpath);
        }
        return resultMap;
    }

}
