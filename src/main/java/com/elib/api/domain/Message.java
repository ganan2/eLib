package com.elib.api.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Message implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long messageId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	StoryMember storyMember;
	
	@Column(nullable = false)
	String message;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "chatId")
	ChatTemplate chatTemplate;
}
