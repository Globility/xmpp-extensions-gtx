package net.gltd.gtms.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "type", "extension", "pin" })
@XmlAccessorType(XmlAccessType.FIELD)
public class CallIn {

	public enum CallInType {
		moderator, participant;
	}

	@XmlAttribute(name = "type")
	private CallInType type;
	@XmlElement(name = "extension", namespace = "http://gltd.net/protocol/gtx")
	private String extension;
	@XmlElement(name = "pin", namespace = "http://gltd.net/protocol/gtx")
	private String pin;

	public CallInType getType() {
		return this.type;
	}

	public void setType(CallInType type) {
		this.type = type;
	}

	public String getExtension() {
		return this.extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getPin() {
		return this.pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}
}
