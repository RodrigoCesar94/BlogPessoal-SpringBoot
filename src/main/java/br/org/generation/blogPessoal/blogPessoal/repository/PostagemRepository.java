package br.org.generation.blogPessoal.blogPessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.blogPessoal.blogPessoal.Model.Postagem; // no diamante da sua interface herdada JpaRepository  
// abrem-se 2 parâmetros sendo  <T, ID> onde T = Tipo de entidade que estamos trabalhando, deve ser
// o mesmo nome do model que criamos, neste caso Postagem.
// é indicada a correção de import comentada agora. o ID é onde você coloca a tipagem da sua primary Key, no nosso caso
// definimos na model como long, mas aqui ela deve ser usada em seu modo primitivo, fazemos isso usando L maiusculo, ficando
// <Postagem, Long>


@Repository
public interface PostagemRepository extends JpaRepository <Postagem, Long> // herdando interface JpaRepository
{
	public List<Postagem> findAllByTituloContainingIgnoreCase(String titulo);			

}
