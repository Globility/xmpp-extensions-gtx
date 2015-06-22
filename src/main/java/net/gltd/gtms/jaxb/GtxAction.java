package net.gltd.gtms.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "gtx-action", namespace = "http://gltd.net/protocol/gtx")
@XmlType(propOrder = { "system", "action" })
@XmlAccessorType(XmlAccessType.FIELD)
public class GtxAction {

	@XmlElement(name = "system", namespace = "http://gltd.net/protocol/gtx")
	private String system;
	@XmlElement(name = "action", namespace = "http://gltd.net/protocol/gtx")
	private Action action;

	public String getSystem() {
		return this.system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public Action getAction() {
		return this.action;
	}

	public void setAction(Action action) {
		this.action = action;
	}
}
