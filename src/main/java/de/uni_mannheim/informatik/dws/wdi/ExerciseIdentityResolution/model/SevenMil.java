/*
 * Copyright (c) 2017 Data and Web Science Group, University of Mannheim, Germany (http://dws.informatik.uni-mannheim.de/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */
package de.uni_mannheim.informatik.dws.wdi.ExerciseIdentityResolution.model;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import de.uni_mannheim.informatik.dws.winter.model.AbstractRecord;
import de.uni_mannheim.informatik.dws.winter.model.Matchable;

/**
 * A {@link AbstractRecord} representing a company from the 7.1M dataset.
 * 
 * 
 */
public class SevenMil implements Matchable {

	/*
	 * example entry <movie> <id>academy_awards_2</id> <title>True Grit</title>
	 * <director> <name>Joel Coen and Ethan Coen</name> </director> <actors>
	 * <actor> <name>Jeff Bridges</name> </actor> <actor> <name>Hailee
	 * Steinfeld</name> </actor> </actors> <date>2010-01-01</date> </movie>
	 */

	protected String id;
	protected String provenance;
	private List<String> industries;
	protected String name;
	private Integer foundingYear;
	private String country;
	private String city;
	private long numberOfEmployees;

	public SevenMil(String identifier, String provenance) {
		id = identifier;
		this.provenance = provenance;
		industries = new LinkedList<>();
	}

	@Override
	public String getIdentifier() {
		return id;
	}

	@Override
	public String getProvenance() {
		return provenance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getIndustries() {
		return industries;
	}

	public void setIndustries(List<String> industries) {
		this.industries = industries;
	}

	public Integer getFoundingYear() {
		return foundingYear;
	}

	public void setFoundingYear(Integer foundingYear) {
		this.foundingYear = foundingYear;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getcity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(long numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	@Override
	public String toString() {
		return String.format("[Company %s: %s / %s / %s]", getIdentifier(), getName(),
				getCountry(), getFoundingYear().toString());
	}

	@Override
	public int hashCode() {
		return getIdentifier().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof SevenMil){
			return this.getIdentifier().equals(((SevenMil) obj).getIdentifier());
		}else
			return false;
	}
}
