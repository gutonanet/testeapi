package com.augusto.lemes.teste;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.augusto.lemes.teste.controller.GastoController;
import com.augusto.lemes.teste.model.Gasto;
import com.augusto.lemes.teste.service.GastoService;

import junit.framework.Assert;


@RunWith(SpringRunner.class)
@WebMvcTest(value = GastoController.class, secure = false)
public class GastoControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private GastoService gastoService;

	

	@Test
	public void testListGastos() throws Exception {
		Date data = new Date();
		Gasto mockGasto = new Gasto(1L, "teste", 10.00D, 1L, null);
		
		List<Gasto> gastos = new ArrayList<>();
		gastos.add(mockGasto);
		Mockito.when(
				gastoService.listGastos()).thenReturn(gastos);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/gastos").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		System.out.println("data: "+data);
		String expected = "[{id:1,descricao:teste,valor:10.0,codigoUsuario:1,data:null}]";

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
	@Test
	public void testCreateGasto() throws Exception {
		Gasto mockGasto = new Gasto(1L, "teste", 10.00D, 1L, null);
		
		Mockito.when(
				gastoService.save(mockGasto)).thenReturn(mockGasto);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
				"/api/gastos",mockGasto).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "200";

		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

		Assert.assertEquals(expected, result.getResponse().getStatus(), false);
	}

	@Test
	public void testFindGastosByCodigoUsuario() throws Exception {
		Date data = new Date();
		Gasto mockGasto = new Gasto(1L, "teste", 10.00D, 1L, null);
		
		List<Gasto> gastos = new ArrayList<>();
		gastos.add(mockGasto);
		Mockito.when(
				gastoService.findByCodigoUsuario(1L)).thenReturn(gastos);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/gastos/codigousuario/1").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		System.out.println("data: "+data);
		String expected = "[{id:1,descricao:teste,valor:10.0,codigoUsuario:1,data:null}]";

		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
	
	@Test
	public void testFindGastosByData() throws Exception {
		Date data = new Date();
		Gasto mockGasto = new Gasto(1L, "teste", 10.00D, 1L, null);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dataString = format.format(data);
		List<Gasto> gastos = new ArrayList<>();
		gastos.add(mockGasto);
		Mockito.when(
				gastoService.findByData(data)).thenReturn(gastos);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/gastos/data/"+dataString).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "[{id:1,descricao:teste,valor:10.0,codigoUsuario:1,data:null}]";

		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}	
	
	
}