package com.organicgarden.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
	private String email;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Plant> plants;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private List<Achievment> achievments;

    private int points = 0;

	public User() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }

    public List<Achievment> getAchievments() {
        return achievments;
    }

    public void setAchievments(List<Achievment> achievments) {
        this.achievments = achievments;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
