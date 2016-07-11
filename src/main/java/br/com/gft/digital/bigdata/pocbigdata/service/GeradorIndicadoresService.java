package br.com.gft.digital.bigdata.pocbigdata.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gft.digital.bigdata.pocbigdata.constantes.TipoIndexador;
import br.com.gft.digital.bigdata.pocbigdata.dao.impl.ApoliceRepositoryImpl;
import br.com.gft.digital.bigdata.pocbigdata.dao.impl.ClienteRepositoryImpl;
import br.com.gft.digital.bigdata.pocbigdata.dao.impl.IndicadorStringRepositoryImpl;
import br.com.gft.digital.bigdata.pocbigdata.dao.impl.SinistroRepositoryImpl;
import br.com.gft.digital.bigdata.pocbigdata.model.IndicadorString;
import br.com.gft.digital.bigdata.pocbigdata.model.Sinistro;

@Service("geradorIndicadoresService")
public class GeradorIndicadoresService {
	
	@Autowired
	private IndicadorStringRepositoryImpl indicadoresStringRepository;
	
	@Autowired
	private SinistroRepositoryImpl sinistroRepository;
	
	@Autowired
	private ApoliceRepositoryImpl apoliceRepository;
	
	@Autowired
	private ClienteRepositoryImpl clienteRepository;
	
	private List<Sinistro> sinistros = null;
	
	public void gerarIndicadores() {
		gerarIndicadoresSinistroRegiao();
		System.out.println("Indicadores foram gerados");
	}
	
	private void gerarIndicadoresSinistroRegiao() {
		IndicadorString indicadorString = indicadoresStringRepository.get(TipoIndexador.REGIAO_X_SINISTROS);
		List<Sinistro> sinistrosIndexar = null;
		
		Map<String, Long> mapeados = new HashMap<String, Long>();
		
		if(indicadorString == null) {
			if(sinistros == null) {
				sinistros = sinistroRepository.get();
				sinistrosIndexar = sinistros;
			}
		} else {
			sinistrosIndexar = sinistroRepository.getSinistros(indicadorString.getUltimoIndexado());
		}
		
		for(Sinistro sinistro : sinistrosIndexar) {
			if(mapeados.containsKey(sinistro.getBairro())) {
				mapeados.put(sinistro.getBairro(), mapeados.get(sinistro.getBairro()) + 1);
			} else {
				mapeados.put(sinistro.getBairro(), 1L);
			}
		}
		
		if(!sinistrosIndexar.isEmpty()) {
			if(indicadorString == null) {
				IndicadorString indicadorGerado = new IndicadorString();
				indicadorGerado.setTipoIndicador(TipoIndexador.REGIAO_X_SINISTROS.getDescricao());
				indicadorGerado.setDados(mapeados);
				indicadorGerado.setUltimoIndexado(sinistrosIndexar.get(sinistrosIndexar.size()-1).getIdSinistro());
				indicadoresStringRepository.save(indicadorGerado);
			} else {
				for (String key : indicadorString.getDados().keySet()) {
                    if(mapeados.containsKey(key)) {
                    	indicadorString.getDados().put(key, (indicadorString.getDados().get(key) + mapeados.get(key)));
                    }
				}
				
				indicadorString.setUltimoIndexado(sinistrosIndexar.get(sinistrosIndexar.size()-1).getIdSinistro());
				indicadoresStringRepository.save(indicadorString);
			}
		}
		
	}
	
}
