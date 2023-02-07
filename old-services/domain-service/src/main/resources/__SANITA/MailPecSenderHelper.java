package it.osapulie.web.portlet.util;

//import it.linksmt.pec.SMTPManager;

import java.io.File;


import java.io.IOException;
import java.util.Map;

import javax.mail.internet.InternetAddress;
import javax.naming.CommunicationException;

import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.liferay.portal.kernel.mail.Account;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.mail.SMTPAccount;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.util.mail.MailEngine;
import com.liferay.util.mail.MailEngineException;

public class MailPecSenderHelper {

	private Logger log = LoggerFactory.getLogger(MailPecSenderHelper.class);
	
	@Value("#{applicationProperties.fromMail}")
	private String FROM;
	@Value("#{applicationProperties.toMail}")
	private String TO;

	private VelocityEngine velocityEngine;

	/**
	 * Metodo per l'invio di una PEC mail.
	 * 
	 * @param subject
	 * @param templateLocation
	 * @param model
	 * @param attachment
	 * @throws Exception
	 */
	public void sendMail(String subject, String corpo, File[] attachment,String[] to) throws Exception {
		this.sendMail(subject, 
				corpo, 
				attachment, 
				PrefsPropsUtil.getString("admin.pec.email.from.address"),
				to, 
//				PrefsPropsUtil.getString("pec.mail.session.mail.smtp.enable"),
				PrefsPropsUtil.getString("pec.mail.session.mail.smtp.host"),
				PrefsPropsUtil.getString("pec.mail.session.mail.smtp.port"),
				PrefsPropsUtil.getString("pec.mail.session.mail.transport.protocol"),
				PrefsPropsUtil.getString("pec.mail.session.mail.smtp.user"),
				PrefsPropsUtil.getString("pec.mail.session.mail.smtp.password"));
	}
	
	/**
	 * Metodo per l'invio di una PEC mail.
	 * 
	 * @param subject
	 * @param templateLocation
	 * @param model
	 * @param attachment
	 * @throws Exception
	 */
	public void sendMail(String subject, String corpo, File[] attachment,String from, String[] to) throws Exception {
		
		String sender = PrefsPropsUtil.getString("admin.pec.email.from.address");
		if (from!=null && !from.isEmpty())
			sender = from;
			
		this.sendMail(subject, 
				corpo, 
				attachment, 
				sender,
				to, 
//				PrefsPropsUtil.getString("pec.mail.session.mail.smtp.enable"),
				PrefsPropsUtil.getString("pec.mail.session.mail.smtp.host"),
				PrefsPropsUtil.getString("pec.mail.session.mail.smtp.port"),
				PrefsPropsUtil.getString("pec.mail.session.mail.transport.protocol"),
				PrefsPropsUtil.getString("pec.mail.session.mail.smtp.user"),
				PrefsPropsUtil.getString("pec.mail.session.mail.smtp.password"));
	}
	
	/**
	 * Metodo per l'invio di una PEC mail.
	 * 
	 * @param subject
	 * @param templateLocation
	 * @param model
	 * @param attachment
	 * @throws Exception
	 */
	public void sendMail(String subject, 
			String corpo, 
			File[] attachment,
			String _from,
			String[] _to, 
			String pecHost,
			String pecPort,
			String pecProtocol,
			String pecUsername, 
			String pecPassword) throws Exception {

		log.debug("sendMail :: entering method");
		
		try{
			MailMessage message = new MailMessage();
	
			// Creazione SMTPS account
			SMTPAccount smtpAccount = null;
	
//			boolean pecEnableBoolean = Boolean.parseBoolean(pecEnable);
			// test raggiungibilità SMTP PEC mail server
//			if (pecEnableBoolean && !SMTPManager.testSmtpServer(pecHost, Integer.parseInt(pecPort), pecUsername, pecPassword)) {
//				throw new Exception("Errore di comunicazione con il server SMTP");
//			}
	
			smtpAccount = (SMTPAccount) Account.getInstance(pecProtocol, Integer.parseInt(pecPort));
			smtpAccount.setHost(pecHost);
			smtpAccount.setUser(pecUsername);
			smtpAccount.setPassword(pecPassword);
	
			message.setSMTPAccount(smtpAccount);
	
			InternetAddress from = new InternetAddress(_from);
			
			InternetAddress[] to = new InternetAddress[_to.length];
			for (int i=0;i<_to.length;i++){
				String em = _to[i];
				InternetAddress toMail = new InternetAddress(em);
				to[i] = toMail;
			}
			
			message.setFrom(from);
			message.setTo(to);
			message.setSubject(subject);
			message.setBody(corpo);
			message.setHTMLFormat(true);
	
			if (attachment != null) {
				for (File file : attachment) {
					message.addFileAttachment(file);
				}
			}
	
			log.debug("sendMail :: sending PEC mail to : " + to);
	
			MailEngine.send(message);
			
		}catch(Exception e){
			log.error("sendmail :: " + e.getMessage(),e);
			throw new Exception(e.getCause());
		}

	}

	/**
	 * Invia la PEC mail per la dichiarazione/iscrizione e relativi allegati
	 * 
	 * @param tipologia
	 * @param templateName
	 * @param attachment
	 * @param model
	 * @throws MailEngineException
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	public void sendConfirmationEmail(String tipologia, String templateName, File attachment, Map<String, String> model) throws IOException,Exception {

		MailMessage message = new MailMessage();

		// Creazione SMTPS account
		//String pecEnable = PrefsPropsUtil.getString("pec.mail.session.mail.smtp.enable");
		String pecHost = PrefsPropsUtil.getString("pec.mail.session.mail.smtp.host");
		String pecPort = PrefsPropsUtil.getString("pec.mail.session.mail.smtp.port");
		String pecProtocol = PrefsPropsUtil.getString("pec.mail.session.mail.transport.protocol");
		String pecUsername = PrefsPropsUtil.getString("pec.mail.session.mail.smtp.user");
		String pecPassword = PrefsPropsUtil.getString("pec.mail.session.mail.smtp.password");
		SMTPAccount smtpAccount = null;

		//boolean pecEnableBoolean = Boolean.parseBoolean(pecEnable);

		// test raggiungibilità SMTP PEC mail server
		//if (pecEnableBoolean && !SMTPManager.testSmtpServer(pecHost, Integer.parseInt(pecPort), pecUsername, pecPassword)) {
			//throw new Exception("Errore di comunicazione con il server SMTP");
		//}

		smtpAccount = (SMTPAccount) Account.getInstance(pecProtocol, Integer.parseInt(pecPort));
		smtpAccount.setHost(pecHost);
		smtpAccount.setUser(pecUsername);
		smtpAccount.setPassword(pecPassword);

		message.setSMTPAccount(smtpAccount);

		InternetAddress from = null;

		if (FROM != null && !FROM.equals(""))
			from = new InternetAddress(FROM);
		else
			from = new InternetAddress(PrefsPropsUtil.getString("admin.pec.email.from.address"));

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
			//MultipartFile generatedFile = attachment.getFile();
			
			//if(!generatedFile.isEmpty()){
				//File file = new File(generatedFile.getOriginalFilename());
				//generatedFile.transferTo(file);
				message.addFileAttachment(attachment);				
			//}
			
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

		log.debug("sendConfirmationEmail :: sending PEC mail to : " + to);

		try {
			MailEngine.send(message);
		}
		catch (Exception e) {
			log.error("sendConfirmationEmail :: " + e.getMessage(), e);
			throw new IOException("sendPec :: Errore durante l'invio della PEC mail", e);
		}

	}

	public String getTO() {
		return TO;
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

	public void setTO(String tO) {
		TO = tO;
	}

}
