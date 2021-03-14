package br.com.kleytonms.sysChamados.servicos;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.security.auth.login.LoginException;

import br.com.kleytonms.sysChamados.daos.UsuarioDAO;
import br.com.kleytonms.sysChamados.dtos.Login;
import br.com.kleytonms.sysChamados.dtos.LoginDTO;
import br.com.kleytonms.sysChamados.encrypt.PHPass;
import br.com.kleytonms.sysChamados.entidades.Usuario;
import br.com.kleytonms.sysChamados.exceptions.DBException;

@Stateless
public class LoginService {
	private static final Logger logger = Logger.getLogger(LoginService.class.getName());

	@Inject
	private UsuarioDAO userDAO;


	public static final PHPass phpass = new PHPass(8);

	public LoginDTO login(final String login, final String pass) throws LoginException {
		LoginService.phpass.HashPassword(pass);
		Usuario user = this.userDAO.getUsuarioPorEmail(login);
		if(user==null){
			user = this.userDAO.getUsuarioPorLogin(login);
			if(user==null){
				throw new LoginException("Login inválido");
			}
		}

		final boolean check = LoginService.phpass.CheckPassword(pass, user.getSenha());
		if(!check) {
			throw new LoginException("Login inválido");
		}

		final LoginDTO dto = new LoginDTO();
		dto.setId(user.getId());
		dto.setNome(user.getNome());
		dto.setUsername(user.getUsuario());
		dto.setEmail(user.getEmail());
		return dto;
	}
	
	
	
	public LoginDTO loginApp(final Login login) throws LoginException{
		LoginService.logger.info("Acessando aplicativo :" + login.getUsername());
		return this.login(login.getUsername(), login.getPassword());
	}

	public void salvarUsuario(final Usuario user) throws DBException {
		this.userDAO.create(user);
	}

}
