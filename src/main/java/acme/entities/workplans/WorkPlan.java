
package acme.entities.workplans;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import acme.entities.roles.Manager;
import acme.entities.tasks.Task;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class WorkPlan extends DomainEntity {

	//Serialisation identifier 

	protected static final long		serialVersionUID	= 1L;

	//Attributes

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	protected Date					startExecutionPeriod;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	protected Date					endExecutionPeriod;

	@NotNull
	protected WorkPlanShare			share;

	//Derived attributes

	@Transient
	public Double totalWorkload() {

		return this.tasks.stream().map(Task::getWorkload).reduce(0., Double::sum);
	}
	
	//Relationships
	
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	protected Collection<@Valid Task>	tasks;
	
	@NotNull
	@Valid
	@ManyToOne(optional = false)
	protected Manager manager;

}
