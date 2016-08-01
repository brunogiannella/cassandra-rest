package br.com.gft.digital.bigdata.pocbigdata.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gft.digital.bigdata.pocbigdata.constantes.FaixaEtaria;
import br.com.gft.digital.bigdata.pocbigdata.constantes.TipoIndexador;
import br.com.gft.digital.bigdata.pocbigdata.dao.impl.ApoliceRepositoryImpl;
import br.com.gft.digital.bigdata.pocbigdata.dao.impl.ClienteRepositoryImpl;
import br.com.gft.digital.bigdata.pocbigdata.dao.impl.IndicadorStringRepositoryImpl;
import br.com.gft.digital.bigdata.pocbigdata.dao.impl.SinistroRepositoryImpl;
import br.com.gft.digital.bigdata.pocbigdata.model.Apolice;
import br.com.gft.digital.bigdata.pocbigdata.model.Cliente;
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
		try {
			gerarIndicadoresSinistroRegiao();
			gerarIndicadoresFaixaEtaria();
			gerarIndicadoresMarcas(TipoIndexador.MARCA_X_DEFEITOS, "pane");
			gerarIndicadoresMarcas(TipoIndexador.MARCA_X_ROUBOS, "roubo");
			gerarIndicadoresAcidentesRoubos();
			System.out.println("Indicadores foram gerados");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void gerarIndicadoresAcidentesRoubos() {
		IndicadorString indicadorString = indicadoresStringRepository.get(TipoIndexador.ACIDENTES_X_ROUBOS.getDescricao());
		List<Sinistro> sinistrosIndexar = null;
		Map<String, Long> mapeados = new HashMap<String, Long>();
		
		if(indicadorString == null) {
			if(sinistros == null) {
				sinistros = sinistroRepository.get();
			}
			sinistrosIndexar = sinistros;
		} else {
			sinistrosIndexar = sinistroRepository.getSinistros(indicadorString.getUltimoIndexado());
		}
		
		if(!sinistrosIndexar.isEmpty()) {
			for(Sinistro sinistro : sinistrosIndexar) {
				if(mapeados.containsKey(sinistro.getTipoSinistro())) {
					mapeados.put(sinistro.getTipoSinistro(), mapeados.get(sinistro.getTipoSinistro()) + 1);
				} else {
					mapeados.put(sinistro.getTipoSinistro(), 1L);
				}
			}
			
			if(indicadorString == null) {
				IndicadorString indicadorGerado = new IndicadorString();
				indicadorGerado.setTipoIndicador(TipoIndexador.ACIDENTES_X_ROUBOS.getDescricao());
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

	private void gerarIndicadoresFaixaEtaria() {
		IndicadorString indicadorString = indicadoresStringRepository.get(TipoIndexador.FAIXAETATICA_X_SINISTROS.getDescricao());
		List<Sinistro> sinistrosIndexar = null;
		Map<String, Long> mapeados = new HashMap<String, Long>();
		
		if(indicadorString == null) {
			if(sinistros == null) {
				sinistros = sinistroRepository.get();
			}
			sinistrosIndexar = sinistros;
		} else {
			sinistrosIndexar = sinistroRepository.getSinistros(indicadorString.getUltimoIndexado());
		}
		
		if(!sinistrosIndexar.isEmpty()) {
			for(Sinistro sinistro : sinistrosIndexar) {
				Apolice apoliceSinistro = apoliceRepository.get(sinistro.getIdApolice());
				if(apoliceSinistro != null) {
					Cliente cliente = clienteRepository.get(apoliceSinistro.getCpfCnpjCliente());
					
					if(cliente != null) {
						FaixaEtaria faixa = null;
						
						if(cliente.getIdade() >= 18 && cliente.getIdade() <= 25) {
							faixa = FaixaEtaria.ENTRE_18_E_25_ANOS;
						} else if(cliente.getIdade() > 25 && cliente.getIdade() <= 30) {
							faixa = FaixaEtaria.ENTRE_25_E_30_ANOS;
						} else if(cliente.getIdade() > 30 && cliente.getIdade() <= 40) {
							faixa = FaixaEtaria.ENTRE_30_E_40_ANOS;
						} else if(cliente.getIdade() > 40 && cliente.getIdade() <= 50) {
							faixa = FaixaEtaria.ENTRE_40_E_50_ANOS;
						} else if(cliente.getIdade() > 50 && cliente.getIdade() <= 60) {
							faixa = FaixaEtaria.ENTRE_50_E_60_ANOS;
						} else if(cliente.getIdade() > 60) {
							faixa = FaixaEtaria.MAIS_DE_60_ANOS;
						}
						
						if(mapeados.containsKey(faixa.getDescricao())) {
							mapeados.put(faixa.getDescricao(), mapeados.get(faixa.getDescricao()) + 1);
						} else {
							mapeados.put(faixa.getDescricao(), 1L);
						}
					}
					
					if(indicadorString == null) {
						IndicadorString indicadorGerado = new IndicadorString();
						indicadorGerado.setTipoIndicador(TipoIndexador.FAIXAETATICA_X_SINISTROS.getDescricao());
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
	}
	
	private void gerarIndicadoresMarcas(TipoIndexador tipoIndexador, String tipoSinistro) {
		IndicadorString indicadorString = indicadoresStringRepository.get(tipoIndexador.getDescricao());
		List<Sinistro> sinistrosIndexar = null;
		Map<String, Long> mapeados = new HashMap<String, Long>();
		
		if(indicadorString == null) {
			if(sinistros == null) {
				sinistros = sinistroRepository.get();
			}
			sinistrosIndexar = sinistros;
		} else {
			sinistrosIndexar = sinistroRepository.getSinistros(indicadorString.getUltimoIndexado());
		}
		
		if(!sinistrosIndexar.isEmpty()) {
			for(Sinistro sinistro : sinistrosIndexar) {
				if(sinistro.getTipoSinistro().equals(tipoSinistro)) {
					Apolice apoliceSinistro = apoliceRepository.get(sinistro.getIdApolice());
					
					if(mapeados.containsKey(apoliceSinistro.getModeloVeiculo())) {
						mapeados.put(apoliceSinistro.getModeloVeiculo(), mapeados.get(apoliceSinistro.getModeloVeiculo()) + 1);
					} else {
						mapeados.put(apoliceSinistro.getModeloVeiculo(), 1L);
					}
				}
			}
			
			if(indicadorString == null) {
				IndicadorString indicadorGerado = new IndicadorString();
				indicadorGerado.setTipoIndicador(tipoIndexador.getDescricao());
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
	
	private void gerarIndicadoresSinistroRegiao() {
		IndicadorString indicadorString = indicadoresStringRepository.get(TipoIndexador.REGIAO_X_SINISTROS.getDescricao());
		List<Sinistro> sinistrosIndexar = null;
		Map<String, Long> mapeados = new HashMap<String, Long>();
		
		if(indicadorString == null) {
			if(sinistros == null) {
				sinistros = sinistroRepository.get();
			}
			sinistrosIndexar = sinistros;
		} else {
			sinistrosIndexar = sinistroRepository.getSinistros(indicadorString.getUltimoIndexado());
		}
		
		if(!sinistrosIndexar.isEmpty()) {
			
			for(Sinistro sinistro : sinistrosIndexar) {
				if(mapeados.containsKey(sinistro.getEndereco())) {
					mapeados.put(sinistro.getEndereco(), mapeados.get(sinistro.getEndereco()) + 1);
				} else {
					mapeados.put(sinistro.getEndereco(), 1L);
				}
			}
			
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
