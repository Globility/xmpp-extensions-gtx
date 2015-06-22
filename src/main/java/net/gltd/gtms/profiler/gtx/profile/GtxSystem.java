package net.gltd.gtms.profiler.gtx.profile;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

import net.gltd.util.constraints.IsAlphanumericNoWhitespace;
import net.gltd.util.constraints.NotBlank;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@XmlType(propOrder = { "id", "type", "category", "enabled", "properties", "features" })
@XmlAccessorType(XmlAccessType.FIELD)
public class GtxSystem {

	@NotBlank
	@IsAlphanumericNoWhitespace
	@XmlAttribute(required = true)
	private String id;

	@NotBlank
	@IsAlphanumericNoWhitespace
	@XmlAttribute(required = true)
	private String type;

	@NotBlank
	@IsAlphanumericNoWhitespace
	@XmlAttribute
	private String category;

	@XmlAttribute(required = true)
	private boolean enabled;

	@XmlElementWrapper(name = "properties", namespace = "http://gltd.net/protocol/gtx/properties")
	@XmlElement(name = "property", namespace = "http://gltd.net/protocol/gtx/properties")
	private Set<Property> properties;

	@XmlElementWrapper(name = "features", namespace = "http://gltd.net/protocol/gtx/features")
	@XmlElement(name = "feature", namespace = "http://gltd.net/protocol/gtx/features")
	private Set<Feature> features;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Set<Property> getProperties() {
		return this.properties;
	}

	public void setProperties(Set<Property> properties) {
		this.properties = properties;
	}

	public Set<Feature> getFeatures() {
		return this.features;
	}

	public void setFeatures(Set<Feature> features) {
		this.features = features;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	public boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void updateProperty(String id, String value, boolean required) {
		Validate.notNull(id);
		Validate.notNull(value);
		Validate.notNull(required);

		if (this.properties == null) {
			this.properties = new HashSet<Property>();
		}

		Property p = new Property();
		p.setId(id);
		p.setValue(value);
		p.setRequired(required);

		this.properties.remove(p);
		this.properties.add(p);
	}

	public void updateProperty(String id, String value) {
		this.updateProperty(id, value, false);
	}

	public void updateProperty(Property property) {
		Validate.notNull(property);
		Validate.notNull(property.getId());
		Validate.notNull(property.getValue());

		if (this.properties == null) {
			this.properties = new HashSet<Property>();
		}

		this.properties.remove(property);
		this.properties.add(property);
	}

	public void updateFeature(String id, String value) {
		Validate.notNull(id);
		Validate.notNull(value);

		if (this.features == null) {
			this.features = new HashSet<Feature>();
		}

		Feature f = new Feature();
		f.setId(id);
		f.setValue(value);

		this.features.remove(f);
		this.features.add(f);
	}

	public void updateFeature(Feature feature) {
		Validate.notNull(feature);
		Validate.notNull(feature.getId());
		Validate.notNull(feature.getValue());

		if (this.features == null) {
			this.features = new HashSet<Feature>();
		}

		this.features.remove(feature);
		this.features.add(feature);
	}

	public Property getProperty(String id) {
		if ((this.properties == null) || (id == null)) {
			return null;
		}

		for (Property p : this.properties) {
			if (id.equals(p.getId())) {
				return p;
			}
		}

		return null;
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
		GtxSystem rhs = (GtxSystem) obj;
		return new EqualsBuilder().append(this.id, rhs.getId()).isEquals();
	}

	@Override
	public int hashCode() {
		// you pick a hard-coded, randomly chosen, non-zero, odd number, ideally
		// different for each class
		return new HashCodeBuilder(37, 37).append(this.id).toHashCode();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}
