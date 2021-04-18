package edu.kosta.restaurant.service;

import edu.kosta.restaurant.domain.Tablet;
import edu.kosta.restaurant.repository.TabletRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TabletServiceTest {

    @Autowired
    private TabletRepository repository;

    @Autowired
    private TabletService service;

    private Tablet t;

    @BeforeAll
    void setup() {
        t = new Tablet();
        t.setLocation("야외1번테이블");
    }

    @Test
    void setTablet() {
        service.saveTablet(t);
        assertEquals(5, t.getId());
    }

    @Test
    void fineTablet() {
        Optional<Tablet> result = service.findById(5);
        assertNotNull(result.get());
        assertEquals("야외1번테이블", t.getLocation());
    }

}