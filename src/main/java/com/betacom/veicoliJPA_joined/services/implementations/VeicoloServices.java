package com.betacom.veicoliJPA_joined.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.veicoliJPA_joined.dto.input.BiciReq;
import com.betacom.veicoliJPA_joined.dto.input.MacchinaReq;
import com.betacom.veicoliJPA_joined.dto.input.MotoReq;
import com.betacom.veicoliJPA_joined.dto.input.VeicoloReq;
import com.betacom.veicoliJPA_joined.dto.input.VeicoloSearchReq;
import com.betacom.veicoliJPA_joined.dto.output.VeicoloDTO;
import com.betacom.veicoliJPA_joined.exceptions.VeicoloException;
import com.betacom.veicoliJPA_joined.mapper.VeicoloMap;
import com.betacom.veicoliJPA_joined.models.Bici;
import com.betacom.veicoliJPA_joined.models.Macchina;
import com.betacom.veicoliJPA_joined.models.Moto;
import com.betacom.veicoliJPA_joined.models.Veicolo;
import com.betacom.veicoliJPA_joined.repositories.IAlimentazioneRepository;
import com.betacom.veicoliJPA_joined.repositories.ICategoriaRepository;
import com.betacom.veicoliJPA_joined.repositories.IColoreRepository;
import com.betacom.veicoliJPA_joined.repositories.IMacchinaRepository;
import com.betacom.veicoliJPA_joined.repositories.IMarcaRepository;
import com.betacom.veicoliJPA_joined.repositories.IMotoRepository;
import com.betacom.veicoliJPA_joined.repositories.IVeicoloRepository;
import com.betacom.veicoliJPA_joined.services.interfaces.IVeicoloServices;
import com.betacom.veicoliJPA_joined.specifications.VeicoloSpecs;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class VeicoloServices implements IVeicoloServices {

	

	@Autowired private IVeicoloRepository veicoloR;
	@Autowired private IMacchinaRepository macchinaR;
	@Autowired private IMotoRepository motoR;
	// lookup del gruppo: devono esporre findByDescrizioneIgnoreCase(...)
	@Autowired private IMarcaRepository marcaR;
	@Autowired private IColoreRepository coloreR;
	@Autowired private IAlimentazioneRepository alimentazioneR;
	@Autowired private ICategoriaRepository categoriaR;

	@Override
	@Transactional
	public VeicoloDTO createMacchina(MacchinaReq req) throws VeicoloException {
		if (macchinaR.existsByTarga(req.getTarga())) {
			throw new VeicoloException("veicolo.targa.duplicata");
		}
		Macchina m = new Macchina();
		resolveLookups(m, req);
		m.setModello(req.getModello());
		m.setAnno(req.getAnno());
		m.setRuote(req.getRuote());
		m.setPorte(req.getPorte());
		m.setTarga(req.getTarga());
		veicoloR.save(m);
		return VeicoloMap.mapToDTO(m);
	}

	@Override
	@Transactional
	public VeicoloDTO createMoto(MotoReq req) throws VeicoloException {
		if (motoR.existsByTarga(req.getTarga())) {
			throw new VeicoloException("veicolo.targa.duplicata");
		}
		Moto mo = new Moto();
		resolveLookups(mo, req);
		mo.setModello(req.getModello());
		mo.setAnno(req.getAnno());
		mo.setRuote(req.getRuote());
		mo.setTipoForcella(req.getTipoForcella());
		mo.setTarga(req.getTarga());
		veicoloR.save(mo);
		return VeicoloMap.mapToDTO(mo);
	}

	@Override
	@Transactional
	public VeicoloDTO createBici(BiciReq req) throws VeicoloException {
		Bici bi = new Bici();
		resolveLookups(bi, req);
		bi.setModello(req.getModello());
		bi.setAnno(req.getAnno());
		bi.setRuote(req.getRuote());
		bi.setMarce(req.getMarce());
		bi.setFreno(req.getFreno());
		bi.setSospensione(req.getSospensione());
		bi.setPieghevole(req.getPieghevole());
		veicoloR.save(bi);
		return VeicoloMap.mapToDTO(bi);
	}

	@Override
	@Transactional
	public VeicoloDTO updateMacchina(MacchinaReq req) throws VeicoloException {
		Veicolo v = veicoloR.findById(req.getId())
				.orElseThrow(() -> new VeicoloException("veicolo.non.trovato"));
		if (!(v instanceof Macchina m)) throw new VeicoloException("veicolo.tipo.errato");
		resolveLookupsUpdate(m, req);
		if (req.getModello() != null) m.setModello(req.getModello());
		if (req.getAnno() != null)    m.setAnno(req.getAnno());
		if (req.getRuote() != null)   m.setRuote(req.getRuote());
		if (req.getPorte() != null)   m.setPorte(req.getPorte());
		if (req.getTarga() != null) {
			if (!req.getTarga().equals(m.getTarga()) && macchinaR.existsByTarga(req.getTarga()))
				throw new VeicoloException("veicolo.targa.duplicata");
			m.setTarga(req.getTarga());
		}
		veicoloR.save(m);
		return VeicoloMap.mapToDTO(m);
	}

	@Override
	@Transactional
	public VeicoloDTO updateMoto(MotoReq req) throws VeicoloException {
		Veicolo v = veicoloR.findById(req.getId())
				.orElseThrow(() -> new VeicoloException("veicolo.non.trovato"));
		if (!(v instanceof Moto mo)) throw new VeicoloException("veicolo.tipo.errato");
		resolveLookupsUpdate(mo, req);
		if (req.getModello() != null)      mo.setModello(req.getModello());
		if (req.getAnno() != null)         mo.setAnno(req.getAnno());
		if (req.getRuote() != null)        mo.setRuote(req.getRuote());
		if (req.getTipoForcella() != null) mo.setTipoForcella(req.getTipoForcella());
		if (req.getTarga() != null) {
			if (!req.getTarga().equals(mo.getTarga()) && motoR.existsByTarga(req.getTarga()))
				throw new VeicoloException("veicolo.targa.duplicata");
			mo.setTarga(req.getTarga());
		}
		veicoloR.save(mo);
		return VeicoloMap.mapToDTO(mo);
	}

	@Override
	@Transactional
	public VeicoloDTO updateBici(BiciReq req) throws VeicoloException {
		Veicolo v = veicoloR.findById(req.getId())
				.orElseThrow(() -> new VeicoloException("veicolo.non.trovato"));
		if (!(v instanceof Bici bi)) throw new VeicoloException("veicolo.tipo.errato");
		resolveLookupsUpdate(bi, req);
		if (req.getModello() != null)     bi.setModello(req.getModello());
		if (req.getAnno() != null)        bi.setAnno(req.getAnno());
		if (req.getRuote() != null)       bi.setRuote(req.getRuote());
		if (req.getMarce() != null)       bi.setMarce(req.getMarce());
		if (req.getFreno() != null)       bi.setFreno(req.getFreno());
		if (req.getSospensione() != null) bi.setSospensione(req.getSospensione());
		if (req.getPieghevole() != null)  bi.setPieghevole(req.getPieghevole());
		veicoloR.save(bi);
		return VeicoloMap.mapToDTO(bi);
	}

	@Override
	@Transactional
	public void delete(Integer id) throws VeicoloException {
		Veicolo v = veicoloR.findById(id)
				.orElseThrow(() -> new VeicoloException("veicolo.non.trovato"));
		veicoloR.delete(v);
	}

	@Override
	public VeicoloDTO getById(Integer id) throws VeicoloException {
		return VeicoloMap.mapToDTO(veicoloR.findById(id)
				.orElseThrow(() -> new VeicoloException("veicolo.non.trovato")));
	}

	@Override
	public List<VeicoloDTO> listAll() {
		return veicoloR.findAll().stream().map(VeicoloMap::mapToDTO).toList();
	}

	@Override
	public List<VeicoloDTO> search(VeicoloSearchReq req) {
		Specification<Veicolo> spec = Specification.allOf();
		if (req.getTipo() != null)          spec = spec.and(VeicoloSpecs.tipo(req.getTipo()));
		if (req.getMarca() != null)         spec = spec.and(VeicoloSpecs.marca(req.getMarca()));
		if (req.getColore() != null)        spec = spec.and(VeicoloSpecs.colore(req.getColore()));
		if (req.getAlimentazione() != null) spec = spec.and(VeicoloSpecs.alimentazione(req.getAlimentazione()));
		if (req.getCategoria() != null)     spec = spec.and(VeicoloSpecs.categoria(req.getCategoria()));
		if (req.getAnnoMin() != null)       spec = spec.and(VeicoloSpecs.annoMin(req.getAnnoMin()));
		if (req.getAnnoMax() != null)       spec = spec.and(VeicoloSpecs.annoMax(req.getAnnoMax()));
		if (req.getPorte() != null)         spec = spec.and(VeicoloSpecs.porte(req.getPorte()));
		if (req.getMarce() != null)         spec = spec.and(VeicoloSpecs.marce(req.getMarce()));
		if (req.getTargaAuto() != null)     spec = spec.and(VeicoloSpecs.targaAuto(req.getTargaAuto()));
		if (req.getTargaMoto() != null)     spec = spec.and(VeicoloSpecs.targaMoto(req.getTargaMoto()));
		return veicoloR.findAll(spec).stream().map(VeicoloMap::mapToDTO).toList();
	}

	/** Risolve le descrizioni lookup in entità (creazione: tutte obbligatorie tranne colore). */
	private void resolveLookups(Veicolo v, VeicoloReq req) throws VeicoloException {
		v.setMarca(marcaR.findByDescrizioneIgnoreCase(req.getMarca())
				.orElseThrow(() -> new VeicoloException("marca.non.trovata")));
		v.setAlimentazione(alimentazioneR.findByDescrizioneIgnoreCase(req.getAlimentazione())
				.orElseThrow(() -> new VeicoloException("alimentazione.non.trovata")));
		v.setCategoria(categoriaR.findByDescrizioneIgnoreCase(req.getCategoria())
				.orElseThrow(() -> new VeicoloException("categoria.non.trovata")));
		if (req.getColore() != null) {
			v.setColore(coloreR.findByDescrizioneIgnoreCase(req.getColore())
					.orElseThrow(() -> new VeicoloException("colore.non.trovato")));
		}
	}

	/** In update risolve solo le lookup effettivamente passate (partial). */
	private void resolveLookupsUpdate(Veicolo v, VeicoloReq req) throws VeicoloException {
		if (req.getMarca() != null)
			v.setMarca(marcaR.findByDescrizioneIgnoreCase(req.getMarca())
					.orElseThrow(() -> new VeicoloException("marca.non.trovata")));
		if (req.getAlimentazione() != null)
			v.setAlimentazione(alimentazioneR.findByDescrizioneIgnoreCase(req.getAlimentazione())
					.orElseThrow(() -> new VeicoloException("alimentazione.non.trovata")));
		if (req.getCategoria() != null)
			v.setCategoria(categoriaR.findByDescrizioneIgnoreCase(req.getCategoria())
					.orElseThrow(() -> new VeicoloException("categoria.non.trovata")));
		if (req.getColore() != null)
			v.setColore(coloreR.findByDescrizioneIgnoreCase(req.getColore())
					.orElseThrow(() -> new VeicoloException("colore.non.trovato")));
	}
}
