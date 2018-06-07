package com.lyc.cloud.ip;

public class HelloMessage {

	private String toUser;

	private String name;

	private String sendMessageBody;

	private String imageUrl;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getToUser() {
		return toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	public void setSendMessageBody(String sendMessageBody) {
		this.sendMessageBody = sendMessageBody;
	}

	public String getSendMessageBody() {
		return sendMessageBody;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
