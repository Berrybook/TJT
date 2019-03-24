package com.tjt.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configurable
@EnableJpaRepositories(basePackages="com.tjt.dao")
public class DAOConfig {

}
