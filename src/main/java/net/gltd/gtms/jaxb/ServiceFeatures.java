package net.gltd.gtms.jaxb;


public enum ServiceFeatures {
	VideoUrl("video#url"), AudioUrl("audio#url"), VideoStream("video#stream"), AudioStream("audio#stream"), AudioGateway("audio#gateway");

	private final String namespaceSuffix;

	private ServiceFeatures(String namespaceSuffix) {
		this.namespaceSuffix = namespaceSuffix;
	}

	public String getNamespaceSuffix() {
		return this.namespaceSuffix;
	}
}
