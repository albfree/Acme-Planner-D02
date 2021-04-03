package acme.features.anonymous.shout;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.shouts.Shout;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousShoutRepository extends AbstractRepository {

	@Query("select s from Shout s")
	Collection<Shout> findMany();
	
	@Query("select s from Shout s where datediff(now(), s.moment) <= 30")
	Collection<Shout> findWithinAMonth(Sort sort);
}
