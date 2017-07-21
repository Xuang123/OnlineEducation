package com.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractTCategory entity provides the base persistence definition of the
 * TCategory entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTCategory implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer level;
	private Integer pid;
	private Set TExams = new HashSet(0);
	private Set TQuestions = new HashSet(0);
	private Set TCourses = new HashSet(0);
	private Set TPapers = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractTCategory() {
	}

	/** full constructor */
	public AbstractTCategory(String name, Integer level, Integer pid,
			Set TExams, Set TQuestions, Set TCourses, Set TPapers) {
		this.name = name;
		this.level = level;
		this.pid = pid;
		this.TExams = TExams;
		this.TQuestions = TQuestions;
		this.TCourses = TCourses;
		this.TPapers = TPapers;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Set getTExams() {
		return this.TExams;
	}

	public void setTExams(Set TExams) {
		this.TExams = TExams;
	}

	public Set getTQuestions() {
		return this.TQuestions;
	}

	public void setTQuestions(Set TQuestions) {
		this.TQuestions = TQuestions;
	}

	public Set getTCourses() {
		return this.TCourses;
	}

	public void setTCourses(Set TCourses) {
		this.TCourses = TCourses;
	}

	public Set getTPapers() {
		return this.TPapers;
	}

	public void setTPapers(Set TPapers) {
		this.TPapers = TPapers;
	}

}