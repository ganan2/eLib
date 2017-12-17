package com.elib.api.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ChatTemplate implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long chatId;
	
	@OneToMany(mappedBy = "chatTemplate", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Message> messageList;
	
	@OneToMany(mappedBy = "chatTemplate", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<StoryMember> storyMemberSet;
	
	@Column(nullable = false)
	private Date messageDate;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "nodeId")
	private StoryNode storyNode;
}
