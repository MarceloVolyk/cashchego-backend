package com.cashchego.demo.websocket;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.cashchego.demo.dtos.TransactionDTO;
import com.cashchego.demo.dtos.TransactionFilterDTO;
import com.cashchego.demo.services.TransactionService;

@Controller
public class WebSocketController {

	@Autowired
	private TransactionService transactionService;
	
    @MessageMapping("/hello") // Rota para enviar mensagens (/app/hello)
    @SendTo("/topic/greetings") // Tópico para enviar a resposta
    public String greeting(String message) throws Exception {
        Thread.sleep(1000); // Simula processamento
        return "Hello, " + message + "!";
    }
    
    @MessageMapping("/transacoes/filtrar")
    @SendTo("/topic/transacoes-filtradas")
    public List<TransactionDTO> filtrarTransacoes(TransactionFilterDTO filtro) {
        if (!filtro.isValid()) {
            throw new IllegalArgumentException("Parâmetros inválidos");
        }
        
        return transactionService.filtrarTransacoesPorDataECategoria(
            filtro.getDataInicio(),
            filtro.getDataFim(),
            filtro.getCategoriaId()
        );
    }
}
