package br.com.eoc.web.client.service;

import org.springframework.transaction.annotation.Transactional;


@Transactional(rollbackFor = Exception.class)
public abstract class AbstractService {

}
