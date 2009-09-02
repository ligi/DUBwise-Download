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
	String[] res_a;
	try
	    {
		res_a=InstallHelper.read_http_str(getDownloadURL()+"trunk/version").split("\\.");
			res=res_a[0]+"."+res_a[1]+res_a[2];
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
	    cache.put(cache_key_installer_version, null);
	} catch (Exception e) {	}

    }


    // could be used to balance between diffrent servers
    public static String getDownloadURL()
    {
	return "http://ligi.selfip.org/ligi/dubwise_dl/";
    }
    
    public static String getStableDownloadURL()
    {
	return getDownloadURL() + "tags/";
    }

    public static String getBleedingDownloadURL()
    {
	return getDownloadURL() + "trunk/" ;
    }
    
    public static String install_notify_URL()
    {
    	return "http://dubwise-download.appspot.com/notify?install=";
    }

    public static String delete_notify_URL()
    {
    	return "http://dubwise-download.appspot.com/notify?delete=";
    }
    
}
