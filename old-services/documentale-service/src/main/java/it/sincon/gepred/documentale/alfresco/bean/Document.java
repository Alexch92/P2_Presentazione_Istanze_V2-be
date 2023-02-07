package it.sincon.gepred.documentale.alfresco.bean;

/**
 * @author Birtolo
 *
 */
public class Document {
	
	private String name;
	private String type;
	private String creator;
	private String creationTime;
	private String uuid;
	private String content;
	
	/**
	 * Crea un'istanza di <code>Document</code> con nome e tipologia dati in input.
	 * <p>
	 * Se uno degli argomenti &egrave; <code>null</code> o una stringa vuota, viene
	 * lanciata un'eccezione di tipo <code>IllegalArgumentException</code>.
	 * @param name {@code String} - il nome del documento
	 * @param type {@code String} - la tipologia del documento
	 * @param creator {@code String} - il nome dell'utente che ha creato il documento
	 * @param creationTime {@code String} - Data e ora di creazione del documento. Il formato
	 * da usare &egrave;: {@code aaaa-mm-ggThh:mm:ss.MMMfff:ff} dove {@code aaaa} &egrave;
	 * l'anno, {@code mm} &egrave; il mese, {@code gg} &egrave; il giorno, segue una lettera
	 * {@code T}, {@code hh} sono le ore ({@code 00}-{@code 23}), {@code mm} sono i minuti,
	 * {@code ss} sono i secondi, {@code MMM} sono i millisecondi e la parte finale &egrave;
	 * la differenza di fuso orario con l'ora GMT.<br/>
	 * Esempio: {@code 2011-12-28T11:12:39.366+00:00}
	 * @throws IllegalArgumentException se uno degli argomenti &egrave; <code>null</code> o una
	 * stringa vuota
	 */
	public Document(String name, String type, String creator, String creationTime,String uuid)
			throws IllegalArgumentException {
		if (name == null || name.equals(""))
			throw new IllegalArgumentException("Nome mancante");
		if (type == null || type.equals(""))
			throw new IllegalArgumentException("Tipologia mancante");
		if (creator == null || creator.equals(""))
			throw new IllegalArgumentException("Creatore mancante");
		if (creationTime == null || creationTime.equals(""))
			throw new IllegalArgumentException("Data creazione mancante");
		this.name = name;
		this.type = type;
		this.creator = creator;
		this.creationTime = creationTime;
		this.uuid = uuid;
	}
	
	public Document(String name, String type, String creator, String creationTime,String uuid, String content)
			throws IllegalArgumentException {
		this(name, type, creator, creationTime, uuid);
		
		this.content = content;
	}

	/**
	 * Restituisce il nome del documento
	 * @return {@code String}
	 */
	public String getName() {
		return name;
	}

	/**
	 * Restituisce la tipologia del documento
	 * @return {@code String}
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Restituisce il nome dell'utente che ha creato il documento
	 * @return {@code String}
	 */
	public String getCreator() {
		return creator;
	}

	/**
	 * Restituisce data e ora di creazione del documento
	 * @return {@code String} - Il formato &egrave;: {@code aaaa-mm-ggThh:mm:ss.MMMfff:ff} dove
	 * {@code aaaa} &egrave; l'anno, {@code mm} &egrave; il mese, {@code gg} &egrave; il giorno,
	 * segue una lettera {@code T}, {@code hh} sono le ore ({@code 00}-{@code 23}), {@code mm}
	 * sono i minuti, {@code ss} sono i secondi, {@code MMM} sono i millisecondi e la parte
	 * finale &egrave; la differenza di fuso orario con l'ora GMT.<br/>
	 * Esempio: {@code 2011-12-28T11:12:39.366+00:00}
	 */
	public String getCreationTime() {
		return creationTime;
	}
	
	/**
	 * Il documento viene rappresentato da tutti i suoi attributi
	 */
	@Override
	public String toString() {
		return "Document [name=" + name + ", type=" + type + ", creator="
				+ creator + ", creationTime=" + creationTime + ", uuid="+uuid+"]";
	}

	public String getUuid() {
		return uuid;
	}
	
	public String getContent() {
		return content;
	}
	
}

