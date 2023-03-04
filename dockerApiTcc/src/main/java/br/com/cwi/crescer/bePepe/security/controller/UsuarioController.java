package br.com.cwi.crescer.bePepe.security.controller;

import br.com.cwi.crescer.bePepe.security.controller.request.EditarUsuarioRequest;
import br.com.cwi.crescer.bePepe.security.controller.request.UsuarioRequest;
import br.com.cwi.crescer.bePepe.security.controller.response.AmizadesResponse;
import br.com.cwi.crescer.bePepe.security.controller.response.UsuarioResponse;
import br.com.cwi.crescer.bePepe.security.service.*;
import br.com.cwi.crescer.bePepe.security.service.core.BuscarUsuarioPorIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IncluirUsuarioService service;

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @Autowired
    private EditarUsuarioService editarUsuarioService;

    @Autowired
    private ListarUsuariosService listarUsuariosService;

    @Autowired
    private PesquisarUsuarioService pesquisarUsuarioService;

    @Autowired
    private EnviarSolicitacaoService enviarSolicitacaoService;

    @Autowired
    private AceitarSolicitacaoService aceitarSolicitacaoService;

    @Autowired
    private ListarAmizadeService listarAmizadeService;

    @Autowired
    private BuscarUsuarioDetalhadoService buscarUsuarioDetalhadoService;

    @Autowired
    private RejeitarSolicitacaoService rejeitarSolicitacaoService;

    @GetMapping("/me")
    public UsuarioResponse buscarUsuarioAutenticado() {
        return buscarUsuarioService.buscar();
    }

    @GetMapping("{id}")
    public UsuarioResponse buscarOutroUsuario(@PathVariable Long id) {
        return buscarUsuarioDetalhadoService.buscar(id);
    }

    @PostMapping
    public UsuarioResponse incluir(@RequestBody UsuarioRequest request) {
        return service.incluir(request);
    }

    @PutMapping("/{id}")
    public UsuarioResponse editar(@RequestBody EditarUsuarioRequest request, @PathVariable Long id) {
        return editarUsuarioService.editar(request, id);
    }

    @GetMapping("/search")
    public Page<UsuarioResponse> listarPaginado(@RequestParam ("text") String searchTerm, Pageable pageable) {
        return pesquisarUsuarioService.listarUsuariosPaginado(searchTerm, pageable);
    }

    @GetMapping
    public List<UsuarioResponse> listar() {
        return listarUsuariosService.listar();
    }

    @PostMapping("/{id}/amizades")
    public void enviar(@PathVariable Long id) {
        enviarSolicitacaoService.enviar(id);
    }

    @PutMapping("/{id}/amizades")
    public void aceitar(@PathVariable Long id){
        aceitarSolicitacaoService.aceitar(id);
    }
    @PutMapping("/{id}/amizades/rejeitar")
    public void rejeitar(@PathVariable Long id){
        rejeitarSolicitacaoService.rejeitar(id);
    }

    @GetMapping("/amizades")
    public List<AmizadesResponse> listarAmizade() {
        return listarAmizadeService.listar();
    }

    @GetMapping("/amizades/solicitadas")
    public List<AmizadesResponse> listarAmizadeSolicitada() {
        return listarAmizadeService.listarSolicitada();
    }
}
