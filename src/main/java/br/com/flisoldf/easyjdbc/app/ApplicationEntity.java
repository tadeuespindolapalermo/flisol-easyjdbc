package br.com.flisoldf.easyjdbc.app;

import com.github.tadeuespindolapalermo.easyjdbc.connection.InfoConnection;
import com.github.tadeuespindolapalermo.easyjdbc.crud.CrudEntity;
import com.github.tadeuespindolapalermo.easyjdbc.enumeration.EnumDatabase;

import br.com.flisoldf.easyjdbc.entity.Usuario;

public class ApplicationEntity {

	public static void main(String[] args) throws Exception {
		
		toConnect();
		
		CrudEntity<Usuario> crudEntity = new CrudEntity<>(Usuario.class);

		Usuario u1 = new Usuario("João Paulo", "joao@gmail.com", "123", 45, false);
		Usuario u2 = new Usuario("Maria Pereira", "maria@gmail.com", "123", 54, true);
		Usuario u3 = new Usuario("Tadeu Espindola", "tadeu@gmail.com", "123", 35, true);
		Usuario u4 = new Usuario("Eduardo", "tadeu@gmail.com", "456", 80, true);		
		
		crudEntity.save(u1);
		crudEntity.save(u2);
		crudEntity.save(u3);
		crudEntity.save(u4);
		
		Usuario userUpdate = crudEntity.searchById(1);
		userUpdate.setNome("Mario Sérgio");		
		crudEntity.update(userUpdate);
		
		System.out.println("=================================");
		
		crudEntity.getAll().forEach(System.out::println);
		System.out.println("=================================");
		
		System.out.println(crudEntity.searchById(3));
		System.out.println("=================================");
		
		crudEntity.deleteById(2);
		crudEntity.getAll().forEach(System.out::println);
		System.out.println("=================================");
		
		crudEntity.search("SELECT * FROM tb_usuario WHERE iscasado = false")
			.forEach(e -> System.out.println(e.getNome()));
		System.out.println("=================================");
		
		int result = crudEntity.operateWithResultSet("SELECT COUNT(1) AS qtde FROM tb_usuario WHERE iscasado = true").getInt("qtde");		
		System.out.println(result);
		System.out.println("=================================");			
	}

	private static void toConnect() {
		InfoConnection.setDatabase(EnumDatabase.POSTGRE);
		InfoConnection.setNameDatabase("flisoldf2020");
		InfoConnection.setUser("postgres");
		InfoConnection.setPassword("tadeu123");
	}

}
