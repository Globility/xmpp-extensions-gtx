package net.gltd.gtms.jaxb;

import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "command", "destination", "calls" })
@XmlAccessorType(XmlAccessType.FIELD)
public class Action {

	public enum ActionCommand {
		makeCall, scheduleCall, deleteCall, listCalls, getCall;
	}

	@XmlAttribute(name = "command")
	private ActionCommand command;
	@XmlAttribute(name = "destination")
	private String destination;
	@XmlElementWrapper(name = "calls", namespace = "http://gltd.net/protocol/gtx")
	@XmlElement(name = "call", namespace = "http://gltd.net/protocol/gtx")
	private Set<Call> calls;

	public ActionCommand getCommand() {
		return this.command;
	}

	public void setCommand(ActionCommand command) {
		this.command = command;
	}

	public Set<Call> getCalls() {
		return this.calls;
	}

	public void setCalls(Set<Call> calls) {
		this.calls = calls;
	}

	public String getDestination() {
		return this.destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
}
