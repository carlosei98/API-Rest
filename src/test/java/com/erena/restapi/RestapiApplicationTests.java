package com.erena.restapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Carlos
 * @date 23/03/2020
 *
 * Con este test lo que se pretende es comprobar que la arquitectura DAO funciona correctamente.
 * Lo que hacemos es crear un test para probar dos cosas:
 * 	- La primera es que se guardan los datos en la base de datos.
 * 	- La segunda, es que se obtienen correctamente los datos.
 *
 * 	Para ello, primero creamos una cuenta con el usuario "carlos" y la contraseña "root", y luego obtenemos todas las cuentas a través de la interfaz CuentasRepository.
 * 	Por último, comprobamos que la longitud de la lista con todas las cuentas es igual a dos, la cuenta que acabamos de crear y una por defecto que tenemos en la tabla.
 */


@SpringBootTest
class RestapiApplicationTests {
	@Autowired
	private CuentasRepository repository;

	@Test
	public void saveAndCheckUsers() {
		repository.save(new Cuenta("carlos","root"));
		List<Cuenta> cuentaList = repository.findAll();

		assertThat(cuentaList.size()).isEqualTo(2);
	}


	@Test
	void contextLoads() {
	}

}
