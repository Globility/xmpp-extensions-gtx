package net.gltd.gtms.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "type", "recipient" })
@XmlAccessorType(XmlAccessType.FIELD)
public class Notification {

	public enum NotificationType {
		email, sms, im;
	}

	@XmlAttribute(name = "type")
	private NotificationType type;
	@XmlElement(name = "recipient", namespace = "http://gltd.net/protocol/gtx")
	private String recipient;

	public NotificationType getType() {
		return this.type;
	}

	public void setType(NotificationType type) {
		this.type = type;
	}

	public String getRecipient() {
		return this.recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
}
