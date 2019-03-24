package com.tjt.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Import;

@Configurable
@Import(value={ServiceConfig.class,EntityConfig.class,DAOConfig.class})
public class RootConfig {

}
