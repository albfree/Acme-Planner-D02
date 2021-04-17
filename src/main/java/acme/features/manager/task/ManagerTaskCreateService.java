/*
 * ManagerTaskCreateService.java
 *
 * Copyright (C) 2012-2021 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.manager.task;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.tasks.Task;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Manager;
import acme.framework.services.AbstractCreateService;

@Service
public class ManagerTaskCreateService implements AbstractCreateService<Manager, Task> {

	@Autowired
	protected ManagerTaskRepository repository;
	
	@Override
	public boolean authorise(final Request<Task> request) {
		assert request != null;
		
		return true;
	}
	
	@Override
	public void bind(final Request<Task> request, final Task entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}
	
	@Override
	public void unbind(final Request<Task> request, final Task entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "startExecutionPeriod", "endExecutionPeriod", "workload", "description", "share", "link");
		model.setAttribute("readonly", false);
	}
	
	@Override
	public Task instantiate(final Request<Task> request) {
		assert request != null;
		
		final Task result;
		Manager manager;
		
		result = new Task();
		manager = this.repository.findManagerById(request.getPrincipal().getActiveRoleId());
		result.setManager(manager);
		
		return result;
	}
	
	@Override
	public void validate(final Request<Task> request, final Task entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		if(!errors.hasErrors("workload")) {
			final Double workload = entity.getWorkload();
			final Double maxWorkload = entity.maxWorkload();
			errors.state(request, workload <= maxWorkload, "workload", "manager.task.form.error.max-workload-exceeded");
		}
		
		if(!errors.hasErrors("startExecutionPeriod") && !errors.hasErrors("endExecutionPeriod")) {
			final Date currentDate = new Date();
			final Date startExecutionPeriod = entity.getStartExecutionPeriod();
			final Date endExecutionPeriod = entity.getEndExecutionPeriod();
			errors.state(request, startExecutionPeriod.after(currentDate), "startExecutionPeriod", "manager.task.form.error.start-period-future");
			errors.state(request, endExecutionPeriod.after(currentDate), "endExecutionPeriod", "manager.task.form.error.end-period-future");
			errors.state(request, endExecutionPeriod.after(startExecutionPeriod), "endExecutionPeriod", "manager.task.form.error.period-invalid");
		}
	}
	
	@Override
	public void create(final Request<Task> request, final Task entity) {
		assert request != null;
		assert entity != null;
		
		this.repository.save(entity);
	}
}
