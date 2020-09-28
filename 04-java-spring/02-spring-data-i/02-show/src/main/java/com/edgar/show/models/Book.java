package com.edgar.show.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name="books")
public class Book {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)

	private Long id;
	@Size(min = 3, max = 20)
    private String title;
    
    @Size(min = 5, max = 200)
    private String description;
    
    @Size(min = 3, max = 40)
    private String language;
    
    @Min(100)
    private int pages;
    
    public Book() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	
	
}
