package one.digitalinnovation.labpadroesprojetosspring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

/**
 * Utilizado site jsonschema2pojo.org para gerar os atributos desse modelo
 * por meio do JSON de retorno do ViaCEP.
 *
 * @see <a href="https://www.jsonschema2pojo.org/">jsonschema2pojo.org</a>
 * @see <a href="https://viacep.com.br">ViaCEP</a>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Endereco {

    @Id
    @NotBlank
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;

}
