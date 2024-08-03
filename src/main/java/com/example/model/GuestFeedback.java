package com.example.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "guestFeedback")
public class GuestFeedback {


    @Id
    @Column(name = "feedbackId")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "id_generator")
	@TableGenerator(name = "id_generator", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_value", pkColumnValue = "task_gen", initialValue = 10000000, allocationSize = 1)
    private Long feedbackId;

    @Column(name = "rating")
    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating must be at most 5")
    private Byte rating;

    @ManyToOne
    @JoinColumn(name = "guestEmail", referencedColumnName = "guestEmail")
    private GuestProfile guestProfile;

    @Column(name = "description", length = 1000)
    @Size(max = 1000, message = "Description must be less than or equal to 1000 characters")
    private String description;

	public Long getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(Long feedbackId) {
		this.feedbackId = feedbackId;
	}

	public Byte getRating() {
		return rating;
	}

	public void setRating(Byte rating) {
		this.rating = rating;
	}

	public GuestProfile getGuestProfile() {
		return guestProfile;
	}

	public void setGuestProfile(GuestProfile guestProfile) {
		this.guestProfile = guestProfile;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public GuestFeedback(Long feedbackId, Byte rating, GuestProfile guestProfile, String description) {
		super();
		this.feedbackId = feedbackId;
		this.rating = rating;
		this.guestProfile = guestProfile;
		this.description = description;
	}

	public GuestFeedback() {
		super();
	}

}
