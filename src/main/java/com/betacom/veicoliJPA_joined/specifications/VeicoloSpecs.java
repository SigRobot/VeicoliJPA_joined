package com.betacom.veicoliJPA_joined.specifications;

import org.springframework.data.jpa.domain.Specification;

import com.betacom.veicoliJPA_joined.models.Veicolo;

public class VeicoloSpecs {

	private VeicoloSpecs() {}

	public static Specification<Veicolo> tipo(String tipo) {
		return (root, query, cb) -> cb.equal(root.get("tipoVeicolo"), tipo);
	}

	// navigano la relazione: marca -> descrizione, con join generato da Spring
	public static Specification<Veicolo> marca(String descrizione) {
		return (root, query, cb) ->
				cb.equal(cb.lower(root.get("marca").get("descrizione")), descrizione.toLowerCase());
	}

	public static Specification<Veicolo> colore(String descrizione) {
		return (root, query, cb) ->
				cb.equal(cb.lower(root.get("colore").get("descrizione")), descrizione.toLowerCase());
	}

	public static Specification<Veicolo> alimentazione(String descrizione) {
		return (root, query, cb) ->
				cb.equal(cb.lower(root.get("alimentazione").get("descrizione")), descrizione.toLowerCase());
	}

	public static Specification<Veicolo> categoria(String descrizione) {
		return (root, query, cb) ->
				cb.equal(cb.lower(root.get("categoria").get("descrizione")), descrizione.toLowerCase());
	}

	public static Specification<Veicolo> annoMin(Integer anno) {
		return (root, query, cb) -> cb.greaterThanOrEqualTo(root.get("anno"), anno);
	}

	public static Specification<Veicolo> annoMax(Integer anno) {
		return (root, query, cb) -> cb.lessThanOrEqualTo(root.get("anno"), anno);
	}

	// campi specifici: treat() per accedere al sottotipo, come nel JPQL ma in forma typesafe
	public static Specification<Veicolo> porte(Integer porte) {
		return (root, query, cb) -> {
			var macchina = cb.treat(root, com.betacom.veicoliJPA_joined.models.Macchina.class);
			return cb.equal(macchina.get("porte"), porte);
		};
	}

	public static Specification<Veicolo> marce(Integer marce) {
		return (root, query, cb) -> {
			var bici = cb.treat(root, com.betacom.veicoliJPA_joined.models.Bici.class);
			return cb.equal(bici.get("marce"), marce);
		};
	}

	public static Specification<Veicolo> targaAuto(String targa) {
		return (root, query, cb) -> {
			var macchina = cb.treat(root, com.betacom.veicoliJPA_joined.models.Macchina.class);
			return cb.equal(macchina.get("targa"), targa);
		};
	}

	public static Specification<Veicolo> targaMoto(String targa) {
		return (root, query, cb) -> {
			var moto = cb.treat(root, com.betacom.veicoliJPA_joined.models.Moto.class);
			return cb.equal(moto.get("targa"), targa);
		};
	}
}
