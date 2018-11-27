package com.spotigram.models;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="artists")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ArtistsModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="artist_id")
	private int id;
	@Column(name="artist_name")
	private String name;
	@Column(name="date_start")
	private Timestamp startDate;
	@Column(name="date_finish")
	private Timestamp endDate;
	
	
	public ArtistsModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ArtistsModel(int id, String name, Timestamp startDate, Timestamp endDate) {
		super();
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Timestamp getStartDate() {
		return startDate;
	}


	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}


	public Timestamp getEndDate() {
		return endDate;
	}


	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArtistsModel other = (ArtistsModel) obj;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ArtistsModel [id=" + id + ", name=" + name + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
	
	
}
