package br.com.vgsolutions.vgexchange;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.vgsolutions.vgexchange.entity.AutoridadeUsuario;
import br.com.vgsolutions.vgexchange.entity.Usuario;
import br.com.vgsolutions.vgexchange.util.VGXORMTestUtil;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class UsuarioPersistenceTests {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Before
	public void beforeStarts(){
		entityManager = VGXORMTestUtil.getEntityManagerFactory().createEntityManager();
	}
	
	@Test
	@Transactional
	public void testeSalvarComAutoridade() throws Exception{
		Usuario usuario = new Usuario();
		usuario.setEmail("teste@teste.com.br");
		usuario.setUsuariosAutoridade(new AutoridadeUsuario());
		entityManager.persist(usuario);
		entityManager.flush();
		
	}
	
	@Test
	@Transactional
	public void testeSalvarBuscar() throws Exception{
		String email = "teste@teste.com.br";
		
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setUsuariosAutoridade(new AutoridadeUsuario());
		entityManager.persist(usuario);
		entityManager.flush();
		entityManager.clear();
		
		Usuario usuarioBusca = (Usuario) entityManager.find(Usuario.class, email);
		Assert.assertEquals(email, usuarioBusca.getEmail());
	}
	
}
