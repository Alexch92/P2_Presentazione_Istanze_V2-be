package it.sincon.sanita.services.beans;

public class ENG_Image {               //  long                   lat
//	imageData = {"groupId":25176,"uuid":"5673ffef-0c83-4620-89a2-a09cd3cdf19a","version":"1.0"}
	
	private long groupId;
	private String uuid;
	private String version;
	
	public long getGroupId() {
		return groupId;
	}
	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}

}
