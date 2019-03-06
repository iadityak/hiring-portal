package com.idemia.hiring.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "resume")
public class Resume {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer resumeId;

	private String candidateId;
	
	private String filetype;
	@Lob
	private byte[] resume;

	public Integer getResumeId() {
		return resumeId;
	}

	public void setResumeId(Integer resumeId) {
		this.resumeId = resumeId;
	}

	public String getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public byte[] getResume() {
		return resume;
	}

	public void setResume(byte[] resume) {
		this.resume = resume;
	}

	public Resume(String candidateId, String filetype, byte[] resume) {
		super();
		this.candidateId = candidateId;
		this.filetype = filetype;
		this.resume = resume;
	}

	public Resume() {
		super();
	}

}
