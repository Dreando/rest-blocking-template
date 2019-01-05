package org.dreando.jpacascadingplayground;

import org.dreando.jpacascadingplayground.common.Profiles;
import org.dreando.jpacascadingplayground.config.BaseConfig;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = BaseConfig.class)
@ActiveProfiles(Profiles.TEST_PROFILE)
public abstract class BaseDatabaseTest {
}
