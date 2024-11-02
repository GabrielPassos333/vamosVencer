package com.fatec.vamosVencer.controller;

import com.fatec.vamosVencer.entity.Curriculo;
import com.fatec.vamosVencer.service.CurriculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador para o recurso Curriculo
 */
@RestController
@RequestMapping("/curriculos")
public class CurriculoController {

    /**
     * Injeção de dependência para o serviço de curriculo
     */
    @Autowired
    private CurriculoService curriculoService;

    /**
     * Busca todos os curriculos
     * @return lista de curriculos
     */
    @GetMapping
    public List<Curriculo> getAllCurriculos() {
        return curriculoService.findAll();
    }

    /**
     * Busca um curriculo pelo id
     * @param id do curriculo
     * @return o curriculo encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<Curriculo> getCurriculoById(@PathVariable Integer id) {
        Optional<Curriculo> curriculo = curriculoService.findById(id);
        return curriculo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo curriculo
     * @param curriculo a ser criado
     * @return o curriculo criado
     */
    @PostMapping
    public ResponseEntity<Curriculo> createCurriculo(@RequestBody Curriculo curriculo) {
        Curriculo novoCurriculo = curriculoService.save(curriculo);
        return new ResponseEntity<>(novoCurriculo, HttpStatus.CREATED);
    }

    /**
     * Atualiza um curriculo
     * @param id do curriculo a ser atualizado
     * @param curriculo com os novos dados
     * @return o curriculo atualizado
     */
    @PutMapping("/{id}")
    public ResponseEntity<Curriculo> updateCurriculo(@PathVariable Integer id, @RequestBody Curriculo curriculo) {
        if (!curriculoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        curriculo.setCodCurriculo(id);
        Curriculo curriculoAtualizado = curriculoService.save(curriculo);
        return ResponseEntity.ok(curriculoAtualizado);
    }

    /**
     * Deleta um curriculo
     * @param id do curriculo a ser deletado
     * @return resposta vazia
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurriculo(@PathVariable Integer id) {
        if (!curriculoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        curriculoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
