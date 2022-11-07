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
		user12 = usuarioDao.save(user12);
		/* -----Personas */
		Persona user1 = new Persona();
		user1.setNombre("Jose");
		user1.setApellido("Apellido");
		user1.setEmail("jcast@gmail.com");
		user1.setTelefono("12489765");
		user1.setSueldo(1000.00);
		user1.setUser(user12);
		user1 = personaDao.save(user1);


		Persona user2 = new Persona();
		user2.setNombre("Daniel");
		user2.setApellido("Apellido1");
		user2.setEmail("jcast@gmail.com");
		user2.setTelefono("12489765");
		user2.setSueldo(1000.00);
		user2.setUser(user12);
		user2 = personaDao.save(user2);


		/*  ------------------------------ */
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
		credito.setFechaInicio(new Date()); 	
		credito.setFechaFinal(new Date(2023,1,20));
		double canti = 1000.00;
		credito.setTotalI(canti);
		credito.setTotalF(canti);
	
		creditoService.saveCredito(credito);


		
		Credito credito1 = new Credito();
		credito1.setPersona(user2);
		credito1.setCuotas(10);
		credito1.setFechaInicio(new Date()); 	
		credito1.setFechaFinal(new Date(2023,1,20));
		double canti1 = 1000.00;
		credito1.setTotalI(canti1);
		credito1.setTotalF(canti1);
	
		creditoService.saveCredito(credito1);



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

	@Test
	public void updateCredito(){
		Credito creditoV = creditoService.getCreditoById(1);
		creditoService.updateCoutas(creditoV, 1, 100.00);
		creditoV = creditoService.getCreditoById(1);
		System.out.println("coutoas: " + creditoV.getCuotas()+ "\tTotal: " 
		+ creditoV.getTotalF());

	}
	



}
