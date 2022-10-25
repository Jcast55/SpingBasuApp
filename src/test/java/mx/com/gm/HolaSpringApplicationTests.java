package mx.com.gm;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import mx.com.gm.dao.PersonaDao;
import mx.com.gm.dao.RolDao;
import mx.com.gm.dao.UsuarioDao;
import mx.com.gm.domain.Credito;
import mx.com.gm.domain.Persona;
import mx.com.gm.domain.Rol;
import mx.com.gm.domain.Usuario;
import mx.com.gm.servicio.CreditoService;
import mx.com.gm.util.EncriptarPassword;

@SpringBootTest
class HolaSpringApplicationTests {
	@Autowired
	UsuarioDao usuarioDao;
	@Autowired
	RolDao rolDao;
	@Autowired
	PersonaDao personaDao;
	@Autowired
	CreditoService creditoService;

	@Test
	void contextLoads() {

		Usuario user = new Usuario();
	
		Usuario user12 = new Usuario();
		 
		user.setUsername("admin");
		user.setPassword(EncriptarPassword.encriptarPassword("123"));
	

		user12.setUsername("user");
		user12.setPassword(EncriptarPassword.encriptarPassword("1234"));
		
		usuarioDao.save(user);
		usuarioDao.save(user12);

		Persona user1 = new Persona();
		user1.setNombre("Jose");
		user1.setApellido("Apellido");
		user1.setEmail("jcast@gmail.com");
		user1.setTelefono("12489765");
		user1.setSueldo(1000.00);
		user1.setUser(user12);
		personaDao.save(user1);

		Rol rolAdmin = new Rol();
		Rol rolUser = new Rol();
		rolUser.setNombre("ROLE_USER");
		rolAdmin.setNombre("ROLE_ADMIN");
		rolAdmin.setUsuario(user);
		rolUser.setUsuario(user);
		
		//List<Rol> rolesAdmin = new ArrayList<>();
		
		
		Rol rolUser1 = new Rol();
		rolUser1.setNombre("ROLE_USER");
		rolUser1.setUsuario(user12);

		rolDao.save(rolAdmin);
		rolDao.save(rolUser);
		rolDao.save(rolUser1); 


		/* ----Credito------ */

		Credito credito = new Credito();
		credito.setPersona(user1);
		credito.setCuotas(10);
		Date date = new Date();
		credito.setFechaFinal(new Date());


		/* ------------- */
	}
	@Test
	public void probarUser(){
		long id = 1;
		Optional<Usuario> userOptional =  usuarioDao.findById(id);
		Usuario user = userOptional.get();
		List<Rol> rolesAdmin = user.getRoles();
		for (Rol rol : rolesAdmin) {
			System.out.println(rol.getNombre()+ " ID:" + rol.getIdRol());
		}
	}

	


}
