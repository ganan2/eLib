package com.elib.api.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class StoryNode implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long nodeId;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String subject;
	
	@Column(name = "include")
	private Boolean include;
	
	@Column(name = "clear")
	private Boolean clear;
	
	@Column(name = "resolve")
	private Boolean resolve;
	
	@Column(name = "important")
	private Boolean important;
	
	@Column(name = "personal")
	private Boolean personal;
	
	@Column(name = "warning")
	private Boolean warning;
	
	@OneToOne(mappedBy = "storyNode", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private ChatTemplate chatTemplate;
}
