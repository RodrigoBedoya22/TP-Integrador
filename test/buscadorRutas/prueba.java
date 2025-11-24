package buscadorRutas;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class prueba {
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		
		long cantDias = Duration.between(LocalDate.of(2020, 12, 12).atStartOfDay(), LocalDate.of(2020, 12, 13).atStartOfDay()).toDays();
		assertEquals(cantDias, 1);
		
	}

}
