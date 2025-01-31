package org.zerock.springex.sample;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service // 서비스를 다루는 객체들(주입)
@ToString
@RequiredArgsConstructor // final같이 필수적인 것만 들어감(여기서는 DAO)
public class SampleService {

    @Qualifier("normal") // normal 사용
    private final SampleDAO sampleDAO;
}