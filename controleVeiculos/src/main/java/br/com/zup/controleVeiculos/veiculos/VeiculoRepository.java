package br.com.zup.controleVeiculos.veiculos;

import br.com.zup.controleVeiculos.usuarios.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    //boolean VerificaRodizio(String diaSemana);

}
