package net.gltd.gtms.jaxb;

import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

import net.gltd.gtms.jaxb.CallIn.CallInType;
import net.gltd.gtms.profiler.gtx.profile.Property;

@XmlType(propOrder = { "type", "id", "url", "startTime", "endTime", "subject", "properties", "notifications", "callIns" })
@XmlAccessorType(XmlAccessType.FIELD)
public class Call {

	public enum CallAction {
		addParticipant, endVideoCall;
	}

	public enum CallType {
		video, audio;
	}

	public enum AudioType {
		conference, application;
	}

	@XmlAttribute(name = "type")
	private CallType type;
	@XmlAttribute(name = "audioType")
	private AudioType audioType;
	@XmlElement(name = "id", namespace = "http://gltd.net/protocol/gtx")
	private String id;
	@XmlElement(name = "url", namespace = "http://gltd.net/protocol/gtx")
	private String url;
	@XmlElement(name = "startTime", namespace = "http://gltd.net/protocol/gtx")
	private String startTime;
	@XmlElement(name = "endTime", namespace = "http://gltd.net/protocol/gtx")
	private String endTime;
	@XmlElement(name = "subject", namespace = "http://gltd.net/protocol/gtx")
	private String subject;
	@XmlElementWrapper(name = "properties", namespace = "http://gltd.net/protocol/gtx")
	@XmlElement(name = "property", namespace = "http://gltd.net/protocol/gtx")
	private Set<Property> properties;
	@XmlElementWrapper(name = "notifications", namespace = "http://gltd.net/protocol/gtx")
	@XmlElement(name = "notification", namespace = "http://gltd.net/protocol/gtx")
	private Set<Notification> notifications;
	@XmlElementWrapper(name = "callIns", namespace = "http://gltd.net/protocol/gtx")
	@XmlElement(name = "callIn", namespace = "http://gltd.net/protocol/gtx")
	private Set<CallIn> callIns;

	public CallType getType() {
		return this.type;
	}

	public void setType(CallType type) {
		this.type = type;
	}

	public AudioType getAudioType() {
		return this.audioType;
	}

	public void setAudioType(AudioType audioType) {
		this.audioType = audioType;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getStartTime() {
		return this.startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return this.endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Set<Property> getProperties() {
		return this.properties;
	}

	public void setProperties(Set<Property> properties) {
		this.properties = properties;
	}

	public String getProperty(String id) {
		if ((this.properties == null) || this.properties.isEmpty()) {
			return null;
		}

		for (Property p : this.properties) {
			if (id.equals(p.getId())) {
				return p.getValue();
			}
		}

		return null;
	}

	public Set<Notification> getNotifications() {
		return this.notifications;
	}

	public void setNotifications(Set<Notification> notifications) {
		this.notifications = notifications;
	}

	public Set<CallIn> getCallIns() {
		return this.callIns;
	}

	public void setCallIns(Set<CallIn> callIns) {
		this.callIns = callIns;
	}

	public CallIn getCallIn(CallInType callInType) {
		if ((this.callIns == null) || this.callIns.isEmpty()) {
			return null;
		}

		for (CallIn c : this.callIns) {
			if (callInType.equals(c.getType())) {
				return c;
			}
		}

		return null;
	}
}
