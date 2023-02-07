package it.sincon.gepred.web.portlet.varie;

import java.io.*;

import javax.activation.DataHandler;
import javax.mail.*;
import javax.mail.internet.*;

import com.sun.istack.ByteArrayDataSource;

public class StandardMessage
{

    public StandardMessage()
    {
        contents = new MimeMultipart();
    }

    public void addContentString(String data, String id, String type,String name)
            throws MessagingException
    {
    	addContentString(data, id, type, name,contents.getCount());
    }
    
    public void addContentAttachment(byte[] data, String id,String type,String name)
            throws MessagingException
      {
        	addContentAttachment(data, id, type, name,contents.getCount());
        }
    
    public void addContentString(String data, String id, String type,String name,int position) throws MessagingException {
        MimeBodyPart bp = new MimeBodyPart();
        bp.setContent(data, type);
        bp.setHeader(CONTENTID, id);
        bp.setHeader(CONTENTLOCATION, name);
        bp.setHeader(ENCODING, "7bit");
        addAttachment(((BodyPart) (bp)),position);
    	
    }
    
    public void addContentAttachment(byte[] data, String id,String type,String name,int position) throws MessagingException {
        MimeBodyPart bp = new MimeBodyPart();
        bp.setDataHandler(new DataHandler(new ByteArrayDataSource(data, type)));
        bp.setHeader(CONTENTTYPE, type+"; name="+name);
        bp.setHeader(CONTENTID, id);
        bp.setHeader(CONTENTLOCATION, name);
        bp.setHeader(ENCODING, "base64");
        addAttachment(((BodyPart) (bp)),position);
    }


    public void addAttachment(BodyPart bp,int position)
        throws MessagingException
    {
        contents.addBodyPart(bp,position);
    }

    public InputStream getAttachment(String id)
        throws MessagingException, IOException
    {
        BodyPart part = getPart(id);
        return part == null ? null : part.getInputStream();
    }

    public InputStream getAttachment(int index)
        throws MessagingException, IOException
    {
        BodyPart part = getPart(index);
        return part == null ? null : part.getInputStream();
    }

    public BodyPart getPart(int index)
        throws MessagingException, IOException
    {
        return contents.getBodyPart(index);
    }

    public BodyPart getPart(String id)
        throws MessagingException, IOException
    {
        BodyPart part = null;
        if(id.length() > 4 && id.toLowerCase().startsWith("cid:"))
        {
            String cid = id.substring(4);
            if(cid.charAt(0) != '<' || cid.charAt(cid.length()) != '>')
                cid = (new StringBuilder()).append('<').append(cid).append('>').toString();
            part = contents.getBodyPart(cid);
        } else
        {
            part = contents.getBodyPart(id);
            for(int i = 1; part == null && i < contents.getCount(); i++)
            {
                MimeBodyPart cPart = (MimeBodyPart)contents.getBodyPart(i);
                if(id.equalsIgnoreCase(cPart.getFileName()) || id.equalsIgnoreCase(cPart.getHeader(CONTENTLOCATION, null)))
                    part = cPart;
            }

        }
        return part;
    }

 
    public void writeTo(OutputStream out)
        throws IOException, MessagingException
    {
        if(contents.getCount() == 1)
        {
            BodyPart bp = contents.getBodyPart(0);
            bp.writeTo(out);
        } else
        if(contents.getCount() > 0)
            contents.writeTo(out);
    }


    public static final String CONTENTTYPE = "Content-Type";
    public static final String CONTENTID = "Content-ID";
    public static final String CONTENTLOCATION = "Content-Location";
    public static final String ENCODING="Content-Transfer-Encoding";
    private MimeMultipart contents;
}