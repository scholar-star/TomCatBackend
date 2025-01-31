package org.zerock.springex.sample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
// @Primary // 우선선택
@Qualifier("event")
public class EventSampleDAOImpl implements SampleDAO {
}
