package org.springframework.samples.petclinic.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name="appointment")
public class Appointment extends BaseEntity {
	
	@Column(name="ownerid")
	@NotEmpty
	private Integer owner_id;
	@Column(name="petid")
	@NotEmpty
	private Integer pet_id;
	@Column(name="vetid")
	@NotEmpty
	private Integer vet_id;
	@Column(name="date")
	@NotEmpty
	private Date date;
	@Column(name="timeid")
	@NotEmpty
	
	private  Integer appointment_time_id;
	public Integer getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(Integer owner_id) {
		this.owner_id = owner_id;
	}
	public Integer getPet_id() {
		return pet_id;
	}
	public void setPet_id(Integer pet_id) {
		this.pet_id = pet_id;
	}
	public Integer getVet_id() {
		return vet_id;
	}
	public void setVet_id(Integer vet_id) {
		this.vet_id = vet_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getAppointment_time_id() {
		return appointment_time_id;
	}
	public void setAppointment_time_id(Integer appointment_time_id) {
		this.appointment_time_id = appointment_time_id;
	}
	
	

}
