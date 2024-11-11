package tn.esprit.microservice.produits;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import tn.esprit.microservice.produits.entites.Categorie;
import tn.esprit.microservice.produits.entites.EtatProduit;
import tn.esprit.microservice.produits.entites.Produit;
import tn.esprit.microservice.produits.entites.Statut;
import tn.esprit.microservice.produits.repositories.ProduitRepo;

import java.time.LocalDateTime;


@SpringBootApplication
@EnableDiscoveryClient
public class ProduitsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProduitsApplication.class, args);
	}
	/*@Autowired
	private ProduitRepo repository;

	@Bean
	 ApplicationRunner init() { return (args) -> {
// save
		repository.save(new Produit(1,"Montre connectée","Montre intelligente avec fonctionnalités de suivi de la santé.", Categorie.ELECTRONIQUE,  15000L, 20000L, Statut.disponible, LocalDateTime.now(),LocalDateTime.now().plusDays(7), EtatProduit.ANTIQUE));

// fetch
		repository.findAll().forEach(System.out::println);

	};

	}*/

}
