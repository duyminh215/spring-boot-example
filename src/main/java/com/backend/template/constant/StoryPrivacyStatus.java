package com.backend.template.constant;

public enum StoryPrivacyStatus {
	
	ONLY_ME(0),
	FRIEND(1),
	PUBLIC(2);

	private int privacyStatus;
	public int getPrivacyStatus() {
		return privacyStatus;
	}
	public void setPrivacyStatus(int privacyStatus) {
		this.privacyStatus = privacyStatus;
	}
	private StoryPrivacyStatus(int privacyStatus) {
		this.privacyStatus = privacyStatus;
	}
}
