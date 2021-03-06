package com.hjc.service;

import com.hjc.pojo.Provider;
import com.hjc.service.provider.ProviderService;
import com.hjc.service.provider.ProviderServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ProviderServiceTest {
    private ApplicationContext context;
    private ProviderService providerService;

    @Before
    public void init() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        providerService = context.getBean("providerService", ProviderServiceImpl.class);
    }

    @Test
    public void testGetProviderList() {
        List<Provider> providerList = providerService.getProviderList();
        for (Provider provider : providerList) {
            System.out.println(provider);
        }
    }

    @Test
    public void testGetProviderById() {
        int id = 10;
        Provider provider = providerService.getProviderById(id);
        System.out.println(provider);
    }

    @Test
    public void testGetProviderList1() {
        String proCode = "bj";
        String proName = null;
        List<Provider> providerList = providerService.getProviderList(proCode, proName);
        for (Provider provider : providerList) {
            System.out.println(provider);
        }
    }

    @Test
    public void testUpdateProvider() {
        Provider provider = new Provider();
        provider.setId(16);
        provider.setProCode("test");
        provider.setProName("test1");
        provider.setProContact("test1");
        provider.setProPhone("11111111111");
        provider.setProAddress("test1");
        provider.setProFax("test1");
        provider.setProDesc("test1");
        providerService.updateProvider(provider);
    }
}
