package net.gltd.gtms.profiler.gtx.profile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import net.gltd.util.constraints.IsAlphanumericNoWhitespace;
import net.gltd.util.constraints.NotBlank;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@XmlRootElement(name = "property", namespace = "http://gltd.net/protocol/gtx/properties")
@XmlType(propOrder = { "id", "required", "value" })
@XmlAccessorType(XmlAccessType.FIELD)
public class Property {

	public static final String VIDEO_USER_SESSION_TOKEN = "userSessionToken";
	public static final String VIDEO_INVITATION_TEXT = "invitationText";

	@NotBlank
	@IsAlphanumericNoWhitespace
	@XmlAttribute(required = true)
	String id;

	@XmlAttribute
	Boolean required = false;

	@NotBlank
	@IsAlphanumericNoWhitespace
	@XmlElement
	String value;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Boolean getRequired() {
		return this.required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != this.getClass()) {
			return false;
		}
		Property rhs = (Property) obj;
		return new EqualsBuilder().append(this.id, rhs.getId()).isEquals();
	}

	@Override
	public int hashCode() {
		// you pick a hard-coded, randomly chosen, non-zero, odd number, ideally different for each class
		return new HashCodeBuilder(17, 17).append(this.id).toHashCode();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}
