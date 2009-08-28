package org.ligi.dubwise.download;

import javax.cache.Cache;
import javax.cache.CacheException;
import javax.cache.CacheManager;
import java.util.Collections;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.IOException;
import java.io.*;
import java.nio.*;



public class SourceInfoProvider {

    public final static String cache_key_installer_version="source_info_installer_version";
  
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


    public static String act_version()
    {

	Cache cache = null;
	try {
	    cache = CacheManager.getInstance().getCacheFactory().createCache(Collections.emptyMap());
	} catch (CacheException e) {	}

	if (cache != null) {
	    try
		{
		    if (cache.get(cache_key_installer_version)!=null)
			return (String) cache.get(cache_key_installer_version);
		}
	    catch (Exception e) {}
	}

	// couldnt get it from the cache - refetch
	
	String res;
	try
	    {
		res=read_http_str(getDownloadURL()+"trunk/version");
		cache.put(cache_key_installer_version,res);
	    }
	catch (Exception e) { res= "error";}
	return res;
    }

    public static void update_act_version()
    {
	Cache cache = null;
	try {
	    cache = CacheManager.getInstance().getCacheFactory().createCache(Collections.emptyMap());
	    cache.put(cache_key_installer_version,read_http_str(getDownloadURL()+"trunk/version"));
	} catch (Exception e) {	}

    }


    // could be used to balance between diffrent servers
    public static String getDownloadURL()
    {
	return "http://ligi.selfip.org/ligi/dubwise_dl/";


    }
}
