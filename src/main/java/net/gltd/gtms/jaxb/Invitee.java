package net.gltd.gtms.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "jid", "email" })
@XmlAccessorType(XmlAccessType.FIELD)
public class Invitee {
	@XmlAttribute
	private String jid;
	@XmlAttribute
	private String email;

	public String getJid() {
		return this.jid;
	}

	public void setJid(String jid) {
		this.jid = jid;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
