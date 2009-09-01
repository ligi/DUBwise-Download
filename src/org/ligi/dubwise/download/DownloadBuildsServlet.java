package org.ligi.dubwise.download;

import java.io.IOException;
import java.util.Date;
import java.util.logging.Logger;
import java.util.logging.Level;

import javax.jdo.PersistenceManager;
import javax.servlet.http.*;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

import org.ligi.dubwise.download.PMF;
import org.ligi.dubwise.download.BuildRecord;

import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.datastore.Text;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.IOException;
import java.io.*;
import java.nio.*;


import java.util.*;
import javax.jdo.Query;

// ...

public class DownloadBuildsServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger( EnterCodeServlet.class.getName());




    public void create_all()
    {

        PersistenceManager pm = PMF.get().getPersistenceManager();
        try {

	    DUBwiseProps props=new DUBwiseProps();
	    Date date = new Date();
	    for (int i=0;i<999999;i++)
		if (props.set_code(""+i)){
		    BuildRecord build_record=new BuildRecord(""+i,date,null,null);
		    
		    pm.makePersistent(build_record);
		}
	} finally {
            pm.close();
        }

    }   


    public byte[] read_http(String _url) throws IOException {
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
        //Lines below used to test if file is corrupt
        //FileOutputStream fos = new FileOutputStream("C:\\abc.pdf");
        //fos.write(tmpOut.toByteArray());

        return bb.array();
    }

    /*
    public byte[] read_http(String address) {
        byte[] byteReturn = null;
        URL theURL = null;
        InputStream inStream = null;
        try {
            theURL = new URL(address);
            inStream = theURL.openStream();
            byteReturn = readStream(inStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inStream != null) {
                  inStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return byteReturn;
	}*/


    /*
      ing res="";
	try {
            URL url = new URL(_url);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            
	    int act_char;
	    
            while ((act_char = reader.read()) != -1) {
                res+=(char)act_char;
            }
            reader.close();

        } catch (MalformedURLException e) {
            // ...
        } catch (IOException e) {
            // ...
        }
	return res;

	}*/

    public void delete_all()
    {
    PersistenceManager pm = PMF.get().getPersistenceManager();

    Query query = pm.newQuery(BuildRecord.class);
    query.setOrdering("id asc");

    int del_count=0;
    try {
        List<BuildRecord> results = (List<BuildRecord>) query.execute();
        if (results.iterator().hasNext()) {
            for (  BuildRecord e : results) {
	        pm.deletePersistent(e);	
		del_count++;
            }
        }
    } 
    catch (Exception e)
	{
	}
    finally {
        query.closeAll();
    }

	
    }



    public void create_record(String code,PersistenceManager pm)
    {


	Date date = new Date();
	BuildRecord build_record=new BuildRecord(code,date,null,null);
		    
	pm.makePersistent(build_record);
    
    }


    public void create_missing_records()
    {

    PersistenceManager pm = PMF.get().getPersistenceManager();

    Query  query = pm.newQuery("select code from org.ligi.dubwise.download.BuildRecord " +
                              "order by code desc limit 1");

    DUBwiseProps props=new DUBwiseProps();
	


    String last_done="none";


        try {
        List<String> results = (List<String>)query.execute();

	if (results.size()==0)
	        create_record("000000",pm);
	else
	    {
		int last = new Integer((String)results.get(0)).intValue();
		for( int i=0;i<100;i++)
		    {
			last++;
			while ((!props.set_code( new Formatter().format("%06d", last).toString()))&&(last<999999))
			    {
				last++;
			    }
			
			if (last<999999)
			    {
				create_record(	new Formatter().format("%06d", last).toString(),pm);
				last_done=new Formatter().format("%06d", last).toString();
			    }
		    }
	    }
	}
	
    

	finally {
	    query.closeAll();
	}
    

    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws IOException {



    PersistenceManager pm = PMF.get().getPersistenceManager();

    Query  query = pm.newQuery("select from org.ligi.dubwise.download.BuildRecord " +
                              "where update_flag == false");
    query.setRange(0,1);
    DUBwiseProps props=new DUBwiseProps();
	


    String last_done="none";


    
        try {
        List<BuildRecord> results = (List<BuildRecord>)query.execute();

	if (results.size()==0)
	    {

		resp.setContentType("text/plain");
		resp.getWriter().print("no more stuff to do" );
		return;
	    }
	     
	else
	    {
		BuildRecord last =(BuildRecord)results.get(0);
		props.set_code(last.getCode());
		last_done=last.getCode();



		last.setJAD(new Text(new String(read_http("http://ligi.selfip.org/ligi/dubwise_dl/tags/"+props.getJADFileName()))));

		last.setJAR(new Blob(read_http("http://ligi.selfip.org/ligi/dubwise_dl/tags/"+props.getJARFileName())));

		last.setUpdateFlag(true);

		pm.close();
	    }
	}
	
    

	finally {
	    query.closeAll();
	}
    


	resp.setContentType("text/plain");
	resp.getWriter().print("last:" +last_done);


    }
}
