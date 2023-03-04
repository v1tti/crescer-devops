package br.com.cwi.crescer.bePepe.controller;

import br.com.cwi.crescer.bePepe.controller.request.ComentarioRequest;
import br.com.cwi.crescer.bePepe.controller.request.CurtidaRequest;
import br.com.cwi.crescer.bePepe.controller.request.PostRequest;
import br.com.cwi.crescer.bePepe.controller.request.PrivarPostRequest;
import br.com.cwi.crescer.bePepe.controller.response.ComentarioResponse;
import br.com.cwi.crescer.bePepe.controller.response.CurtidaResponse;
import br.com.cwi.crescer.bePepe.controller.response.ListarPostResponse;
import br.com.cwi.crescer.bePepe.controller.response.PostResponse;
import br.com.cwi.crescer.bePepe.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private CriarPostService criarPostService;

    @Autowired
    private DetalharPostService detalharPostService;

    @Autowired
    private ComentarPostService comentarPostService;

    @Autowired
    private CurtirPostService curtirPostService;

    @Autowired
    private PrivarPostService privarPostService;

    @PostMapping
    public PostResponse incluir(@RequestBody PostRequest request) {
        return criarPostService.incluir(request);
    }

    @GetMapping
    public Page<ListarPostResponse> listarPost(Pageable pageable) {
        return detalharPostService.listar(pageable);
    }

    @PutMapping("/{id}/adicionarComentario")
    public ComentarioResponse comentarPost(@PathVariable Long id,@RequestBody ComentarioRequest request){
        return comentarPostService.comentarPost(id ,request);
    }

    @PutMapping("/{id}/curtida")
    public CurtidaResponse curtirPost(@PathVariable Long id, @RequestBody CurtidaRequest request){
        return curtirPostService.curtirPost(id ,request);
    }
    @PutMapping("/{id}")
    public PostResponse privarPost(@PathVariable Long id, @RequestBody PrivarPostRequest request){
        return privarPostService.privarPost(id ,request);
    }

}
