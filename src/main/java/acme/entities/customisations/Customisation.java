package acme.entities.customisations;

import javax.persistence.Entity;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customisation extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	@Length(min = 1, max = 255)
	private String				spamWords;

	@NotNull
	@Digits(integer = 3, fraction = 2)
	@Positive
	private Double				threshold;
}
