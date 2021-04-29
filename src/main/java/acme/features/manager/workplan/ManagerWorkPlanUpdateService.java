/*
 * ManagerWorkPlanUpdateService.java
 *
 * Copyright (C) 2012-2021 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.manager.workplan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Manager;
import acme.entities.tasks.TaskShare;
import acme.entities.workplans.WorkPlan;
import acme.entities.workplans.WorkPlanShare;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractUpdateService;

@Service
public class ManagerWorkPlanUpdateService implements AbstractUpdateService<Manager, WorkPlan> {

	@Autowired
	protected ManagerWorkPlanRepository repository;
	
	@Override
	public boolean authorise(final Request<WorkPlan> request) {
		assert request != null;
		
		boolean result;
		int workPlanId;
		WorkPlan workPlan;
		int managerId;

		workPlanId = request.getModel().getInteger("id");
		workPlan = this.repository.findWorkPlanById(workPlanId);
		managerId = request.getPrincipal().getActiveRoleId();
		
		result = workPlan.getManager().getId() == managerId;
		
		return result;
	}
	
	@Override
	public void bind(final Request<WorkPlan> request, final WorkPlan entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}
	
	@Override
	public void unbind(final Request<WorkPlan> request, final WorkPlan entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "startExecutionPeriod", "endExecutionPeriod", "share", "totalWorkload");
	}
	
	@Override
	public WorkPlan findOne(final Request<WorkPlan> request) {
		assert request != null;

		WorkPlan result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findWorkPlanById(id);

		return result;
	}
	
	@Override
	public void validate(final Request<WorkPlan> request, final WorkPlan entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		if (!errors.hasErrors("share") && entity.getShare().equals(WorkPlanShare.PUBLIC)) {
			errors.state(request, entity.getTasks().stream().noneMatch(task -> task.getShare().equals(TaskShare.PRIVATE)),
				"share", "manager.work-plan.form.error.has-private-tasks");
		}
		
		if (!errors.hasErrors("startExecutionPeriod") && !errors.hasErrors("endExecutionPeriod")) {
			errors.state(request, entity.getEndExecutionPeriod().after(entity.getStartExecutionPeriod()), 
				"endExecutionPeriod", "manager.work-plan.form.error.period-invalid");
		}
		
		if (!entity.getTasks().isEmpty()) {
			errors.state(request, entity.getTasks().stream().noneMatch(task -> task.getStartExecutionPeriod().before(entity.getStartExecutionPeriod())),
				"startExecutionPeriod", "manager.work-plan.form.error.period-tasks-invalid");
			
			errors.state(request, entity.getTasks().stream().noneMatch(task -> task.getEndExecutionPeriod().after(entity.getEndExecutionPeriod())),
				"endExecutionPeriod", "manager.work-plan.form.error.period-tasks-invalid");
		}
	}
	
	@Override
	public void update(final Request<WorkPlan> request, final WorkPlan entity) {
		assert request != null;
		assert entity != null;
		
		this.repository.save(entity);
	}
}
