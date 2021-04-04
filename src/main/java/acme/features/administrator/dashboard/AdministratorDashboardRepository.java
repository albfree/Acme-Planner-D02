/*
 * AdministratorDashboardRepository.java
 *
 * Copyright (C) 2012-2021 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.administrator.dashboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	@Query("select count(t) from Task t where t.share = 'public'")
	Double totalNumberOfPublicTasks();

	@Query("select count(t) from Task t where t.share = 'private'")
	Double totalNumberOfPrivateTasks();

	@Query("select count(t) from Task t where t.endExecutionPeriod < CURRENT_TIMESTAMP")
	Double totalNumberOfFinishedTasks();
	
	@Query("select count(t) from Task t where t.endExecutionPeriod > CURRENT_TIMESTAMP")
	Double totalNumberOfNonFinishedTasks();
	
	@Query("select count(t) from Task t")
	Double averageTaskExecutionPeriods();

	@Query("select count(t) from Task t")
	Double deviationTaskExecutionPeriods();

	@Query("select count(t) from Task t")
	Double minimumTaskExecutionPeriod();
	
	@Query("select count(t) from Task t")
	Double maximumTaskExecutionPeriod();
	
	@Query("select avg(t.workload) from Task t")
	Double averageTaskWorkloads();

	@Query("select count(t) from Task t")
	Double deviationTaskWorkloads();

	@Query("select min(t.workload) from Task t")
	Double minimumTaskWorkload();
	
	@Query("select max(t.workload) from Task t")
	Double maximumTaskWorkload();

}