package br.com.mgx.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class Teste {
	
	
	public static void main(String args[]){
		Teste teste = new Teste();
		try {
			teste.importaBanco();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	public void importaBanco() throws Exception{
		Class.forName("com.hxtt.sql.paradox.ParadoxDriver");
		Class.forName("com.mysql.jdbc.Driver");		
		
		Connection conParadox = DriverManager.getConnection("jdbc:paradox:/M:/ProUtil/banco");
	    Connection conMySQL = DriverManager.getConnection("jdbc:mysql://192.168.123.150:3306/mgx",
	    	        "mgx", "mgx");		
		
		Statement stmtParadox = conParadox.createStatement();
		Statement stmtMySQL = conMySQL.createStatement();
 
		//para clientes
		//ResultSet rsParadox = stmtParadox.executeQuery("select * from Clientes");
		
		//para fornecedores
		ResultSet rsParadox = stmtParadox.executeQuery("select * from Fornecedores");
		
		String insertMySQL = null;
		
		while(rsParadox.next()){
			System.out.println("\n\n******************************");
			
		//	insertMySQL.delete(0,insertMySQL.length());
		/*	insertMySQL.append("INSERT INTO " ).append(
							"dadoscadastrais" ).append(
							" VALUES (null, " ).append( // ID
							rsParadox.getObject("Bairro")!=null?"'"+ rsParadox.getObject("Bairro")+"',":"null," ).append(
							"null," ).append( // CATEGORIA
							rsParadox.getObject("Cep")!=null?"'"+rsParadox.getObject("Cep")+"',":"null," ).append(
							rsParadox.getObject("CNPJ")!=null?"'"+rsParadox.getObject("CNPJ")+"',":"null," ).append(
							rsParadox.getObject("Cidade")!=null?"'"+rsParadox.getObject("Cidade")+"',":"null," ).append(
							"null, " ).append(// COMPLEMENTO
							rsParadox.getObject("Contato")!=null?"'"+rsParadox.getObject("Contato")+"',":"null,").append(
							rsParadox.getObject("Email")!=null?"'"+rsParadox.getObject("Email")+"',":"null," ).append(
							rsParadox.getObject("Endereco")!=null?"'"+rsParadox.getObject("Endereco")+"',":"null," ).append(
							rsParadox.getObject("Fax")!=null?"'"+rsParadox.getObject("Fax")+"',":"null," ).append(
							rsParadox.getObject("Inscricao")!=null?"'"+rsParadox.getObject("Inscricao")+"',":"null," ).append(
							rsParadox.getObject("Nome_cli")!=null?"'"+rsParadox.getObject("Nome_cli")+"',":"null," ).append(
							rsParadox.getObject("Obs:")!=null?"'"+rsParadox.getObject("Obs:")+"',":"null," ).append(
							rsParadox.getObject("Razao_Social")!=null?"'"+rsParadox.getObject("Razao_Social")+"',":"null," ).append(
							rsParadox.getObject("Tel")!=null?"'"+rsParadox.getObject("Tel")+"',":"null," ).append(
							"null," ).append(// TELEFONE2
							rsParadox.getObject("UF")!=null?"'"+rsParadox.getObject("UF")+"'":"null" ).append(
							")");*/
			
			
			
			insertMySQL = "INSERT INTO dadoscadastrais VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			
			
			PreparedStatement pstmt = (PreparedStatement)conMySQL.prepareStatement(insertMySQL);
			
			pstmt.setNull(1, Types.BIGINT);
			setParameter(pstmt, 2, rsParadox.getObject("Bairro"));
			pstmt.setNull(3, Types.VARCHAR);
			setParameter(pstmt, 4, rsParadox.getObject("Cep"));
			setParameter(pstmt, 5, rsParadox.getObject("CNPJ"));
			setParameter(pstmt, 6, rsParadox.getObject("Cidade"));		
			pstmt.setNull(7, Types.VARCHAR);	
			setParameter(pstmt, 8, rsParadox.getObject("Contato"));				
			setParameter(pstmt, 9, rsParadox.getObject("Email"));			
			setParameter(pstmt, 10, rsParadox.getObject("Endereco"));
			setParameter(pstmt, 11, rsParadox.getObject("Fax"));
			setParameter(pstmt, 12, rsParadox.getObject("Inscricao"));	
			
			// para cliente Nome_cli. para fornecedor Nome_for
			setParameter(pstmt, 13, rsParadox.getObject("Nome_for"));
			setParameter(pstmt, 14, rsParadox.getObject("Obs:"));
			setParameter(pstmt, 15, rsParadox.getObject("Razao_Social"));
			setParameter(pstmt, 16, rsParadox.getObject("Tel"));				
			pstmt.setNull(17, Types.VARCHAR);
			setParameter(pstmt, 18, rsParadox.getObject("UF"));			
			
			System.out.println(insertMySQL);			
			pstmt.execute();
			ResultSet rsMySQL =  stmtMySQL.executeQuery("SELECT MAX(id) FROM dadoscadastrais");
			rsMySQL.next();
			long newID = rsMySQL.getLong(1);
			System.out.println(newID);
			
			//para cliente
			//stmtMySQL.execute("INSERT INTO cliente VALUES(null,null,"+newID+")");
			
			//para fornecedor
			stmtMySQL.execute("INSERT INTO fornecedor VALUES(null,"+newID+")");
			
				
		}
		conParadox.close();
		conMySQL.close();
	}
	
	private void setParameter(PreparedStatement pstmt, int posicao, Object obj) throws SQLException{
		if(obj != null)
			pstmt.setString(posicao, obj.toString());
		else
			pstmt.setNull(posicao, Types.VARCHAR);
	}

}
