package com.kodlamaio.inventoryservice;

import com.kodlamaio.commonpackage.utils.constants.Paths;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableDiscoveryClient // Eureka client olarak çalışacağını belirttik. Discovery server a kayıt olacak.
@SpringBootApplication(scanBasePackages = {Paths.ConfigurationBasePackage, Paths.Inventory.ServiceBasePackage})
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

}
