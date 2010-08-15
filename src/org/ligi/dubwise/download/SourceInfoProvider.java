package org.ligi.dubwise.download;

import javax.cache.Cache;
import javax.cache.CacheException;
import javax.cache.CacheManager;
import java.util.Collections;
import java.util.Random;

public class SourceInfoProvider {

    public final static String cache_key_installer_version="source_info_installer_version";
  
    public static String act_installer_version() {
    	return "0.19";
    }

    public static String act_version() {

		Cache cache = null;
		try {
		    cache = CacheManager.getInstance().getCacheFactory().createCache(Collections.emptyMap());
		} catch (CacheException e) {	}
	
		if (cache != null) {
		    try	{
			    if (cache.get(cache_key_installer_version)!=null)
				return (String) cache.get(cache_key_installer_version);
			}
		    catch (Exception e) {}
		}
	
		// couldnt get it from the cache - refetch
		
		String res;
		String[] res_a;
		try  {
			// had a caching problem with urlfetch - solved with this hint http://osdir.com/ml/GoogleAppEngine/2009-03/msg00125.html
			Random random=new Random();
			res_a=InstallHelper.read_http_str(getDownloadURL()+"trunk/version?"+random.nextInt()).replace("\n", "").replace("\r", "") .split("\\.");
				res=res_a[0]+"."+res_a[1]+res_a[2];
			cache.put(cache_key_installer_version,res);
		    }
		catch (Exception e) { res= "error";}
		return res;
    }

    public static void update_act_version() {
    	Cache cache = null;
    	try {
    		cache = CacheManager.getInstance().getCacheFactory().createCache(Collections.emptyMap());
    		cache.put(cache_key_installer_version, null);
    	} catch (Exception e) {	}
    }


    /**
     * as a function so that could be used to balance 
     * between different servers
     * 
     * @return the URL where the binaries are
     */
    public static String getDownloadURL() {
    	return "http://dubwise.freestone.net/";
    }
    
    public static String getStableDownloadURL() {
    	return getDownloadURL() + "tags/";
    }

    public static String getBleedingDownloadURL() {
    	return getDownloadURL() + "trunk/" ;
    }
    
    public static String install_notify_URL() {
    	return "http://dubwise-download.appspot.com/notify?install=";
    }

    public static String delete_notify_URL() {
    	return "http://dubwise-download.appspot.com/notify?delete=";
    }

    public static String installer_extern_base_URL() {
    	return "http://dubwise-download.appspot.com/midlet_download/DUBwiseInstaller";
    }


    public static String installer_source_base_URL() {
    	return getDownloadURL()+"DUBwiseInstaller";
    }
}
