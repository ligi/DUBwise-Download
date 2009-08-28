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

public class PostDeviceInfos extends HttpServlet {
    private static final Logger log = Logger.getLogger( EnterCodeServlet.class.getName());


    public boolean check_bool_param(String param)
    {
	if (param==null)
	    return false;
	return param.equals("true");
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
                throws IOException {


    	// store in Database
        Date date = new Date();
        PersistentDevice device_record = new PersistentDevice(date,req.getHeader("user-agent"));
        

        device_record.setPlatform(req.getParameter("platform"));
        device_record.setEncoding(req.getParameter("encoding"));
        device_record.setLocale(req.getParameter("locale"));
        device_record.setConfiguration(req.getParameter("configuration"));
        device_record.setProfiles(req.getParameter("profiles"));
        device_record.setLocation_api_version(req.getParameter("location_api_version"));
        device_record.setSensor_api_version(req.getParameter("sensor_api_version"));
        device_record.setComPorts(req.getParameter("comports"));
	device_record.setComPorts(req.getParameter("comports"));
	device_record.setCanvas_width(new Integer(req.getParameter("canvas_width")).intValue());
	device_record.setCanvas_height(new Integer(req.getParameter("canvas_height")).intValue());
	device_record.setCanvas_full_width(new Integer(req.getParameter("canvas_full_width")).intValue());
	device_record.setCanvas_full_height(new Integer(req.getParameter("canvas_full_height")).intValue());
	device_record.setFreeMem(new Integer(req.getParameter("free_mem")).intValue());
	device_record.setTotalMem(new Integer(req.getParameter("total_mem")).intValue());
	device_record.setRMSAvail(new Integer(req.getParameter("rms_avail")).intValue());
	device_record.setDeviceControl(check_bool_param(req.getParameter("devicecontrol")));
	device_record.setCldc11( check_bool_param(req.getParameter("cldc11")));
	device_record.setFileAPI( check_bool_param(req.getParameter("fileapi")));
	device_record.setBluetooth( check_bool_param(req.getParameter("bluetooth")));
	device_record.setSymbian( check_bool_param(req.getParameter("symbian")));
	device_record.setSensorAPI( check_bool_param(req.getParameter("sensorapi")));
	device_record.setJSR179( check_bool_param(req.getParameter("jsr179")));

        PersistenceManager pm = PMF.get().getPersistenceManager();
        try {
            pm.makePersistent(device_record);
	    log.log(Level.WARNING,"Device made persistent") ;
	} finally {
            pm.close();
        }
	
	// send mail
	Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("marcus.bueschleb@googlemail.com"));
            msg.addRecipient(Message.RecipientType.TO,
                             new InternetAddress("marcus.bueschleb@googlemail.com"));
            msg.setSubject("DUBwise Device Info");
            msg.setText(device_record.info_text());
            Transport.send(msg);


        } catch (Exception e) {
	    log.log(Level.WARNING,"exception while sending mail " +e );
            // dont care if failing
        } 

	
	resp.setContentType("text/plain");
	resp.getWriter().print(""+device_record.getId());
    }
}
