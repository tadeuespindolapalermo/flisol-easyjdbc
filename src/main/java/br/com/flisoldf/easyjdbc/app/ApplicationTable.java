package br.com.flisoldf.easyjdbc.app;

import java.util.HashMap;
import java.util.Map;

import com.github.tadeuespindolapalermo.easyjdbc.connection.InfoConnection;
import com.github.tadeuespindolapalermo.easyjdbc.crud.Crud;
import com.github.tadeuespindolapalermo.easyjdbc.crud.CrudEntity;
import com.github.tadeuespindolapalermo.easyjdbc.enumeration.EnumDatabase;

import br.com.flisoldf.easyjdbc.entity.Usuario;

public class ApplicationTable {
	
	private static final String TB_NAME = "tb_usuario";

	public static void main(String[] args) throws Exception {		

		toConnect();

		Crud crud = new Crud();
		CrudEntity<Usuario> crudEntity = new CrudEntity<>(Usuario.class);

		crud.save(createColumnsAndValues(), TB_NAME);		
		
		crud.delete(TB_NAME, "password", "123456");
		
		crudEntity.getAll().forEach(System.out::println);
		
		crud.save(createColumnsAndValues(), TB_NAME);		
		crud.update(updateColumnsAndValues(), clauseColumnAndValue(), TB_NAME);
		crudEntity.getAll().forEach(System.out::println);
	}

	private static Map<String, Object> createColumnsAndValues() {
		Map<String, Object> columnsAndValues = new HashMap<>();
		columnsAndValues.put("nome", "Olavo");
		columnsAndValues.put("email", "olavo@uol.com");
		columnsAndValues.put("password", "123456");
		columnsAndValues.put("idade", 59);
		columnsAndValues.put("iscasado", true);
		return columnsAndValues;
	}
	
	private static Map<String, Object> updateColumnsAndValues() {
		Map<String, Object> columnsAndValues = new HashMap<>();
		columnsAndValues.put("nome", "Olavoooooooooo");
		columnsAndValues.put("email", "olavo@uoooooooool.com");		
		return columnsAndValues;
	}
	
	private static Map<String, Object> clauseColumnAndValue() {
		Map<String, Object> columnsAndValues = new HashMap<>();
		columnsAndValues.put("id", 16);
		return columnsAndValues;
	}

	private static void toConnect() {
		InfoConnection.setDatabase(EnumDatabase.POSTGRE);
		InfoConnection.setNameDatabase("flisoldf2020");
		InfoConnection.setUser("postgres");
		InfoConnection.setPassword("tadeu123");
	}

}
