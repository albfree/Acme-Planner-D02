/*
 * ManagerWorkPlanShowService.java
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

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Manager;
import acme.entities.workplans.WorkPlan;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class ManagerWorkPlanShowService implements AbstractShowService<Manager, WorkPlan> {

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
	public void unbind(final Request<WorkPlan> request, final WorkPlan entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "startExecutionPeriod", "endExecutionPeriod", "share", "totalWorkload");
		
		model.setAttribute("hasTasks", !entity.getTasks().isEmpty());
		
		if (!entity.getTasks().isEmpty()) {
			final Date minDate = entity.getTasks().stream().map(task -> task.getStartExecutionPeriod()).min(Date::compareTo).get();
			final Date maxDate = entity.getTasks().stream().map(task -> task.getStartExecutionPeriod()).max(Date::compareTo).get();
			
			final Calendar minCalendar = Calendar.getInstance();
			minCalendar.setTime(minDate);
			minCalendar.set(Calendar.DAY_OF_MONTH, -1);
			minCalendar.set(Calendar.HOUR_OF_DAY, 8);
			minCalendar.set(Calendar.MINUTE, 0);
			
			final Calendar maxCalendar = Calendar.getInstance();
			maxCalendar.setTime(maxDate);
			maxCalendar.add(Calendar.DAY_OF_MONTH, 1);
			maxCalendar.set(Calendar.HOUR_OF_DAY, 17);
			maxCalendar.set(Calendar.MINUTE, 0);
			
			if (request.getLocale().equals(Locale.ENGLISH)) {
				model.setAttribute("suggestedMessage", "Suggested start date: " + minCalendar.getTime().toString() +
					"/ Suggested finish date: " + maxCalendar.getTime().toString());
			} else {
				model.setAttribute("suggestedMessage", "Fecha de inicio recomendada: " + minCalendar.getTime().toString() +
					"/ Fecha de fin recomendada: " + maxCalendar.getTime().toString());
			}
		}
	}

	@Override
	public WorkPlan findOne(final Request<WorkPlan> request) {
		assert request != null;

		WorkPlan result;
		int workPlanId;

		workPlanId = request.getModel().getInteger("id");
		result = this.repository.findWorkPlanById(workPlanId);

		return result;
	}

}
