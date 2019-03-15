
package com.idemia.hiring.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.idemia.hiring.enums.RatingEnum;

/***
 * 
 * 
 * @author G521917(aman.ahuja@idemia.com)
 * 
 *         This object contains feedback information submitted by a particular
 *         Candidate after interview for a particular interview round.
 *
 */
@Entity(name = "candfeedback")
public class CandidateFeedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cand_feed_id")
	private Integer candFeedId;

	@JoinColumn(name = "feed_candidate")
	@ManyToOne(fetch = FetchType.EAGER)
	private Candidate candFeedCandidate;

	@JoinColumn(name = "feed_round")
	@OneToOne
	private Interview candFeedRound;

	@Column(name = "cand_feed_rating")
	private RatingEnum candFeedOverallRating;

	@Column(name = "cand_comments", length = 160)
	private String candFeedComments;

	@Column(name = "feed_creation_time")
	private LocalDateTime candFeedCreated;

	public Integer getCandFeedId() {
		return candFeedId;
	}

	public void setCandFeedId(Integer candFeedId) {
		this.candFeedId = candFeedId;
	}

	public Candidate getCandFeedCandidate() {
		return candFeedCandidate;
	}

	public void setCandFeedCandidate(Candidate candFeedCandidate) {
		this.candFeedCandidate = candFeedCandidate;
	}

	public Interview getCandFeedRound() {
		return candFeedRound;
	}

	public void setCandFeedRound(Interview candFeedRound) {
		this.candFeedRound = candFeedRound;
	}

	public RatingEnum getCandFeedOverallRating() {
		return candFeedOverallRating;
	}

	public void setCandFeedOverallRating(RatingEnum candFeedOverallRating) {
		this.candFeedOverallRating = candFeedOverallRating;
	}

	public String getCandFeedComments() {
		return candFeedComments;
	}

	public void setCandFeedComments(String candFeedComments) {
		this.candFeedComments = candFeedComments;
	}

	public LocalDateTime getCandFeedCreated() {
		return candFeedCreated;
	}

	public void setCandFeedCreated(LocalDateTime candFeedCreated) {
		this.candFeedCreated = candFeedCreated;
	}

}
