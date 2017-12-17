package com.elib.api.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class StoryMember implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long storyMemberId;
	
	@Column(nullable = false)
	String firstName;
	
	@Column(nullable = false)
	String lastName;
	
	@Column(nullable = false)
	String email;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "chatId")
	ChatTemplate chatTemplate;

	@OneToMany(mappedBy = "storyMember", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	List<Message> message;
}
