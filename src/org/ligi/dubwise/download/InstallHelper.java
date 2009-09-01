package org.ligi.dubwise.download;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;



public class InstallHelper {

    public static String read_http_str(String _url) throws IOException {
        ByteArrayOutputStream tmpOut = new ByteArrayOutputStream();
	
	URL url = new URL(_url);
        URLConnection connection = url.openConnection();
        int contentLength = connection.getContentLength();
        InputStream in = url.openStream();
        byte[] buf = new byte[512];
        int len;
        while (true) {
            len = in.read(buf);
            if (len == -1) {
                break;
            }
            tmpOut.write(buf, 0, len);
        }
        tmpOut.close();
        ByteBuffer bb = ByteBuffer.wrap(tmpOut.toByteArray(), 0,
                                        tmpOut.size());
        return new String(bb.array());
    }

}
