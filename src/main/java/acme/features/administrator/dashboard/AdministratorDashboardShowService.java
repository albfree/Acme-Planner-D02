/*
 * AdministratorDashboardShowService.java
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.Dashboard;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorDashboardShowService implements AbstractShowService<Administrator, Dashboard> {

	@Autowired
	protected AdministratorDashboardRepository repository;

	@Override
	public boolean authorise(final Request<Dashboard> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Dashboard> request, final Dashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "totalNumberOfPublicTasks", "totalNumberOfPrivateTasks", "totalNumberOfFinishedTasks", "totalNumberOfNonFinishedTasks", "averageTaskExecutionPeriods", "deviationTaskExecutionPeriods", "minimumTaskExecutionPeriod", "maximumTaskExecutionPeriod", "averageTaskWorkloads", "deviationTaskWorkloads", "minimumTaskWorkload", "maximumTaskWorkload");
	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {
		assert request != null;
		
		Dashboard result;
		result = new Dashboard();

		final Double totalNumberOfPublicTasks = this.repository.totalNumberOfPublicTasks() != null ? this.repository.totalNumberOfPublicTasks() : 0.;
		result.setTotalNumberOfPublicTasks(totalNumberOfPublicTasks);

		final Double totalNumberOfPrivateTasks = this.repository.totalNumberOfPrivateTasks() != null ? this.repository.totalNumberOfPrivateTasks() : 0.;
		result.setTotalNumberOfPrivateTasks(totalNumberOfPrivateTasks);

		final Double totalNumberOfFinishedTasks = this.repository.totalNumberOfFinishedTasks() != null ? this.repository.totalNumberOfFinishedTasks() : 0.;
		result.setTotalNumberOfFinishedTasks(totalNumberOfFinishedTasks);
		
		final Double totalNumberOfNonFinishedTasks = this.repository.totalNumberOfNonFinishedTasks() != null ? this.repository.totalNumberOfNonFinishedTasks() : 0.;
		result.setTotalNumberOfNonFinishedTasks(totalNumberOfNonFinishedTasks);
		
		final Double averageTaskExecutionPeriods = this.repository.averageTaskExecutionPeriods() != null ? this.repository.averageTaskExecutionPeriods() : 0.;
		result.setAverageTaskExecutionPeriods(averageTaskExecutionPeriods);

		final Double deviationTaskExecutionPeriods = this.repository.deviationTaskExecutionPeriods() != null ? this.repository.deviationTaskExecutionPeriods() : 0.;
		result.setDeviationTaskExecutionPeriods(deviationTaskExecutionPeriods);

		final Double minimumTaskExecutionPeriod = this.repository.minimumTaskExecutionPeriod() != null ? this.repository.minimumTaskExecutionPeriod() : 0.;
		result.setMinimumTaskExecutionPeriod(minimumTaskExecutionPeriod);
		
		final Double maximumTaskExecutionPeriod = this.repository.maximumTaskExecutionPeriod() != null ? this.repository.maximumTaskExecutionPeriod() : 0.;
		result.setMaximumTaskExecutionPeriod(maximumTaskExecutionPeriod);
		
		final Double averageTaskWorkloads = this.repository.averageTaskWorkloads() != null ? this.repository.averageTaskWorkloads() : 0.;
		result.setAverageTaskWorkloads(averageTaskWorkloads);

		final Double deviationTaskWorkloads = this.repository.deviationTaskWorkloads() != null ? this.repository.deviationTaskWorkloads() : 0.;
		result.setDeviationTaskWorkloads(deviationTaskWorkloads);

		final Double minimumTaskWorkload = this.repository.minimumTaskWorkload() != null ? this.repository.minimumTaskWorkload() : 0.;
		result.setMinimumTaskWorkload(minimumTaskWorkload);
		
		final Double maximumTaskWorkload = this.repository.maximumTaskWorkload() != null ? this.repository.maximumTaskWorkload() : 0.;
		result.setMaximumTaskWorkload(maximumTaskWorkload);

		return result;
	}

}
