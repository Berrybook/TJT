package com.tjt.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.tjt.config.RootConfig;
import com.tjt.config.WebMVCConfig;

@SpringBootApplication
@Import(value={RootConfig.class,WebMVCConfig.class})
public class TjtyrecompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TjtyrecompanyApplication.class, args);
	}
}
