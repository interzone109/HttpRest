package com.http.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.http.rest.client.RestClient;
import com.http.rest.entity.Document;
import com.http.rest.entity.service.DocumentServiceImpl;

import javassist.NotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestClientTest {

	@Autowired
	private RestClient client;
	@Autowired
	private DocumentServiceImpl documentServiceImpl;

	private String url1 = "https://lb-api-sandbox.prozorro.gov.ua/api/2.4/contracts/47fa8764e1b74f4db58f84c9db460566/documents";
	private String url2 = "https://lb-api-sandbox.prozorro.gov.ua/api/2.4/contracts/4805f381d48948b1b34d6ea2daa029a3/documents";
	private String url3 = "https://lb-api-sandbox.prozorro.gov.ua/api/2.4/contracts/23567e24f52746ef92c470be6059d193/documents";

	@Test
	public void testUrl1() {
		client.getObjectByUrl(url1);

		String id = "219c45e36e4548f4963a484642420478";

		Document document = documentServiceImpl.findById(id).get();
		assertEquals(id, document.getId());
		assertTrue(document.getUrl().equals(
				"https://public-docs-sandbox.prozorro.gov.ua/get/f104698a64f64bdf8142f7e11df74dd2?KeyID=1331dc52&Signature=oi3cRoqISdyAb4f0wEM%252B43P8Mn1eh19YH%2FGwQkoHWlLDnQWWwFhZeXGvZStKoaJ8yDh%252B5JRy%252BTm4UNyzetDoCQ%253D%253D"));

	}

	@Test
	public void testUrl2() {
		client.getObjectByUrl(url2);

		String id = "e7bf347964704ae98efba0d04b5232bb";

		Document document = documentServiceImpl.findById(id).get();
		assertEquals(id, document.getId());
		assertTrue(document.getTitle().equals("Перелік змін.docx"));

	}

	@Test
	public void testUrl3() {
		client.getObjectByUrl(url3);

		String id = "a5ef4c3063d94b10a13630fa9cca90b9";

		Document document = documentServiceImpl.findById(id).get();
		assertEquals(id, document.getId());
		assertTrue(document.getHash().equals("md5:ee80acf16c48f3b659a2132526ae9800"));
	}

	@Test(expected = NotFoundException.class)
	public void testCatchExeption() throws NotFoundException {

		client.getObjectByUrl(url1);

		String id = "219c45e36e411114963a111142420478";
		Document document = documentServiceImpl.findById(id)
				.orElseThrow(() -> new NotFoundException("Document not dound"));

	}

	@Test(expected = NullPointerException.class)
	public void testCatchNullPointerException() {
		client.getObjectByUrl(null);

	}

	

}
