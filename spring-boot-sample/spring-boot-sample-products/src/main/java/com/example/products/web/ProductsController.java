package com.example.products.web;

import com.example.products.model.BlobStorageToken;
import com.example.products.model.ProductImageResult;
import com.example.products.service.ProductStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.*;

import com.example.products.model.Product;
import com.example.products.model.ProductFilter;
import com.example.products.service.ProductsService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
@Slf4j
@CrossOrigin(origins = "http://localhost:4200",maxAge = 0,methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
public class ProductsController {
	
	@Autowired
	private ProductsService productsService;

	@Autowired
	private ProductStorageService productStorageService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Product> getProducts(@RequestParam(defaultValue = "1") Integer pageSize, 
    		@RequestParam(defaultValue = "1") Integer start, @RequestParam String q, ServerHttpResponse response) {
		
		ProductFilter filter = new ProductFilter();
		filter.setDescriptionQuery(q);
		filter.setPageSize(pageSize);
		filter.setStart(start);
		
		Flux<Product> productsFlow = productsService.findProducts(filter).map(p -> {
			return p.add(WebMvcLinkBuilder.linkTo(
					WebMvcLinkBuilder.methodOn(ProductsController.class).getProduct(p.getId()))
				.withSelfRel());
		});
		
		response.getHeaders().add("CustomerHeader", "Head");
		log.info("returning");
		return productsFlow;
    }
	
	@GetMapping(path = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Product> getProduct(@PathVariable String productId) {
		return productsService.getProduct(productId);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Product> saveProduct(@RequestBody Product product){
		return productsService.saveProduct(product);
	}

	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public Mono<ProductImageResult> saveProductImages(@RequestPart(name = "file") Mono<FilePart> productImages){

		return productImages.map(filePart -> {
			log.info(filePart.filename());
			return new ProductImageResult(filePart.filename());
		});

		//return productsService.saveProductImages(productImages);
	}


	@GetMapping("/sastoken")
	@ResponseStatus(value = HttpStatus.OK)
	public Mono<BlobStorageToken> getSasToken(){
		return Mono.just(productStorageService.generateAccessToken());
	}
	
}