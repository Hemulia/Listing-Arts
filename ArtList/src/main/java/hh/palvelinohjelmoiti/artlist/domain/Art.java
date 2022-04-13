package hh.palvelinohjelmoiti.artlist.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "art")
public class Art {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long id;
	private String name;
	private String artist;
	private int year;
	private String description;

	@ManyToOne
	@JoinColumn(name = "typeid")
	@JsonIgnoreProperties("arts")
	private Type type;

	public Art() {
		super();
	}

	public Art(Long id, String name, String artist, int year, String description, Type type) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.description = description;
		this.artist = artist;
		this.type = type;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Type getType() {
		return type;
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
		if (this.type == null)
			return "Art [Id=" + id + ", Name=" + name + ", Artist=" + artist + ", Year=" + year + ", Description="
					+ description + ", Type =" + this.getType() + "]";
		else
			return "Art [Id=" + id + ", Name=" + name + ", Artist=" + artist + ", Year=" + year + ", Description="
					+ description + "]";

	}
}
