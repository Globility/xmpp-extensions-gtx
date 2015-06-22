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

@XmlType(propOrder = { "id", "properties", "systems" })
@XmlAccessorType(XmlAccessType.FIELD)
public class Profile {

	@NotBlank
	@IsAlphanumericNoWhitespace
	@XmlAttribute(required = true)
	String id;

	@XmlElementWrapper(name = "properties", namespace = "http://gltd.net/protocol/gtx/properties")
	@XmlElement(name = "property", namespace = "http://gltd.net/protocol/gtx/properties")
	private Set<Property> properties;

	@XmlElementWrapper(name = "systems", namespace = "http://gltd.net/protocol/gtx/profile")
	@XmlElement(name = "system", namespace = "http://gltd.net/protocol/gtx/profile")
	private Set<GtxSystem> systems;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Set<Property> getProperties() {
		return this.properties;
	}

	public void setProperties(Set<Property> properties) {
		this.properties = properties;
	}

	public Set<GtxSystem> getSystems() {
		return this.systems;
	}

	public void setSystems(Set<GtxSystem> systems) {
		this.systems = systems;
	}

	public void updateProperty(String id, String value) {
		Validate.notNull(id, "Property ID invalid");
		Validate.notNull(value, "Property value invalid");

		if (this.properties == null) {
			this.properties = new HashSet<Property>();
		}

		Property p = new Property();
		p.setId(id);
		p.setValue(value);

		this.properties.remove(p);
		this.properties.add(p);
	}

	public void updateProperty(Property property) {
		Validate.notNull(property);
		Validate.notNull(property.getId(), "Property invalid");
		Validate.notNull(property.getId(), "Property ID invalid");
		Validate.notNull(property.getValue(), "Property value invalid");

		if (this.properties == null) {
			this.properties = new HashSet<Property>();
		}

		this.properties.remove(property);
		this.properties.add(property);
	}

	public GtxSystem addGtxSystem(String id, String type, String category) {
		Validate.notNull(id, "System ID invalid");
		Validate.notNull(type, "System type invalid");
		Validate.notNull(category, "System category invalid");

		if (this.systems == null) {
			this.systems = new HashSet<GtxSystem>();
		}

		GtxSystem system = new GtxSystem();
		system.setId(id);
		system.setType(type);
		system.setCategory(category);

		this.systems.remove(system); // drop any existing with same ID
		this.systems.add(system);
		return system;
	}

	public GtxSystem addGtxSystem(GtxSystem system) {
		Validate.notNull(system);
		Validate.notNull(system.getId(), "System invalid");
		Validate.notNull(system.getId(), "System ID invalid");
		Validate.notNull(system.getType(), "System type invalid");
		Validate.notNull(system.getCategory(), "System category invalid");

		if (this.systems == null) {
			this.systems = new HashSet<GtxSystem>();
		}

		this.systems.remove(system); // drop any existing with same ID
		this.systems.add(system);
		return system;
	}

	public GtxSystem getGtxSystem(String id) {
		if ((this.systems == null) || (id == null)) {
			return null;
		}

		for (GtxSystem gtxSystem : this.systems) {
			if (id.equals(gtxSystem.getId())) {
				return gtxSystem;
			}
		}

		return null;
	}

	public Set<GtxSystem> getGtxSystemsByType(String type) {
		if ((this.systems == null) || (type == null)) {
			return new HashSet<GtxSystem>();
		}

		Set<GtxSystem> typeSystems = new HashSet<GtxSystem>();
		for (GtxSystem gtxSystem : this.systems) {
			if (type.equals(gtxSystem.getType())) {
				typeSystems.add(gtxSystem);
			}
		}

		return typeSystems;
	}

	public Set<GtxSystem> getGtxSystemsByCategory(String category) {
		if ((this.systems == null) || (category == null)) {
			return new HashSet<GtxSystem>();
		}

		Set<GtxSystem> typeSystems = new HashSet<GtxSystem>();
		for (GtxSystem gtxSystem : this.systems) {
			if (category.equals(gtxSystem.getCategory())) {
				typeSystems.add(gtxSystem);
			}
		}

		return typeSystems;
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
		Profile rhs = (Profile) obj;
		return new EqualsBuilder().append(this.id, rhs.getId()).isEquals();
	}

	@Override
	public int hashCode() {
		// you pick a hard-coded, randomly chosen, non-zero, odd number, ideally
		// different for each class
		return new HashCodeBuilder(27, 27).append(this.id).toHashCode();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}
