package it.osapulie.web.portlet.util;

import it.osapulie.infrastructure.impl.StreamUtils;

import javax.mail.AuthenticationFailedException;
import javax.mail.Folder;
import javax.mail.FolderClosedException;
import javax.mail.FolderNotFoundException;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.ReadOnlyFolderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.StoreClosedException;
import javax.mail.internet.InternetAddress;

/**
 * 
 * @author Davide Ciannamea
 *
 */

public class MailHelper {
	
	//Chiamata al costruttore
		public MailHelper() {
		   processMail();
		}
		 
		//E' una funzione che stampa i video i risultati
		private void printData(String data) {
		   System.out.println(data);
		}
		 
		public void processMail() {
		   Session session = null;
		   Store store = null;
		   Folder folder = null;
		   Message message = null;
		   Message[] messages = null;
		   Object messagecontentObject = null;
		   String sender = null;
		   String subject = null;
		   Multipart multipart = null;
		   Part part = null;
		   String contentType = null;
		 
		   try {
		      printData("--------------Avvio elaborazione email-----------------");
		      session = Session.getDefaultInstance(System.getProperties(), null);
		 
		      printData("Prelievo della sessione in corso.");
		      store = session.getStore("imap");
		 
		      //store.connect("host Name OR IP","username","password");
		      store.connect("localhost","administrator","admin");
		      printData("Connessione stabilita con il server IMAP");
		 
		      // Get a handle on the default folder
		      folder = store.getDefaultFolder();
		 
		      printData("Lettura della cartella INBOX.");
		 
		      // Retrieve the "Inbox"
		      folder = folder.getFolder("INBOX");
		 
		      //Reading the Email Index in Read / Write Mode
		      folder.open(Folder.READ_ONLY);
		 
		      // Retrieve the messages
		      messages = folder.getMessages();
		 
		      // Loop over all of the messages
		      for (int messageNumber = 0; messageNumber < messages.length; messageNumber++) {
		           // Retrieve the next message to be read
			   message = messages[messageNumber];
		 
		           // Retrieve the message content
		           messagecontentObject = message.getContent();
		 
		           // Determine email type
		           if (messagecontentObject instanceof Multipart) {
		               printData("Nuova email con allegati");
		               sender = ((InternetAddress) message.getFrom()[0]).getPersonal();
		 
		               printData("Ricerca indirizzo per mittente (sender)");
		 
			       if (sender == null) {
			 	   sender = ((InternetAddress) message.getFrom()[0]).getAddress();
				   printData("Indirizzo mittente:" + sender);
			       }
		               printData("Mittente: " + sender);
		 
		               // Get the subject information
		               subject = message.getSubject();
		               printData("subject=" + subject);
		 
		               // Prelievo dell'oggetto Multipart del messaggio
		               multipart = (Multipart) message.getContent();
		               
		               printData("Prelievo dell'oggetto Multipart del messaggio");
		 
		               // Loop over the parts of the email
		               for (int i = 0; i < multipart.getCount(); i++) {
		                    // Retrieve the next part
		                    part = multipart.getBodyPart(i);
		 
		                    // Get the content type
		                    contentType = part.getContentType();
		 
		                   // Display the content type
				   printData("Content: " + contentType);
		 
		                   if (contentType.startsWith("text/plain")) {
					printData("---------Lettura del contenuto del tipo text/plain-------------");
					
					Object contenuto_object = part.getContent();
					//_________________________________________________
					
					byte[] contenuto_array = StreamUtils.toByteArray(contenuto_object);
					String contenuto = new String(contenuto_array, "ISO-8859-1");
					//char[] contenuto_chars = contenuto.toCharArray();
					printData("Contenuto text: "+ contenuto);
				
				   } else {
					// Nome del file
					String fileName = part.getFileName();
					printData("Nome del file="+ fileName);
				   }
			      } 
			   } else {
			      printData("Nuova email senza allegato");
			      sender = ((InternetAddress) message.getFrom()[0]).getPersonal();
		 
		              printData("Ricerca indirizzo per mittente (sender)");
		 
		              if (sender == null) {
				sender = ((InternetAddress) message.getFrom()[0]).getAddress();
				printData("Indirizzo mittente:" + sender);
			     }
		 
		             // Oggetto dell'email
			     subject = message.getSubject();
			     printData("subject=" + subject);
			     
			     	// Stampa contenuto email
			     printData("Corpo del messaggio:" + message.getContent());
			     
			     /*****************************************************************/
			      
			     } 
		      }
		 
		      // Chiudi cartella
		      folder.close(true);
		 
		      // chiudi connessione
		      store.close();
		  } catch(AuthenticationFailedException e) {
		     printData("Not able to process the mail reading.");
		     e.printStackTrace();
		  } catch(FolderClosedException e) {
		     printData("Not able to process the mail reading.");
		     e.printStackTrace();
		  } catch(FolderNotFoundException e) {
		     printData("Not able to process the mail reading.");
		     e.printStackTrace();
		  }  catch(NoSuchProviderException e) {
		     printData("Not able to process the mail reading.");
		     e.printStackTrace();
		  } catch(ReadOnlyFolderException e) {
		     printData("Not able to process the mail reading.");
		     e.printStackTrace();
		  } catch(StoreClosedException e) {
		     printData("Not able to process the mail reading.");
		     e.printStackTrace();
		  } catch (Exception e) {
		     printData("Not able to process the mail reading.");
		     e.printStackTrace();
		  }
		}
		 
		//Funzione principale per MailHelper()
		public static void main(String args[]) {
		    //Creating new readEmail Object
		    MailHelper readMail = new MailHelper();
		 
		    //Calling processMail Function to read from IMAP Account
		    readMail.processMail();
		}

}
