package com.tjt.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;


@Configurable
@ComponentScan(basePackages="com.tjt.controller")
public class WebMVCConfig {

}
