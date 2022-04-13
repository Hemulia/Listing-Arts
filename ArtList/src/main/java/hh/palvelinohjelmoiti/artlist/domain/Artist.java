package hh.palvelinohjelmoiti.artlist.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "artist")
public class Artist {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long artistid;

	private String name;

	public Artist() {
		super();
	}

	public Artist(Long id, String name) {
		super();
		this.artistid = id;
		this.name = name;
	}

	public Long getId() {
		return artistid;
	}

	public void setId(Long id) {
		this.artistid = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Artist [Id=" + artistid + ", Name=" + name + "]";
	}

}
