package it.sincon.gepred.persistence;

import it.sincon.gepred.domain.UserLog;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Eligio Cavallo
 *
 */
public interface UserLogRepository extends PagingAndSortingRepository<UserLog,Long> {
}
