package com.pyramidweb.util;

import com.pyramidweb.config.ProxyConfiguration;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;
import java.net.URL;

public class ImageIOUtil {
    public static BufferedImage read(URL input) throws IOException {
        if (input == null) {
            throw new IllegalArgumentException("input == null!");
        }

        InputStream istream = null;
        Proxy proxy = null;
        try {
            proxy = ProxyConfiguration.getProxy();
            if (proxy != null) {
                istream = input.openConnection(proxy).getInputStream();
            } else {
                istream = input.openStream();
            }
        } catch (IOException e) {
            throw new IIOException("Can't get input stream from URL!", e);
        }
        ImageInputStream stream = ImageIO.createImageInputStream(istream);
        BufferedImage bi;
        try {
            bi = ImageIO.read(stream);
            if (bi == null) {
                stream.close();
            }
        } finally {
            istream.close();
        }
        return bi;
    }

}
