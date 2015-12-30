package org.siva.narayan.aiqs.db.repo;

import org.siva.narayan.aiqs.db.entity.SampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * A Sample Repository to do Database operations on SAMPLE table.
 * 
 * @author Siva Narayana Reddy M [siva.narayanareddy.maddula@gmail.com]
 *
 */
@Repository
public interface SampleRepository extends JpaRepository<SampleEntity, Long> {

}
