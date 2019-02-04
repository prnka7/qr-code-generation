package com.emxcel.qrcode.entity;



public class Data {
	private String fullName;
	private String occupation;
	private String address;
	private String website;
	private String facebook;
	private String twitter;
	private String linkedIn;

	public Data() {
	}

	public Data(String fullname, String occupation, String address, String website, String facebook, String twitter,
			String linkedin) {
		this.setFullName(fullname);
		this.occupation = occupation;
		this.address = address;
		this.website = website;
		this.facebook = facebook;
		this.twitter = twitter;
		this.setLinkedIn(linkedin);
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String toString() {
		return fullName + "" + occupation + "" + address + "" + website + "" + facebook + "" + twitter + "" + linkedIn;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getLinkedIn() {
		return linkedIn;
	}

	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}

}
