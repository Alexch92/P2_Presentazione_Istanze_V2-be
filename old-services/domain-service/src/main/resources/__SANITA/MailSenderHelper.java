package it.osapulie.web.portlet.util;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.mail.internet.InternetAddress;

import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.web.multipart.MultipartFile;

import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.util.mail.MailEngine;
import com.liferay.util.mail.MailEngineException;

public class MailSenderHelper {

	private Logger log = LoggerFactory.getLogger(MailSenderHelper.class);

	private VelocityEngine velocityEngine;

	private String FROM;
	private String TO;
	
	public String mergeTplModelli(String templateLocation, Map<String, Object> model){
		String body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, templateLocation, model);
		return body;
	}
	
	public String mergeTplModelli(String templateLocation, String encoding, Map<String, Object> model){
		String body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, templateLocation, encoding, model);
		return body;
	}
	/**
	 * Metodo per l'invio di una mail generica.
	 * 
	 * @param subject
	 * @param templateLocation
	 * @param model
	 * @param attachment
	 * @throws Exception
	 */
	public void sendMail(String subject, String corpo, File[] attachment,String from, String[] to) throws Exception {

		MailMessage message = new MailMessage();
		
		String sender = PrefsPropsUtil.getString("admin.email.from.address");
		if (from != null && !from.isEmpty())
			sender = from;

		InternetAddress fromAddress = new InternetAddress(sender);

		InternetAddress[] to2 = new InternetAddress[to.length];
		for (int i=0;i<to.length;i++){
			String em = to[i];
			InternetAddress toMail = new InternetAddress(em);
			to2[i] = toMail;
		}

		message.setFrom(fromAddress);
		message.setTo(to2);
		message.setSubject(subject);
		message.setBody(corpo);
		message.setHTMLFormat(true);
		
		String infoMsg = String.format("sendMail :: sending mail from :%s to :%s", from, to[0]);
		if (attachment != null) {
			infoMsg = infoMsg.concat(String.format(" with %s attachments...", attachment.length));
			for (File file : attachment) {
				message.addFileAttachment(file);
			}
		}

		log.info(infoMsg);
		MailEngine.send(message);
		log.info(String.format("sendMail :: mail succesfully sent from :%s to :%s!!", from, to[0]));
	}

	/**
	 * Invia la mail per la dichiarazione/iscrizione e relativi allegati
	 * 
	 * @param tipologia
	 * @param templateName
	 * @param attachment
	 * @param model
	 * @throws MailEngineException
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	public void sendConfirmationEmail(String tipologia, String templateName, UploadItem attachment, Map<String, String> model) throws Exception {

		MailMessage message = new MailMessage();

		InternetAddress from = null;

		if (FROM != null && !FROM.equals(""))
			from = new InternetAddress(FROM);
		else
			from = new InternetAddress(PrefsPropsUtil.getString("admin.email.from.address"));

		InternetAddress[] to = new InternetAddress[1];
		InternetAddress toInternetAddress = new InternetAddress(TO);
		to[0] = toInternetAddress;

		String body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, templateName, model);

		message.setFrom(from);
		message.setTo(to);
		message.setSubject(tipologia);
		message.setBody(body);
		message.setHTMLFormat(true);

		if (attachment != null) {
			//List<MultipartFile> files = attachment.getMultipartFiles();
			MultipartFile generatedFile = attachment.getFile();
			
			if(!generatedFile.isEmpty()){
				File file = new File(generatedFile.getOriginalFilename());
				generatedFile.transferTo(file);
				message.addFileAttachment(file);
			}
			
			/*if (files != null && files.size() > 0) {
				for (MultipartFile multipartFile : files) {
					if (multipartFile.getSize() > 0) {
						File file = new File(multipartFile.getOriginalFilename());
						multipartFile.transferTo(file);
						message.addFileAttachment(file);
					}
				}
			}*/
		}

		log.debug("sendConfirmationEmail :: sending mail to : " + to);

		MailEngine.send(message);

	}

	public String getTO() {
		return TO;
	}

	public void setTO(String tO) {
		this.TO = tO;
	}

	public VelocityEngine getVelocityEngine() {
		return velocityEngine;
	}

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

	public String getFROM() {
		return FROM;
	}

	public void setFROM(String fROM) {
		FROM = fROM;
	}

}
