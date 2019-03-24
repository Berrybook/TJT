package com.tjt.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@Configurable
@EntityScan(basePackages="com.tjt.entity")
public class EntityConfig {

}
