package acme.entities.tasks;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Task extends DomainEntity {
	
	//Serialisation identifier 

	protected static final long serialVersionUID = 1L;

	//Attributes
	
	@NotBlank
	@Length(min = 1, max = 80)
	protected String title;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	protected Date startExecutionPeriod;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	protected Date endExecutionPeriod;
	
	@NotNull
	@Digits(integer = 100, fraction = 2)
	protected Double  workload;
	
	@NotBlank
	@Length(min = 1, max = 500)
	protected String description;
	
	@NotBlank
	@Pattern(regexp = "^(public|private)$")
	protected String share;
	
	@URL
	protected String link;
	
	//Derived attributes
	
	@Transient
	public long maxHours() {
		final long diffMillies = Math.abs(this.endExecutionPeriod.getTime()-this.startExecutionPeriod.getTime());
		return TimeUnit.HOURS.convert(diffMillies, TimeUnit.MILLISECONDS);
	}

	//Relationships
	
}
