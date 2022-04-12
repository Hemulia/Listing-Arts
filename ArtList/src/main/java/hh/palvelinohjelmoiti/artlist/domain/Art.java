package hh.palvelinohjelmoiti.artlist.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Art {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long id;

	private String name;

	private int year;

	private String description;

	@ManyToOne
	@JoinColumn(name = "artistid")
	@JsonIgnoreProperties("arts")
	private Artist artist;

	public Art() {
		super();
	}

	public Art(Long id, String name, int year, String description, Artist artist) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.description = description;
		this.artist = artist;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public Artist getArtist() {
		return artist;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		if (this.artist == null)
			return "Art [Id=" + id + ", Name=" + name + ", Year=" + year + ", Description=" + description + ", Artist ="
					+ this.getArtist() + "]";
		else
			return "Art [Id=" + id + ", Name=" + name + ", Year=" + year + ", Description=" + description + "]";

	}
}
