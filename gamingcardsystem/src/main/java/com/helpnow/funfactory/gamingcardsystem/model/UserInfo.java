package com.helpnow.funfactory.gamingcardsystem.model;

public class UserInfo {

	private UserAttributes userAttributes;

	private Card card;
	
	public UserInfo(UserAttributes userAttributes, Card card) {
		this.userAttributes = userAttributes;
		this.card = card;
	}
	
	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public UserAttributes getUserBasicDetails() {
		return userAttributes;
	}

	public void setUserBasicDetails(UserAttributes userAttributes) {
		this.userAttributes = userAttributes;
	}
}
