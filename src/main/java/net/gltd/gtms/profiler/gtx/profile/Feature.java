package net.gltd.gtms.profiler.gtx.profile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

import net.gltd.util.constraints.IsAlphanumericNoWhitespace;
import net.gltd.util.constraints.NotBlank;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@XmlRootElement(name = "feature", namespace = "http://gltd.net/protocol/gtx/features")
@XmlType(propOrder = { "id"/* , "feature" */})
@XmlAccessorType(XmlAccessType.FIELD)
public class Feature {

	@NotBlank
	@IsAlphanumericNoWhitespace
	@XmlAttribute(required = true)
	String id;

	// @XmlElement
	// Feature feature;

	@NotBlank
	@IsAlphanumericNoWhitespace
	@XmlValue
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
		Feature rhs = (Feature) obj;
		return new EqualsBuilder().append(this.id, rhs.getId()).isEquals();
	}

	@Override
	public int hashCode() {
		// you pick a hard-coded, randomly chosen, non-zero, odd number, ideally
		// different for each class
		return new HashCodeBuilder(47, 47).append(this.id).toHashCode();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}
