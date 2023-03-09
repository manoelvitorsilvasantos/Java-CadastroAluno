/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.app.view.dadosPessoais.dao;


import br.cadastro.app.aluno.dao.AlunoDAO;
import br.cadastro.app.aluno.model.Aluno;
import br.cadastro.app.aluno.service.AlunoService;
import br.cadastro.app.connect.ConnectionFactory;
import br.cadastro.app.contatos.service.ContatosService;
import br.cadastro.app.endereco.service.EnderecoService;
import br.cadastro.app.model.Contatos;
import br.cadastro.app.model.Endereco;
import java.awt.HeadlessException;
import java.sql.Connection;



/**
 *
 * @author mvictor
 */
public class DadosPessoaisDAO implements DadosPessoaisDAOInterface {

    private final Connection conn;
    private final AlunoService alunoService;
    private final AlunoDAO alunodao;
    private final EnderecoService enderecoService;
    private final ContatosService contatosService;
    
    public DadosPessoaisDAO(){
        this.conn = ConnectionFactory.criarConexao();
        this.alunoService = new AlunoService();
        this.alunodao = new AlunoDAO();
        this.enderecoService= new EnderecoService();
        this.contatosService = new ContatosService();
    }

    /**
     *
     * @param aluno
     * @param contatos
     * @param endereco
     * @return saveDadosPessoais
     */
    @Override
    public boolean saveDadosPessoais(Aluno aluno, Contatos contatos, Endereco endereco) {
        boolean status = false;
        int id = -1;
        //contatos
        contatos.setId(id);
        contatos.setTelefone(aluno.getContatos().getTelefone());
        contatos.setCelular(aluno.getContatos().getCelular());
        contatos.setEmail(aluno.getContatos().getEmail());
        
        //endereco
        endereco.setId(id);
        endereco.setLogradouro(aluno.getEndereco().getLogradouro());
        endereco.setBairro(aluno.getEndereco().getBairro());
        endereco.setComplemento(aluno.getEndereco().getComplemento());
        endereco.setNumero(aluno.getEndereco().getNumero());
        endereco.setCep(aluno.getEndereco().getCep());
        endereco.setCidade(aluno.getEndereco().getCidade());
        endereco.setUf(aluno.getEndereco().getUf());
        endereco.setAluno_id(id); //contatos
        contatos.setId(id);
        contatos.setTelefone(aluno.getContatos().getTelefone());
        contatos.setCelular(aluno.getContatos().getCelular());
        contatos.setEmail(aluno.getContatos().getEmail());
        contatos.setAluno_id(id);
        //endereco
        endereco.setId(id);
        endereco.setLogradouro(aluno.getEndereco().getLogradouro());
        endereco.setBairro(aluno.getEndereco().getBairro());
        endereco.setComplemento(aluno.getEndereco().getComplemento());
        endereco.setNumero(aluno.getEndereco().getNumero());
        endereco.setCep(aluno.getEndereco().getCep());
        endereco.setCidade(aluno.getEndereco().getCidade());
        endereco.setUf(aluno.getEndereco().getUf());
        endereco.setAluno_id(id); 
        aluno.setId(0);
        status = alunoService.save(aluno);
        if(status == true){
            id = alunodao.findStudentByCpf(aluno.getCpf());
            //contatos
            contatos.setId(id);
            contatos.setTelefone(aluno.getContatos().getTelefone());
            contatos.setCelular(aluno.getContatos().getCelular());
            contatos.setEmail(aluno.getContatos().getEmail());
            contatos.setAluno_id(id);
            //endereco
            endereco.setId(id);
            endereco.setLogradouro(aluno.getEndereco().getLogradouro());
            endereco.setBairro(aluno.getEndereco().getBairro());
            endereco.setComplemento(aluno.getEndereco().getComplemento());
            endereco.setNumero(aluno.getEndereco().getNumero());
            endereco.setCep(aluno.getEndereco().getCep());
            endereco.setCidade(aluno.getEndereco().getCidade());
            endereco.setUf(aluno.getEndereco().getUf());
            contatos.setAluno_id(id);
            endereco.setAluno_id(id); 
            status = contatosService.save(contatos) && enderecoService.save(endereco);
        }
        return status;
    }

    @Override
    public boolean updateDadosPessoais(Aluno aluno, Contatos contatos, Endereco endereco) {
        boolean status = false;
        int id = -1;
        //contatos
        contatos.setId(id);
        contatos.setTelefone(aluno.getContatos().getTelefone());
        contatos.setCelular(aluno.getContatos().getCelular());
        contatos.setEmail(aluno.getContatos().getEmail());
        
        //endereco
        endereco.setId(id);
        endereco.setLogradouro(aluno.getEndereco().getLogradouro());
        endereco.setBairro(aluno.getEndereco().getBairro());
        endereco.setComplemento(aluno.getEndereco().getComplemento());
        endereco.setNumero(aluno.getEndereco().getNumero());
        endereco.setCep(aluno.getEndereco().getCep());
        endereco.setCidade(aluno.getEndereco().getCidade());
        endereco.setUf(aluno.getEndereco().getUf());
        endereco.setAluno_id(id); //contatos
        contatos.setId(id);
        contatos.setTelefone(aluno.getContatos().getTelefone());
        contatos.setCelular(aluno.getContatos().getCelular());
        contatos.setEmail(aluno.getContatos().getEmail());
        contatos.setAluno_id(id);
        //endereco
        endereco.setId(id);
        endereco.setLogradouro(aluno.getEndereco().getLogradouro());
        endereco.setBairro(aluno.getEndereco().getBairro());
        endereco.setComplemento(aluno.getEndereco().getComplemento());
        endereco.setNumero(aluno.getEndereco().getNumero());
        endereco.setCep(aluno.getEndereco().getCep());
        endereco.setCidade(aluno.getEndereco().getCidade());
        endereco.setUf(aluno.getEndereco().getUf());
        endereco.setAluno_id(id); 
        aluno.setId(0);
        status = alunoService.save(aluno);
        if(status == true){
            id = alunodao.findStudentByCpf(aluno.getCpf());
            //contatos
            contatos.setId(id);
            contatos.setTelefone(aluno.getContatos().getTelefone());
            contatos.setCelular(aluno.getContatos().getCelular());
            contatos.setEmail(aluno.getContatos().getEmail());
            contatos.setAluno_id(id);
            //endereco
            endereco.setId(id);
            endereco.setLogradouro(aluno.getEndereco().getLogradouro());
            endereco.setBairro(aluno.getEndereco().getBairro());
            endereco.setComplemento(aluno.getEndereco().getComplemento());
            endereco.setNumero(aluno.getEndereco().getNumero());
            endereco.setCep(aluno.getEndereco().getCep());
            endereco.setCidade(aluno.getEndereco().getCidade());
            endereco.setUf(aluno.getEndereco().getUf());
            contatos.setAluno_id(id);
            endereco.setAluno_id(id); 
            status = contatosService.save(contatos) && enderecoService.save(endereco);
        }
        return status;
    }
   
}
