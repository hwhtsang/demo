package com.arxall.tema.demo;
/*
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
*/
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories
public class ElasticsearchConfiguration extends AbstractElasticsearchConfiguration {

	private ElasticsearchProperties elasticsearchProperties;
	
	public ElasticsearchConfiguration(ElasticsearchProperties elasticsearchProperties) {
		this.elasticsearchProperties = elasticsearchProperties;
	}
	
	@Override
	@Bean
	public RestHighLevelClient elasticsearchClient() {
		final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
	    		.connectedTo(this.elasticsearchProperties.getUris().get(0))
//	    		.usingSsl(createSSLContext())
//	    		.withBasicAuth(this.elasticsearchProperties.getUsername(), this.elasticsearchProperties.getPassword())
	    		.build();
	    return RestClients.create(clientConfiguration).rest();
	}
/*
	private SSLContext createSSLContext() {
		try {
			InputStream is = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\demo\\src\\main\\resources\\http_ca.crt");
			CertificateFactory cf = CertificateFactory.getInstance("X.509");
			X509Certificate caCert = (X509Certificate)cf.generateCertificate(is);

			TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
			KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
			ks.load(null); // You don't need the KeyStore instance to come from a file.
			ks.setCertificateEntry("caCert", caCert);

			tmf.init(ks);

			SSLContext sslContext = SSLContext.getInstance("TLS");
			sslContext.init(null, tmf.getTrustManagers(), null);
			return sslContext;
		} catch(Exception ex) {
			return null;
		}
	}
*/
}
