package com.example.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "guestGrievance")
public class GuestGrievance {

	@Id
	@Column(name = "grievanceId")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "id_generator")
	@TableGenerator(name = "id_generator", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_value", pkColumnValue = "task_gen", initialValue = 10000000, allocationSize = 1)
	@NotNull(message = "Grievance ID cannot be null")
	private Long grievanceId;

	@ManyToOne
	@JoinColumn(name = "guestEmail", referencedColumnName = "guestEmail")
	private GuestProfile guestProfile;

	@Column(name = "subject", length = 100, nullable = false)
	@Size(max = 100, message = "Subject must be less than or equal to 100 characters")
	private String subject;

	@Column(name = "description", length = 1000, nullable = false)
	@Size(max = 1000, message = "Description must be less than or equal to 1000 characters")
	private String description;

	@Column(name = "timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	@PastOrPresent(message = "Timestamp must be in the past or present")
	private Date timestamp;

	@Column(name = "resolutionStatus")
	@Enumerated(EnumType.STRING)
	private ResolutionStatus status;

	public Long getGrievanceId() {
		return grievanceId;
	}

	public void setGrievanceId(Long grievanceId) {
		this.grievanceId = grievanceId;
	}

	public GuestProfile getGuestProfile() {
		return guestProfile;
	}

	public void setGuestProfile(GuestProfile guestProfile) {
		this.guestProfile = guestProfile;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public ResolutionStatus getStatus() {
		return status;
	}

	public void setStatus(ResolutionStatus status) {
		this.status = status;
	}

	public GuestGrievance(Long grievanceId, GuestProfile guestProfile, String subject, String description,
			Date timestamp, ResolutionStatus status) {
		super();
		this.grievanceId = grievanceId;
		this.guestProfile = guestProfile;
		this.subject = subject;
		this.description = description;
		this.timestamp = timestamp;
		this.status = status;
	}

	public GuestGrievance() {
		super();
	}

}
