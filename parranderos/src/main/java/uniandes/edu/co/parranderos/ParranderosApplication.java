package uniandes.edu.co.parranderos;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uniandes.edu.co.parranderos.modelo.Hotel;
import uniandes.edu.co.parranderos.repositorio.HotelRepository;

@SpringBootApplication
public class ParranderosApplication implements CommandLineRunner{

	@Autowired
	private HotelRepository hotelRepository;
	public static void main(String[] args) {
		SpringApplication.run(ParranderosApplication.class, args);
	}

	@Override
	public void run(String... arg)
	{
		Collection<Hotel> hoteles = hotelRepository.darHoteles();
		for (Hotel h : hoteles) {
			System.out.println(h);
		}
	}
}
