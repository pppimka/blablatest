package com.blablacar.palii.repo;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.File;

import static org.jeasy.random.FieldPredicates.named;
import static org.jeasy.random.TypePredicates.ofType;

@ActiveProfiles(value = {"test"})
@SpringBootTest
public class BaseTest {

	protected static EasyRandom easyRandom = new EasyRandom(new EasyRandomParameters()
		.excludeField(named("id")).excludeType(ofType(File.class)));

	@PersistenceContext
	protected EntityManager entityManager;
}
