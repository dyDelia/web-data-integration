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
package de.uni_mannheim.informatik.dws.wdi.ExerciseIdentityResolution.Comparators.ft_db;

import de.uni_mannheim.informatik.dws.winter.matching.rules.comparators.Comparator;
import de.uni_mannheim.informatik.dws.winter.matching.rules.comparators.ComparatorLogger;
import de.uni_mannheim.informatik.dws.winter.model.Correspondence;
import de.uni_mannheim.informatik.dws.winter.model.Matchable;
import de.uni_mannheim.informatik.dws.winter.model.defaultmodel.Attribute;
import de.uni_mannheim.informatik.dws.winter.similarity.numeric.AbsoluteDifferenceSimilarity;
import de.uni_mannheim.informatik.dws.wdi.ExerciseIdentityResolution.model.DBpedia;
import de.uni_mannheim.informatik.dws.wdi.ExerciseIdentityResolution.model.Movie;

/**
 * {@link Comparator} for {@link Movie}s based on the {@link Movie#getTitle()}
 * value and their {@link LevenshteinSimilarity} value.
 * 
 * @author Oliver Lehmberg (oli@dwslab.de)
 * 
 */
public class NumberOfEmployeesComparatorAbsoluteDifferenceSimilarity implements Comparator<DBpedia, Attribute> {
	
	private static final long serialVersionUID = 1L;
	private AbsoluteDifferenceSimilarity sim = new AbsoluteDifferenceSimilarity(1000000.0);
	
	private ComparatorLogger comparisonLog;

	@Override
	public double compare(
			DBpedia record1,
			DBpedia record2,
			Correspondence<Attribute, Matchable> schemaCorrespondences) {
		
		double s1 = record1.getNumberOfEmployees();
		double s2 = record2.getNumberOfEmployees();
		
		double similarity = sim.calculate(s1, s2);
		
		if(this.comparisonLog != null){
			this.comparisonLog.setComparatorName(getClass().getName());
		
			this.comparisonLog.setRecord1Value(Double.toString(s1));
			this.comparisonLog.setRecord2Value(Double.toString(s2));
    	
			this.comparisonLog.setSimilarity(Double.toString(similarity));
		}
		
		return similarity;
		
	}

	@Override
	public ComparatorLogger getComparisonLog() {
		return this.comparisonLog;
	}

	@Override
	public void setComparisonLog(ComparatorLogger comparatorLog) {
		this.comparisonLog = comparatorLog;
	}

}