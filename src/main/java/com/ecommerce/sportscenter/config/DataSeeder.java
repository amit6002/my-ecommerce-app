package com.ecommerce.sportscenter.config;

import com.ecommerce.sportscenter.entity.Brand;
import com.ecommerce.sportscenter.entity.Product;
import com.ecommerce.sportscenter.entity.Type;
import com.ecommerce.sportscenter.repository.BrandRepository;
import com.ecommerce.sportscenter.repository.ProductRepository;
import com.ecommerce.sportscenter.repository.TypeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Log4j2
public class DataSeeder implements CommandLineRunner {

    private final BrandRepository brandRepository;
    private final TypeRepository typeRepository;
    private final ProductRepository productRepository;

    public DataSeeder(BrandRepository brandRepository, TypeRepository typeRepository, ProductRepository productRepository) {
        this.brandRepository = brandRepository;
        this.typeRepository = typeRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Checking if database seeding is required...");
        if (brandRepository.count() == 0) {
            log.info("Seeding Brands...");
            Brand adidas = brandRepository.save(Brand.builder().name("Adidas").build());
            Brand asics = brandRepository.save(Brand.builder().name("ASICS").build());
            Brand victor = brandRepository.save(Brand.builder().name("Victor").build());
            Brand yonex = brandRepository.save(Brand.builder().name("Yonex").build());
            Brand puma = brandRepository.save(Brand.builder().name("Puma").build());
            Brand nike = brandRepository.save(Brand.builder().name("Nike").build());
            Brand babolat = brandRepository.save(Brand.builder().name("Babolat").build());

            log.info("Seeding Types...");
            Type shoes = typeRepository.save(Type.builder().name("Shoes").build());
            Type rackets = typeRepository.save(Type.builder().name("Rackets").build());
            Type football = typeRepository.save(Type.builder().name("Football").build());
            Type kitBags = typeRepository.save(Type.builder().name("Kit Bags").build());

            log.info("Seeding Products...");
            List<Product> products = Arrays.asList(
                Product.builder().name("Adidas Quick Force Indoor Shoes").description("Designed for professional badminton players.").price(3500L).pictureUrl("images/Product/adidas_shoe-1.png").brand(adidas).type(shoes).build(),
                Product.builder().name("Adidas Quick Force Indoor Shoes II").description("Designed for amateur badminton players.").price(3375L).pictureUrl("images/Product/adidas_shoe-2.png").brand(adidas).type(shoes).build(),
                Product.builder().name("Asics Gel Rocket 8 Indoor Court Shoes").description("Indoor court performance shoes.").price(4249L).pictureUrl("images/Product/asics_shoe-1.png").brand(asics).type(shoes).build(),
                Product.builder().name("Victor SHW503 F Badminton Shoes").description("High resilience indoor shoes.").price(2392L).pictureUrl("images/Product/victor_shoe-1.png").brand(victor).type(shoes).build(),
                Product.builder().name("YONEX Super Ace Light Badminton Shoes").description("Maximum shock absorption.").price(2590L).pictureUrl("images/Product/yonex_shoe-1.png").brand(yonex).type(shoes).build(),
                Product.builder().name("Puma 19 FH Rubber Spike Shoes").description("Cricket and turf rubber spike shoes.").price(4999L).pictureUrl("images/Product/puma_shoe-1.png").brand(puma).type(shoes).build(),
                Product.builder().name("Babolat Shadow Spirit Mens Shoes").description("Lightweight indoor badminton shoes.").price(4125L).pictureUrl("images/Product/babolat_shoe-1.png").brand(babolat).type(shoes).build(),
                Product.builder().name("Yonex VCORE Pro 100 Tennis Racquet").description("Game-changing spin and power.").price(6099L).pictureUrl("images/Product/yonex-racket-1.png").brand(yonex).type(rackets).build(),
                Product.builder().name("Babolat Boost D Tennis Racquet").description("Professional lightweight racquet.").price(6999L).pictureUrl("images/Product/babolat-racket-1.png").brand(babolat).type(rackets).build(),
                Product.builder().name("Adidas FIFA World Cup OMB Football").description("Featuring an innovative surface panel design.").price(2499L).pictureUrl("images/Product/adidas_football-1.png").brand(adidas).type(football).build(),
                Product.builder().name("Nike Pitch Premier League Football").description("High visibility match ball.").price(1525L).pictureUrl("images/Product/Nike-Football-1.png").brand(nike).type(football).build(),
                Product.builder().name("Babolat Team Line Racket Kit Bag").description("Holds up to 12 racquets.").price(4550L).pictureUrl("images/Product/babolat-kitback-1.png").brand(babolat).type(kitBags).build(),
                Product.builder().name("Yonex SUNR 4826TK Badminton Kit Bag").description("Durable multi-compartment kit bag.").price(1999L).pictureUrl("images/Product/yonex-kitback-1.png").brand(yonex).type(kitBags).build()
            );
            productRepository.saveAll(products);
            log.info("Database seeding completed successfully!");
        } else {
            log.info("Database already contains data, skipping seeding.");
        }
    }
}
