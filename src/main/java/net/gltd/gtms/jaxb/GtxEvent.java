package net.gltd.gtms.jaxb;


import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "gtx-event", namespace = "http://gltd.net/protocol/gtx")
@XmlType(propOrder = { "system", "calls" })
@XmlAccessorType(XmlAccessType.FIELD)
public class GtxEvent {

	@XmlElement(name = "system", namespace = "http://gltd.net/protocol/gtx")
	private String system;
	@XmlElementWrapper(name = "calls", namespace = "http://gltd.net/protocol/gtx")
	@XmlElement(name = "call", namespace = "http://gltd.net/protocol/gtx")
	private Set<Call> calls;

	public String getSystem() {
		return this.system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public Set<Call> getCalls() {
		return this.calls;
	}

	public void setCalls(Set<Call> calls) {
		this.calls = calls;
	}
}
