package com.spring.main.models;

public class Student {
	private String cin;
	private String cne;
	private String nom;
	private String prenom;
	private String dateNaissance;
	
	private String cinPere;
	private String nomPere;
	private String prenomPere;
	
	private String cinMere;
	private String nomMere;
	private String prenomMere;
	
	private String couvertureCNSS;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getCne() {
		return cne;
	}

	public void setCne(String cne) {
		this.cne = cne;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getCinPere() {
		return cinPere;
	}

	public void setCinPere(String cinPere) {
		this.cinPere = cinPere;
	}

	public String getNomPere() {
		return nomPere;
	}

	public void setNomPere(String nomPere) {
		this.nomPere = nomPere;
	}

	public String getPrenomPere() {
		return prenomPere;
	}

	public void setPrenomPere(String prenomPere) {
		this.prenomPere = prenomPere;
	}

	public String getCinMere() {
		return cinMere;
	}

	public void setCinMere(String cinMere) {
		this.cinMere = cinMere;
	}

	public String getNomMere() {
		return nomMere;
	}

	public void setNomMere(String nomMere) {
		this.nomMere = nomMere;
	}

	public String getPrenomMere() {
		return prenomMere;
	}

	public void setPrenomMere(String prenomMere) {
		this.prenomMere = prenomMere;
	}

	public String getCouvertureCNSS() {
		return couvertureCNSS;
	}

	public void setCouvertureCNSS(String couvertureCNSS) {
		this.couvertureCNSS = couvertureCNSS;
	}

	@Override
	public String toString() {
		return "Student [cin=" + cin + ", cne=" + cne + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance="
				+ dateNaissance + ", cinPere=" + cinPere + ", nomPere=" + nomPere + ", prenomPere=" + prenomPere
				+ ", cinMere=" + cinMere + ", nomMere=" + nomMere + ", prenomMere=" + prenomMere + "]";
	}
	
}
